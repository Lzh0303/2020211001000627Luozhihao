<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>get request paramter using El code</h2>
name:${param.name}<br>
ID:${param.id}<br>
subject:${paramValues.subject[0]},${paramValues.subject[1]},${paramValues.subject[2]}<br>
<hr>

<h2>get request header - using El</h2>


<h2>get Context init param(set in web.xml) -using El code</h2>
Driver :${initParam.driver}<br>
username :${initParam.username}<br>
<hr>
<h2>get session、request.method from pageContext  -using El code</h2>
session ID:${pageContext.session.id}<br>
request method:${pageContext.request.method}<br>
</body>
</html>
