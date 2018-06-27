<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <!-- 设置变量 -->
     <c:set var="uid" value="admin" scope="request"></c:set>
     用户名：${uid }<br/>
     <!-- 删掉 -->
     <c:remove var="uid"/>
     remove用户名:${uid }
</body>
</html>