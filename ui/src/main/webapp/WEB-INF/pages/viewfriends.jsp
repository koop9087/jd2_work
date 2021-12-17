<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Salary</th></tr>
    <c:forEach items="${msg}" var="user">
        <tr>
            <td>${user.userLink}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/ui/friends/1">1</a>
<a href="/ui/friends/2">2</a>
<a href="/ui/friends/3">3</a>
</body>
</html>