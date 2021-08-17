<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/9/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file = "common/header.jspf" %>

<style>
    .selectList {
        border: 1px solid;
        width: 515px;
        height: 150px;
        border-radius: 3px;
        overflow-y: scroll;
    }

    label {
        margin: 5px;
        font-size: 1.5rem !important;
    }

    .form-group {
        margin: 20px;
        text-align: left;
        border-radius: 3px;
    }

    .textarea {
        width: 500px;
        display: block;
        height: 150px;
        border: 1px solid black;
        border-radius: 3px;
    }
</style>

<h1 class = "display-5">Create a New Recipe</h1>
<hr>
<div class = "container">
    <c:url var = "addNewRecipeUrl" value="/addNewRecipe"/>
    <form:form method = "POST" action = "${addNewRecipeUrl}" modelAttribute = "recipe">
        <div class = "form-group">
            <label class = "display-5" for="title">Title: </label>
            <form:input path="title"/>
            <form:errors path="title" cssClass="title"/>
        </div>

        <div class = "form-group">
            <label class = "display-5" for="difficulty">Difficulty (1-3): </label>
            <form:input path="difficulty" type="number" value="1" min="1" max="3" placeholder = "Insert difficulty rating of recipe here (1-3)."/>
            <form:errors path="difficulty" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label class = "display-5" for="overview">Overview: </label>
            <form:input type = "textarea" path="overview" placeholder = "Insert description of recipe here."/>
            <form:errors path="overview" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label class = "display-5">Category/Categories: </label>
<%--            path will change depending on whether we list categories as separate model or as part of a recipe (recipe.category)--%>
            <div class = "row">
                <div class = "container selectList">
                        <div class = "row text-capitalize" style = "margin-left: 15px;">
                            <form:checkboxes path = "categories" name="categories" items = "${categories}"/>
                        </div>
                </div>
            </div>
<%--            Healthy <input type = "checkbox" name = "categories[]" value = "Healthy"/>--%>
<%--            Mexican <input type = "checkbox" name = "categories[]" value = "Mexican"/>--%>
<%--            Thai <input type = "checkbox" name = "categories[]" value = "Thai"/>--%>
<%--            Sushi <input type = "checkbox" name= "categories[]" value = "Sushi"/>--%>
<%--            Vegetarian <input type = "checkbox" name = "categories[]" value = "Vegetarian"/>--%>
        </div>

        <div class = "form-group" style = "margin-bottom: 5px;">
            <label class = "display-5">Ingredients: </label>
            <div class = "container selectList">
                <div class = "row text-capitalize" style = "margin-left: 15px;">
                        <form:checkboxes path="ingredients" name = "ingredients" items="${ingredients}"/>
                </div>
            </div>
            <p>Don't see an ingredient? Add an ingredient with the button below!</p>
            <a href="addNewIngredient" class = "btn btn-success btn-sm">Add New Ingredient</a>
        </div>

        <div class = "form-group">
            <label class = "display-5" for="instructions">Instructions: </label>
            <div class = "row textarea" style = "margin-left: 5px;">
            <form:input type = "textarea" path="instructions" />
            <form:errors path="instructions" cssClass="error"/>
            </div>
        </div>

        <input class = "btn btn-success text-left" type = "submit" value = "Submit">
    </form:form>
</div>


<%@ include file = "common/footer.jspf" %>
