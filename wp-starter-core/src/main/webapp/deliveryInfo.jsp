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
<form action="/AddressInfo.do" method="post">
    <h3>Order Pizza</h3>
    <label>Name: &nbsp;</label><input id="name" type="text" name="name">
    <br>
    <label>Address: &nbsp;</label><input id="address" type="text" name="address">
    <br>
    <input type="submit" value="Sumbit">
</form>
</body>
</html>
