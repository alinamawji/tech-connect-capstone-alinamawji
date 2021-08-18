<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "common/header.jspf" %>
<style>
    label {
        font-size: 1.5rem !important;
    }
    .form-group {
        margin-top: 5px;
        margin-bottom: 5px;
    }
</style>

<h1 class = "display-5">Add a New Ingredient</h1>
<hr>

<c:url var = "addNewIngredientUrl" value="/addNewIngredient"/>
<form:form method = "POST" action = "${addNewIngredientUrl}" modelAttribute = "ingredient">
    <label class= "display-5">Please submit one ingredient at a time: </label>
    <div class = "form-group">
    <form:input path = "name"/>
    <form:errors path = "name" cssClass="errors"/>
    </div>

    <div class = "form-group">
    <input type = "submit" class = "btn btn-success" value = "Submit">
    </div>
</form:form>



<%@ include file = "common/footer.jspf" %>
