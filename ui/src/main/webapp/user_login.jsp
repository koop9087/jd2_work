<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<jsp:include page="_header.jsp"/>
<meta charset="utf-8">
<h1>Registration form</h1>

<div style="position: center">
<form method="post" action="/ui/login">
  <div class="mb-3">
    <label for="login" class="form-label">Login</label>
    <input name="login" type="text" class="form-control" id="login" aria-describedby="loginHelp" pattern="[a-z]{4,8}">
    <script>
          $('#login').keyup(function() {
               var Value = $('#login').val();
                 $('#check').empty();
                 $('#check').text(Value);
               });
            </script>
    <div id="check"></div>
    <div>HJHHKJHKJKJHFTYUGIHOJPKOJH</div>
    <p>Usernames must be lowercase and 4-8 characters in length.</p>
    <div id="firstNameHelp" class="form-text">Enter login</div>
  </div>
 <div class="mb-3">
     <label for="password" class="form-label">Password</label>
     <input name="password" type="text" class="form-control" id="password" aria-describedby="passwordHelp" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
     <p>Пароль не может быть короче восьми символов и должен содержать хотя бы одну цифру, одну маленькую и одну большую латинскую букву></p>
     <div id="passwordHelp" class="form-text">Enter password</div>
   </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email address</label>
        <input name="email" type="text" class="form-control" id="email" aria-describedby="emailHelp" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
        <div id="emailHelp" class="form-text">Enter email</div>
      </div>
      <input type="hidden" name="command" value="add-new-user-login">
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
<jsp:include page="_footer.jsp"/>