<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/16/2021
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file = "common/header.jspf" %>

<style>
    .text-italic {
        font-style: italic;
    }
    .text-color {
        color: darkgreen;
    }
</style>

<%--title, date created, description--%>
<h1 class="display-5 text-italic text-color">Grocery List for <c:out value="${mealPlan.title}"/> </h1>
<p>Meal Plan Date Created: ${mealPlan.dateCreated}</p>
<h5 class="display-6 text-color">Description:</h5>
<p class = "text-capitalize">${mealPlan.description} </p>

<hr>

<h1 class = "display-6 text-color" style = "margin-bottom: 10px;">Items: </h1>
<div class = "container">
    <ul class = "list-group" style = "display: inline-block;">
        <%--        for loop to display the items --%>
        <c:forEach items = "${groceryList}" var = "item">
            <li class = "list-group-item text-capitalize"><c:out value="${item}"/></li>
        </c:forEach>
    </ul>
</div>
