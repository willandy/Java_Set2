<%@page import="entity.PageSupport"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.News"%>
<%@page import="java.util.List"%>
<%@page import="Dao.NewsDao"%>
<%@page import="Dao.NewsDaoImpl"%>
<%@page import="service.NewsServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 静态包含 -->
    <%@include file="css/common.jsp" %>
    <!-- jsp动作标签 -->
<%-- <jsp:useBean id="newsServiceImpl" class="service.NewsServiceImpl" scope="page"></jsp:useBean> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!-- 用来处理时间 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
     function addNews(){
    	 window.location="jsp/newsDetailCreateSimple.jsp";
     }
     //把form表单中隐藏域里的值赋值
     function page_nav(frm,num){
    	 frm.pageIndex.value=num;
    	 frm.submit();/* 以post方式提交 */
     }
     /* Go方法的跳转 */
     function jump_to(frm,num){
    	 //用户输入验证'
    	 var regexp = /^[1-9]\d*$/;
    	 var totalPageCount = document.getElementById("totalPageCount").value;
    	 alert(num);
    	 alert(totalPageCount);
    	 if(!regexp.test(num)){
    		 alert("请输入大于0的正整数!");
    		 return false;
    	 }else if((num - totalPageCount)>0){
    		 alert("请输入小于总页数的页码!");
    		 return false;
    	 }else{
    		 page_nav(frm,num);
    	 }
     }
