<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: Roboto, Helvetica, sans-serif;
            background: url(${pageContext.servletContext.contextPath}/css/img4.png); /* сделать другой фон */
            padding-top: 225px;
        }

        .additional-info {
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
            $("#url").keyup(function () {
                $.ajax({
                    url: '/ui/check/checkURL',
                    data: {
                        link: $('#url').val()
                    },
                    success: function (data) {
                        $('#urlMessage').text(data.message);
                        if (data.successful) {
                            $('#button').attr('disabled', 'disabled');
                            $('#urlMessage').show();
                        } else {
                            $('#button').removeAttr('disabled', 'disabled');
                            $('#urlMessage').hide();
                        }
                    }
                });
            })
        });
    </script>
</head>
<body>

<form:form class="additional-info" method="post" action="${pageContext.request.contextPath}/profile"
           modelAttribute="registrationWrapper">
    <spring:message code="add.info.firstName.placeholder" var="validFirstNameMessage"/>
    <spring:message code="add.info.secondName.placeholder" var="validSecondNameMessage"/>
    <spring:message code="add.info.url.placeholder" var="validUrlMessage"/>
    <div class="container">
        <h1><spring:message code="add.info.info.value"/></h1>
        <p><spring:message code="add.info.fill.info.value"/></p>
        <hr>
        <label for="firstName"><b><spring:message code="add.info.firstName.value"/></b></label>
        <form:input path="firstName" type="text" placeholder="${validFirstNameMessage}" class="form-control"
                    id="firstName"
                    pattern="^[a-zA-Z]{0,100}$"/>
        <p/>
        <label for="secondName"><b><spring:message code="add.info.secondName.value"/></b></label>
        <form:input path="secondName" type="text" placeholder="${validSecondNameMessage}" class="form-control"
                    id="secondName"
                    pattern="^[a-zA-Z]{0,50}$"/>
        <p/>
        <label for="url" class="form-label"><b><spring:message code="add.info.url.value"/></b></label>
        <form:input path="url" type="text" placeholder="${validUrlMessage}" class="form-control" id="url"
                    pattern="[0-9]{0,7}"/>
        <div id="urlMessage" hidden>
            <spring:message code="rest.info.url.value"/>
        </div>
        </p>
        <input type="hidden" name="command" value="add-new-user-info">
        <button id="button" type="submit" class="registerbtn"><spring:message code="add.info.button.value"/></button>
    </div>
</form:form>
</body>
</html>