<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo#1- week 10</title>
</head>
<body>
    <h2> use of pageContext to set ,get ,remove attribute from 4 scope: page,request,session,applicaton  </h2>
    <%
        pageContext.setAttribute("attName","in page");
        request.setAttribute("attName","in request");
        session.setAttribute("attName","in session");
//        application.setAttribute("attName","in applicatopn");

        pageContext.setAttribute("attName","in application",PageContext.APPLICATION_SCOPE);

    %>
    <h2>Get attribute using imlicit object-way1</h2>
    att value:<%=pageContext.getAttribute("attName")%><br>
    att value:<%=request.getAttribute("attName")%><br>
    att value:<%=session.getAttribute("attName")%><br>
    att value:<%=application.getAttribute("attName")%><br>
    <br>
    <h2>Get attribute using imlicit object-way2</h2>
    att value:<%=pageContext.getAttribute("attName",PageContext.PAGE_SCOPE)%><br>
    att value:<%=pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE)%><br>
    att value:<%=pageContext.getAttribute("attName",PageContext.SESSION_SCOPE)%><br>
    att value:<%=pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE)%><br>
    <h2>use findAttribute of pageContext-search-page-request-seesion-application-null</h2>
    att Value:<%=pageContext.findAttribute("attName")%> (which one?)<br>





</body>
</html>
