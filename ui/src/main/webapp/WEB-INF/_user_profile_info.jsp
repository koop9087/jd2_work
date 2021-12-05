<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>List of persons</h1>
<table class="table">
<tbody>
<c:forEach var="user" items="${user}">
    <tr>
        <td scope="row"><a href="/ui/sign">LogOut</a></td>
        <td scope="row"><a href="/ui/sign?id=${user.id}">Open</a></td>
        <td>${user.firstName}</td>
        <td>${user.secondName}</td>
    </tr>
</c:forEach>
</tbody>
</table>