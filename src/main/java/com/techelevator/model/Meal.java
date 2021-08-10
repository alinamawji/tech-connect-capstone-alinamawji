package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class Meal {
    private long meal_id;

    @NotBlank(message = "Title is required")
    private String title;

    private long user_id;

    @NotEmpty(message = "Recipe list cannot be empty")
    private List<Recipe> recipesInMeal;

    public long getMeal_id() {
        return meal_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public List<Recipe> getRecipesInMeal() {
        return recipesInMeal;
    }

    public void setMeal_id(long meal_id) {
        this.meal_id = meal_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRecipesInMeal(List<Recipe> recipesInMeal) {
        this.recipesInMeal = recipesInMeal;
    }
}
