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

<h1 class = "display-5">Delete Ingredients</h1>
<hr>

<c:url var = "deleteIngredientsUrl" value="/deleteIngredientsFromRecipe"/>
<form:form method = "POST" action = "${deleteIngredientsUrl}" modelAttribute="ingredient">
    <ul class = "list-group" style = "display: inline-block;">
            <%--        for loop to display the ingredients for the recipe--%>
        <p class = "row">Select any ingredients you'd like to remove from the recipe: </p>
        <c:forEach items = "${ingredients}" var = "ingredient">
            <li class = "text-capitalize list-group-item">
                <div class="input-group" style="display: table; width: 100%">
                                    <span style="display: table-cell">
                                               <label for = "removeTheseIngredients"><c:out value = "${ingredient}"></c:out></label>
    <input type = "checkbox" name = "removeTheseIngredients" id = "removeTheseIngredients" value = "${ingredient}"/>
                                    </span>
                </div>
            </li>
        </c:forEach>
    </ul>


    <div class = "container">
        <input type = "hidden" id = "recipeId" name = "recipeId" value = "${recipe.recipeId}"/>
        <input style = "margin-top: 5px;" type = "submit" class = "btn btn-success" value = "Submit">
    </div>
</form:form>




<%@ include file = "common/footer.jspf" %>

