<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "common/header.jspf" %>

<style>
    .form-group {
        margin: 10px;
    }
</style>

<h1 class = "display-5">Create a Meal Plan</h1>
<hr>

<c:url value="/addNewMealPlan" var = "addNewMealPlanUrl"/>
<div class = "container">
<form:form method = "POST" action = "${addNewMealPlanUrl}" modelAttribute="mealPlan">
    <div class = "form-group">
    <label for = "title">Title: </label>
    <form:input path="title"/>
    <form:errors path="title" cssClass="errors"/>
    </div>
<%--    <form:hidden path="userId" value = "${user.userId}"/>--%>

    <div class = "form-group">
    <label for = "description">Description: </label>
    <form:input type = "textarea" path = "description"/>
    <form:errors path = "description" cssClass = "errors"/>
    </div>


    <div class = "form-group">
    <label>Select which day you're planning meals for: </label>
    <select>
    <for:forEach var = "day" begin = "1" end = "7">
        <option><p class = "fw-bold"><c:out value = "Day ${day} "/></option>
    </for:forEach>
    </select>
    </div>


        <for:forEach var = "numberOfMeals" begin = "1" end = "4">
            <p><c:out value = "Meal #${numberOfMeals}"/></p>
    <div class="form-group">
        <label>Select which meal you'd like to add: </label>
        <select>
    <for:forEach items = "${meals}" var = "meal">
        <label for = "meal">${meal.title}</label>
        <option id = "meal" value = "${meal.mealId}">${meal.title}</option>
    </for:forEach>
        </select>
    </div>

    <div class = "form-group">
        <label>Select what time of day you'd like for this meal: </label>
        <select>
            <for:forEach var = "i" begin = "1" end = "4">
                <option id = "mealEvent" value ="${i}">${i}</option>
            </for:forEach>
        </select>
    </div>
        </for:forEach>
    <div class = "form-group">
        <input type = "submit" class="btn btn-success" value = "Submit">
    </div>
</form:form>
</div>



<%@ include file = "common/footer.jspf" %>