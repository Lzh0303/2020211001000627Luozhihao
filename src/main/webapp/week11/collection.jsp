<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo -3 -week 11</title>
</head>
<body>
<%
    //array
    String[] fristName={"Bill","Scott","Larry"};
    //list
    ArrayList<String> lastName=new ArrayList<>();
    lastName.add("Ellison");
    lastName.add("Gates");
    lastName.add("McNealy");
    //map
    HashMap<String,String> companyName=new HashMap<>();
    companyName.put("Ellison","Sun");
    companyName.put("Gates","Oracle");
    companyName.put("McNealy","Micosoft");
    //set attribute in any one scope
    request.setAttribute("fname",fristName);
    request.setAttribute("lname",lastName);
    request.setAttribute("company",companyName);
%>

<h2>get data from Array -->List -->map --using El code</h2>
<ul>
    <li>${fname["0"]}--->${lname["0"]}--->${company[lname["0"]]}</li>
    <li>${fname["1"]}--->${lname["1"]}--->${company[lname["1"]]}</li>
    <li>${fname["2"]}--->${lname["2"]}--->${company[lname["2"]]}</li>
</ul>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>use c:forEach to get from array</h2>
<ul>
    <c:forEach var="a" items="${fname}">
        <li>${a}</li>
    </c:forEach>
</ul>
<h2>use c:forEach to get from List</h2>
<ul>
    <c:forEach var="l" items="${lname}">
        <li>${l}</li>
    </c:forEach>
</ul>
<h2>use c:forEach to get from HashMap</h2>
<ul>
    <c:forEach var="c" items="${company}">
        <li>${c.value}</li>
    </c:forEach>
</ul>
</body>
</html>
