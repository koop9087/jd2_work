<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

<h2>Welcome</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td>Second name</td>
        <td>${user.secondName}</td>
    </tr>
    <h2>
        <tr>
            <a href="#">Messages</a>
        </tr>
        <tr>

            <a href="#">Friends</a>
        </tr>
        <tr>
            <a href="/ui/edit">Edit page</a>
        </tr>
    </h2>
</table>
</body>
</html>