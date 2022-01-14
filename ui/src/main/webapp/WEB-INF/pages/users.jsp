<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><spring:message code="users.title.value"/></title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th><spring:message code="registration.login"/></th>
        <th><spring:message code="edit.field.firstName"/></th>
        <th><spring:message code="edit.field.secondName"/></th>
        <th><spring:message code="users.friend.add"/></th>
        </thead>
        <c:forEach items="${allUsers}" var="oneOfUsers" varStatus="status">
            <tr>
                <td>${oneOfUsers.id}</td>
                <td>${oneOfUsers.firstName}</td>
                <td>${oneOfUsers.secondName}</td>
                <td>
                    <form action="/ui/profile/add" method="post">
                        <input type="hidden" name="testUserLink" value="${oneOfUsers.userLink}"/>
                        <button type="submit" name="add" value="add" class="btn-link"><spring:message code="users.friend.add.action"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/ui/home"><spring:message code="home.title"/></a>
</div>
</body>
</html>
