<%@ include file = "common/header.jspf" %>

<c:url var="loginUrl" value="/login"/>
<form action="${loginUrl}" method="POST">
    <div class="form-group">
        <label for="username">Username</label>
<<<<<<< HEAD
        <input type="text" class="form-control" id="username" name="username" placeholder="enter username">
=======
        <input type="text" class="form-control" id="username" name="username" placeholder="username">
>>>>>>> 591e4ec7d88014569c8c55f9af5a215ba05e1cf7
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="enter password">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
</form>

<%@ include file = "common/footer.jspf" %>