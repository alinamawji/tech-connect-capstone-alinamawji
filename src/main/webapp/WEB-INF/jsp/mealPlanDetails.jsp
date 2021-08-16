<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/9/2021
  Time: 7:19 PM
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
  .text-right {
    text-align: right !important;
  }
</style>

<%--make sure you replace these features with the expression language call for the recipe models--%>
<div class = "container">
  <div class = "row">
    <div class = "text-right" style = "margin-bottom: 5px; margin-top: 10px;">

      <c:set var="activeButton" value=""/>
      <c:if test = "${mealPlan.user_id != user.userId || user.firstName == null}">
        <c:set var="activeButton" value="disabled"/>
      </c:if>

      <c:if test = "${activeButton == 'disabled'}">
        <c:out value = "You can only edit recipes you've created."/>
      </c:if>

      <%--            <c:url var="formAction" value="/mealPlanDetails"/>--%>
      <%--            <form method="POST" action="${ formAction }">--%>
      <%--                <input type="hidden" id="mealplan_id" name="mealplan_id" value="${ mealPlan.plan_id }">--%>
      <%--                <input type="submit" role="button" class = "btn btn-sm btn-success ${activeButton}" style = "margin-bottom: 5px;" aria-disabled="true" value="Edit Meal Plan">--%>
      <%--            </form>--%>
      <a  class = "btn btn-success ${activeButton}" href="<c:url value='/modifyMealPlan'>
             <c:param name="mealplan_id" value='${mealPlan.plan_id}'/>
            </c:url>">Edit</a>

    </div>
  </div>
</div>
<h1 class="display-5 text-italic text-color"><c:out value="${mealPlan.title}"/> </h1>
<p>Date Created: ${mealPlan.date_created}</p>


<%--<hr>--%>

<%--<h1 class = "display-6 text-color">Description: </h1>--%>
<%--<p><c:out value = "${mealPlan.description}"/></p>--%>

<hr>

<h1 class = "display-6 text-color" style = "margin-bottom: 10px;">Meals: </h1>

<%--        this creates a card per meal, cannot group by day     --%>

<div class = "container" id = "grid">
  <div class = "row">
    <for:forEach items="${mealPlan.plannedMeals}" var="plannedMeal" >
      <%-- <c:url var="mealDetails" value="/mealDetails"> --%>
      <%--     <c:param name="mealplan_id" value="${mealPlan.plan_id}"/> --%>
      <%-- </c:url> --%>
    <div class = "col-md-4">
      <div class = "card" style = "margin-bottom: 5px; margin-top: 5px;">
        <div class="card-body text-center">


            <%--     set day name for each day     --%>
          <c:if test=${${plannedMeal.key.weekday} == 1}>
          <c:set var="dayString" value="Sunday"/>
          </c:if>
          <c:if test=${${plannedMeal.key.weekday} == 2}>
          <c:set var="dayString" value="Monday"/>
          </c:if>
          <c:if test=${${plannedMeal.key.weekday} == 3}>
          <c:set var="dayString" value="Tuesday"/>
          </c:if>
          <c:if test=${${plannedMeal.key.weekday} == 4}>
          <c:set var="dayString" value="Wednesday"/>
          </c:if>
          <c:if test=${${plannedMeal.key.weekday} == 5}>
          <c:set var="dayString" value="Thursday"/>
          </c:if>
          <c:if test=${${plannedMeal.key.weekday} == 6}>
          <c:set var="dayString" value="Friday"/>
          </c:if>
          <c:if test=${${plannedMeal.key.weekday} == 7}>
          <c:set var="dayString" value="Sunday"/>
          </c:if>

          <%--     set time name for each time     --%>
          <c:if test=${${plannedMeal.key.time_of_day} == 1}>
          <c:set var="timeString" value="Breakfast"/>
          </c:if>
          <c:if test=${${plannedMeal.key.time_of_day} == 2}>
          <c:set var="timeString" value="Lunch"/>
          </c:if>
          <c:if test=${${plannedMeal.key.time_of_day} == 3}>
          <c:set var="timeString" value="Dinner"/>
          </c:if>
          <c:if test=${${plannedMeal.key.time_of_day} == 4}>
          <c:set var="timeString" value="Snack"/>
          </c:if>

          <%--        print out day / time and meal     --%>
          <h5 class="card-text" style="font-weight: bold">${dayString} </h5>&nbsp;
          <h5 class="card-text">${timeString}</h5>

          <p class="card-text">${plannedMeal.value.title}</p>

          <%-- <a href="${detailUrl}" class="btn btn-success">View Meal</a> --%>
        </div>
      </div>
    </div>
    </for:forEach>
  </div>
</div>


<%@ include file = "common/footer.jspf" %>
