<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>
<style>
    .form-group {
        margin-top: 5px;
        margin-bottom: 5px;
    }
</style>

<h1 class="display-5">Edit Recipe Instructions</h1>
<hr>

<c:url var="changeInstructionsUrl" value="/changeInstructions"/>
<form:form method="POST" action="${changeInstructionsUrl}" modelAttribute="instructions">
    <div class="container">
        <div class="form-group">
            <label for="newInstructions">Please edit your instructions below.</label>
            <input type="hidden" id="recipeId" name="recipeId" value="${recipe.recipeId}">
        </div>

        <div class="form-group">
            <input style="height: 150px; width: 200px;" type="textarea" id="newInstructions" name="newInstructions"
                   value="${recipe.instructions}">
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-success" value="Submit">
        </div>
    </div>
</form:form>
<%@ include file="common/footer.jspf" %>