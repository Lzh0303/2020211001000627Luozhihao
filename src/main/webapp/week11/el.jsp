<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 1-week 11</title>
</head>

<%
    pageContext.setAttribute("attName","att in page");
    request.setAttribute("attName","att in request");
    session.setAttribute("attName","att in session");
    application.setAttribute("attName","att in applicatopn");
//    pageContext.setAttribute("attName","in application",PageContext.APPLICATION_SCOPE);
%>
<body>
    <h2>get 4 scope variable -ussing java code </h2>
    att value:<%=pageContext.getAttribute("attName",PageContext.PAGE_SCOPE)%><br>
    att value:<%=pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE)%><br>
    att value:<%=pageContext.getAttribute("attName",PageContext.SESSION_SCOPE)%><br>
    att value:<%=pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE)%><br>

    Find att:<%=pageContext.findAttribute("attName")%>

    <h2>get 4 scope variable -ussing El code </h2>

    Att value: ${attName}<!--findAttribute("attName") which one-->

    <h2>not find - get Attribute from any one scope  using El code </h2>

    att value_session:${sessionScope.attName}<br/>
    att Value_request:${requestScope.attName}<br/>
    att value_page:${pageScope.attName}<br/>
    att value_application:${applicationScope.attName}<br/>




</body>
</html>
