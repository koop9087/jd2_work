<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin page</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>ID</th>
        <th>UserName</th>
        <th>Password</th>
        <th>Roles</th>
        <th>FirstName</th>
        <th>SecondName</th>
        <th>Status</th>
        <th>Delete</th>
        <th>Ban</th>
        <th>Unban</th>
        </thead>
        <c:forEach items="${allUsers}" var="oneOfUsers">
            <tr>
                <td>${oneOfUsers.id}</td>
                <td>${oneOfUsers.login}</td>
                <td>${oneOfUsers.password}</td>
                <td>
                    <c:forEach items="${oneOfUsers.roles}" var="role">${role.name}; </c:forEach>
                </td>
                <td>${oneOfUsers.firstName}</td>
                <td>${oneOfUsers.secondName}</td>
                <td>${oneOfUsers.status}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="userId" value="${oneOfUsers.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="userId" value="${oneOfUsers.id}"/>
                        <input type="hidden" name="action" value="ban"/>
                        <button type="submit">Ban</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="userId" value="${oneOfUsers.id}"/>
                        <input type="hidden" name="action" value="unban"/>
                        <button type="submit">Unban</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/ui/home">Главная</a>
</div>
</body>
</html>
