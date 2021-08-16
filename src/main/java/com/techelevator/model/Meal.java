package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Meal {
    @Autowired
    private MealDAO mealDAO;

    private long meal_id;

    @NotBlank(message = "Title is required")
    private String title;

    private long user_id;

    @NotEmpty(message = "Recipe list cannot be empty")
    private List<String> recipesInMeal;

    public long getMealId() {
        return meal_id;
    }

    public long getUserId() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getRecipesInMeal() {
        return recipesInMeal;
    }

    public void setMealId(long meal_id) {
        this.meal_id = meal_id;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRecipesInMeal(List<String> recipesInMeal) {
        this.recipesInMeal = recipesInMeal;
    }
}
