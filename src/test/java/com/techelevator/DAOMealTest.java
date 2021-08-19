package com.techelevator;

import com.techelevator.model.JDBCMealDAO;
import com.techelevator.model.Meal;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DAOMealTest extends DAOIntegrationTest {
    private JDBCMealDAO jdbcMealDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        jdbcMealDAO = new JDBCMealDAO(dataSource);
    }

    @Test
    public void addRecipesToMeal() {
        jdbcMealDAO.addRecipesToMeal(1, 1);
        List<String> recipes = jdbcMealDAO.getRecipesInMeal(1);
        assertEquals("Adding waffles to meal 1, result is 3 total recipes", 3, recipes.size());
    }

    @Test
    public void removeRecipeFromMeal() {
        jdbcMealDAO.removeRecipeFromMeal(1, 2);
        List<String> recipes = jdbcMealDAO.getRecipesInMeal(1);
        assertEquals("Removing sandwich from meal 1, result is 1 total recipe", 1, recipes.size());
    }

    @Test
    public void getAllMealsByUserID() {
        List<Meal> meals = jdbcMealDAO.getAllMealsByUserID(3);
        assertEquals("Finding total meals in alinaMawji, expecting 1 meal", 1, meals.size());
    }

    @Test
    public void createMeal() {
        jdbcMealDAO.createMeal("newMeal", 3);
        List<Meal> meals = jdbcMealDAO.getAllMealsByUserID(3);
        assertEquals("Adding another meal to alinaMawji profile, expecting 2 total", 2, meals.size());
    }

    @Test
    public void updateMealRecipeTable() {
        jdbcMealDAO.updateMealRecipeTable("Pizza and sandwich", "Spaghetti & Meatballs");
        List<String> recipes = jdbcMealDAO.getRecipesInMeal(1);
        assertEquals("Adding Spaghetti & Meatballs to Pizza and sandwich meal, expecting 3 recipes now", 3, recipes.size());
    }

    @Test
    public void deleteMealFromMealRecipe() {
        jdbcMealDAO.deleteMealFromMealRecipe(1, 2);
        List<String> recipes = jdbcMealDAO.getRecipesInMeal(1);
        assertEquals("Deleted recipe 2 from meal 1, expecting 1 recipe", 1, recipes.size());
    }

    // CAN'T TEST THIS BECAUSE MEAL_ID 1 STILL REFERRED TO IN MEAL_EVENT TABLE
//    @Test
//    public void deleteMealFromMeal() {
//        jdbcMealDAO.deleteMealFromMeal(1);
//        List<Meal> meals = jdbcMealDAO.getAllMealsByUserID(3);
//        assertEquals("Deleting meal 1 from alinaMawji, expecting 0 remaining", 0, meals.size());
//    }

    @Test
    public void getMealByID() {
        Meal meal = jdbcMealDAO.getMealByID(1);
        assertEquals("Checking that meal 1 has title Pizza and sandwich", "Pizza and sandwich", meal.getTitle());
    }

    @Test
    public void getRecipesInMeal() {
        List<String> recipes = jdbcMealDAO.getRecipesInMeal(1);
        assertEquals("Checking that meal 1 has Pizza Bagel Bites and Club Sandwich", Arrays.asList("Club Sandwich", "Pizza Bagel Bites"), recipes);
    }
}
