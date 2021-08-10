package com.techelevator.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class Cookbook {
    private long user_id;

    private List<Recipe> recipes;

    private CookbookDAO cookbookDAO;

    public long getUserId() {
        return user_id;
    }

    public List<Recipe> getRecipes() {
        long user_id = getUserId();
        List<Recipe> cookbookRecipes = cookbookDAO.getRecipesFromMyCookbook(user_id);
        return cookbookRecipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }
}
