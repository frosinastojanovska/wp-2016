<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Frosina
  Date: 22.11.2016
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<String> pizzaTypes = (ArrayList<String>) request.getAttribute("pizzaTypes"); %>
<html>
<head>
    <title>Index</title>
    <link rel="shortcut icon" href="/favicon.ico" type="image/png">
    <style>
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
        }
    </style>
</head>
<body>
<form action="/showClientInfo" method="post">
    <h3>Order Pizza</h3>
    <c:forEach var="item" items="${pizzaTypes}">
    <input id="${item}" type="radio" name="pizzaType" value="${item}">
    <label for="${item}">${item}</label>
    <br>
    </c:forEach>
        <br>
        <input type="submit" value="Sumbit">
</form>
</body>
</html>
