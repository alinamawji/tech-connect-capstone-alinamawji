-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- INSERT statements for app_user table listed below (NOTE: not sure how to set up salt)
INSERT INTO app_user (first_name,last_name,username,password,email,role,salt)
VALUES ('Diana','Dang','dianaDang', '1234', 'a@e.com', 'admin', '1');

INSERT INTO app_user (first_name,last_name,username,password,email,role,salt)
VALUES ('Erin','Xu','erinXu', '1234', 'b@e.com', 'admin', '2');

INSERT INTO app_user (first_name,last_name,username,password,email,role,salt)
VALUES ('Alina','Mawji','alinaMawji', '1234', 'c@e.com', 'admin', '3');

INSERT INTO app_user (first_name,last_name,username,password,email,role,salt)
VALUES ('Aidan','Fox','aidanFox', '1234', 'd@e.com', 'admin', '4');

-- INSERT statements for ingredients table listed below:
INSERT INTO ingredient (ingredient_name) VALUES ('blueberries');
INSERT INTO ingredient (ingredient_name) VALUES ('strawberries');
INSERT INTO ingredient (ingredient_name) VALUES ('maple-flavored syrup');
INSERT INTO ingredient (ingredient_name) VALUES ('all-purpose flour');
INSERT INTO ingredient (ingredient_name) VALUES ('whole-wheat flour');
INSERT INTO ingredient (ingredient_name) VALUES ('quick-cooking rolled oats');
INSERT INTO ingredient (ingredient_name) VALUES ('sugar');
INSERT INTO ingredient (ingredient_name) VALUES ('baking powder');
INSERT INTO ingredient (ingredient_name) VALUES ('baking soda');
INSERT INTO ingredient (ingredient_name) VALUES ('buttermilk');
INSERT INTO ingredient (ingredient_name) VALUES ('eggs');
INSERT INTO ingredient (ingredient_name) VALUES ('butter');

INSERT INTO ingredient (ingredient_name) VALUES ('turkey');
INSERT INTO ingredient (ingredient_name) VALUES ('bacon');
INSERT INTO ingredient (ingredient_name) VALUES ('ham');
INSERT INTO ingredient (ingredient_name) VALUES ('swiss cheese');
INSERT INTO ingredient (ingredient_name) VALUES ('lettuce');
INSERT INTO ingredient (ingredient_name) VALUES ('tomatoes');
INSERT INTO ingredient (ingredient_name) VALUES ('mayo');
INSERT INTO ingredient (ingredient_name) VALUES ('sliced bread');

INSERT INTO ingredient (ingredient_name) VALUES ('pizza sauce');
INSERT INTO ingredient (ingredient_name) VALUES ('mini-bagels');
INSERT INTO ingredient (ingredient_name) VALUES ('shredded mozzarella');
INSERT INTO ingredient (ingredient_name) VALUES ('toppings of choice');

INSERT INTO ingredient (ingredient_name) VALUES ('fresh basil');
INSERT INTO ingredient (ingredient_name) VALUES ('fresh parsley');
INSERT INTO ingredient (ingredient_name) VALUES ('dried oregano');
INSERT INTO ingredient (ingredient_name) VALUES ('salt');
INSERT INTO ingredient (ingredient_name) VALUES ('black pepper');
INSERT INTO ingredient (ingredient_name) VALUES ('garlic');
INSERT INTO ingredient (ingredient_name) VALUES ('water');
INSERT INTO ingredient (ingredient_name) VALUES ('meatloaf mix');
INSERT INTO ingredient (ingredient_name) VALUES ('bread crumbs');
INSERT INTO ingredient (ingredient_name) VALUES ('parmesan cheese');
INSERT INTO ingredient (ingredient_name) VALUES ('marinara sauce');

--INSERT statements for Recipe Table listed below

INSERT INTO recipe(ingredient_id,category_id,title,instructions)




COMMIT;