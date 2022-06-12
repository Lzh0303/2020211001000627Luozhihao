<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form method="post" action="register.jsp">
        Username:<input type="text" name="username" placeholder="Username" /><br>
        Password:<input type="password" name="password" placeholder="password" /><br>
        EMail:<input type="email" name="email" placeholder="Email"><br>
        <label>Gender:</label>
        <span>
            &nbsp;
            <input type="radio" style="width: 15px; height: 15px; display:inline;" name="gender" value="male" checked/>&nbsp;Male
            &nbsp;
            <input type="radio" style="width: 15px; height: 15px; display: inline;" name="gender" value="female"/>&nbsp;Female
        </span><br>
        Date of Birth: <input type="date" name="birthdate" placeholder="Date of Birth (yyyy-mm-dd)"><br>
        <input type="submit" value="Register"/>
    </form>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--连接数据库--%>
<sql:setDataSource var="myDs"
                   driver='${initParam.get("driver")}'
                   url='${initParam.get("url")}'
                   user='${initParam.get("username")}'
                   password='${initParam.get("password")}'/>
<c:if test="${!empty param.username}" >
    <sql:update var="newUser" dataSource="${myDs}">
        insert into user(`username`,`password`,`email`,`gender`,`birthdate`) values(?,?,?,?,?)
        <sql:param value="${param.username}"/>
        <sql:param value="${param.password}"/>
        <sql:param value="${param.email}"/>
        <sql:param value="${param.gender}"/>
        <sql:param value="${param.birthdate}"/>
    </sql:update>
</c:if>

<%--select--%>
<sql:query var="selectusers" dataSource="${myDs}">
    select * from user
</sql:query>
<table>
    <c:forEach var="row" items="${selectusers.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.username}"/></td>
            <td><c:out value="${row.password}"/></td>
            <td><c:out value="${row.email}"/></td>
            <td><c:out value="${row.gender}"/></td>
            <td><c:out value="${row.birthdate}"/></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
