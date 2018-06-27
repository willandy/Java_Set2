<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.util.Date"%>
<%@page import="entity.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../css/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%--    <%
          //设置请求的字符编码UTF-8
          request.setCharacterEncoding("UTF-8");
          String categoryId = request.getParameter("categoryId");
          String title = request.getParameter("title");
          String author = request.getParameter("author");
          String summary = request.getParameter("summary");
          String content = request.getParameter("newscontent");
          
          //从请求中取出数据，提交数据库
          News news = new News();
          news.setAuthor(author);
          news.setCategoryId(Integer.parseInt(categoryId));
          news.setContent(content);
          news.setSummary(summary);
          news.setTitle(title);
          news.setCreateDate(new Date());
          if(newsServiceImpl.add(news)){//成功
        	  //转发
        	 // request.getRequestDispatcher("../newsDetailList.jsp").forward(request, response);
             //现在采用<jsp:forward>来进行跳转
      %>
      <jsp:forward page="../newsDetailList.jsp"></jsp:forward>
      <%} %> --%>
      
      <!-- 实现文件上传 -->
      <%
         //设置请求的字符编码UTF-8
         request.setCharacterEncoding("UTF-8");
         //解析请求之前，先判断是否为文件上传类型
         boolean isMultiPart=ServletFileUpload.isMultipartContent(request);
         
         //request.getSession().getServletContext()获取项目部署在tomcat上真实的路径
         //"upload/"表示创建这个文件夹
         String uploadPath = request.getSession().getServletContext().getRealPath("upload/");
         
         //判断目标路径是否存在，不存在，自动创建
         File saveDir = new File(uploadPath);
         News news = new News();
         news.setCreateDate(new Date());
         if(!saveDir.exists()){
        	 saveDir.mkdir();
         }
         
         //处理文件上传
         if(isMultiPart){
        	 //创建文件上传的核心类ServletFileUpload
        	 FileItemFactory factory = new DiskFileItemFactory();
        	 ServletFileUpload upload = new ServletFileUpload(factory);
        	 
        	 //解析请求
        	 List<FileItem> items=upload.parseRequest(request);
        	 //获取迭代器
        	 Iterator<FileItem> iters=items.iterator();
        	 while(iters.hasNext()){
        		 FileItem item=iters.next();
        		 //判断fileItem是文本域还是文件域，如果是文本域就是newsDetailCreateSimple.jsp中<input>里面的name属性
        		 if(item.isFormField()){//若是普通的文本表单控件
        			 String filedName=item.getFieldName();//获得文件域name的值
        		     if(filedName.equals("categoryId")){
        		    	 news.setCategoryId(Integer.parseInt(item.getString()));
        		     }else if(filedName.equals("title")){
        		    	 news.setTitle(item.getString("UTF-8"));//若是文本域value的值
        		     }else if(filedName.equals("author")){
        		    	 news.setAuthor(item.getString("UTF-8"));
        		     }else if(filedName.equals("summary")){
        		    	 news.setSummary(item.getString("UTF-8"));
        		     }else if(filedName.equals("newscontent")){
        		    	 news.setContent(item.getString("UTF-8"));
        		     }
        		 }else{//若是文件表单控件
        			 String fileName=item.getName();//获取上传文件的全路径和文件名
        		     System.out.println("filename=====>"+fileName);
        			 if(fileName !=null && !fileName.equals("")){
        		    	 File fullFile = new File(fileName);
        		    	 System.out.println("fullFile.getName()=====>"+fullFile.getName());
        		    	 //把文件上传到指定的目录下
        		    	 File saveFile = new File(uploadPath,fullFile.getName());
        		    	 System.out.println("saveFile.getName()=====>"+saveFile.getName());
        		    	 item.write(saveFile);//把item里面的流写到设定的路径里面
        		         //文件路径传到数据库中
        		         news.setPicPath(fullFile.getName());
        			 }
        		 }
        	 }
        	 
         }
       if(newsServiceImpl.add(news)){
         
      %>
      <jsp:forward page="../newsDetailList.jsp"></jsp:forward>
      <%} %>
      
      
      
      
      
      
      
      
</body>
</html>