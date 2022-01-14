<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: Roboto, Helvetica, sans-serif;
            background: url(${pageContext.servletContext.contextPath}/css/img.png);
            padding-top: 125px;
        }

        .registration {
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
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(function () {
            $("#login").keyup(function () {
                $.ajax({
                    url: '/ui/check',
                    data: {
                        login: $('#login').val()
                    },
                    success: function (data) {
                        if (data.successful) {
                            $('#button').attr('disabled', 'disabled');
                            $('#loginMessage').show();
                        } else {
                            $('#button').removeAttr('disabled', 'disabled');
                            $('#loginMessage').hide();
                        }
                    }
                });
            })
        });
    </script>
</head>
<body>

<form:form class="registration" method="post" modelAttribute="registrationWrapper">
    <spring:message code="registration.login.pattern.message" var="validLoginMessage"/>
    <spring:message code="registration.password.pattern.message" var="validPasswordMessage"/>
    <spring:message code="registration.email.pattern.message" var="validEmailMessage"/>
    <div class="container">
        <div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
            <a href="${pageContext.request.contextPath}/register?lang=en">Language(English)</a>
            &nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/register?lang=ru">Язык(Русский)</a>
            &nbsp;&nbsp;
        </div>
        <h1><spring:message code="registration.button"/></h1>
        <p><spring:message code="registration.fill.form"/></p>
        <hr>
        <label for="login"><b><spring:message code="registration.login"/></b></label>
        <input name="login" type="text" placeholder="${validLoginMessage}"
               class="form-control" id="login" pattern="[a-z]{6,18}" value="${login}" required>
        <div id="loginMessage" hidden>
            <spring:message code="rest.info.value"/>
        </div>
        <div id="label"></div>
        <br/>
        <label><b><spring:message code="registration.password"/></b></label>
        <form:input path="password" placeholder="${validPasswordMessage}"
                    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"/>
        <form:errors path="password" cssStyle="color: red" cssClass="form-control height30px error"/>
        <p/>
        <label><b><spring:message code="registration.email"/></b></label>
        <form:input path="email" placeholder="${validEmailMessage}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"/>
        <form:errors path="email" cssStyle="color: red" cssClass="form-control height30px error"/>
        <p/>
        <hr>
        <p><spring:message code="registration.terms"/><a href="#"><spring:message
                code="registration.terms.privacy"/></a></p>
        <input type="hidden" name="command" value="add-new-user-login">
        <button id="button" type="submit" class="registerbtn"><spring:message code="registration.button"/></button>
    </div>
    <div class="container signin">
        <p><spring:message code="registration.sign.question"/><a href="/ui/sign"><spring:message
                code="registration.sign.value"/></a>.</p>
    </div>
</form:form>

</body>
</html>