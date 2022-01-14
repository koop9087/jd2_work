<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h1><spring:message code="friends.title.value"/></h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th><spring:message code="friends.id.value"/></th>
        <th><spring:message code="edit.field.firstName"/></th>
        <th><spring:message code="edit.field.secondName"/></th>
        <th><spring:message code="friends.delete.value"/></th>
        <th><spring:message code="friends.send.value"/></th>
    </tr>
    <c:forEach items="${friends}" var="oneOfUsers">
        <form:form action="/ui/delete/${oneOfUsers.userLink}" method="post">
            <tr>
                <td>${oneOfUsers.userLink}</td>
                <td>${oneOfUsers.firstName}</td>
                <td>${oneOfUsers.secondName}</td>
                <td>
                    <button type="submit" name="add" value="add" class="btn-link"><spring:message code="admin.delete.value"/></button>
                </td>
                <td><a href="/ui/messages/${oneOfUsers.userLink}"><spring:message code="friends.send.value"/></a></td>
            </tr>
        </form:form>
    </c:forEach>
</table>
<br/>
<a href="/ui/friends/1">1</a>
<a href="/ui/friends/2">2</a>
<a href="/ui/friends/3">3</a>
</body>
</html>