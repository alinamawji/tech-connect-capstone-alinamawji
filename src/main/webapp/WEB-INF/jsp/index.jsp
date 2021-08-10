<%@ include file = "common/header.jspf" %>
<style>
    .jumbotron {
        margin-top: 10px;
        padding: 50px;
        background: url("https://online.ahu.edu/wp-content/uploads/2019/03/Healthy-Food-Doesnt-Have-To-Be-Expensive.jpg") center center / cover no-repeat;
        border-radius: 5px;
        margin-bottom: 10px;
    }
    .text-color{
        color: white;
    }
    .bg-success {
        border-radius: 5px;
        padding-bottom: 20px;
    }
    .card {
        border: black 1px solid;
        border-radius: 3px;
    }
    .card-img-top {
        width: 100%;
        height: 15vw;
        object-fit: cover;
    }
</style>

<div class = "jumbotron text-center">
    <div class = "container bg-success text-color">
        <h1 class = "display-6">Welcome To The Best Byte</h1>
        <p class = "fw-lighter">Sign up or login to create your own meal plans, add recipes, and more!</p>
        <a href = "register" class = "btn btn-light">Sign Up</a>
        <a href = "login" class = "btn btn-light">Login</a>
    </div>
</div>

<div class = "container">
    <div class = "row">
        <div class = "col-md-4">
        <div class="card">
                <img src="https://images-gmi-pmc.edge-generalmills.com/c35325b7-3553-482c-a625-7dba7f5b2597.jpg" class="card-img-top" alt="Waffles with fruit image">
                    <div class="card-body text-center">
                        <h5 class="card-title">Fruit Topped Whole Grain Waffles</h5>
                        <p class="card-text">Looking for a fruity breakfast? Then check out these whole grain waffles topped with berries and maple-flavored syrup, a great way to start your day.
                        </p>
                        <a href="recipeDetails" class="btn btn-success">View More</a>
                    </div>
                </div>
        </div>

        <div class = "col-md-4">
            <div class="card">
                <img src="https://www.spendwithpennies.com/wp-content/uploads/2019/05/Classic-Club-Sandwich-Spend-With-Pennies-23.jpg" class="card-img-top" alt="Club sandwich photo">
                <div class="card-body text-center">
                    <h5 class="card-title">Healthy Club Sandwich</h5>
                    <p class="card-text">A Club Sandwich is one of the most iconic sandwiches on any menu! Layers of ham, bacon and turkey with juicy tomatoes, crisp lettuce and cheddar cheese create the perfect bite!</p>
                    <a href="recipeDetails" class="btn btn-success">View More</a>
                </div>
            </div>
        </div>

        <div class = "col-md-4">
            <div class="card">
                <img src="https://spoonuniversity.com/wp-content/uploads/sites/66/2016/04/PizzaBites2.jpg" class="card-img-top" alt="Pizza bagel bites">
                <div class="card-body text-center">
                    <h5 class="card-title">Pizza Bagel Bites</h5>
                    <p class="card-text">Throwing it back to the childhood years of begging your parents to let you have pizza for an after school snack.</p>
                    <a href="recipeDetails" class="btn btn-success">View More</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file = "common/footer.jspf" %>