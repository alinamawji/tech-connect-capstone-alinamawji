package com.techelevator.model;

import java.util.*;

public interface MealDAO {
    public void createMeal (long meal_id, String title, long user_id);
    public void deleteMeal (long meal_id);
    public void addRecipesToMeal(long meal_id, long recipe_id);
    public void removeRecipeFromMeal(long meal_id, long recipe_id);
    public List<Meal> getAllMeals();
}
