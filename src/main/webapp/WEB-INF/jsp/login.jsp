<%@ include file = "common/header.jspf" %>

<c:url var="loginUrl" value="/login"/>
<h1 class = "display-6" style = "margin-top: 10px; margin-bottom: 10px;">Login</h1>
<form action="${loginUrl}" method="POST">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="enter username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="enter password">
    </div>
    <button type="submit" class="btn btn-outline-dark" style = "margin-top: 10px;">Login</button>
</form>

<%@ include file = "common/footer.jspf" %>