<%@ page import="java.util.List" %>
<%@ page import="app.enties.User" %><%--
  Created by IntelliJ IDEA.
  User: kdobr
  Date: 07.11.2019
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>

<%
    List<User> users = (List<User>) request.getAttribute("users");

    if (users != null && !users.isEmpty()) {
        out.println("<ui>");
        for (User u : users) {
            out.println("<li>" + u + "</li>");
        }
        out.println("<ui>");
    } else out.println("<p>There are no users yet!</p>");
%><br>
<button onclick="location.href='/'">User Home Page</button>

</body>
</html>
