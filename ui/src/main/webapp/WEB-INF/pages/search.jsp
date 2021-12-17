
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(function () {
        $("#login").keyup(function () {
            $.ajax({
                url: '/ui/search',
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
</body>
</html>
