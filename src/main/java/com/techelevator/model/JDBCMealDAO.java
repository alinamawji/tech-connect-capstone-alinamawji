package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMealDAO implements MealDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMealDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRecipesToMeal(long meal_id, long recipe_id) {
        // TO-DO
        // LEFT OFF HERE
    }
}

class mealRowMapper implements RowMapper {
    @Override
    public Meal mapRow(ResultSet results, int i) throws SQLException {
        Meal meal = new Meal();
        meal.setMeal_id(results.getLong("meal_id"));
        meal.setUser_id(results.getLong("user_id"));
        meal.setTitle(results.getString("title"));
//        meal.setRecipesInMeal(results.getString("recipes"));
        return meal;
    }
}
