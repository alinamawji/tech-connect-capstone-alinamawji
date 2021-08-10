package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Recipe {
    @Autowired
    private RecipeDAO recipeDAO;

    private long recipe_id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotEmpty(message = "Ingredient list cannot be empty")
    private List<Ingredient> ingredients;

    @NotBlank(message = "Instructions are required")
    public String instructions;

    @NotBlank(message = "Difficulty is required")
    @Range(message = "Min = 1 (Easy), Max = 3 (Hard)")
    public int difficulty;

    @NotEmpty(message = "Category list cannot be empty")
    private List<Category> categories;

    @NotBlank(message = "Overview is required")
    private String overview;

    @NotBlank(message = "Image is required")
//    private String image;

    //
    // GET METHODS
    //
    public long getRecipe_id() {
        return recipe_id;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingredient> getIngredients() {
        long recipe_id = getRecipe_id();
        return recipeDAO.getRecipeIngredients(recipe_id);
    }

    public String getInstructions() {
        return instructions;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public List<Category> getCategory() {
        long recipe_id = getRecipe_id();
        return recipeDAO.getRecipeCategories(recipe_id);
    }

    public String getOverview() {
        return overview;
    }

//    public String getImage() {
//        return image;
//    }

    //
    // SET METHODS
    //
    public void setRecipe_id(long recipe_id) {
        this.recipe_id = recipe_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

//    public void setImage(String image) {
//        this.image = image;
//    }

}
