
<%--
Created by IntelliJ IDEA.
User: Student
Date: 8/9/2021
Time: 3:42 PM
To change this template use File | Settings | File Templates.
--%>
<%@ include file = "common/header.jspf" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<style>
    #grid {
        display: grid;
        grid-gap: 15px;
        grid-auto-rows: minmax(150px, 1fr);
        grid-auto-flow: row dense;
    }
    .text-right {
        text-align: right !important;
    }
</style>

<h1 class = "display-6" style = "margin-top: 20px; margin-bottom: 10px;">Meal Plans</h1>
<hr>


<%--ternary operator to determine if there is a user logged in--%>
<c:set var = "activeButton" value = "${user.firstName != null ? '' : 'disabled'}"/>

<c:if test = "${activeButton == 'disabled'}">
    <c:out value = "Looks like you aren't currently logged in! Please login to access some of our other features like creating meal plans."/>
</c:if>

<div class = "text-right" style = "margin-bottom: 10px; margin-top: 10px;">

    <%--button is not active when the user is not logged in  --%>
    <a href="addNewMealPlan" class="btn btn-success btn-sm ${activeButton}" role="button" aria-disabled="true">Create New Meal Plan</a>
</div>

<div class = "container" id = "grid">
    <div class = "row">
        <for:forEach items="${mealPlans}" var="mealPlan" >
            <c:url var="detailUrl" value="/mealPlanDetails">
                <c:param name="plan_id" value="${mealPlan.planId}"/>
            </c:url>
            <div class = "col-md-4">
                <div class = "card" style = "margin-bottom: 5px; margin-top: 5px;">
                    <div class="card-body text-center">
                        <h5 class="card-title"><c:out value="${mealPlan.title}"/></h5>
                        <p class="card-text">${mealPlan.description}</p>
                        <a href="${detailUrl}" class="btn btn-success">View More</a>
                    </div>
                </div>
            </div>
        </for:forEach>
    </div>
</div>
</body>

<%@ include file = "common/footer.jspf" %>
