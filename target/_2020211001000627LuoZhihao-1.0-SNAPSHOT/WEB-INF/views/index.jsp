<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@include file="header.jsp"%>
<%!
  public void jspInit(){
    System.out.println("ininit()");
  }
%>
<!-- service-->
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %><% System.out.println("service");%>
  Date and Time<%out.print(new Date());%>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
<!-- end of service-->
<%!
  public void jspDestroy(){
    System.out.println("jspDestroy()");
  }
%>
<%@include file="footer.jsp"%>