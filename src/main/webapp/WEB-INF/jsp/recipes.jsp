
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
</style>

<h1 class = "display-6" style = "margin-top: 20px; margin-bottom: 20px;">Recipes</h1>
<div class = "container" id = "grid">
        <div class = "col-md-4">
            <for:forEach var = "i" begin = "1" end  = "10">
                <div class = "card">
                    <div class="card-body text-center">
                        <div style = "text-align: right;">
                            <button type="button" class = "btn btn-sm btn-success">Save</button>
                        </div>
                        <h5 class="card-title">Recipe ${i}</h5>
                        <p class="card-text">Recipe Overview # ${i}</p>
                        <a href="recipeDetails" class="btn btn-success">View More</a>
                    </div>
                </div>
            </for:forEach>
        </div>
    </div>
</div>
</body>

<%@ include file = "common/footer.jspf" %>
