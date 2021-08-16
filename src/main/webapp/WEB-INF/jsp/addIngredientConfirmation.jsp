<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/13/2021
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "common/header.jspf" %>

<h1 class = "display-5">Add a New Ingredient</h1>
<hr>

<p>You've added ${newIngredient} to the list of ingredients. Use the button below to go back to uploading a recipe.</p>
<a href="addNewRecipe" class="btn btn-success btn-sm" role="button" aria-disabled="true">Upload New Recipe</a>

<%@ include file = "common/footer.jspf" %>