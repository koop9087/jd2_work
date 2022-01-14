<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <style>
        * {
            box-sizing: border-box
        }

        @import 'https://fonts.googleapis.com/css?family=Open+Sans:400,400i&subset=cyrillic';
        body {
            margin: 0;
            background: #F7F7F7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: 'Open Sans', sans-serif;
        }

        .form-wrap {
            width: 550px;
            background: #ffd500;
            border-radius: 20px;
        }

        .form-wrap * {
            transition: .1s linear
        }

        .profile {
            width: 240px;
            float: left;
            text-align: center;
            padding: 30px;
        }

        form {
            background: white;
            float: left;
            width: calc(100% - 240px);
            padding: 30px;
            border-radius: 0 20px 20px 0;
            color: #7b7b7b;
        }

        .form-wrap:after, form div:after {
            content: "";
            display: table;
            clear: both;
        }

        form div {
            margin-bottom: 15px;
            position: relative;
        }

        h1 {
            font-size: 24px;
            font-weight: 400;
            position: relative;
            margin-top: 50px;
        }

        label, span {
            display: block;
            font-size: 14px;
            margin-bottom: 8px;
        }

        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px 15px;
            border-width: 0;
            background: #e6e6e6;
            outline: none;
            margin: 0;
        }

        input[type="text"]:focus, input[type="email"]:focus {
            box-shadow: inset 0 0 0 2px rgba(0, 0, 0, .2);
        }

        .radio label {
            position: relative;
            padding-left: 50px;
            cursor: pointer;
            width: 50%;
            float: left;
            line-height: 40px;
        }

        .radio input {
            position: absolute;
            opacity: 0;
        }

        .radio-control {
            position: absolute;
            top: 0;
            left: 0;
            height: 40px;
            width: 40px;
            background: #e6e6e6;
            border-radius: 50%;
            text-align: center;
        }

        .male:before {
            content: "\f222";
            font-family: FontAwesome;
            font-weight: bold;
        }

        .female:before {
            content: "\f221";
            font-family: FontAwesome;
            font-weight: bold;
        }

        .radio label:hover input ~ .radio-control,
        .radiol input:focus ~ .radio-control {
            box-shadow: inset 0 0 0 2px rgba(0, 0, 0, .2);
        }

        .radio input:checked ~ .radio-control {
            color: red;
        }

        select {
            width: 100%;
            cursor: pointer;
            padding: 10px 15px;
            outline: 0;
            border: 0;
            background: #e6e6e6;
            color: #7b7b7b;
            -webkit-appearance: none;
            -moz-appearance: none;
        }

        select::-ms-expand {
            display: none;
        }

        .select-arrow {
            position: absolute;
            top: 38px;
            right: 15px;
            width: 0;
            height: 0;
            pointer-events: none;
            border-style: solid;
            border-width: 8px 5px 0 5px;
            border-color: #7b7b7b transparent transparent transparent;
        }

        button {
            padding: 10px 0;
            border-width: 0;
            display: block;
            width: 120px;
            margin: 25px auto 0;
            background: #60e6c5;
            color: white;
            font-size: 14px;
            outline: none;
            text-transform: uppercase;
        }

        @media (max-width: 600px) {
            body {
                display: block
            }

            .form-wrap {
                margin: 20px auto;
                max-width: 550px;
                width: 100%
            }

            .profile, form {
                float: none;
                width: 100%
            }

            h1 {
                margin-top: auto;
                padding-bottom: 50px;
            }

            form {
                border-radius: 0 0 20px 20px
            }
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(function () {
            $("#wrapperUrl").keyup(function () {
                $.ajax({
                    url: '/ui/check/checkURL',
                    data: {
                        link: $('#wrapperUrl').val()
                    },
                    success: function (data) {
                        $('#wrapperUrlMessage').text(data.message);
                        if (data.successful) {
                            $('#button').attr('disabled', 'disabled');
                            $('#wrapperUrlMessage').show();
                        } else {
                            $('#button').removeAttr('disabled', 'disabled');
                            $('#wrapperUrlMessage').hide();
                        }
                    }
                });
            })
        });
    </script>
</head>

<div class="form-wrap">
    <spring:message code="edit.field.firstName.placeholder" var="firstNamePlaceholder"/>
    <spring:message code="edit.field.secondName.placeholder" var="secondNamePlaceholder"/>
    <div class="profile"><img src="https://html5book.ru/wp-content/uploads/2016/10/profile-image.png">
        <h1><spring:message code="edit.info.value"/></h1>
        <h1><spring:message code="edit.fill.info.value"/></h1>
    </div>
    <form:form method="post" modelAttribute="editWrapper">
        <div>
            <label><spring:message code="edit.field.firstName"/> >> ${user.firstName}</label>
            <form:input path="wrapperFirstName" type="text" placeholder="${firstNamePlaceholder}"/>
            </p>
            <form:errors path="wrapperFirstName" cssStyle="color: red" cssClass="form-control height30px error"/>
            </p>
            <label><spring:message code="edit.field.secondName"/> >> ${user.secondName}</label>
            <form:input path="wrapperSecondName" type="text" placeholder="${secondNamePlaceholder}"
                        id="secondName"
                        pattern="^[a-zA-Z]{1,50}$"/>
            </p>
            <form:errors path="wrapperSecondName" cssStyle="color: red" cssClass="form-control height30px error"/>
            </p>
            <label><spring:message code="edit.field.url"/> >> ${user.userLink}</label>
            <form:input path="wrapperUrl" type="text" placeholder="${secondNamePlaceholder}"
                        pattern="[0-9]{1,7}" id="wrapperUrl"/>
            <div id="wrapperUrlMessage" hidden>
                <spring:message code="rest.info.url.value"/></div>
            </p>
            <form:errors path="wrapperUrl" cssStyle="color: red" cssClass="form-control height30px error"/>
            </p>
            <label><spring:message code="edit.field.email"/> >> ${user.email}</label>
            <form:input path="wrapperEmail" type="text" placeholder="${firstNamePlaceholder}"
                        pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
            </p>
            <form:errors path="wrapperEmail" cssStyle="color: red" cssClass="form-control height30px error"/>
            </p>
            <label><spring:message code="edit.field.profileStatus"/> >> ${user.profileStatus} </label>
            <form:input path="wrapperProfileStatus" type="text" placeholder="${firstNamePlaceholder}"
                        pattern="^[a-zA-Z]{1,20}$"/>
            </p>
            <form:errors path="wrapperProfileStatus" cssStyle="color: red" cssClass="form-control height30px error"/>
        </b>
        <div class="radio">
            <span><spring:message code="edit.field.gender"/> >> ${user.gender}</span>
            <label>
                <input type="radio" name="gender" value="man"><spring:message code="edit.field.gender.value.man"/>
                <div class="radio-control male"></div>
            </label>
            <label>
                <input type="radio" name="gender" value="woman"><spring:message code="edit.field.gender.value.woman"/>
                <div class="radio-control female"></div>
            </label>
        </div>
        <div>
            <label><spring:message code="edit.field.country"/> >> ${user.country}</label>
            <form:select path="wrapperCountry">
                <form:option value=""><spring:message code="edit.field.country.option.value"/></form:option>
                <form:option value="Russia"><spring:message code="edit.field.country.option.value.russia"/></form:option>
                <form:option value="Ukraine"><spring:message code="edit.field.country.option.value.ukraine"/></form:option>
                <form:option value="Belarus"><spring:message code="edit.field.country.option.value.belarus"/></form:option>
            </form:select>
            <div class="select-arrow"></div>
        </div>
        <button type="submit"><spring:message code="edit.button.value"/></button>
    </form:form>
</div>