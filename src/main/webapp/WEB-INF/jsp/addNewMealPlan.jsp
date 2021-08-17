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
    <form:input type = "textarea" path="title"/>
    <form:errors path="title" cssClass="errors"/>
    </div>
<%--    <form:hidden path="userId" value = "${user.userId}"/>--%>

    <div class = "form-group">
    <label for = "description">Description: </label>
    <form:input type = "textarea" path = "description"/>
    <form:errors path = "description" cssClass = "errors"/>
    </div>
    <div class="form-group">
        <label>Select which meal you'd like to add : </label>
<%--        <select>--%>
<%--            <for:forEach items = "${meals}" var = "meal">--%>
<%--                <label for = "meal">${meal.title}</label>--%>
<%--                <option id = "meal" value = "${meal.mealId}">${meal.title}</option>--%>
<%--            </for:forEach>--%>
<%--        </select>--%>
        <ul>
        <for:forEach items = "${meals}" var = "meal">
            <li class = "list-group item">
            <label for = "meal_id"><c:out value = "${meal.title}"/></label>
            <input type = "checkbox" name = "meal_id" id = "meal_id" value = "${meal.mealId}">
            </li>
        </for:forEach>
        </ul>
    </div>

    <div class = "form-group">
        <p>Continue to the next page to schedule your meals.</p>
        <input type = "submit" class="btn btn-success" value = "Continue to Next Page">
    </div>
</form:form>




<%@ include file = "common/footer.jspf" %>