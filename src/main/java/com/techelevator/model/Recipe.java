package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class Recipe {
    @Autowired
    private RecipeDAO recipeDAO;

    private long recipe_id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotEmpty(message = "Ingredient list cannot be empty")
    private List<String> ingredients;

    @NotBlank(message = "Instructions are required")
    public String instructions;

    @Range(min=1, max=3, message = "Min = 1 (Easy), Max = 3 (Hard)")
    public int difficulty;

    @NotEmpty(message = "Category list cannot be empty")
    private List<String> categories;

    @NotBlank(message = "Overview is required")
    private String overview;

    private LocalDate date_created;

    private String creator_username;

//    @NotBlank(message = "Image is required")
//    private String image;

    //
    // GET METHODS
    //
    public long getRecipeId() {
        return recipe_id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getOverview() {
        return overview;
    }

    public LocalDate getDateCreated() {
        return date_created;
    }

    public String getCreatorUsername() {
        return creator_username;
    }

    //    public String getImage() {
//        return image;
//    }

    //
    // SET METHODS
    //
    public void setRecipeId(long recipe_id) {
        this.recipe_id = recipe_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setDateCreated(LocalDate date_created) {
        this.date_created = date_created;
    }

    public void setCreatorUsername(String creator_username) {
        this.creator_username = creator_username;
    }

    //    public void setImage(String image) {
//        this.image = image;
//    }

}
