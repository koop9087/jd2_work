<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: Roboto, Helvetica, sans-serif;
            background: url(${pageContext.servletContext.contextPath}/css/img3.png);
            background-size 100% 100%;
            padding-top: 225px;
        }

        .sign-info {
            width: 500px;
            margin: auto;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background: black;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>

<form:form class="sign-info" method="post" modelAttribute="signWrapper">
    <spring:message code="sign.placeholder.login.info" var="placeholderLoginInfo"/>
    <spring:message code="sign.placeholder.password.info" var="placeholderPasswordInfo"/>
    <div class="container">
        <div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
            <a href="${pageContext.request.contextPath}/sign?lang=en">Language(English)</a>
            &nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/sign?lang=ru">????????(??????????????)</a>
            &nbsp;&nbsp;
        </div>
        <h1><spring:message code="sign.info.value"/></h1>
        <p><spring:message code="sign.info.fill.form"/></p>
        <hr>
        <label for="login"><b><h1><spring:message code="registration.login"/></h1></b></label>
        <form:input path="login" type="text" placeholder="${placeholderLoginInfo}" class="form-control"
                    id="login" pattern="[a-z]{5,18}"/>
        <br/>
        <label for="password"><b><spring:message code="registration.password"/></b></label>
        <form:input path="password" type="text" placeholder="${placeholderPasswordInfo}" class="form-control"
                    id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"/>
        <input type="hidden" name="command" value="user-sign-in">
        <button id="button" type="submit" class="registerbtn"><spring:message code="sign.info.value"/></button>
    </div>
</form:form>
</body>
</html>