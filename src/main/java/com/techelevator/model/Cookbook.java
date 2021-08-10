package com.techelevator.model;

import java.util.List;

public class Cookbook {
    private long user_id;
    private List<Recipe> recipes;

    private CookbookDAO cookbookDAO;

    public long getUser_id() {
        return user_id;
    }

    public List<Recipe> getRecipes() {
        long user_id = getUser_id();
        List<Recipe> cookbookRecipes = cookbookDAO.getRecipesFromMyCookbook(user_id);
        return cookbookRecipes;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
