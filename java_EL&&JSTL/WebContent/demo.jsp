
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
     /* 如果传入的特殊字符 */
     request.setAttribute("student.name", "zhangsan");
     /* 如果传入的集合对象 */
     ArrayList list = new ArrayList();
     list.add("今天礼拜一");
     list.add("明天礼拜二");
     request.setAttribute("list", list);/* 记得放入到作用域里 */
     /* 简单运算符 */
     request.setAttribute("totalCount", 10);
     request.setAttribute("pageSize", 2);
     %>
     ${requestScope["student.name"] }
     ${list[0] }
     ${totalCount/pageSize }
</body>
</html>