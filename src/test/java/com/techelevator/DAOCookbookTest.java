package com.techelevator;

import com.techelevator.model.JDBCCategoryDAO;
import com.techelevator.model.JDBCCookbookDAO;
import com.techelevator.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DAOCookbookTest extends DAOIntegrationTest {

    private JDBCCookbookDAO jdbcCookbookDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        jdbcCookbookDAO = new JDBCCookbookDAO(dataSource);
    }

    @Test
    public void addRecipeToCookbook() {
        jdbcCookbookDAO.addRecipeToCookbook(1L, 3L);
        List<Recipe> recipes = jdbcCookbookDAO.getRecipesFromMyCookbook(3);
        assertEquals("Adding Waffles to alinaMawji cookbook, should have 3 total recipes", 3, recipes.size());
    }

    @Test
    public void deleteRecipeFromCookbook() {
        jdbcCookbookDAO.deleteRecipeFromCookbook(2L, 3L);
        List<Recipe> recipes = jdbcCookbookDAO.getRecipesFromMyCookbook(3);
        assertEquals("Removing sandwich from alinaMawji cookbook, should have 2 total recipes", 1, recipes.size());
    }

    @Test
    public void getRecipesFromMyCookbook() {
        List<Recipe> recipes = jdbcCookbookDAO.getRecipesFromMyCookbook(3);
        assertEquals("Total recipes in alinaMawji cookbook should be 2", 2, recipes.size());
    }

}
