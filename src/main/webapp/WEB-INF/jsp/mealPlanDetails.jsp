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
<%--      <c:if test = "${mealPlan.userId != user.userId || user.firstName == null}">--%>
<%--        <c:set var="activeButton" value="disabled"/>--%>
<%--      </c:if>--%>

<%--      <c:if test = "${activeButton == 'disabled'}">--%>
<%--        <c:out value = "You can only edit meal plans you've created."/>--%>
<%--      </c:if>--%>

      <%--            <c:url var="formAction" value="/mealPlanDetails"/>--%>
      <%--            <form method="POST" action="${ formAction }">--%>
      <%--                <input type="hidden" id="mealplan_id" name="mealplan_id" value="${ mealPlan.plan_id }">--%>
      <%--                <input type="submit" role="button" class = "btn btn-sm btn-success ${activeButton}" style = "margin-bottom: 5px;" aria-disabled="true" value="Edit Meal Plan">--%>
      <%--            </form>--%>
      <a  class = "btn btn-success ${activeButton}" href="<c:url value='/modifyMealPlan'>
            <c:param name="plan_id" value='${mealPlan.planId}'/>
            </c:url>">Edit</a>

      <a  class = "btn btn-success ${activeButton}" href="<c:url value='/groceryList'>
             <c:param name="plan_id" value='${mealPlan.planId}'/>
            </c:url>">Create Grocery List</a>

    </div>
  </div>
</div>
<h1 class="display-5 text-italic text-color"><c:out value="${mealPlan.title}"/> </h1>
<p>Date Created: ${mealPlan.dateCreated}</p>

<hr>

      <%--          BUTTON TO VIEW MEAL?    --%>
      <%-- <c:url var="mealDetails" value="/mealDetails"> --%>
      <%--     <c:param name="plan_id" value="${mealPlan.planId}"/> --%>
      <%-- </c:url> --%>
      <%-- <a href="${detailUrl}" class="btn btn-success">View Meal</a> --%>

<h1 class = "display-6 text-color" style = "margin-bottom: 10px;">Meals: </h1>

