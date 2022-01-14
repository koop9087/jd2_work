<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><spring:message code="admin.title.value"/></title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th><spring:message code="friends.id.value"/></th>
        <th><spring:message code="registration.login"/></th>
        <th><spring:message code="registration.password"/></th>
        <th><spring:message code="admin.roles.value"/></th>
        <th><spring:message code="add.info.firstName.value"/></th>
        <th><spring:message code="add.info.secondName.value"/></th>
        <th><spring:message code="admin.status.value"/></th>
        <th><spring:message code="admin.delete.value"/></th>
        <th><spring:message code="admin.ban.value"/></th>
        <th><spring:message code="admin.unban.value"/></th>
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
                    <form method="post">
                        <input type="hidden" name="userId" value="${oneOfUsers.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit"><spring:message code="admin.delete.value"/></button>
                    </form>
                </td>
                <td>
                    <form method="post">
                        <input type="hidden" name="userId" value="${oneOfUsers.id}"/>
                        <input type="hidden" name="action" value="ban"/>
                        <button type="submit"><spring:message code="admin.ban.value"/></button>
                    </form>
                </td>
                <td>
                    <form method="post">
                        <input type="hidden" name="userId" value="${oneOfUsers.id}"/>
                        <input type="hidden" name="action" value="unban"/>
                        <button type="submit"><spring:message code="admin.unban.value"/></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/ui/home"><spring:message code="home.title"/></a>
</div>
</body>
</html>
