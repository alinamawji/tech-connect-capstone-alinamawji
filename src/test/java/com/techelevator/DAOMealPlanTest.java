package com.techelevator;

import com.techelevator.model.*;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DAOMealPlanTest extends  DAOIntegrationTest {

    private JDBCMealPlanDAO jdbcMealPlanDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        jdbcMealPlanDAO = new JDBCMealPlanDAO(dataSource);
    }

    @Test
    public void addMealPlanOnly() {
        jdbcMealPlanDAO.addMealPlanOnly(3, "mealplan", "description");
        List<MealPlan> mealPlanList = jdbcMealPlanDAO.getAllMealPlansByUser(3);
        assertEquals("Added another meal plan to user 3", 5, mealPlanList.size());
    }

    // DON'T KNOW HOW ELSE TO TEST THIS
//    @Test
//    public void deleteMealPlanFromDB() {
//        jdbcMealPlanDAO.deleteMealPlanFromDB(4);
//        List<MealPlan> mealPlanList = jdbcMealPlanDAO.getAllMealPlansByUser(3);
//        assertEquals("Removed 1 meal plan from user 3", 3, mealPlanList.size());
//    }

    @Test
    public void getMealPlanByID() {
        MealPlan mealPlan = jdbcMealPlanDAO.getMealPlanByID(4);
        assertEquals("Checking mealPlan 4 should have a description of description4", "description4", mealPlan.getDescription());
    }

    @Test
    public void getAllMealPlansByUser() {
        List<MealPlan> mealPlans = jdbcMealPlanDAO.getAllMealPlansByUser(3);
        assertEquals("Checking user 3 has 4 meal plans", 4, mealPlans.size());
    }

    // DON'T KNOW HOW ELSE TO TEST THIS
//    @Test
//    public void getPlannedMeals() {
//        Map<MealEvent, Meal> mealMap = jdbcMealPlanDAO.getPlannedMeals(1);
//        assertEquals("Checking mealPlan 1 has 2 MealEvent:Meal mappings", 2, mealMap.size());
//    }

    @Test
    public void getMealsInAPlan() {
        List<Meal> mealsInPlan2 = jdbcMealPlanDAO.getMealsInAPlan(2);
        assertEquals("Checking mealPlan 2 has 1 meal", 1, mealsInPlan2.size());
    }

//    @Test
//    public void getMealsNotAlreadyInAPlan() {
//        List<Meal> mealsNotInPlan2 = jdbcMealPlanDAO.getMealsNotAlreadyInAPlan(2);
//        assertEquals("Checking mealPlan 2 has all the meals in the database", 0, mealsNotInPlan2.size());
//    }

    // CONFUSED ON HOW TO TEST THIS METHOD
//    @Test
//    public void addMealToPlan() {
//
//    }

    // CONFUSED ON HOW TO TEST THIS METHOD
//    @Test
//    public void createMealEvent() {
//        jdbcMealPlanDAO.createMealEvent(1, 1, 3, "Pizza and sandwich", 1);
//        assertEquals("Adding Pizza and sandwich meal to Monday Breakfast", );
//    }

    @Test
    public void removeMealFromPlan() {
        jdbcMealPlanDAO.removeMealFromPlan(1, 1);
        List<Meal> mealsFromPlan1 = jdbcMealPlanDAO.getMealsInAPlan(1);
        assertEquals("Checking that mealPlan1 has no meals", 0, mealsFromPlan1.size());
    }

    @Test
    public void deleteMealEvent() {
        jdbcMealPlanDAO.deleteMealEvent(1, 1);
        Map<MealEvent, Meal> mealMap = jdbcMealPlanDAO.getMealPlanByID(1).getPlannedMeals();
        assertEquals("plan1 should have no associated meal events", null, mealMap);
    }

    @Test
    public void updateTitle() {
        jdbcMealPlanDAO.updateTitle(1, "mealPlan1");
        assertEquals("Changing name of plan1 to mealPlan1", "mealPlan1", jdbcMealPlanDAO.getMealPlanByID(1).getTitle());
    }

    @Test
    public void updateDescription() {
        jdbcMealPlanDAO.updateDescription(1, "mealPlanDescription1");
        assertEquals("Changing name of plan1's description from description1 to mealPlanDescription1", "mealPlanDescription1", jdbcMealPlanDAO.getMealPlanByID(1).getDescription());
    }

    @Test
    public void generateGroceryList() {
        List<String> groceryList = jdbcMealPlanDAO.generateGroceryList(2);
        assertEquals("Generating grocery list for plan 2", Arrays.asList("bacon", "cheddar cheese", "fresh basil", "ham", "lettuce", "mayo", "mini-bagels", "pizza sauce", "shredded mozzarella", "sliced bread", "tomatoes", "toppings of choice", "turkey"), groceryList);
    }
}