<div class = "container" id = "grid">
  <div class = "row">

    <c:forEach var="day" begin="1" end="7">

      <div class = "col-md-4">
        <div class = "card" style = "margin-bottom: 5px; margin-top: 5px;">
          <div class="card-body text-center">

      <%-- SUNDAY --%>
      <c:if test="${day == 1}">
        <h5 class="card-text" style="font-weight: bold">Sunday</h5>

        <c:forEach var="meal" begin="1" end="4">

          <c:if test="${meal == 1}">
            <h6 class="card-text" style="font-style: italic">Breakfast</h6>
            <c:forEach var="meal" items="${ sundayBreakfast }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 2}">
            <h6 class="card-text" style="font-style: italic">Lunch</h6>
            <c:forEach var="meal" items="${ sundayLunch }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 3}">
            <h6 class="card-text" style="font-style: italic">Dinner</h6>
            <c:forEach var="meal" items="${ sundayDinner }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 4}">
            <h6 class="card-text" style="font-style: italic">Snacks</h6>
            <c:forEach var="meal" items="${ sundaySnacks }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>

        </c:forEach>

      </c:if>

      <%-- MONDAY --%>
      <c:if test="${day == 2}">
        <h5 class="card-text" style="font-weight: bold">Monday</h5>

        <c:forEach var="meal" begin="1" end="4">

          <c:if test="${meal == 1}">
            <h6 class="card-text" style="font-style: italic">Breakfast</h6>
            <c:forEach var="meal" items="${ mondayBreakfast }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 2}">
            <h6 class="card-text" style="font-style: italic">Lunch</h6>
            <c:forEach var="meal" items="${ mondayLunch }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 3}">
            <h6 class="card-text" style="font-style: italic">Dinner</h6>
            <c:forEach var="meal" items="${ mondayDinner }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 4}">
            <h6 class="card-text" style="font-style: italic">Snacks</h6>
            <c:forEach var="meal" items="${ mondaySnacks }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>

        </c:forEach>

      </c:if>

      <%-- TUESDAY --%>
      <c:if test="${day == 3}">
        <h5 class="card-text" style="font-weight: bold">Tuesday</h5>

        <c:forEach var="meal" begin="1" end="4">

          <c:if test="${meal == 1}">
            <h6 class="card-text" style="font-style: italic">Breakfast</h6>
            <c:forEach var="meal" items="${ tuesdayBreakfast }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 2}">
            <h6 class="card-text" style="font-style: italic">Lunch</h6>
            <c:forEach var="meal" items="${ tuesdayLunch }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 3}">
            <h6 class="card-text" style="font-style: italic">Dinner</h6>
            <c:forEach var="meal" items="${ tuesdayDinner }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 4}">
            <h6 class="card-text" style="font-style: italic">Snacks</h6>
            <c:forEach var="meal" items="${ tuesdaySnacks }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>

        </c:forEach>

      </c:if>

      <%-- WEDNESDAY --%>
      <c:if test="${day == 4}">
        <h5 class="card-text" style="font-weight: bold">Wednesday</h5>
          <c:forEach var="meal" begin="1" end="4">

            <c:if test="${meal == 1}">
              <h6 class="card-text" style="font-style: italic">Breakfast</h6>
              <c:forEach var="meal" items="${ wednesdayBreakfast }">
                <p class="card-text text-color">${meal}</p>
              </c:forEach>
            </c:if>
            <c:if test="${meal == 2}">
              <h6 class="card-text" style="font-style: italic">Lunch</h6>
              <c:forEach var="meal" items="${ wednesdayLunch }">
                <p class="card-text text-color">${meal}</p>
              </c:forEach>
            </c:if>
            <c:if test="${meal == 3}">
              <h6 class="card-text" style="font-style: italic">Dinner</h6>
              <c:forEach var="meal" items="${ wednesdayDinner }">
                <p class="card-text text-color">${meal}</p>
              </c:forEach>
            </c:if>
            <c:if test="${meal == 4}">
              <h6 class="card-text" style="font-style: italic">Snacks</h6>
              <c:forEach var="meal" items="${ wednesdaySnacks }">
                <p class="card-text text-color">${meal}</p>
              </c:forEach>
            </c:if>

          </c:forEach>

      </c:if>

      <%-- THURSDAY --%>
      <c:if test="${day == 5}">
        <h5 class="card-text" style="font-weight: bold">Thursday</h5>
        <c:forEach var="meal" begin="1" end="4">

          <c:if test="${meal == 1}">
            <h6 class="card-text" style="font-style: italic">Breakfast</h6>
            <c:forEach var="meal" items="${ thursdayBreakfast }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 2}">
            <h6 class="card-text" style="font-style: italic">Lunch</h6>
            <c:forEach var="meal" items="${ thursdayLunch }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 3}">
            <h6 class="card-text" style="font-style: italic">Dinner</h6>
            <c:forEach var="meal" items="${ thursdayDinner }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 4}">
            <h6 class="card-text" style="font-style: italic">Snacks</h6>
            <c:forEach var="meal" items="${ thursdaySnacks }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>

        </c:forEach>

      </c:if>

      <%-- FRIDAY --%>
      <c:if test="${day == 6}">
        <h5 class="card-text" style="font-weight: bold">Friday</h5>

        <c:forEach var="meal" begin="1" end="4">

          <c:if test="${meal == 1}">
            <h6 class="card-text" style="font-style: italic">Breakfast</h6>
            <c:forEach var="meal" items="${ fridayBreakfast }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 2}">
            <h6 class="card-text" style="font-style: italic">Lunch</h6>
            <c:forEach var="meal" items="${ fridayLunch }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 3}">
            <h6 class="card-text" style="font-style: italic">Dinner</h6>
            <c:forEach var="meal" items="${ fridayDinner }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 4}">
            <h6 class="card-text" style="font-style: italic">Snacks</h6>
            <c:forEach var="meal" items="${ fridaySnacks }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>

        </c:forEach>

      </c:if>

      <%-- SATURDAY --%>
      <c:if test="${day == 7}">
        <h5 class="card-text" style="font-weight: bold">Saturday</h5>

        <c:forEach var="meal" begin="1" end="4">

          <c:if test="${meal == 1}">
            <h6 class="card-text" style="font-style: italic">Breakfast</h6>
            <c:forEach var="meal" items="${ saturdayBreakfast }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 2}">
            <h6 class="card-text" style="font-style: italic">Lunch</h6>
            <c:forEach var="meal" items="${ saturdayLunch }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 3}">
            <h6 class="card-text" style="font-style: italic">Dinner</h6>
            <c:forEach var="meal" items="${ saturdayDinner }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>
          <c:if test="${meal == 4}">
            <h6 class="card-text" style="font-style: italic">Snacks</h6>
            <c:forEach var="meal" items="${ saturdaySnacks }">
              <p class="card-text text-color">${meal}</p>
            </c:forEach>
          </c:if>

        </c:forEach>

      </c:if>

          </div>
        </div>
      </div>

    </c:forEach>

  </div>
</div>


<%@ include file = "common/footer.jspf" %>
