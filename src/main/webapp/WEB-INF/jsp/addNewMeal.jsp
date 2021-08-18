<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "common/header.jspf" %>

<style>
    label {
        margin: 5px;
        font-size: 1.5rem !important;
    }
    #recipeLabels {
        font-size: 20px !important;
    }

    .form-group {
        margin: 20px;
        text-align: left;
        border-radius: 3px;
    }
    .selectList {
        border: 1px solid;
        width: 515px;
        height: 150px;
        border-radius: 3px;
        overflow-y: scroll;
    }
    input[type="checkbox"]
    {
        vertical-align:middle;
    }
</style>

<h1 class = "display-5">Create a New Meal</h1>
<hr>
<div class = "container">
        <c:url var = "addNewMealUrl" value="/addNewMeal"/>
        <form:form method = "POST" action = "${addNewMealUrl}" modelAttribute = "meal">
        <div class = "form-group">
            <label for="title" class = "display-5">Title: </label>
            <form:input class="form-group" style = "border: 1px solid black;" path="title" placeholder="Enter meal name"/>
            <form:errors path="title" cssClass="title"/>
        </div>

        <div class = "form-group">
            <label class = "display-5">Recipes from My Cookbook: </label>
            <div class="row">
                <div class="container selectList">
                    <ul class = "list-group">
                    <for:forEach items="${cookbookRecipes}" var="cookbookRecipe">
                        <div class="row text-capitalize">
                            <li class = "list-group-item">
                            <label for = "recipesInMeal" id = "recipeLabels">${cookbookRecipe.title}</label>
                            <input type="checkbox" name="recipesInMeal" id="recipesInMeal" value="${cookbookRecipe.title}"/>
                            </li>
                        </div>
                    </ul>
                    </for:forEach>
                </div>
            </div>
        </div>
            <input class = "btn btn-success text-left" style = "margin: 20px;" type = "submit" value = "Create Meal">
    </form:form>
</div>


<%@ include file = "common/footer.jspf" %>
