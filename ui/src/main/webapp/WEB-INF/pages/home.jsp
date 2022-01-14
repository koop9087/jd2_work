<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="home.title"/></title>
    <meta charset=UTF-8"/>
</head>
<body>
<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <div>
        <a href="${pageContext.request.contextPath}/home?lang=en">Language(English)</a>
        &nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/home?lang=ru">Язык(Русский)</a>
        &nbsp;&nbsp;
    </div>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/ui/sign"><spring:message code="home.sign"/></a></h4>
        <h4><a href="/ui/register"><spring:message code="home.register"/></a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/ui/logout"><spring:message code="home.logout"/></a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/ui/friends"><spring:message code="home.friends"/></a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/ui/edit"><spring:message code="home.edit"/></a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/ui/users"><spring:message code="home.users"/></a></h4>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <h4><a href="/ui/admin"><spring:message code="home.users.admin"/></a></h4>
    </sec:authorize>
</div>
</body>
</html>