<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify users</title>
</head>
<body>

<form action="/userAdd">
    Add New User <br>
    Login:<br>
    <input type="text" name="login"><br>
    Password:<br>
    <input type="text" name="password"><br>
    Name:<br>
    <input type="text" name="name"><br>
    Amount on account:<br>
    <input type="number" step="0.01" min="0" lang="en" name="amount"><br><br>
    <input formmethod="post" type="submit" value="Add User"/>
    </form>
<br><br>
<%
    if (request.getAttribute("AddUserLogin") != null) {
        out.println("<h3>User '" + request.getAttribute("AddUserLogin") + "' added!</h3>");
    }
    if (request.getAttribute("wrongRequest") != null) {
        out.println("<h3>" + request.getAttribute("wrongRequest") + "</h3>");
    }
%>
<br>
<button onclick="location.href='/'">User Home Page</button>
</body>
</html>
