package com.techelevator.model;

import java.util.ArrayList;

public class Cookbook {
    private long user_id;
    private ArrayList<Recipe> recipes;

    public long getUser_id() {
        return user_id;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }
}
