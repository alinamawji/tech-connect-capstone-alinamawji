package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JDBCRecipeDAO implements RecipeDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCRecipeDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRecipeToDB(long recipe_id, String title, String overview, int difficulty, DateTimeFormat date_created, String instructions, List<Ingredient> ingredients, List<Category> categories) {
        // insert recipe into recipe table
        String sqlNewRecipe = "INSERT INTO recipe(recipe_id, title, overview, difficulty, date_created, instructions) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlNewRecipe, new recipeRowMapper(), recipe_id, title, overview, difficulty, date_created, instructions);

        // insert recipe categories into recipe_category associative table
        for (Category c : categories) {
            String sqlRecipeIngredients = "INSERT INTO recipe_category(recipe_id, category_id) values(?, ?)";
            jdbcTemplate.update(sqlRecipeIngredients, new categoryRowMapper(), recipe_id, c.getCategory_id());
        }

        // insert recipe ingredients into recipe_ingredient associative table
        for (Ingredient i : ingredients) {
            String sqlRecipeIngredients = "INSERT INTO recipe_ingredient(recipe_id, ingredient_id) values(?, ?)";
            jdbcTemplate.update(sqlRecipeIngredients, new ingredientRowMapper(), recipe_id, i.getIngredient_id());
        }
    }

    @Override
    public void deleteRecipeFromDB(long recipe_id) {
        String sqlDeleteRecipeFromDB = "DELETE FROM recipe WHERE recipe_id = ?";
        jdbcTemplate.update(sqlDeleteRecipeFromDB, new recipeRowMapper(), recipe_id);
    }

    @Override
    public void deleteRecipeFromCookbook(long recipe_id) {
        String sqlDeleteRecipeFromCookbook = "DELETE FROM app_user_recipe WHERE recipe_id = ?";
        jdbcTemplate.update(sqlDeleteRecipeFromCookbook, new recipeRowMapper(), recipe_id);
    }

    @Override
    public List<Ingredient> getRecipeIngredients(long recipe_id) {
        String sql = "SELECT ingredient_id FROM recipe_ingredient WHERE recipe_id = ?";
        List<Ingredient> ingredientList = jdbcTemplate.query(sql, new recipeRowMapper(), recipe_id);
        return ingredientList;
    }

    @Override
    public List<Category> getRecipeCategories(long recipe_id) {
        String sql = "SELECT category_id FROM recipe_category WHERE recipe_id = ?";
        List<Category> categoryList = jdbcTemplate.query(sql, new recipeRowMapper(), recipe_id);
        return categoryList;
    }

    @Override
    public void addIngredientToList(long recipe_id, Ingredient ingredient) {
        String sqlNewIngredient = "INSERT INTO recipe_ingredient(recipe_id) values(?, ?)";
        jdbcTemplate.update(sqlNewIngredient, new recipeRowMapper(), recipe_id, ingredient.getIngredient_id());
    }

    @Override
    public void removeIngredientFromList(long recipe_id, Ingredient ingredient) {
        String sqlNewIngredient = "DELETE FROM recipe_ingredient WHERE recipe_id = ? AND ingredient_id = ?";
        jdbcTemplate.update(sqlNewIngredient, new recipeRowMapper(), recipe_id, ingredient.getIngredient_id());
    }

    @Override
    public void modifyInstructions(long recipe_id, String instructions) {
        String sqlNewIngredient = "UPDATE recipe SET instructions = ? WHERE recipe_id = ?";
        jdbcTemplate.update(sqlNewIngredient, new recipeRowMapper(), instructions, recipe_id);
    };
}

class recipeRowMapper implements RowMapper {
    @Override
    public Recipe mapRow(ResultSet results, int i) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(results.getLong("recipe_id"));
        recipe.setTitle(results.getString("name"));
//        recipe.setIngredients(results.getString("ingredients"));
        recipe.setOverview(results.getString("description"));
        recipe.setDifficulty(results.getInt("difficulty"));
//        recipe.setCategories(results.getString("category"));
        recipe.setInstructions(results.getString("instructions"));
        return recipe;
    }
}

