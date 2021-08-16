<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/15/2021
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "common/header.jspf" %>

<h1 class = "display-5">Add Ingredients To Recipe</h1>
<hr>

<c:url var = "addIngredientsToRecipeUrl" value="/addNewIngredientsToRecipe"/>
<form:form method = "POST" action = "${addIngredientsToRecipeUrl}" modelAttribute="newIngredients">
    <div class = "container">
    <p>Select any ingredients you'd like to add to the recipe: </p>
    <ul class = "list-group" style = "display: inline-block;">
            <%--        for loop to display the ingredients for the recipe--%>
        <c:forEach items = "${allIngredients}" var = "ingredient">
            <li class = "text-capitalize list-group-item">
                <div class="input-group" style="display: table; width: 100%">
                                    <span style="display: table-cell">
<%--                                        is there anyway to print out only ingredients NOT in the recipe already?--%>
                                               <label for = "newIngredients"><c:out value = "${ingredient}"/></label>
    <input type = "checkbox" name = "newIngredients" id = "newIngredients" value = "${ingredient}"/>
                                    </span>
                </div>
            </li>
        </c:forEach>
    </ul>
    </div>

    <div class = "container">
    <input type = "hidden" id = "recipeId" name = "recipeId" value = "${recipe.recipeId}"/>
    <input type = "submit" class = "btn btn-success" value = "Submit">
    </div>
</form:form>
