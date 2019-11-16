<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Modify users</title>
</head>
<body>
<div align="center">
<form>
    Update User <br><br>
    Login:<br>
    <input type="text" name="login" value=${param.login}><br>
    Password:<br>
    <input type="text" name="password"><br>
    New Password:<br>
    <input type="text" name="newPassword"><br>
    Name:<br>
    <input type="text" name="newName" value=${param.name}><br>
    Amount on account:<br>
    <input type="number" step="0.01" min="0" lang="en" name="newAmount" value=${param.amount}><br><br>
    <input formmethod="post" type="submit" value="Update User"/>
</form>
<br>
<button onclick="location.href='/list'">Home</button>
</div>
</body>
</html>
