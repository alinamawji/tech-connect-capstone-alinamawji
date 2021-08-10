-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;


-- INSERT statements for app_user table listed below (NOTE: password for all accounts is 123)

INSERT INTO app_user (first_name, last_name, username, password, email, role, salt)
VALUES ('Diana', 'Dang', 'dianaDang', 'fCFtc2lfdJ2ydm1ojJjRIw==', 'a@e.com', 'admin',
        'yA/UvIAglq5O9hir6oZtOmdmypEhPaAvEHhw' ||
        'DyWuLrsfusRbPxiET7DCuF5stKIhRJoR0IYRdju0BLTtE2SD0sFtUAPbFlajm9NGaF2yPUVnufQ6qi5YqDqZVl02+akNJ8x+oviGW3tdsP8dmiO' ||
        'p9Sf4Deqkyb1g5AOITW5zhBE=');

INSERT INTO app_user (first_name, last_name, username, password, email, role, salt)
VALUES ('Erin', 'Xu', 'erinXu', 'fCFtc2lfdJ2ydm1ojJjRIw==', 'b@e.com', 'admin',
        'yA/UvIAglq5O9hir6oZtOmdmypEhPaAvEHhw' ||
        'DyWuLrsfusRbPxiET7DCuF5stKIhRJoR0IYRdju0BLTtE2SD0sFtUAPbFlajm9NGaF2yPUVnufQ6qi5YqDqZVl02+akNJ8x+oviGW3tdsP8dmiO' ||
        'p9Sf4Deqkyb1g5AOITW5zhBE=');

INSERT INTO app_user (first_name, last_name, username, password, email, role, salt)
VALUES ('Alina', 'Mawji', 'alinaMawji', 'fCFtc2lfdJ2ydm1ojJjRIw==', 'c@e.com', 'admin',
        'yA/UvIAglq5O9hir6oZtOmdmypEhPaAvEHhw' ||
        'DyWuLrsfusRbPxiET7DCuF5stKIhRJoR0IYRdju0BLTtE2SD0sFtUAPbFlajm9NGaF2yPUVnufQ6qi5YqDqZVl02+akNJ8x+oviGW3tdsP8dmiO' ||
        'p9Sf4Deqkyb1g5AOITW5zhBE=');

INSERT INTO app_user (first_name, last_name, username, password, email, role, salt)
VALUES ('Aidan', 'Fox', 'aidanFox', 'fCFtc2lfdJ2ydm1ojJjRIw==', 'd@e.com', 'admin',
        'yA/UvIAglq5O9hir6oZtOmdmypEhPaAvEHhw' ||
        'DyWuLrsfusRbPxiET7DCuF5stKIhRJoR0IYRdju0BLTtE2SD0sFtUAPbFlajm9NGaF2yPUVnufQ6qi5YqDqZVl02+akNJ8x+oviGW3tdsP8dmiO' ||
        'p9Sf4Deqkyb1g5AOITW5zhBE=');


-- INSERT statements for ingredients table listed below:

INSERT INTO ingredient (ingredient_name)
VALUES ('blueberries');
INSERT INTO ingredient (ingredient_name)
VALUES ('strawberries');
INSERT INTO ingredient (ingredient_name)
VALUES ('maple-flavored syrup');
INSERT INTO ingredient (ingredient_name)
VALUES ('all-purpose flour');
INSERT INTO ingredient (ingredient_name)
VALUES ('whole-wheat flour');
INSERT INTO ingredient (ingredient_name)
VALUES ('quick-cooking rolled oats');
INSERT INTO ingredient (ingredient_name)
VALUES ('sugar');
INSERT INTO ingredient (ingredient_name)
VALUES ('baking powder');
INSERT INTO ingredient (ingredient_name)
VALUES ('baking soda');
INSERT INTO ingredient (ingredient_name)
VALUES ('buttermilk');
INSERT INTO ingredient (ingredient_name)
VALUES ('eggs');
INSERT INTO ingredient (ingredient_name)
VALUES ('butter');

