package com.techelevator;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.model.JDBCRecipeDAO;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDAO;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import static org.junit.Assert.*;


public class DAORecipeTest extends DAOIntegrationTest {

    private JDBCRecipeDAO jdbcRecipeDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        jdbcRecipeDAO = new JDBCRecipeDAO(dataSource);
    }

    @Test
    public void getRecipeByID() {
        Recipe recipe = jdbcRecipeDAO.getRecipeByID(3);
        assertEquals("Input: 3 (Title = Pizza Bagel Bites)", "Pizza Bagel Bites", recipe.getTitle());
        assertEquals("Input: 3 (Creator Username = alinaMawji", "alinaMawji", recipe.getCreatorUsername());
    }

    // NOT SURE HOW TO TEST?
//    @Test
//    public void addRecipeToDB() {
//        jdbcRecipeDAO.addRecipeToDB("title", "overview", 2, "instructions", Arrays.asList("1", "2"), Arrays.asList("1", "2"), "username", 3);
//        List<Recipe> recipes = jdbcRecipeDAO.getAllRecipes();
//        assertEquals("Testing that 1 recipe was added", 6, recipes.size());
//    }

    // NOT SURE HOW TO TEST?
//    @Test
//    public void deleteRecipeFromDB() {
//        jdbcRecipeDAO.deleteRecipeFromDB(3);
//        List<Recipe> recipes = jdbcRecipeDAO.getAllRecipes();
//        assertEquals("Testing that 1 recipe was deleted", 4, recipes.size());
//    }

    @Test
    public void getRecipeIngredients() {
        assertEquals("Testing ingredients of Pizza Bagel Bites", Arrays.asList("pizza sauce", "mini-bagels", "shredded mozzarella", "toppings of choice", "fresh basil"), jdbcRecipeDAO.getRecipeIngredients(3));
    }

    @Test
    public void getRecipeCategories() {
        assertEquals("Testing categories of Pizza Bagel Bites", Arrays.asList("Quick-prep", "Snacks"), jdbcRecipeDAO.getRecipeCategories(3));
    }

    @Test
    public void getRecipeByTitle() {
        assertEquals("Getting recipe ID of Pizza Bagel Bites", 3, jdbcRecipeDAO.getRecipeByTitle("Pizza Bagel Bites").getRecipeId());
    }

    @Test
    public void addIngredientToList() {
        jdbcRecipeDAO.addIngredientToList(3, "bread crumbs");
        assertEquals("Adding bread crumbs to Pizza Bagel Bites ingredients", Arrays.asList("pizza sauce", "mini-bagels", "shredded mozzarella", "toppings of choice", "fresh basil", "bread crumbs"), jdbcRecipeDAO.getRecipeIngredients(3));
    }

    @Test
    public void removeIngredientFromList() {
        jdbcRecipeDAO.removeIngredientFromList(3, "fresh basil");
        assertEquals("Removing fresh basil from Pizza Bagel Bites ingredients", Arrays.asList("pizza sauce", "mini-bagels", "shredded mozzarella", "toppings of choice"), jdbcRecipeDAO.getRecipeIngredients(3));
    }

    @Test
    public void modifyInstructions() {
        jdbcRecipeDAO.modifyInstructions(3, "modified instructions");
        assertEquals("Modifying instructions of Pizza Bagel Bites", "modified instructions", jdbcRecipeDAO.getRecipeByID(3).getInstructions());
    }

    @Test
    public void getAllRecipes() {
        List<Recipe> recipes = jdbcRecipeDAO.getAllRecipes();
        assertEquals("Checking that there are 5 recipes total in DB", 5, recipes.size());
    }

    @Test
    public void getRecipesFromUser() {
        List<Recipe> recipes = jdbcRecipeDAO.getRecipesFromUser("alinaMawji");
        assertEquals("Checking that 1 recipe was created by alinaMawji", 1, recipes.size());
    }

}
