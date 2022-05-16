<%@ page import="com.luozhihao.model.User" %>

<%@include file="header.jsp"%>
<h1> User Info</h1>

<%
//User user=(User)request.getAttribute("user");
    User user=(User)request.getSession().getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr><tr>
        <td>Password:</td><td><%=user.getPassword()%></td>
</tr><tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
</tr><tr>
    <td>Gender:</td><td><%=user.getGender()%></td>
</tr><tr>
    <td>Birth Date:</td><td><%=user.getBirthdate()%></td>
</tr><tr>
    <td><a href="update">updateInfo</a></td>
</tr>

</table>

<%@include file="footer.jsp"%>
