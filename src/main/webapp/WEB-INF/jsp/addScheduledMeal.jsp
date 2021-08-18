<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>

<style>
    label {
        margin: 5px;
        font-size: 1.5rem !important;
    }

    .form-group {
        margin: 20px;
        text-align: left;
        border-radius: 3px;
    }
    input[type="checkbox"]
    {
        vertical-align:middle;
    }
</style>

<h1 class="display-5">Add More Scheduled Meals</h1>
<hr>

<c:url value="/addScheduledMeal" var="addScheduledMealsUrl"/>
<div class="container">
    <form:form method="POST" action="${addScheduledMealsUrl}" modelAttribute="mealEvent">
    <div id="planned_meal">
        <div class="form-group">
            <label>Select which meal you'd like to add: </label>
            <select class = "form-select" id="meal_id" name="meal_id">
                <for:forEach items="${mealPlan.selectedMeals}" var="meal">
                    <option value="${meal.mealId}">${meal.title}</option>
                </for:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Select which day you're planning meals for: </label>
            <select class = "form-select" id="weekday" name="weekday">
                <option name="weekday" value="2">Monday</option>
                <option name="weekday" value="3">Tuesday</option>
                <option name="weekday" value="4">Wednesday</option>
                <option name="weekday" value="5">Thursday</option>
                <option name="weekday" value="6">Friday</option>
                <option name="weekday" value="7">Saturday</option>
                <option name="weekday" value="1">Sunday</option>
            </select>
        </div>

        <div class="form-group">
            <label>Select what time of day you'd like for this meal:</label>
            <select class = "form-select" id="time_of_day" name="time_of_day">
                <option name="time_of_day" value="1">Breakfast</option>
                <option name="time_of_day" value="2">Lunch</option>
                <option name="time_of_day" value="3">Dinner</option>
                <option name="time_of_day" value="4">Snack</option>
            </select>
        </div>
        <div class = "form-group">
        <input class = "btn btn-success btn-sm" type="submit" id="submitMeal" name="submitMeal" value="Add Planned Meal">
        </div>
    </div>
    </form:form>
    <h4>Current Schedule of Meals</h4>
    <table class = "table">
        <thead>
        <tr>
            <th scope = "col">Meal</th>
            <th scope = "col">Day</th>
            <th scope = "col">Time of Day</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${plannedMeals}" var="event">
            <c:set var="eventMeal" value="${event.key}"/>
            <c:set var="meal" value="${event.value}"/>
            <tr>
                <td class = "text-capitalize"><c:out value="${meal.title}"/></td>
                <td>
                    <c:if test="${eventMeal.weekday == 2}">Monday</c:if>
                    <c:if test="${eventMeal.weekday == 3}">Tuesday</c:if>
                    <c:if test="${eventMeal.weekday == 4}">Wednesday</c:if>
                    <c:if test="${eventMeal.weekday == 5}">Thursday</c:if>
                    <c:if test="${eventMeal.weekday == 6}">Friday</c:if>
                    <c:if test="${eventMeal.weekday == 7}">Saturday</c:if>
                    <c:if test="${eventMeal.weekday == 1}">Sunday</c:if>
                </td>
                <td>
                    <c:if test="${eventMeal.timeOfDay == 1}">Breakfast</c:if>
                    <c:if test="${eventMeal.timeOfDay == 2}">Lunch</c:if>
                    <c:if test="${eventMeal.timeOfDay == 3}">Dinner</c:if>
                    <c:if test="${eventMeal.timeOfDay == 4}">Snack</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <%--    </ul>--%>
    </table>

        <c:url value="/mealPlans" var="mealPlanUrl"/>
        <div class="form-group">
            <a href="${mealPlanUrl}">
                <input type="submit" class="btn btn-success" value="Submit Meal Plan">
            </a>
        </div>

<%@ include file="common/footer.jspf" %>