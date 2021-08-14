<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "common/header.jspf" %>

<h1 class = "display-5">Add a New Ingredient</h1>
<hr>

<c:url var = "addNewIngredientUrl" value="/addNewIngredient"/>
<form:form method = "POST" action = "${addNewIngredientUrl}" modelAttribute = "ingredient">
    <label>Please submit one ingredient at a time: </label>
    <form:input path = "name"/>
    <input type = "submit" class = "btn btn-success">
</form:form>


<%@ include file = "common/footer.jspf" %>
