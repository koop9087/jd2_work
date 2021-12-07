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
    background: url(css/img3.png) no-repeat;
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

<form method="post" action="/ui/sign" class="sign-info">
  <div class="container">
    <h1>Sign in</h1>
    <p>Please fill in this form to sign in account.</p>
    <hr>

    <label for="login"><b>Login</b></label>
    <input name="login" type="text" placeholder="Enter your login" class="form-control" id="login" required>
    <br/>
    <label for="password"><b>Password</b></label>
    <input name="password" type="text" placeholder="Enter your password" class="form-control" id="password" required>

    <input type="hidden" name="command" value="user-sign-in">
    <button id ="button" type="submit" class="registerbtn">Sign in</button>
  </div>
</form>
</body>
</html>