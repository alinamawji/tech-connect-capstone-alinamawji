package com.techelevator.model;

import java.util.List;

public interface CookbookDAO {
    public void addRecipeToCookbook(Long recipe_id, Long user_id);

    public void deleteRecipeFromCookbook(long recipe_id, long user_id);

    public List<Recipe> getRecipesFromMyCookbook(long user_id);

}
