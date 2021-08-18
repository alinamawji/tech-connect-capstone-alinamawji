<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>
<h1 class="display-5">Delete Scheduled Meals</h1>
<hr>

<c:url var="deleteEventsUrl" value="/deleteScheduledMeal"/>
<form:form method="POST" action="${deleteEventsUrl}" modelAttribute="mealEvent">
    <%--    <ul class = "list-group" style = "display: inline-block;">--%>
    <%--        for loop to display the ingredients for the recipe--%>
    <p class="row">Select any scheduled meals you'd like to remove from the plan: </p>
    <table>
        <thead>
        <tr>
            <th>Meal</th>
            <th>Day</th>
            <th>Time of day</th>
            <th>Delete?</th>
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
                <td>
                    <input type="checkbox" name="removeTheseMealEvents" id="removeTheseMealEvents" value="${event.key.eventId}"/>
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


    <div class="container">
        <input type="submit" class="btn btn-success" value="Submit">
    </div>
</form:form>


<%@ include file="common/footer.jspf" %>
