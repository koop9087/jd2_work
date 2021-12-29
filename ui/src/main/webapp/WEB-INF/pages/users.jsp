<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

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
        <th>UserName</th>
        <th>FirstName</th>
        <th>SecondName</th>
        <th>Add Friend</th>
        </thead>
        <c:forEach items="${allUsers}" var="oneOfUsers" varStatus="status">
            <tr>
                <td>${oneOfUsers.id}</td>
                <td>${oneOfUsers.firstName}</td>
                <td>${oneOfUsers.secondName}</td>
                <td>
                    <form action="/ui/profile/add" method="post">
                        <input type="hidden" name="testUserLink" value="${oneOfUsers.userLink}"/>
                        <button type="submit" name="add" value="add" class="btn-link">Add</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/ui/home">Главная</a>
</div>
</body>
</html>