INSERT INTO ingredient (ingredient_name)
VALUES ('turkey');
INSERT INTO ingredient (ingredient_name)
VALUES ('bacon');
INSERT INTO ingredient (ingredient_name)
VALUES ('ham');
INSERT INTO ingredient (ingredient_name)
VALUES ('cheddar cheese');
INSERT INTO ingredient (ingredient_name)
VALUES ('lettuce');
INSERT INTO ingredient (ingredient_name)
VALUES ('tomatoes');
INSERT INTO ingredient (ingredient_name)
VALUES ('mayo');
INSERT INTO ingredient (ingredient_name)
VALUES ('sliced bread');

INSERT INTO ingredient (ingredient_name)
VALUES ('pizza sauce');
INSERT INTO ingredient (ingredient_name)
VALUES ('mini-bagels');
INSERT INTO ingredient (ingredient_name)
VALUES ('shredded mozzarella');
INSERT INTO ingredient (ingredient_name)
VALUES ('toppings of choice');

INSERT INTO ingredient (ingredient_name)
VALUES ('fresh basil');
INSERT INTO ingredient (ingredient_name)
VALUES ('fresh parsley');
INSERT INTO ingredient (ingredient_name)
VALUES ('dried oregano');
INSERT INTO ingredient (ingredient_name)
VALUES ('salt');
INSERT INTO ingredient (ingredient_name)
VALUES ('black pepper');
INSERT INTO ingredient (ingredient_name)
VALUES ('garlic');
INSERT INTO ingredient (ingredient_name)
VALUES ('water');
INSERT INTO ingredient (ingredient_name)
VALUES ('meatloaf mix');
INSERT INTO ingredient (ingredient_name)
VALUES ('bread crumbs');
INSERT INTO ingredient (ingredient_name)
VALUES ('parmesan cheese');
INSERT INTO ingredient (ingredient_name)
VALUES ('marinara sauce');


-- INSERT statements for Category table listed below

INSERT INTO capstone.public.category(category_name)
VALUES ('Breakfast');
INSERT INTO capstone.public.category(category_name)
VALUES ('Chicken');
INSERT INTO capstone.public.category(category_name)
VALUES ('Desserts');
INSERT INTO capstone.public.category(category_name)
VALUES ('Healthy');
INSERT INTO capstone.public.category(category_name)
VALUES ('Quick-prep');
INSERT INTO capstone.public.category(category_name)
VALUES ('Sandwiches');
INSERT INTO capstone.public.category(category_name)
VALUES ('Mexican');
INSERT INTO capstone.public.category(category_name)
VALUES ('Indian');
INSERT INTO capstone.public.category(category_name)
VALUES ('Barbeque');
INSERT INTO capstone.public.category(category_name)
VALUES ('Asian');
INSERT INTO capstone.public.category(category_name)
VALUES ('Soup');
INSERT INTO capstone.public.category(category_name)
VALUES ('Chinese');
INSERT INTO capstone.public.category(category_name)
VALUES ('Sushi');
INSERT INTO capstone.public.category(category_name)
VALUES ('Italian');
INSERT INTO capstone.public.category(category_name)
VALUES ('Snacks');


--INSERT statements for Recipe Table listed below

INSERT INTO recipe(title, overview, instructions)
VALUES ('Fruit-Topped Whole Grain Waffles',
        'Looking for a fruity breakfast? Then check out these whole grain waffles topped with berries and ' ||
        'maple-flavored syrup – a great way to start your day.',
        '1. Lightly spray waffle iron with nonstick cooking spray; heat until hot. In medium bowl, combine all topping ' ||
        'ingredients (blueberries, strawberries, syrup); mix well. Let stand while preparing waffles.
2. In large bowl, combine all-purpose flour (1/2 cup), whole wheat flour (1/2 cup), oats (1/4 cup), sugar (2 tsp),' ||
        ' baking powder (1 tsp) and baking soda (1/2 tsp) ; mix well. ' ||
        'Add buttermilk (1.25 cups), one egg and butter (2 tbsp); beat well with wire whisk.
3. For each waffle, spoon about 1/2 cup batter into waffle iron, spreading batter to edges. ' ||
        'Bake about 3 minutes or until waffle is golden brown. Serve immediately with toppings.');

INSERT INTO recipe(title, overview, instructions)
VALUES ('Club Sandwich',
        'A Club Sandwich is one of the most iconic sandwiches on any menu! Layers of ham, bacon and turkey with ' ||
        'juicy tomatoes, crisp lettuce and cheddar cheese create the perfect bite!',
        'First Layer: Spread the mayo on one side of lightly toasted bread. Add turkey, tomato and cheese (be sure to put the tomatoes in the middle so the bread doesn’t get soggy). ' ||
        'Second Layer: Layer ham, bacon and lettuce. Top with the final slices of bread, ' ||
        'secure with cute sandwich picks and cut into quarters.');

