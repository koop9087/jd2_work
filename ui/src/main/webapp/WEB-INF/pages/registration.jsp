<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 25.12.2021
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="userForm">
        <h2>Регистрация</h2>
        <div>
            <form:input type="text" path="login" placeholder="login"
                        autofocus="true"/>
            <form:errors path="login"/>
                ${loginError}
        </div>
        <div>
            <form:input type="password" path="password" placeholder="Password"/>
        </div>
        <button type="submit">Зарегистрироваться</button>
    </form:form>
    <a href="/home">Главная</a>
</div>
</body>
</html>

