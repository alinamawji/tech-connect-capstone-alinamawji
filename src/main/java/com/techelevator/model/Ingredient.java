package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;

public class Ingredient {

    private long ingredient_id;

    @NotBlank(message = "Name is required")
    private String name;

    //
    // GET METHODS
    //
    public long getIngredientId() {
        return ingredient_id;
    }

    public String getName() {
        return name;
    }

    //
    // SET METHODS
    //
    public void setIngredientId(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
