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
    <h4>Current Schedule of Meals</h4>
        <table>
            <thead>
            <tr>
                <th>Meal</th>
                <th>Day</th>
                <th>Time of day</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${plannedMeals}" var="event">
                <c:set var="eventMeal" value="${event.key}"/>
                <c:set var="meal" value="${event.value}"/>
                <tr>
                    <td><c:out value="${meal.title}"/> </td>
                    <td>
                        <c:if test="${eventMeal.weekday == 1}">Monday</c:if>
                        <c:if test="${eventMeal.weekday == 2}">Tuesday</c:if>
                        <c:if test="${eventMeal.weekday == 3}">Wednesday</c:if>
                        <c:if test="${eventMeal.weekday == 4}">Thursday</c:if>
                        <c:if test="${eventMeal.weekday == 5}">Friday</c:if>
                        <c:if test="${eventMeal.weekday == 6}">Saturday</c:if>
                        <c:if test="${eventMeal.weekday == 7}">Sunday</c:if>
                    </td>
                    <td>
                        <c:if test="${eventMeal.timeOfDay == 1}">Breakfast</c:if>
                        <c:if test="${eventMeal.timeOfDay == 2}">Lunch</c:if>
                        <c:if test="${eventMeal.timeOfDay == 3}">Dinner</c:if>
                        <c:if test="${eventMeal.timeOfDay == 4}">Snack</c:if>
                    </td>
                </tr>
                <%--            <li class = "text-capitalize list-group-item">--%>
                <%--                <div class="input-group" style="display: table; width: 100%">--%>
                <%--                                    <span style="display: table-cell">--%>
                <%--                                               <label for = "removeTheseMealEvents"><c:out value = "${ingredient}"></c:out></label>--%>
                <%--                                    </span>--%>
                <%--                </div>--%>
                <%--            </li>--%>
            </c:forEach>
            </tbody>
            <%--    </ul>--%>
        </table>



<%@ include file="common/footer.jspf" %>