<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify users</title>
</head>
<body>

<form>
    Update User <br><br>
    Login:<br>
    <input type="text" name="login"><br>
    Password:<br>
    <input type="text" name="password"><br>
    Name:<br>
    <input type="text" name="name"><br>
    Amount on account:<br>
    <input type="number" step="0.01" min="0" lang="en" name="amount"><br><br>
    <input formmethod="post" type="submit" value="Update User"/>

</form>
<br><br>

<%

    if (request.getAttribute("UpdateUserLogin") != null) {
        out.println("<h3>User '" + request.getAttribute("UpdateUserLogin") + "' updated!</h3><br>"+
        "<h3>New user detailes:  " + request.getAttribute("User") + "</h3>");
    }
    if (request.getAttribute("wrongRequest") != null) {
        out.println("<h3>" + request.getAttribute("wrongRequest") + "</h3>");
    }
%>
<br>
<button onclick="location.href='/'">User Home Page</button>
</body>
</html>
