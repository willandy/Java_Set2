<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 使用jstl的话，要加标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       <!-- EL作用域 -->
       <%
         session.setAttribute("uid", "admin");
        
         /* application */
         Integer count=(Integer)application.getAttribute("count");
         if(count == null){
        	 application.setAttribute("count", 1);
         }else{
        	 application.setAttribute("count", count+1);
         }
       %>
       ${sessionScope.uid }
       <!-- 那么如果不加前缀，那么如何判断作用域是pageContext还是request？如果不写，按照范围
       page<request<session<application来查，一般定义的属性都有意义，不会重复 -->
       访问次数：${applicationScope.count }
</body>
</html>