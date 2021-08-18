package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class JDBCRecipeDAO implements RecipeDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCRecipeDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRecipeToDB(String title, String overview, int difficulty, String instructions, List<String> ingredients, List<String> categories, String creatorUsername, long user_id) {
        // insert recipe into recipe table
        String sqlNewRecipe = "INSERT INTO recipe(creator_username, title, overview, difficulty, date_created, instructions)  values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlNewRecipe, creatorUsername, title, overview, difficulty, LocalDate.now(), instructions);

        // insert recipe categories into recipe_category associative table
        for (String categoryName : categories) {
            String sqlRecipeIngredients = "INSERT INTO recipe_category(recipe_id, category_id) values((SELECT recipe_id FROM recipe WHERE title = ?), (SELECT category_id FROM category WHERE category_name = ?))";
            jdbcTemplate.update(sqlRecipeIngredients, title, categoryName);
        }

        // insert recipe ingredients into recipe_ingredient associative table
        for (String ingredientName : ingredients) {
            String sqlRecipeIngredients = "INSERT INTO recipe_ingredient(recipe_id, ingredient_id) values((SELECT recipe_id FROM recipe WHERE title = ?), (SELECT ingredient_id FROM ingredient WHERE ingredient_name = ?))";
            jdbcTemplate.update(sqlRecipeIngredients, title, ingredientName);
        }

        // we have to insert the recipe_id and user_id into the associative table so it comes back in the cookbookDAO method
        String updateAppUserTable = "insert into app_user_recipe (user_id, recipe_id) values (?, (Select recipe_id from recipe where title = ?))";
        jdbcTemplate.update(updateAppUserTable, user_id, title);
    }

    @Override
    public void deleteRecipeFromDB(long recipe_id) {
        String sqlDeleteRecipeFromDB = "DELETE FROM recipe WHERE recipe_id = ?";
        jdbcTemplate.update(sqlDeleteRecipeFromDB, recipe_id);
    }

    @Override
    public List<String> getRecipeIngredients(long recipe_id) {
        String sql = "SELECT ingredient_name FROM ingredient i" +
                " JOIN recipe_ingredient ri ON ri.ingredient_id = i.ingredient_id" +
                " WHERE recipe_id = ?" +
                " order by ingredient_name";
        List<String> ingredientList = jdbcTemplate.query(sql, new ingredientRowMapper(), recipe_id);
        return ingredientList;
    }

    @Override
    public List<String> getRecipeCategories(long recipe_id) {
        String sql = "SELECT category_name FROM category c" +
                " JOIN recipe_category rc ON rc.category_id = c.category_id" +
                " WHERE recipe_id = ?";
        List<String> categoryList = jdbcTemplate.query(sql, new categoryRowMapper(), recipe_id);
        return categoryList;
    }

    @Override
    public Recipe getRecipeByID(long recipe_id) {
        String sqlGetRecipeByID = "SELECT * FROM recipe WHERE recipe_id = ?";
        Recipe recipe = (Recipe) jdbcTemplate.queryForObject(sqlGetRecipeByID, new recipeRowMapper(), recipe_id);
        return recipe;
    }

    @Override
    public Recipe getRecipeByTitle(String title) {
        String sqlGetRecipeByTitle = "SELECT * FROM recipe WHERE title = ?";
        Recipe recipe = (Recipe) jdbcTemplate.queryForObject(sqlGetRecipeByTitle, new recipeRowMapper(), title);
        return recipe;
    }

    @Override
    public void addIngredientToList(long recipe_id, String ingredient) {
        String sqlNewIngredient = "insert into recipe_ingredient (recipe_id, ingredient_id) \n" +
                "values (?, (select ingredient_id from ingredient where ingredient_name = ?));";
        jdbcTemplate.update(sqlNewIngredient, recipe_id, ingredient);
    }

    @Override
    public void removeIngredientFromList(long recipe_id, String ingredient) {
        String sqlDeleteIngredient = "DELETE FROM recipe_ingredient WHERE recipe_id = ? AND ingredient_id = (select ingredient_id from ingredient where ingredient_name = ?)";
        jdbcTemplate.update(sqlDeleteIngredient, recipe_id, ingredient);
    }

    @Override
    public void modifyInstructions(long recipe_id, String instructions) {
        String sqlNewIngredient = "UPDATE recipe SET instructions = ? WHERE recipe_id = ?";
        jdbcTemplate.update(sqlNewIngredient, instructions, recipe_id);
    }

    @Override
    public List<Recipe> getAllRecipes(){
        String sqlAllRecipes = "SELECT * FROM recipe";
        List<Recipe> recipes = (List<Recipe>) jdbcTemplate.query(sqlAllRecipes, new recipeRowMapper());
        return recipes;
    }

    @Override
    public List<Recipe> getRecipesFromUser(String username) {
        String sqlRecipesFromUser = "SELECT * FROM recipe WHERE creator_username = ?";
        List<Recipe> recipes = (List<Recipe>) jdbcTemplate.query(sqlRecipesFromUser, new recipeRowMapper(), username);
        return recipes;
    }

    public List <String> getIngredientsNotInRecipe(long recipe_id) {
        String sqlIngredients = "\n" +
                "select ingredient_name\n" +
                "from ingredient\n" +
                "where ingredient_name NOT IN (select ingredient_name\n" +
                "    from ingredient\n" +
                "    join recipe_ingredient ri on ingredient.ingredient_id = ri.ingredient_id\n" +
                "    where recipe_id = ?)" +
                "order by ingredient_name;";
        List <String> ingredients = jdbcTemplate.query(sqlIngredients, new ingredientRowMapper(), recipe_id);
        return ingredients;
    }
}

class recipeRowMapper implements RowMapper {
    @Override
    public Recipe mapRow(ResultSet results, int i) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(results.getLong("recipe_id"));
        recipe.setTitle(results.getString("title"));
//        recipe.setIngredients(results.getString("ingredients"));
        recipe.setOverview(results.getString("overview"));
        recipe.setDifficulty(results.getInt("difficulty"));
//        recipe.setCategories(results.getString("categories"));
        recipe.setInstructions(results.getString("instructions"));
        recipe.setDateCreated(results.getDate("date_created").toLocalDate());
        recipe.setCreatorUsername(results.getString("creator_username"));
        return recipe;
    }

}

