<%@ page import="com.ChenZirong.model.User" %><
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%--need form--%>
<%
    User user=(User)request.getSession().getAttribute("user");
%>
<form method="post" action="update">
    <input type="hidden" name="id" value="<%=user.getId()%>">
    username<input type="text" name="username" value="<%=user.getUsername()%>" />
    password<input type="password" name="password" value="<%=user.getPassword()%>" />
    Email<input type="text" name="email" value="<%=user.getEmail()%>" />
    Gender<input type="radio" name="gender" value="male" <%="male".equals(user.getGender())?"checked":""%> />Male
    <input type="radio" name="gender" value="female" <%="female".equals(user.getGender())?"checked":""%> />FeMale
    Date of Birth:<input type="text" name="birthdate" value="<%=user.getBirthdate()%>" />
    <input type="submit" value="Save Change" />

</form>
<%@include file="footer.jsp"%>
