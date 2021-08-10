<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/9/2021
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<style>
    .text-italic {
        font-style: italic;
    }
    .text-color {
        color: darkgreen;
    }
</style>
<%@ include file = "common/header.jspf" %>
<%--make sure you replace these features with the expression language call for the recipe models--%>
<div class = "container">
    <div class = "row">
        <div class = "text-right">
            <a href="modifyRecipe" class="btn btn-success btn-sm" role="button" aria-disabled="true">Edit Recipe</a>
        </div>
    </div>
</div>
<h1 class="display-5 text-italic text-color">Recipe Title</h1>


<p class="h6">Difficulty: </p>
<span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-smile" viewBox="0 0 16 16">
  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  <path d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>
</svg></span>

<span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-smile-upside-down" viewBox="0 0 16 16">
  <path d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zm0-1a8 8 0 1 1 0 16A8 8 0 0 1 8 0z"/>
  <path d="M4.285 6.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 4.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 3.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683zM7 9.5C7 8.672 6.552 8 6 8s-1 .672-1 1.5.448 1.5 1 1.5 1-.672 1-1.5zm4 0c0-.828-.448-1.5-1-1.5s-1 .672-1 1.5.448 1.5 1 1.5 1-.672 1-1.5z"/>
</svg></span>

<%--for loop to display difficulty rating--%>
<%--<c:forEach var = "i" begin = "1" end = "3">--%>
<%--    <c:choose>--%>
<%--        <c:when test = "${recipe.difficulty <= 3}">--%>
<%--        <span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-smile-upside-down" viewBox="0 0 16 16">--%>
<%--  <path d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zm0-1a8 8 0 1 1 0 16A8 8 0 0 1 8 0z"/>--%>
<%--  <path d="M4.285 6.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 4.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 3.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683zM7 9.5C7 8.672 6.552 8 6 8s-1 .672-1 1.5.448 1.5 1 1.5 1-.672 1-1.5zm4 0c0-.828-.448-1.5-1-1.5s-1 .672-1 1.5.448 1.5 1 1.5 1-.672 1-1.5z"/>--%>
<%--</svg></span>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-smile" viewBox="0 0 16 16">--%>
<%--  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>--%>
<%--  <path d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>--%>
<%--</svg></span>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</c:forEach>--%>

<h1 class = "display-6 text-color">Ingredients: </h1>
<div class = "container">
    <ul class = "list-group">
        <li class = "list-group-item">Item One</li>
        <li class = "list-group-item">Item Two</li>
        <li class = "list-group-item">Item Three</li>
        <li class = "list-group-item">Item Four</li>

<%--        for loop to display the ingredients for the recipe--%>
<%--        <c:forEach items = "${recipe.ingredients}" var = "ingredient">--%>
<%--            <li class = "list-group-item">${ingredient}</li>--%>
<%--        </c:forEach>--%>
    </ul>
</div>

<div class = "container">
    <h1 class = "display-6 text-color">Instructions: </h1>
    <blockquote class="blockquote">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi blanditiis cupiditate enim error facilis labore necessitatibus nemo nulla sapiente, sunt.
            Accusantium amet aut distinctio enim libero magni modi, quisquam repellat.</p>
<%--        <p>${recipe.instructions}</p>--%>
    </blockquote>
</div>


<%@ include file = "common/footer.jspf" %>
