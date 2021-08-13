<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/9/2021
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file = "common/header.jspf" %>

<style>
    .text-italic {
        font-style: italic;
    }
    .text-color {
        color: darkgreen;
    }
    .text-right {
        text-align: right !important;
    }
</style>

<%--make sure you replace these features with the expression language call for the recipe models--%>
<div class = "container">
    <div class = "row">
        <div class = "text-right" style = "margin-bottom: 5px; margin-top: 10px;">

            <c:set var="activeButton" value=""/>
            <c:if test = "${recipe.creatorUsername != user.username || user.firstName == null}">
                <c:set var="activeButton" value="disabled"/>
            </c:if>

<%--            <c:set var = "activeButton" value = "${user.firstName != null ? '' : 'disabled'}"/>--%>
            <c:if test = "${activeButton == 'disabled'}">
                <c:out value = "Looks like you aren't currently logged in! Please login to access some of our other features like uploading and saving recipes."/>
            </c:if>

            <c:url var="formAction" value="/recipeDetails"/>
            <form method="POST" action="${ formAction }">
                <input type="hidden" id="recipe_id" name="recipe_id" value="${ recipe.recipeId }">
                <input type="submit" role="button" class = "btn btn-sm btn-success ${activeButton}" style = "margin-bottom: 5px;" aria-disabled="true" value="Edit Recipe">
            </form>

        </div>
    </div>
</div>
<h1 class="display-5 text-italic text-color"><c:out value="${recipe.title}"/> </h1>

<%-- for loop to display difficulty rating --%>
<c:forEach var = "i" begin = "1" end = "3">
    <c:choose>
        <c:when test = "${recipe.difficulty <= 3}">
        <span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
</svg></span>
        </c:when>
        <c:otherwise>
            <span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
  <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
</svg></span>
        </c:otherwise>
    </c:choose>
</c:forEach>


<%--<hr>--%>

<%--<h1 class = "display-6 text-color">Overview: </h1>--%>
<%--<p><c:out value = "${recipe.overview}"/></p>--%>

<hr>

<h1 class = "display-6 text-color" style = "margin-bottom: 10px;">Ingredients: </h1>
<div class = "container">
    <ul class = "list-group" style = "display: inline-block;">
<%--        for loop to display the ingredients for the recipe&ndash;--%>
        <c:forEach items = "${ingredients}" var = "ingredient">
            <li class = "list-group-item text-capitalize"><c:out value="${ingredient.name}"/></li>
        </c:forEach>
    </ul>
</div>

<hr>

<div class = "container">
    <h1 class = "display-6 text-color">Instructions: </h1>
    <blockquote class="blockquote">
        <p>${recipe.instructions}</p>
    </blockquote>
</div>


<%@ include file = "common/footer.jspf" %>
