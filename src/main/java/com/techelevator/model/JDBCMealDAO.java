package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JDBCMealDAO implements MealDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMealDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRecipesToMeal(long meal_id, long recipe_id) {
        String sqlNewRecipe = "INSERT INTO meal_recipe(meal_id) values (?, ?)";
        jdbcTemplate.update(sqlNewRecipe, meal_id, recipe_id);
    }

    @Override
    public void removeRecipeFromMeal(long meal_id, long recipe_id) {
        String sqlNewRecipe = "DELETE FROM meal_recipe WHERE meal_id = ? AND recipe_id = ?";
        jdbcTemplate.update(sqlNewRecipe, meal_id, recipe_id);
    }

    @Override
    public List<Meal> getAllMeals() {
        String sqlAllMeals = "SELECT * FROM meal";
        java.util.List<Meal> meals = (List<Meal>) jdbcTemplate.query(sqlAllMeals, new mealRowMapper());
        return meals;
    }

    @Override
    public void createMeal(long meal_id, String title, long user_id) {
        String sqlCreateNewMeal = "INSERT INTO meal(meal_id, title, user_id) values(?, ?, ?)";
        jdbcTemplate.update(sqlCreateNewMeal, meal_id, title, user_id);
    }

    @Override
    public void deleteMeal(long meal_id) {
        String sqlDeleteMeal = "DELETE FROM meal WHERE meal_id = ?";
        jdbcTemplate.update(sqlDeleteMeal, meal_id);
    }
}

class mealRowMapper implements RowMapper {
    @Override
    public Meal mapRow(ResultSet results, int i) throws SQLException {
        Meal meal = new Meal();
        meal.setMealId(results.getLong("meal_id"));
        meal.setUserId(results.getLong("user_id"));
        meal.setTitle(results.getString("title"));
        meal.setRecipesInMeal(results.getString("recipes"));
        return meal;
    }
}
