package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JDBCCookbookDAO implements CookbookDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCookbookDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRecipeToCookbook(Long recipe_id, Long user_id) {

        String sqlAddRecipeToCookbook = "INSERT INTO app_user_recipe(user_id, recipe_id) values(?, ?)";
        jdbcTemplate.update(sqlAddRecipeToCookbook, user_id, recipe_id);
    }

    @Override
    public void deleteRecipeFromCookbook(long recipe_id, long user_id) {
        String sqlDeleteRecipeFromCookbook = "DELETE FROM app_user_recipe WHERE recipe_id = ? AND user_id = ?";
        jdbcTemplate.update(sqlDeleteRecipeFromCookbook, recipe_id, user_id);
    }

    // recipes user saved + created
    @Override
    public List<Recipe> getRecipesFromMyCookbook(long user_id) {
        String sqlViewRecipesFromMyCookbook = "SELECT * FROM recipe r" +
                " JOIN app_user_recipe aur ON aur.recipe_id = r.recipe_id" +
                " WHERE user_id = ?";
        List<Recipe> cookbookRecipes = jdbcTemplate.query(sqlViewRecipesFromMyCookbook, new recipeRowMapper(), user_id);
        return cookbookRecipes;
    }


}

class cookbookRowMapper implements RowMapper {
    @Override
    public Cookbook mapRow(ResultSet results, int i) throws SQLException {
        Cookbook cookbook = new Cookbook();
        cookbook.setUserId(results.getLong("user_id"));
        cookbook.setRecipeId(results.getLong("recipe_id"));
//        cookbook.setRecipes(results.getString("recipes"));
        return cookbook;
    }
}
