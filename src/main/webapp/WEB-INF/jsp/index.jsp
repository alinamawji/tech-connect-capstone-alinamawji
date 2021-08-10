<%@ include file = "common/header.jspf" %>
<style>
    .jumbotron {
        background: url("https://online.ahu.edu/wp-content/uploads/2019/03/Healthy-Food-Doesnt-Have-To-Be-Expensive.jpg") center center / cover no-repeat;
    }
    .text-color{
        color: darkgreen;
    }
    .bg-success {
        border-radius: 5px;
        padding-bottom: 20px;
    }
    .card {
        border: black 1px solid;
        border-radius: 3px;
    }
</style>

<div class = "jumbotron text-center">
    <div class = "container bg-success text-color">
        <h1>Welcome To The Best Byte</h1>
        <p>Sign up or login to create your own meal plans, add recipes, and more!</p>
        <p>Or, view some available recipes below.</p>
        <a href = "register" class = "btn btn-success">Sign Up</a>
        <a href = "login" class = "btn btn-success">Login</a>
    </div>
</div>

<div class = "container">
    <div class = "row">
        <div class = "col-md-4">
        <div class="card">
                <img src="..." class="card-img-top" alt="...">
                    <div class="card-body text-center">
                        <h5 class="card-title">Recipe #1</h5>
                        <p class="card-text">Recipe Description.</p>
                        <a href="recipeDetails" class="btn btn-success">View More</a>
                    </div>
                </div>
        </div>

        <div class = "col-md-4">
            <div class="card">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body text-center">
                    <h5 class="card-title">Recipe #2</h5>
                    <p class="card-text">Recipe Description.</p>
                    <a href="recipeDetails" class="btn btn-success">View More</a>
                </div>
            </div>
        </div>

        <div class = "col-md-4">
            <div class="card">
                <img src="" class="card-img-top" alt="...">
                <div class="card-body text-center">
                    <h5 class="card-title">Recipe #3</h5>
                    <p class="card-text">Recipe Description.</p>
                    <a href="recipeDetails" class="btn btn-success">View More</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file = "common/footer.jspf" %>