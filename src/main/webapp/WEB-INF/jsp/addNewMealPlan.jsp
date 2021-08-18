<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>

<style>
    label {
        margin: 5px;
        font-size: 1.5rem !important;
    }

    #mealIdLabel {
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

    input[type="checkbox"] {
        vertical-align: middle;
    }
</style>
</style>

<h1 class="display-5">Create a Meal Plan</h1>
<hr>

<c:url value="/addNewMealPlan" var="addNewMealPlanUrl"/>
<div class="container">
    <form:form method="POST" action="${addNewMealPlanUrl}" modelAttribute="mealPlan">
    <div class="form-group">
        <label class="display-5" for="title">Title: </label>
        <form:input type="textarea" path="title"/>
        <form:errors path="title" cssClass="errors"/>
    </div>

    <div class="form-group">
        <label class="display-5" for="description">Description: </label>
        <form:input type="textarea" path="description"/>
        <form:errors path="description" cssClass="errors"/>
    </div>

    <div class="form-group">
        <label class="display-5">Select which meals you'd like to add to this meal plan: </label>
        <div class="row">
            <div class="container selectList">
                <ul class="list-group">
                        <%--        for loop to display the meals for the plan--%>
                    <for:forEach items="${meals}" var="meal">
                    <div class="row text-capitalize">
                        <li class="list-group-item">
                            <label for="meal_id" id="mealIdLabel"><c:out value="${meal.title}"/></label>
                            <input type="checkbox" name="meal_id" id="meal_id" value="${meal.mealId}">
                        </li>
                    </div>
                </ul>
                </for:forEach>
            </div>
        </div>
    </div>

    <div class="form-group">
        <p>Continue to the next page to schedule your meals.</p>
        <input type="submit" class="btn btn-success" value="Continue to Next Page">
    </div>
    </form:form>
<%@ include file="common/footer.jspf" %>