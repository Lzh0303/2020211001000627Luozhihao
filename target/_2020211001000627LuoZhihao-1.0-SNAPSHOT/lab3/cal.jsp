<%--
  Created by IntelliJ IDEA.
  User: LuoZhiHao
  Date: 2022/5/30
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cal</title>
</head>
<body>
<form id="myForm" action="${pageContext.request.contextPath}/CalServlet" method="post">
    First val: <input id="firstVal" type="text" name="firstVal" value="${cookie.cFirstValue.value}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Enter a name：<input id="enterName" type="text" name="name" value="${cookie.cName.value}"><br>
    Second val：<input id="secondVal" type="text" name="secondVal" value="${cookie.cSecondValue.value}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Lengyh：<input id="length" type="text" readonly value="${cookie.cLength.value}"><br>
    Result：<input id="result" type="text" readonly value="${cookie.cResult.value}"><br>
    <input id="hidden" type="hidden" name="action" value="">
    <button id="add" type="button">Add</button>&nbsp;
    <button id="subtract" type="button">Subtract</button>&nbsp;
    <button id="multiply" type="button">Multiply</button>&nbsp;
    <button id="divide" type="button">Divide</button>&nbsp;
    <button id="computeLength" type="button">Compute Length</button>&nbsp;
    <br>
    <button id="reset" type="button">Reset</button>
</form>
<script src="../js/jquery.js"></script>
<script>
    $('#add').click(function () {
        $("#hidden").attr("value","add");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#subtract').click(function () {
        $('#hidden').attr("value","subtract");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#multiply').click(function () {
        $('#hidden').attr("value","multiply");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#divide').click(function () {
        $('#hidden').attr("value","divide");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#computeLength').click(function () {
        $('#hidden').attr("value","computeLength");
        if(chexkFormString()){
            $('#myForm').submit();
        }
    })
    $('#reset').click(function () {
        $('#firstVal').attr("value","");
        $('#secondVal').attr("value","");
        $('#enterName').attr("value","");
        $('#length').attr("value","");
        $('#result').attr("value","");
        $('#hidden').attr("value","");
    })
    function checkFormNum() {
        if (!checkNumber($('#firstVal').val())){
            alert("First val is not a number");
            return false;
        }
        if (!checkNumber($('#secondVal').val())){
            alert("Second val is not a number");
            return false;
        }
        return true;
    }
    function chexkFormString() {
        if (checkString($('#enterName').val())){
            alert("Name is not valid");
            return false;
        }
        return true;
    }
    function checkNumber(theObj) {
        var reg = /^[0-9]+.?[0-9]*$/;
        return reg.test(theObj);
    }
    function checkString(str) {
        var reg=/\d/;
        return reg.test(str);
    }
</script>
</body>
</html>
