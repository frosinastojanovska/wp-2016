<%--
  Created by IntelliJ IDEA.
  User: Frosina
  Date: 30.10.2016
  Time: 02:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <style>
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
        }
    </style>
</head>
<body>
<form action="/placeOrder" method="post">
    <h3>Order Pizza</h3>
    <label>Name: &nbsp;</label><input id="clientName" type="text" name="clientName">
    <br>
    <label>Address: &nbsp;</label><input id="clientAddress" type="text" name="clientAddress">
    <br>
    <br>
    <input type="submit" value="Sumbit">
</form>
</body>
</html>
