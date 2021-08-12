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

<h1>Create a New Recipe</h1>
<div class = "container">
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
            <div class = "row">
                <div class = "container" style="border: 2px solid; width:300px; height: 100px; overflow-y: scroll;">
                <for:forEach items = "${categories}" var = "category">
                        <div class = "row text-capitalize">
                                ${category.name} <input type = "checkbox" name = "category[]" value="${category}"/>
                        </div>
                </for:forEach>
                </div>
            </div>
<%--            Healthy <input type = "checkbox" name = "categories[]" value = "Healthy"/>--%>
<%--            Mexican <input type = "checkbox" name = "categories[]" value = "Mexican"/>--%>
<%--            Thai <input type = "checkbox" name = "categories[]" value = "Thai"/>--%>
<%--            Sushi <input type = "checkbox" name= "categories[]" value = "Sushi"/>--%>
<%--            Vegetarian <input type = "checkbox" name = "categories[]" value = "Vegetarian"/>--%>
        </div>

        <div class = "form-group">
            <label for="overview">Overview: </label>
            <form:input path="overview" placeholder = "Insert description of recipe here."/>
            <form:errors path="overview" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label for="difficulty">Difficulty: (Insert difficulty rating of recipe here (1-3).)</label>
            <form:input path="difficulty" type="number" value="1" min="1" max="3" placeholder = "Insert difficulty rating of recipe here (1-3)."/>
            <form:errors path="difficulty" cssClass="error"/>
        </div>

        <div class = "form-group">
            <label>Ingredients: </label>
            <div class = "container" style="border: 2px solid; width:300px; height: 100px; overflow-y: scroll;">
            <for:forEach items = "${ingredients}" var = "ingredient">
                    <div class = "row text-capitalize">
                    ${ingredient.name} <input type = "checkbox" name = "ingredient[]" value="${ingredient}">
                    </div>
            </for:forEach>
            </div>
        </div>

        <div class = "form-group">
            <label for="instructions">Instructions: </label>
            <form:input type = "textarea" path="instructions"/>
            <form:errors path="instructions" cssClass="error"/>
        </div>

        <input type = "submit" value = "Submit">
    </form:form>
</div>


<%@ include file = "common/footer.jspf" %>
