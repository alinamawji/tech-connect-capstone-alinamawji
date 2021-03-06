<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    input[type="checkbox"] {
        vertical-align: middle;
    }
</style>
<h1 class="display-5">Delete Scheduled Meals</h1>
<hr>

<c:url var="deleteEventsUrl" value="/deleteScheduledMeal"/>
<form:form method="POST" action="${deleteEventsUrl}" modelAttribute="mealEvent">
    <%--    <ul class = "list-group" style = "display: inline-block;">--%>
    <%--        for loop to display the ingredients for the recipe--%>

    <div class="form-group">
        <p class="row">Select any scheduled meals you'd like to remove from the plan: </p>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Meal</th>
                <th scope="col">Day</th>
                <th scope="col">Time of day</th>
                <th scope="col">Delete?</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${plannedMeals}" var="event">
                <c:set var="eventMeal" value="${event.key}"/>
                <c:set var="meal" value="${event.value}"/>
                <tr>
                    <td><c:out value="${meal.title}"/></td>
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
                    <td>
                        <input type="checkbox" name="removeTheseMealEvents" id="removeTheseMealEvents"
                               value="${event.key.eventId}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <div class="form-group">
        <input type="submit" class="btn btn-success" value="Submit">
    </div>
</form:form>


<%@ include file="common/footer.jspf" %>
