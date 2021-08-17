package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface RecipeDAO {

    public void addRecipeToDB(String title, String overview, int difficulty, String instructions, List<String> ingredients, List<String> categories, String creatorUsername, long user_id);

    public void deleteRecipeFromDB(long recipe_id);

    public List<String> getRecipeIngredients(long recipe_id);

    public List<String> getRecipeCategories(long recipe_id);

    public Recipe getRecipeByID(long recipe_id);

    public Recipe getRecipeByTitle(String title);

    public void addIngredientToList(long recipe_id, String ingredient);

    public void removeIngredientFromList(long recipe_id, String ingredient);

    public void modifyInstructions(long recipe_id, String instructions);

    public List<Recipe> getAllRecipes();

    public List<Recipe> getRecipesFromUser(String username);

}