INSERT INTO recipe(title, overview, instructions)
VALUES ('Pizza Bagel Bites',
        'Throwing it back to the childhood years of begging your parents to let you have pizza for an after school snack.',
        '1. Preheat oven to 350℉. Cut each mini-bagel in half. Place each side face-up on a lined baking sheet. ' ||
        'Broil the bagels for a few minutes until the tops are lightly toasted. ' ||
        '2. Spread a small amount of pizza sauce on top of each bagel and sprinkle cheese and toppings on top. ' ||
        '3. Bake for 10-15 minutes, or until the cheese is completely melted.');

INSERT INTO recipe(title, overview, instructions)
VALUES ('Spaghetti & Meatballs',
        'This spaghetti and meatball recipe is easy enough for a busy weeknight — and it’s a family favorite, too!',
        'Preheat the oven to 350°F and set an oven rack in the middle position.
In a large bowl, whisk together the egg, basil, parsley, oregano, salt, pepper, garlic and water. ' ||
        'Add the meat, breadcrumbs and cheese and mix until just combined (your hands are the best tool). Do not overwork it.
Roll the mixture into golf ball-sized meatballs and place on an ungreased baking sheet. ' ||
        'Bake for about 10 minutes, then remove the baking sheet from oven and use a metal spatula to turn the meatballs' ||
        ' (they will stick a bit but should release easily when you scrape under them with the spatula). ' ||
        'Put the meatballs back in the oven and cook for another 10 minutes, until they are nicely browned and almost cooked through.
In the meantime, bring the marinara sauce to a simmer in a large skillet. Taste it and adjust the seasoning if necessary' ||
        ' (I usually add a healthy pinch of sugar and some freshly ground black pepper). Transfer the browned meatballs to the marinara sauce, leaving the fat behind. Cover loosely with a lid or foil and simmer for about 10 minutes, until the flavors marry and the meatballs are cooked through. Keep warm until ready to toss with pasta.
While the meatballs are simmering, bring a large pot of well-salted water to a boil. ' ||
        'Add the spaghetti and cook until al dente. Drain, then toss with the sauce and meatballs ' ||
        '(you may find it easier to toss everything together in the pasta pot rather than the skillet; ' ||
        'it depends on the sizes of pans you are using.). Serve topped with fresh basil and more grated cheese.');

--INSERT statements to link given recipes to users

INSERT INTO app_user_recipe(user_id, recipe_id)
VALUES (1, 1);
INSERT INTO app_user_recipe(user_id, recipe_id)
VALUES (2, 2);
INSERT INTO app_user_recipe(user_id, recipe_id)
VALUES (3, 3);
INSERT INTO app_user_recipe(user_id, recipe_id)
VALUES (4, 4);


--INSERT statements to link given recipes to categories, listed below

INSERT INTO recipe_category(recipe_id, category_id)
VALUES (1, 1);
INSERT INTO recipe_category(recipe_id, category_id)
VALUES (1, 4);
INSERT INTO recipe_category(recipe_id, category_id)
VALUES (2, 5);
INSERT INTO recipe_category(recipe_id, category_id)
VALUES (2, 6);
INSERT INTO recipe_category(recipe_id, category_id)
VALUES (3, 15);
INSERT INTO recipe_category(recipe_id, category_id)
VALUES (3, 5);
INSERT INTO recipe_category(recipe_id, category_id)
VALUES (4, 14);

--INSERT statements to link given recipes to ingredients, listed below

INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 1);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 2);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 3);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 4);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 5);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 6);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 7);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 8);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 9);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 10);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 11);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (1, 12);

INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 13);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 14);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 15);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 16);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 17);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 18);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 19);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (2, 20);

INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (3, 21);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (3, 22);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (3, 23);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (3, 24);

INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 25);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 26);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 27);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 28);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 29);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 30);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 31);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 32);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 33);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 34);
INSERT INTO recipe_ingredient(recipe_id, ingredient_id)
VALUES (4, 35);



COMMIT;