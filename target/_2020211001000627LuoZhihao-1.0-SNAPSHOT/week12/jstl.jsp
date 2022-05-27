<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Demo 1 -week 12</title>
</head>
<body>
    <h2>Use C:forEach fixed number of times - Type1</h2>
    <c:forEach var="i" begin="1" end="10" >
        <i>${i}</i>
    </c:forEach>
    <hr>
    <c:forTokens items="one,two,three,four.fiver.six" delims="." var="i">
        <li>${i}</li>
    </c:forTokens>
</body>
</html>
