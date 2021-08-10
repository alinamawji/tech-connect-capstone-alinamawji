package com.techelevator.controller;

import com.techelevator.model.JDBCRecipeDAO;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RecipeController {
    @Autowired
   private JDBCRecipeDAO recipeDAO;

    @RequestMapping(path = "/recipes", method = RequestMethod.GET)
    public String showUniversalRecipes() {
        return "recipes";
    }


    @RequestMapping(path = "/addNewRecipe", method = RequestMethod.GET)
    public String displayAddNewRecipeForm() {
        return "addNewRecipe";
    }
    @RequestMapping(path="/addNewRecipe", method = RequestMethod.POST)
    public String processAddNewRecipeInput(@Valid @ModelAttribute Recipe recipe, BindingResult result,
                                           RedirectAttributes flash) {
        flash.addFlashAttribute("recipe", recipe);

        if(result.hasErrors()){
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "recipe", result);
            return "redirect:/addNewRecipe"
        }
        recipeDAO.addRecipeToDB(recipe.getRecipe_id(),recipe.getTitle(),recipe.getOverview(),recipe.getDifficulty(),
                recipe.getDateCreated(),recipe.getInstructions(), recipe.getIngredients(), recipe.getCategories());
        return "redirect:/recipes"; //Change this to redirect to the cookbook when jsp pages/controller exists

    }

    @RequestMapping(path = "/recipeDetails", method = RequestMethod.GET)
    public String displayRecipeDetails(@RequestParam Long recipe_id, ModelMap modelHolder) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        modelHolder.put("recipe", recipe);

        return "recipeDetails";
    }

    // add methods for modifying a recipe and deleting a recipe, those will have different method calls from the recipe class.
    // These will be implemented on the cookbookController, which handles a user's personal library of recipes. They can only
    // modify/delete the recipes they created.
}

