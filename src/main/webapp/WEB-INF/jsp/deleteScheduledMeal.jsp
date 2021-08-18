<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>
<h1 class="display-5">Delete Ingredients</h1>
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
            <p>${event.key.eventId}</p>
            <%--            <li class = "text-capitalize list-group-item">--%>
            <%--                <div class="input-group" style="display: table; width: 100%">--%>
            <%--                                    <span style="display: table-cell">--%>
            <%--                                               <label for = "removeTheseMealEvents"><c:out value = "${ingredient}"></c:out></label>--%>
            <
            <input type="checkbox" name="removeTheseMealEvents" id="removeTheseMealEvents" value="${event.key.eventId}"/>
            <%--                                    </span>--%>
            <%--                </div>--%>
            <%--            </li>--%>
        </c:forEach>
        </tbody>
            <%--    </ul>--%>
    </table>


    <div class="container">
        <input type="hidden" id="plan_id" name="_id" value="${event.recipeId}"/>
        <input type="submit" class="btn btn-success" value="Submit">
    </div>
</form:form>


<%@ include file="common/footer.jspf" %>
