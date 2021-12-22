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
            background: url(${pageContext.servletContext.contextPath}/css/img4.png );                   /* сделать другой фон */
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
            padding: 10px 10px;
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

<form method="get" action="/ui/profile/${user.userLink}" class="additional-info">
    <div class="container">
        <h1>${user.firstName} ${user.secondName} ${user.userLink}</h1>
        <a href="/ui/edit" class="registerbtn">Edit profile</a>
        <a href="/ui/messages" class="registerbtn">Messages</a>
        <a href="/ui/friends/1" class="registerbtn">Friends</a>
        <a href="/ui/logout" class="registerbtn">Logout</a>
    </div>
</form>



<div class="ui-widget">
    <label for="birds">Birds: </label>
    <input id="birds">
</div>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
        function log( message ) {
            $( "<div>" ).text( message ).prependTo( "#log" );
            $( "#log" ).scrollTop( 0 );
        }

        $( "#birds" ).autocomplete({
            source: "search.jsp",
            minLength: 2,
            select: function( event, ui ) {
                log( "Selected: " + ui.item.value + " aka " + ui.item.id );
            }
        });
    } );
</script>

<div class="ui-widget" style="margin-top:2em; font-family:Arial">
    Result:
    <div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
</div>

</body>
</html>