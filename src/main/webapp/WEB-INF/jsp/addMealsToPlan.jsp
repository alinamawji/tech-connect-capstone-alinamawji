<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>

<style>
    .form-group {
        margin: 10px;
    }
</style>

<h1 class="display-5">Create a Meal Plan</h1>
<hr>

<c:url value="/addMealsToPlan" var="addMealsToPlanUrl"/>
<div class="container">
    <form:form method="POST" action="${addMealsToPlanUrl}" modelAttribute="mealEvent">
    <div id="planned_meal">
        <div class="form-group">
            <label>Select which meal you'd like to add: </label>
            <select id="meal_id" name="meal_id">
                <for:forEach items="${mealPlan.selectedMeals}" var="meal">
                    <option value="${meal.mealId}">${meal.title}</option>
                </for:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Select which day you're planning meals for: </label>
            <select id="weekday" name="weekday">
                <option name="weekday" value="1">Monday</option>
                <option name="weekday" value="2">Tuesday</option>
                <option name="weekday" value="3">Wednesday</option>
                <option name="weekday" value="4">Thursday</option>
                <option name="weekday" value="5">Friday</option>
                <option name="weekday" value="6">Saturday</option>
                <option name="weekday" value="7">Sunday</option>
            </select>
        </div>

        <div class="form-group">
            <label>Select what time of day you'd like for this meal:</label>
            <select id="time_of_day" name="time_of_day">
                <option name="time_of_day" value="1">Breakfast</option>
                <option name="time_of_day" value="2">Lunch</option>
                <option name="time_of_day" value="3">Dinner</option>
                <option name="time_of_day" value="4">Snack</option>
            </select>
        </div>
        <input type="submit" id="submitMeal" name="submitMeal" value="Add Planned Meal">
    </div>
    </form:form>

    <for:url value="/mealPlans" var="mealPlanUrl"/>
    <div class="form-group">
        <a href="${mealPlanUrl}">
            <input type="submit" class="btn btn-success" value="Submit Meal Plan">
        </a>
    </div>


<%@ include file="common/footer.jspf" %>