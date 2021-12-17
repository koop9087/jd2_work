<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
<style>
body {
    font-family: Roboto, Helvetica, sans-serif;
    background: url(${pageContext.servletContext.contextPath}/css/img.png );
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
                    $('#check').text(data.message);
                    if(data.successful) {
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

<form method="post" action="/ui/login" class="registration">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="login"><b>Login</b></label>
    <input name="login" type="text" placeholder="Usernames must be lowercase and 4-8 characters in length" class="form-control" id="login" pattern="[a-z]{4,8}" required>
    <div id="check"></div>
    <div id="label"></div>
    <br/>
    <label for="password"><b>Password</b></label>
    <input name="password" type="text" placeholder="password should consist 8 letters 1 num 1 little and 1 big lattin" class="form-control" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>

    <label for="email" class="form-label"><b>Email address</b></label>
    <input name="email" type="text" placeholder="Enter valid email" class="form-control" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <input type="hidden" name="command" value="add-new-user-login">
    <button id ="button" type="submit" class="registerbtn">Register</button>
  </div>
  <div class="container signin">
    <p>Already have an account? <a href="/ui/sign">Sign in</a>.</p>
  </div>
</form>

</body>
</html>