<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>

<div align="center">
    <form action="userAdd" method="get" id="my_form"></form>
    <table border="1" cellpadding="3">
        <tr>
            <td>Login</td>
            <td>Password</td>
            <td>Name</td>
            <td>Amount</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td>${user.amount}</td>
                <td><div align="center">
                    <form action="${pageContext.servletContext.contextPath}/userDelete" method="get">
                        <button type="submit" name="login" value="${user.login}" class="btn-link">Delete</button>
                    </form>
                </div></td>
                &nbsp;<td>&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.servletContext.contextPath}/userUpdate?login=${user.login}&name=${user.name}&amount=${user.amount}">Update</a>
            </td>
            </tr>
        </c:forEach>
        <tr>
            <td><input type="text" name="login" form="my_form"></td>
            <td><input type="text" name="password" form="my_form"></td>
            <td><input type="text" name="name" form="my_form"></td>
            <td><input type="number" step="0.01" min="0" lang="en" name="amount" form="my_form"></td>
            <td>
                <button type="submit" form="my_form">Add New User</button>
            </td>
        </tr>
    </table>
    <c:if test="${param.deletedLogin !=null}">
        <h2> User <c:out value="${param.deletedLogin}"/> deleted </h2>
    </c:if>
    <c:if test="${param.addUserLogin !=null}">
        <h2> User <c:out value="${param.addUserLogin}"/> added </h2>
    </c:if>
    <c:if test="${param.wrongRequest !=null}">
        <h2> User <c:out value="${param.wrongRequest}"/> not added - already exist! </h2>
    </c:if>
    <c:if test="${param.updatedLogin !=null}">
        <h2> User <c:out value="${param.addUserLogin}"/> updated </h2>
    </c:if>
    <c:if test="${param.wrongUpdate !=null}">
        <h2> User <c:out value="${param.wrongRequest}"/> not updated - login/password wrong! </h2>
    </c:if>
    <br>
    <button onclick="location.href='/list'">Home</button>
</div>
</body>
</html>


