<%@ page import="com.luozhihao.week11.Person" %>
<%@ page import="com.luozhihao.week11.Dog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Demo 2 -week 11</title>
</head>
<body>
<%
    //create objects
    Person person=new Person();
    person.setName("Tom");
    Dog dog=new Dog();
    dog.setName("Tommy");
    person.setDog(dog);
    //set attribute
    request.setAttribute("personAtt",person);

    Person person2=new Person();
    person2.setName("pom");
    Dog dog2=new Dog();
    dog2.setName("Pommy");
    person2.setDog(dog2);

    Person person3=new Person();
    person3.setName("Nom");
    Dog dog3=new Dog();
    dog3.setName("Nommy");
    person3.setDog(dog3);

    //list of person
    ArrayList<Person> personArrayList=new ArrayList<>();
    personArrayList.add(person);
    personArrayList.add(person2);
    personArrayList.add(person3);
    request.setAttribute("pList",personArrayList);

%>
    <h2>get person' dog name -using java code</h2>
    <%
        Person personAtt = (Person) pageContext.findAttribute("personAtt");
        Dog d= personAtt.getDog();
        out.println(personAtt.getName()+"s' Dog name--->"+d.getName());
    %>
    <h2>get person' dog name -using EL code</h2>
    ${personAtt["name"]}‘s Dog name :${personAtt.dog.name}

    <h2>c: forEach to get persons' dog nme</h2>
    <ul>
        <c:forEach var="p" items="${pList}">
            <li>${p.name}s' dog name---->${p.dog.name}</li>
        </c:forEach>
    </ul>
</body>
</html>
