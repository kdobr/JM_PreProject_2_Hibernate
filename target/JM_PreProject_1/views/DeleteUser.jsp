<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify users</title>
</head>
<body>

<form>
    Delete User <br><br>
    Login:<br>
    <input type="text" name="login" ><br>
    Password:<br>
    <input type="text" name="password" ><br><br>
    <input formmethod="post" type="submit" value="Delete User" />
</form> <br><br>

<%
    if (request.getAttribute("DeleteUserLogin") != null) {
        out.println("<h3>User '" + request.getAttribute("DeleteUserLogin") + "' deleted!</h3>");
    }
    if (request.getAttribute("wrongRequest") != null) {
        out.println("<h3>" + request.getAttribute("wrongRequest") +"</h3>");
    }
%>
<br>
<button onclick="location.href='/'">User Home Page</button>
</body>
</html>
