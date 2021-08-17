<%@ include file="common/header.jspf" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<style>
    #grid {
        display: grid;
        grid-gap: 15px;
        grid-auto-rows: minmax(150px, 1fr);
        grid-auto-flow: row dense;
    }

    .text-right {
        text-align: right !important;
    }
</style>

<h1 class="display-6" style="margin-top: 20px; margin-bottom: 10px;">My Meals</h1>
<hr>


<%--ternary operator to determine if there is a user logged in--%>
<c:set var="activeButton" value="${user.firstName != null ? '' : 'disabled'}"/>

<c:if test="${activeButton == 'disabled'}">
    <c:out value="Looks like you aren't currently logged in! Please login to access some of our other features like uploading and saving recipes."/>
</c:if>

<div class="text-right" style="margin-bottom: 10px; margin-top: 10px;">

    <%--button is not active when the user is not logged in  --%>
    <a href="addNewMeal" class="btn btn-success btn-sm ${activeButton}" role="button" aria-disabled="true">Add Meal</a>
</div>

<div class="container" id="grid">
    <div class="row">
        <for:forEach items="${meals}" var="meal">
            <%--            <c:url var="detailUrl" value="/meals">--%>
            <%--                <c:param name="meal_id" value="${meal.mealId}"/>--%>
            <%--            </c:url>--%>
            <div class="col-md-4">
                <div class="card" style="margin-bottom: 5px; margin-top: 5px;">
                    <div class="card-body text-center">
                        <div style="text-align: left">
                            <c:url var="formAction" value="/meals"/>
                            <form method="POST" action="${ formAction }">
                                <input type="hidden" id="meal_id" name="meal_id" value="${meal.mealId}">
                                <input type="submit" role="button" class="btn btn-sm btn-success"
                                       style="margin-bottom: 5px;" value="Delete">
                            </form>
                        </div>
                        <h5 class="card-title"><c:out value="${meal.title}"/></h5>

                        <c:forEach items="${meal.recipesInMeal}" var="recipe" varStatus="status">
                            ${recipe}<c:if test="${!status.last}">,</c:if>
                        </c:forEach>
<%--                                    <c:out value="${meal.recipesInMeal}"/>--%>
                    </div>
                </div>
            </div>
        </for:forEach>
    </div>
</div>
</body>


<%@ include file="common/footer.jspf" %>
