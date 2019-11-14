<%@ page import="app.enties.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List of users</title>
</head>
<body>


<% List<User> users = (List<User>) request.getAttribute("users");
    if (users != null && !users.isEmpty()) {
        out.println("<ui>");
        for (User u : users) {
            out.println("<li>" + u + "</li>");
        }
        out.println("<ui>");
    } else out.println("<p>There are no users yet!</p>");
    pageContext.setAttribute("data", users.get(0).getName());
%>
<p>${requestScope.users[1]}</p>
<table>

    <tr>
        <td>Login</td>
        <td>Password</td>
        <td>Name</td>
        <td>Amount</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <c:out value="${data}"/>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td>${user.amount}/></td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Edit</a>
            </td>
            &nbsp;<td>&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">Delete</a>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='/'">User Home Page</button>

</body>
</html>


<%--
<%
    pageContext.setAttribute("name", "Tom");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Application</title>
</head>
<body>
<p>Name: ${name}</p>
</body>
</html>
--%>

