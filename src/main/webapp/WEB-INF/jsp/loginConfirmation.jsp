<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/11/2021
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file = "common/header.jspf" %>

<!doctype html>
<html lang="en">
<head>
    <title>Login Confirmation</title>
</head>
<body>
<div class = "container">
    <h1 class = "display-4" style = "margin-left: 20px;" >Hi, (insert user name here).</h1>
    <hr>
    <p class = "fw-normal fst-italic">You've logged in successfully. Continue to using Best Byte with the buttons below!</p>

    <div class = "row text-center">
        <div class = "col-md-2">
            <a class="btn btn-success" href="index" role="button">Back to Home</a>
        </div>

        <div class = "col-md-2">
            <a class="btn btn-success" href="recipes" role="button">Go to Recipes</a>
        </div>

        <div class = "col-md-2">
            <a class="btn btn-success" href="cookbook" role="button">My Cookbook</a>
        </div>

    </div>

</div>
</body>



<%@ include file = "common/footer.jspf" %>
