package com.techelevator.model;

import java.util.List;

public interface IngredientDAO {
    public void addIngredientToDB(Ingredient ingredient);

    public List<Ingredient> getAllIngredients();
}
