<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        //error

        out.println(request.getAttribute("message"));
    }
    //记住我
    Cookie[] cookies = request.getCookies();
    String username="";
    String password="";
    String rememberMe="";
    if (cookies!=null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")){
                username=cookie.getValue();
            }
            if (cookie.getName().equals("password")){
                password=cookie.getValue();
            }
            if (cookie.getName().equals("rememberMe")){
                rememberMe=cookie.getValue();
            }
        }
    }
    System.out.println(username);
    System.out.println(password);
    System.out.println(rememberMe);

%>
<form method="post" action="login">
    Username : <input type="text" name="username" value="<%=username%>"><br/>
    Password : <input type="password" name="password" value="<%=password%>"><br/>
<%--    记住我--%>
    <input type="checkbox" name="rememberMe" value="1"  <%=rememberMe.equals("1")?"checked":""%> /> RememberMe
    <input type="submit" value="Submit"/>
</form>
<%@include file="footer.jsp"%>