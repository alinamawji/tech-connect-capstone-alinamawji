<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "common/header.jspf" %>

<h1>Create a New Meal</h1>
<div class = "container">
        <c:url var = "addNewMealUrl" value="/addNewMeal"/>
        <form:form method = "POST" action = "${addNewMealUrl}" modelAttribute = "meal">
        <div class = "form-group">
            <label for="title">Title: </label>
            <form:input class="form-group" path="title" placeholder="Enter meal name"/>
            <form:errors path="title" cssClass="title"/>
        </div>

        <div class = "form-group">
            <label>Recipes from My Cookbook: </label>
            <div class="row">
                <div class="container" style="border: 2px solid; width:300px; height:100px; overflow-y: scroll;">
                    <for:forEach items="${recipes}" var="recipe">
                        <div class="row text-capitalize">
                            <input type="checkbox" name="recipes[]" value="${recipe.title}"/>${recipe.title}
                        </div>
                    </for:forEach>
                </div>
            </div>
        </div>
    </form:form>
</div>


<%@ include file = "common/footer.jspf" %>
