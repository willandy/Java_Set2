<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base target="rightFrame"><!-- 对应页面中的adminRightbar.jsp -->
<!-- <link rel="stylesheet" type="text/css" href="css/common.css"/> -->
<!-- 采用静态包含 -->
<%@include file="css/common.jsp" %>
</head>
<body>
     <!-- 页面顶部 -->
     <jsp:include page="jsp/adminTop.jsp"></jsp:include>
     <!-- 页面中部 -->
     <div id="content" class="main-content clearfix">
        <jsp:include page="jsp/adminSidebar.jsp"></jsp:include>
        <jsp:include page="jsp/adminRightbar.jsp"></jsp:include>
     </div>
     <!-- 页面底部 -->
     <jsp:include page="jsp/adminBottom.jsp"></jsp:include>
</body>
</html>