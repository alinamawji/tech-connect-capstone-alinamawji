package com.techelevator.model;

import java.util.*;

public interface MealDAO {
    public void createMeal (String title, long user_id);
    public void updateMealRecipeTable (String mealTitle, String recipeTitle);
    public void deleteMeal (long meal_id);
    public void addRecipesToMeal(long meal_id, long recipe_id);
    public void removeRecipeFromMeal(long meal_id, long recipe_id);
    public Meal getMealByID(long meal_id);
    public List<String> getRecipesInMeal(long meal_id);
    public List<Meal> getAllMealsByUserID(long user_id);
}
