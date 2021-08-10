package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

public interface RecipeDAO {

    public void addRecipeToDB(long recipe_id, String title, String overview, int difficulty, DateTimeFormat date_created, String instructions, List<Ingredient> ingredients, List<Category> categories);

    public void deleteRecipeFromDB(long recipe_id);

    public List<Ingredient> getRecipeIngredients(long recipe_id);

    public List<Category> getRecipeCategories(long recipe_id);

    public Recipe getRecipeByID(long recipe_id);

    public void addIngredientToList(long recipe_id, Ingredient ingredient);

    public void removeIngredientFromList(long recipe_id, Ingredient ingredient);

    public void modifyInstructions(long recipe_id, String instructions);

}