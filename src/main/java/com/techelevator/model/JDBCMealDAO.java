package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Component
public class JDBCMealDAO implements MealDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMealDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRecipesToMeal(long meal_id, long recipe_id) {
        String sqlNewRecipe = "INSERT INTO meal_recipe(meal_id, recipe_id) values (?, ?)";
        jdbcTemplate.update(sqlNewRecipe, meal_id, recipe_id);
    }

    @Override
    public void removeRecipeFromMeal(long meal_id, long recipe_id) {
        String sqlNewRecipe = "DELETE FROM meal_recipe WHERE meal_id = ? AND recipe_id = ?";
        jdbcTemplate.update(sqlNewRecipe, meal_id, recipe_id);
    }

    @Override
    public List<Meal> getAllMealsByUserID(long user_id) {
        String sqlAllMeals = "SELECT * FROM meal where user_id = ?";
        java.util.List<Meal> meals = (List<Meal>) jdbcTemplate.query(sqlAllMeals, new mealRowMapper(), user_id);
        return meals;
    }

    @Override
    public void createMeal(String title, long user_id) {
        String sqlCreateNewMeal = "INSERT INTO meal(title, user_id) values(?, ?)";
        jdbcTemplate.update(sqlCreateNewMeal, title, user_id);
    }

    @Override
    public void updateMealRecipeTable(String mealTitle, String recipeTitle) {
        String sql = "INSERT INTO meal_recipe (meal_id, recipe_id) VALUES ((SELECT meal_id FROM meal where title = ?), (SELECT recipe_id FROM recipe where title = ?))";
        jdbcTemplate.update(sql, mealTitle, recipeTitle);
    }

    @Override
    public void deleteMealFromMealRecipe(long meal_id, long recipe_id) {
        String sqlDeleteMealFromMealRecipe = "DELETE FROM meal_recipe WHERE meal_id = ? and recipe_id = ?";
        jdbcTemplate.update(sqlDeleteMealFromMealRecipe, meal_id, recipe_id);
    }

    @Override
    public void deleteMealFromMeal(long meal_id) {
        String sqlDeleteMeal = "DELETE FROM meal WHERE meal_id = ?";
        jdbcTemplate.update(sqlDeleteMeal, meal_id);
    }

    @Override
    public Meal getMealByID(long meal_id) {
        String sqlGetMealById = "SELECT * FROM meal WHERE meal_id = ?";
        Meal meal = (Meal) jdbcTemplate.queryForObject(sqlGetMealById, new mealRowMapper(), meal_id);
        return meal;
    }

    @Override
    public List<String> getRecipesInMeal(long meal_id) {
        String sql = "select recipe.title from recipe\n" +
                "join meal_recipe mr on recipe.recipe_id = mr.recipe_id\n" +
                "join meal m on mr.meal_id = m.meal_id\n" +
                "where m.meal_id = ?;";
        List<Map<String, Object>> recipesInMeal = jdbcTemplate.queryForList(sql, meal_id);

        List <String> recipeTitles = new ArrayList<>();
        for (Map <String, Object> recipe: recipesInMeal) {
            recipeTitles.add((String) recipe.get("title"));
        }
        return recipeTitles;
    }
}

class mealRowMapper implements RowMapper {
    @Override
    public Meal mapRow(ResultSet results, int i) throws SQLException {
        Meal meal = new Meal();
        meal.setMealId(results.getLong("meal_id"));
        meal.setUserId(results.getLong("user_id"));
        meal.setTitle(results.getString("title"));
        return meal;
    }
}
