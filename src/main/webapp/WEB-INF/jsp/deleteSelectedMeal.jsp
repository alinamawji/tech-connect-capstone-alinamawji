<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>

<c:url var="addSelectedMealUrl" value="/addSelectedMeal"/>
<form:form method="POST" action="${addSelectedMealUrl}" modelAttribute="deleteMeal">
    <div class="container">
        <p>Select any meals you'd like to add to the meal plan: </p>
        <ul class="list-group" style="display: inline-block;">
            <c:forEach items="${listOfMeals}" var="meal">
                <li class="text-capitalize list-group-item">
                    <div class="input-group" style="display: table; width: 100%">
                                    <span style="display: table-cell">
                                               <label for="selectedMeals"><c:out value="${meal.title}"/></label>
    <input type="checkbox" name="selectedMeals" id="selectedMeals" value="${meal.mealId}"/>
                                    </span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="container">
        <input type="hidden" id="plan_id" name="plan_id" value="${mealPlan.planId}"/>
        <input type="submit" class="btn btn-success" value="Submit">
    </div>
</form:form>


<%@ include file="common/footer.jspf" %>