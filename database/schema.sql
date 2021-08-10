-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

DROP TABLE IF EXISTS app_user,meal_plan,meal,recipe,ingredient,category,meal_plan_meal,
    meal_recipe,recipe_ingredient,recipe_category,app_user_recipe,app_user_meal_plan CASCADE;

-- *************************************************************************************************
-- CREATE statements for the Main Tables listed below
-- *************************************************************************************************

CREATE TABLE app_user
(
    user_id    SERIAL,
    first_name varchar(50)  NOT NULL,
    last_name  varchar(50)  NOT NULL,
    username   varchar(32)  NOT NULL,
    password   varchar(32)  NOT NULL,
    email      varchar(50)  NOT NULL,
    role       varchar(32) NOT NULL DEFAULT 'registered', -- default from format
    salt       varchar(255) NOT NULL,            -- default from format
    CONSTRAINT PK_user PRIMARY KEY (user_id),
    CONSTRAINT UQ_user_username UNIQUE (username),
    CONSTRAINT UQ_user_email UNIQUE (email)
);

CREATE TABLE meal_plan
(
    plan_id      SERIAL,
    user_id      int         NOT NULL,
    title        varchar(50) NOT NULL,
    date_created date        NOT NULL DEFAULT CURRENT_DATE, -- defaults to today's date when generated
    CONSTRAINT PK_meal_plan PRIMARY KEY (plan_id)
);

CREATE TABLE meal
(
    meal_id SERIAL,
    user_id int         NOT NULL,
    title   varchar(50) NOT NULL,
    CONSTRAINT PK_meal PRIMARY KEY (meal_id),
    CONSTRAINT FK_meal_user FOREIGN KEY (user_id) REFERENCES app_user (user_id)
);

CREATE TABLE recipe
(
    recipe_id     SERIAL,
    title         varchar(50)   NOT NULL,
    overview      varchar(300)  NULL,                          -- optional
    difficulty    int           NULL,                          -- optional
    date_created  date          NOT NULL DEFAULT CURRENT_DATE, -- defaults to today's date when generated
    instructions  varchar(2000) NOT NULL,
    CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)
);

CREATE TABLE ingredient
(
    ingredient_id   SERIAL,
    ingredient_name varchar(50) NOT NULL,
    CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id)
);

CREATE TABLE category
(
    category_id   SERIAL,
    category_name varchar(50) NOT NULL,
    CONSTRAINT PK_category PRIMARY KEY (category_id)
);

-- *************************************************************************************************
-- CREATE statements for the Associative Tables listed below
-- *************************************************************************************************

CREATE TABLE meal_plan_meal
(
    plan_id int NOT NULL,
    meal_id int NOT NULL,
    CONSTRAINT PK_meal_plan_meal PRIMARY KEY (plan_id, meal_id),
    CONSTRAINT FK_meal_plan_meal_meal_plan FOREIGN KEY (plan_id) REFERENCES meal_plan (plan_id),
    CONSTRAINT FK_meal_plan_meal_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id)
);

CREATE TABLE meal_recipe
(
    meal_id   int NOT NULL,
    recipe_id int NOT NULL,
    CONSTRAINT PK_meal_recipe PRIMARY KEY (meal_id, recipe_id),
    CONSTRAINT FK_meal_recipe_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id),
    CONSTRAINT FK_meal_recipe_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id)
);

CREATE TABLE recipe_ingredient
(
    recipe_id     int NOT NULL,
    ingredient_id int NOT NULL,
    CONSTRAINT PK_recipe_ingredient PRIMARY KEY (recipe_id, ingredient_id),
    CONSTRAINT FK_recipe_ingredient_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),
    CONSTRAINT FK_recipe_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id)
);

CREATE TABLE recipe_category
(
    recipe_id   int NOT NULL,
    category_id int NOT NULL,
    CONSTRAINT PK_recipe_category PRIMARY KEY (recipe_id, category_id),
    CONSTRAINT FK_recipe_category_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),
    CONSTRAINT FK_recipe_category_category FOREIGN KEY (category_id) REFERENCES category (category_id)
);

CREATE TABLE app_user_recipe
(
    user_id   int NOT NULL,
    recipe_id int NOT NULL,
    CONSTRAINT PK_app_user_recipe PRIMARY KEY (user_id, recipe_id),
    CONSTRAINT FK_app_user_recipe_user FOREIGN KEY (user_id) REFERENCES app_user (user_id),
    CONSTRAINT FK_app_user_recipe_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id)
);

CREATE TABLE app_user_meal_plan
(
    user_id int NOT NULL,
    plan_id int NOT NULL,
    CONSTRAINT PK_app_user_meal_plan PRIMARY KEY (user_id, plan_id),
    CONSTRAINT FK_app_user_meal_plan_user FOREIGN KEY (user_id) REFERENCES app_user (user_id),
    CONSTRAINT FK_app_user_meal_plan_plan FOREIGN KEY (plan_id) REFERENCES meal_plan (plan_id)
);


COMMIT;
