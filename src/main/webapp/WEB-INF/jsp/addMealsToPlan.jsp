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
    <form method="POST" action="${addMealsToPlanUrl}">
    <div id="planned_meal">
        <div class="form-group">
            <label>Select which meal you'd like to add: </label>
            <select>
                <for:forEach items="${meals}" var="meal">
                    <label for="meal_id">${meal.title}</label>
                    <option id="meal_id" name="meal_id" value="${meal.mealId}">${meal.title}</option>
                </for:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Select which day you're planning meals for: </label>
            <select id = "weekday">
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
            <label>Select what time of day you'd like for this meal (up to seven meal time slots per day): </label>
            <select>
                <for:forEach var="i" begin="1" end="7">
                    <option id="mealEvent" value="${i}">${i}</option>
                </for:forEach>
            </select>
        </div>
        <input type="submit" id="submitMeal" name="submitMeal" value="Add Planned Meal">
    </div>
    </form>
    <form method="GET" action="/mealPlans">
        <div class="form-group">
            <input type="submit" class="btn btn-success" value="Submit Meal Plan">
        </div>
    </form>


<%@ include file="common/footer.jspf" %>