<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/9/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file = "common/header.jspf" %>

<h1>Create a New Recipe</h1>
<div class = "container">
    <form class = "form-inline">
    <c:url var = "addNewRecipeUrl" value="/addNewRecipe"/>
    <form:form method = "POST" action = "${addNewRecipeUrl}" modelAttribute = "recipe">
        <div class = "form-group">
            <label for="title">Title: </label>
            <form:input path="title"/>
            <form:errors path="title" cssClass="title"/>
        </div>

        <div class = "form-group">
            <label>Category/Categories: </label>
<%--            path will change depending on whether we list categories as separate model or as part of a recipe (recipe.category)--%>
            Healthy <form:checkbox path="category" value = "Healthy"/>
            Mexican <form:checkbox path="category" value = "Mexican"/>
            Thai <form:checkbox path="category" value = "Thai"/>
            Sushi <form:checkbox path="category" value = "Sushi"/>
            Vegetarian <form:checkbox path="category" value = "Vegetarian"/>
            <form:errors path="category" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label for="overview">Overview: </label>
            <form:input path="overview" placeholder = "Insert description of recipe here."/>
            <form:errors path="overview" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label for="difficulty">Difficulty: </label>
            <form:input path="difficulty" placeholder = "Insert difficulty rating of recipe here (1-3)."/>
            <form:errors path="difficulty" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label>Ingredients: </label>
            <form:checkboxes path="ingredient" items="${ingredientList}"/>
            <form:errors path="ingredient" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label for="instruction">Instructions: </label>
            <form:input type = "textarea" path="instruction"/>
            <form:errors path="instruction" cssClass="error"/>
        </div>
    </form>
    </form:form>
</div>


<%@ include file = "common/footer.jspf" %>
