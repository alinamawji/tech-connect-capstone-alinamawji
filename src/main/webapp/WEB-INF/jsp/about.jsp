<%@ include file = "common/header.jspf" %>
<style>
    h1 {
        color: darkgreen;
        margin-left: 20px;
    }
    .card {
        background-color: seagreen !important;
        color: white;
        margin-left: 10px;
    }
    .card-title, h2 {
        font-style: italic;
    }
    .card-text {
        text-align: left;
    }

    .font-italic {
        font-style: italic;
    }

    img {
        width: 250px;
        min-height: 250px;
        float: left;
        margin: 10px;
    }

    .img-fluid {
        height: 80% !important;
    }

    h2 {
        margin-left: 30px;
    }

</style>
<h1 class = "display-4">About Us</h1>
<hr>
<h2 class = "display-6">Frequently Asked Questions </h2>
<div class = "container">
    <div class = "row">
        <div class="card" style="width: 16rem;">
            <div class="card-body">
                <h5 class="card-title">What is the Best Byte?</h5>
                <p class="card-text">Best Byte is a meal planner website, where you're able to create personalized meal plans based off of recipes you and other users created.</p>
            </div>
        </div>

        <div class="card" style="width: 16rem;">
            <div class="card-body">
                <h5 class="card-title">What do I gain as a logged in user of Best Byte?</h5>
                <p class="card-text">You can upload and edit recipes, combine them to create meals, and add them to your own personalized meal plan. Otherwise, you can only see recipes!</p>
            </div>
        </div>

        <div class="card" style="width: 16rem;">
            <div class="card-body">
                <h5 class="card-title">What's the "My Cookbook" feature?</h5>
                <p class="card-text">The "My Cookbook" feature allows registered users to see recipes they've uploaded or saved from the website.</p>
            </div>
        </div>

        <div class="card" style="width: 16rem;">
            <div class="card-body">
                <h5 class="card-title">How can I contact you guys about improving something on the site?</h5>
                <p class="card-text">Good question! We're always looking for ways to improve. Send us an email or call us to tell us how you'd want Best Byte to better fit your needs.</p>
            </div>
        </div>
    </div>
</div>

<hr>
<h2 class = "display-6">Meet The Team</h2>
<div class = "container">
    <div class = "row">
        <div class = "col-md-3">
            <a href = "https://www.linkedin.com/in/aidan-fox-253b9b1b0" target="_blank" rel="noopener noreferrer"><img src="https://cdn.shopify.com/s/files/1/1431/5776/products/boy-face-with-shaggy-hair-stamp.png?v=1507653886" alt="Aidan Fox headshot" class="img-fluid rounded-circle"></a>
            <p class = "text-center">Aidan Fox</p>
            <p class = "text-center font-italic">Backend Engineer</p>
        </div>

        <div class = "col-md-3">
            <a href = "https://www.linkedin.com/in/alina-mawji" target="_blank" rel="noopener noreferrer"><img src="https://cdn.shopify.com/s/files/1/1431/5776/products/girl-with-big-pigtails-and-bows-face-stamp_1024x1024.png?v=1507655056" alt="Alina Mawji headshot" class="img-fluid rounded-circle"></a>
            <p class = "text-center">Alina Mawji</p>
            <p class = "text-center font-italic">Backend Engineer</p>
        </div>

        <div class = "col-md-3">
            <a href = "https://www.linkedin.com/in/erin-xu-57a787165" target="_blank" rel="noopener noreferrer"><img src="https://www.pinclipart.com/picdir/big/561-5615797_girl-with-short-hair-and-bow-face-stamp.png" alt="Erin Xu headshot" class="img-fluid rounded-circle"></a>
            <p class = "text-center">Erin Xu</p>
            <p class = "text-center font-italic">Frontend Engineer</p>
        </div>

        <div class = "col-md-3">
            <a href = "https://www.linkedin.com/in/dididang" target = "_blank" rel ="noopener noreferrer"><img src="https://www.pngkit.com/png/full/388-3887218_girl-face-with-short-hair-rubber-stamp-stick.png" alt="Diana Dang headshot" class="img-fluid rounded-circle border-success"></a>
            <p class = "text-center">Diana Dang</p>
            <p class = "text-center font-italic">Frontend Engineer</p>
        </div>
    </div>
</div>
<%@ include file = "common/footer.jspf" %>