<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/11/2021
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file = "common/header.jspf" %>

<!doctype html>
<html lang="en">
<head>
    <title>Registration Confirmation</title>
</head>
<body>
<div class = "container">
    <h1 class = "display-4" style = "margin-left: 20px;" >Your registration is complete!</h1>
    <hr>
    <p class = "fw-normal fst-italic">Thanks, (insert user name here). Checkout Best Byte's best features with the buttons below!</p>

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

        <div class = "col-md-2">
            <a class="btn btn-success" href="mealPlan" role="button">Meal Plans</a>
        </div>

    </div>

</div>
</body>
</html>
<%@ include file = "common/footer.jspf" %>