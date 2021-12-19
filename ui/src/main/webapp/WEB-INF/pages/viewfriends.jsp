<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Users</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Second name</th><th>Add to friends</th></tr>
    <c:forEach items="${msg}" var="user">
        <form:form action="/ui/friends/add/${user.userLink}" method="post">
        <tr>
            <td>${user.userLink}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td><button type="submit" name="add" value="add" class="btn-link">Add</button></td>
        </tr>
        </form:form>
    </c:forEach>
</table>
<br/>
<a href="/ui/friends/1">1</a>
<a href="/ui/friends/2">2</a>
<a href="/ui/friends/3">3</a>
</body>
</html>