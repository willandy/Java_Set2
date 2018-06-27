<%@page import="entity.News"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../css/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
     System.out.println("可以看下路径：request.getContextPath()：取出的是根目录就是项目名---->"+request.getContextPath());
      String id = request.getParameter("id");
     System.out.println("id======>"+id);
     News news = new News();
     //调用后台方法，通过ID查找新闻明细
     news=newsServiceImpl.getNewsById(Integer.parseInt(id));
     request.setAttribute("news", news);
     %>
     EL传过来的新闻ID:${param.id }<!-- request是map格式的，所以能取到id的值 -->
     <!--页面主体的右部，包括新闻的列表和评论内容 -->
    <div class="main-content-right">
        <!--各专题的新闻列表-->
        <div class="main-text-box">
            <div class="article-place"><a href="#">新闻中心</a> > <a href="#">国内</a></div>
      		<div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="article-box">
                        <h1><%=news.getTitle() %></h1>
                        <!-- 下面用EL表达式 ,获取信息-->
                        <h1>${news.title }</h1>
                        <div class="source-bar">发布者：<%=news.getAuthor() %> 分类:<%=news.getCategoryName() %>  更新时间：<%=news.getCreateDate() %></div>
                        <div class="article-content">
                            <span class="article-summary"><b>摘要：</b><%=news.getSummary() %></span>
                           <%
                            if(news.getPicPath()==null || news.getPicPath().equals("")){
                           %>
                                                                           新闻图片：暂无
                           <%}else{ %>   
                           <!-- request.getContextPath()获取上下文，也就是根目录 -->
                            <img src="<%=request.getContextPath()%>/upload/<%=news.getPicPath()%>"> 
                           <%} %>    
                           <br/>   
                             <c:out value="${news.content }" escapeXml="false"></c:out>                                   
                            <%-- <%=news.getContent() %> --%>
                        </div>
                    </div>
                </div>
            </div>
            <div style="text-align:center;">
               <button type="button" class="page-btn" name="return"
                 onclick="javascript:location.href='newsDetailList.jsp'">返回</button>
            </div>
        </div>
        <!--//-->
        
    </div>
</body>
</html>