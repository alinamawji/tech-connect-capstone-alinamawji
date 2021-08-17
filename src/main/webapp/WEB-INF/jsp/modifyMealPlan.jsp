<%@ include file = "common/header.jspf" %>

<h1 class = "display-5">Edit Meal Plan Page</h1>
<hr>

<div class = "container">
    <div class = "row">
        <div class = "text-left">
            <a  class = "btn btn-success btn-sm" href="<c:url value="/addSelectedMeal">
                                        <c:param name="plan_id" value='${mealPlan.plan_id}'/>
                                        </c:url>">Add Another Meal</a>
            <a  class = "btn btn-success btn-sm" href="<c:url value="/deleteSelectedMeal">
                                        <c:param name="plan_id" value='${mealPlan.plan_id}'/>
                                        </c:url>">Add Another Meal</a>

        </div>
        <div class = "text-right">
            <a  class = "btn btn-success btn-sm" href="<c:url value="/addScheduledMeal">
                                        <c:param name="plan_id" value='${mealPlan.plan_id}'/>
                                        </c:url>">Add Another Meal</a>
            <a  class = "btn btn-success btn-sm" href="<c:url value="/deleteScheduledMeal">
                                        <c:param name="plan_id" value='${mealPlan.plan_id}'/>
                                        </c:url>">Add Another Meal</a>
        </div>
    </div>
</div>
<%@ include file = "common/footer.jspf" %>