</script>
</head>
<body>
   <div class="main-content-right">
        <!--即时新闻-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <form name ="searchForm" id="searchForm" action="newsDetailList.jsp" method="post">
		 	          <div>
		 				新闻分类：
		 					<select name="categoryId">
		 						<option value="0">全部</option>
			        			
			        				<option value='1' >国内</option>
			        			
			        				<option value='2' >国际</option>
			        			
			        				<option value='3' >娱乐</option>
			        			
			        				<option value='4' >军事</option>
			        			
			        				<option value='5' >财经</option>
			        			
			        				<option value='6' >天气</option>
			        			
	        				</select>
		 				新闻标题<input type="text" name="title" id="title" value=''/>
		 					<button type="submit" class="page-btn">GO</button>
		 					<button type="button" onclick="addNews();" class="page-btn">增加</button>
		 					<!-- 这个隐藏域里的值，是给下面的首页 -->
		 					<!-- 隐藏域一定要写在form里才有效，记得写name -->
		 					<input type="hidden" id="pageIndex" name="pageIndex" value="1"/>
		 	</div>
		 	</form>
			<table cellpadding="1" cellspacing="1" class="admin-list">
				<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                     <%
                     //页面容量
                     int pageSize = 2;
                     //当前页码
                     String pageIndex = request.getParameter("pageIndex");
                     
                     int currentPageNo=0;
                     if(pageIndex == null){
                    	 currentPageNo = 1;
                     }else{
                    	 try{
                    		 currentPageNo = Integer.parseInt(pageIndex);
                    	 }catch(Exception e){
                    		 response.sendRedirect("error.jsp");
                    	 }
                     }
                     
                     //总记录数
                     int totalCount = newsServiceImpl.getNewsCount();
                     //总页数
                     PageSupport pageSupport = new PageSupport();
                     pageSupport.setPageSize(pageSize);
                     pageSupport.setCurrentPageNo(currentPageNo);
                     pageSupport.setTotalCount(totalCount);
                     int totalPageCount = pageSupport.getTotalPageCount();
                     
                     //首页和尾页的异常控制
                     if(currentPageNo<1){
                    	 currentPageNo = 1;
                     }
                     //是为了让用户如果点到最后一页，就不能再点下去
                     if(currentPageNo > totalPageCount){
                    	 currentPageNo = totalPageCount;
                     }
                     
                      /*  NewsServiceImpl newsServiceImpl = new NewsServiceImpl();  */
                       /* List<News> newsList=newsServiceImpl.getNewsList(); */
                       List<News> newsList=newsServiceImpl.getPageNewsList(currentPageNo, pageSize);
                      request.setAttribute("newsList", newsList);/* 这个一定要记得添加，不在作用域里是出不来的 */
                       /* int i=0;
                       for(News news:newsList){
                    	   request.setAttribute("news", news);/* 现在用jstl表达式，一定要在作用域里 */
                    	   /*i++; */
                    	   /* 现在采用forEach */
                    	   
                     %>
                     <!-- 写一个隐藏域取到总页数 -->
                <input type="hidden" id="totalPageCount" name="totalPageCount" value="<%=totalPageCount%>"/>
                	<!-- forEach中news表示集合中的对象 -->
                	<c:forEach var="news" items="${newsList }" varStatus="status">
                	<%-- <tr <%if(i%2==0) {%>class="admin-list-td-h2"<%} %>> --%>
                		<!-- status.count就是有多少行，status是从0开始 -->
                		
                		<tr <c:if test="${status.count%2==0 }">class="admin-list-td-h2"</c:if>>
                		
                		<td>${status.count }</td>
                		<td>${status.index }</td>
                		
                		<td><a href='jsp/adminNewsView.jsp?id=${news.id}<%-- <%=news.getId()%> --%>'>
                		<%-- <%=news.getTitle()%> --%>
                		<!-- 现在用jstl表达式 -->
                		<c:out value="${news.title }"></c:out><!-- 这里title里面就是普通的文本 -->
                		</a></td>
                		<td>
                		<%-- <%=news.getAuthor() %> --%>
                		<!-- 空字符串和NULL区别 ，default只能替换null，不能替换空值-->
                		<c:out value="${news.author }" default="暂无"></c:out>
                		</td>
                		<td>
                		
                		<%-- <%=new SimpleDateFormat("yyyy-MM-dd").format(news.getCreateDate()) %> --%>
                		<fmt:formatDate value="${news.createDate }" pattern="yyyy-MM-dd"/>
                		
                		</td>
                		<!-- <td><a href='adminNewsCreate.jsp?id=3'>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=3'">删除</a>
                		</td> -->
                		
                		<td>
                		<a href=' 
                		  <c:url value="jsp/adminNewsEdit.jsp">
                		    <c:param name="id" value="${news.id }"></c:param>
                		  </c:url>
                		'>修改</a>
                		<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=3'">删除</a>
                		</td>
                		
                	</tr> 
                      <%
                      /* } */
                       %>
                 </c:forEach>
                </tbody>
            </table>
           <%-- <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共<%=totalCount %>条记录&nbsp;&nbsp; <%=currentPageNo %>/<%=totalPageCount %>页</li>
				<!-- 用于判断是否是首页 -->
				<%if(currentPageNo > 1){ %>
				<!-- <a href="newsDetailList.jsp?pageIndex=1">首页</a> -->
				<!-- 上面的a标签是做首页，现在是做go方法，现在采用post方法，前面的document.forms[0]
				是这个文档中的第一个表单，后面的1是传入参数为1 -->
				<a href="javascript:page_nav(document.forms[0],1);">首页</a>
				<a href="javascript:page_nav(document.forms[0],<%=currentPageNo-1%>">上一页</a>
				<!-- 用于判断尾页 -->
				<%}if(currentPageNo < totalPageCount){ %>
				<a href="javascript:page_nav(document.forms[0],<%=currentPageNo+1%>">下一页</a>
				<a href="javascript:page_nav(document.forms[0],<%=totalPageCount%>">最后一页</a>&nbsp;&nbsp;
			    <%} %>
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div>  --%>
		
		<c:import url="jsp/rollPage.jsp">
		  <c:param name="totalCount" value="<%=Integer.toString(totalCount) %>"></c:param>
		 <c:param name="currentPageNo" value="<%=Integer.toString(currentPageNo) %>"></c:param>
		 <c:param name="totalPageCount" value="<%=Integer.toString(totalPageCount) %>"></c:param>
		</c:import>

        </div>
       </div>
   </div>
   </div>

</body>
</html>