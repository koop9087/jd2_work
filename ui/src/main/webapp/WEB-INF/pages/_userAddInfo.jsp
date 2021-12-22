<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
            $("#link").keyup(function () {
                $.ajax({
                    url: '/ui/check/checkURL',
                    data: {
                        link: $('#link').val()
                    },
                    success: function (data) {
                        $('#check').text(data.message);
                        if (data.successful) {
                            $('#button').attr('disabled', 'disabled');
                        } else {
                            $('#button').removeAttr('disabled', 'disabled');
                        }
                    }
                });
            })
        });
    </script>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/login/add" class="additional-info">
    <div class="container">
        <h1>Add some information</h1>
        <p>Please fill in this form to add base info into account.</p>
        <hr>

        <label for="firstName"><b>First name</b></label>
        <input name="firstName" type="text" placeholder="Enter your first name" class="form-control" id="firstName"
              pattern="^[a-zA-Z]{1,100}$" required>
        <br/>
        <label for="secondName"><b>Second name</b></label>
        <input name="secondName" type="text" placeholder="Enter your second name" class="form-control" id="secondName"
               pattern ="^[a-zA-Z]{1,50}$" required>

        <label for="link" class="form-label"><b>Url pattern</b></label>
        <input name="link" type="text" placeholder="Enter valid ur profile link" class="form-control" id="link"
               pattern="[0-9]{1,7}" required>
        <div id="check"></div>
        <input type="hidden" name="command" value="add-new-user-info">
        <button id="button" type="submit" class="registerbtn">Register</button>
    </div>
</form>
</body>
</html>