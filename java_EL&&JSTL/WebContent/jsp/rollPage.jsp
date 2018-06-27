<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
      <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${param.totalCount }条记录&nbsp;&nbsp; ${param.currentPageNo }/${param.totalPageCount }页</li>
				<!-- 用于判断是否是首页 -->
			<c:if test="${param.currentPageNo>1 }">
				<!-- <a href="newsDetailList.jsp?pageIndex=1">首页</a> -->
				<!-- 上面的a标签是做首页，现在是做go方法，现在采用post方法，前面的document.forms[0]
				是这个文档中的第一个表单，后面的1是传入参数为1 -->
				<a href="javascript:page_nav(document.forms[0],1);">首页</a>
				<a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1 })">上一页</a>
				<!-- 用于判断尾页 -->
				</c:if>
				<c:if test="${param.currentPageNo < param.totalPageCount }">
				<a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1 })">下一页</a>
				<a href="javascript:page_nav(document.forms[0],${param.totalPageCount })">最后一页</a>&nbsp;&nbsp;
			  </c:if>
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
</body>
</html>