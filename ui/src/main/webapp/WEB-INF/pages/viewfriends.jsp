<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Users</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Second name</th><th>Delete from friends</th><th>Send Message</th></tr>
    <c:forEach items="${friends}" var="oneOfUsers">
        <form:form action="/ui/delete/${oneOfUsers.userLink}" method="post">
        <tr>
            <td>${oneOfUsers.userLink}</td>
            <td>${oneOfUsers.firstName}</td>
            <td>${oneOfUsers.secondName}</td>
            <td><button type="submit" name="add" value="add" class="btn-link">Delete</button></td>
            <td><a href="/ui/messages/${oneOfUsers.userLink}">Send messages</a></td>
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