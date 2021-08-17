<%@ include file = "common/header.jspf" %>
<style>
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

<h1 class = "display-5">Whoops! You do not have access to this feature. </h1>
<hr>

<div class = "container">
    <p>Looks like you're trying to access a feature only logged in users have access to.
        <a href="login">Login</a> or <a href="register">register</a> here to access this feature. </p>
    <p>Otherwise, checkout some of our recipes below: </p>

    <div class = "container">
        <div class = "row">
            <div class = "col-md-4">
                <div class="card">
                    <img src="https://images-gmi-pmc.edge-generalmills.com/c35325b7-3553-482c-a625-7dba7f5b2597.jpg" class="card-img-top" alt="Waffles with fruit image">
                    <div class="card-body text-center">
                        <h5 class="card-title">Fruit Topped Whole Grain Waffles</h5>
                        <p class="card-text">Looking for a fruity breakfast? Then check out these whole grain waffles topped with berries and maple-flavored syrup, a great way to start your day.
                        </p>
                        <a href="recipeDetails?recipe_id=1" class="btn btn-success">View More</a>
                    </div>
                </div>
            </div>

            <div class = "col-md-4">
                <div class="card">
                    <img src="https://www.spendwithpennies.com/wp-content/uploads/2019/05/Classic-Club-Sandwich-Spend-With-Pennies-23.jpg" class="card-img-top" alt="Club sandwich photo">
                    <div class="card-body text-center">
                        <h5 class="card-title">Healthy Club Sandwich</h5>
                        <p class="card-text">A Club Sandwich is one of the most iconic sandwiches on any menu! Layers of ham, bacon and turkey with juicy tomatoes, crisp lettuce and cheddar cheese create the perfect bite!</p>
                        <a href="recipeDetails?recipe_id=2" class="btn btn-success">View More</a>
                    </div>
                </div>
            </div>

            <div class = "col-md-4">
                <div class="card">
                    <img src="https://spoonuniversity.com/wp-content/uploads/sites/66/2016/04/PizzaBites2.jpg" class="card-img-top" alt="Pizza bagel bites">
                    <div class="card-body text-center">
                        <h5 class="card-title">Pizza Bagel Bites</h5>
                        <p class="card-text">Throwing it back to the childhood years of begging your parents to let you have pizza for an after school snack.</p>
                        <a href="recipeDetails?recipe_id=3" class="btn btn-success">View More</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file = "common/footer.jspf" %>
