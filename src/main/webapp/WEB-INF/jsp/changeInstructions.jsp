<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "common/header.jspf" %>

<h1 class = "display-5">Edit Recipe Instructions</h1>
<hr>

<c:url var = "changeInstructionsUrl" value="/changeInstructions"/>
<form:form method = "POST" action = "${changeInstructionsUrl}" modelAttribute="instructions">
    <div class = "container">
    <label for = "newInstructions">Please edit your instructions below.</label>
    <input type = "hidden" id = "recipeId" name = "recipeId" value = "${recipe.recipeId}">
    <div class = "row">
        <input style = "height: 150px; width: 200px;" type = "textarea" id = "newInstructions" name = "newInstructions" value = "${recipe.instructions}">
    </div>
        <div class = "row">
        <input type = "submit" class = "btn btn-success" value = "Submit">
        </div>
    </div>
</form:form>
<%@ include file = "common/footer.jspf" %>