package com.techelevator.controller;

import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class RecipeController {

    @Autowired
    private JDBCRecipeDAO recipeDAO;

    @Autowired
    private JDBCCookbookDAO cookbookDAO;

    @Autowired
    private JDBCIngredientDAO ingredientDAO;

    @Autowired
    private JDBCCategoryDAO categoryDAO;


    @RequestMapping(path = "/recipes", method = RequestMethod.GET)
    public String showUniversalRecipes(ModelMap modelHolder, HttpSession session) {
        List<Recipe> recipes = recipeDAO.getAllRecipes();
        modelHolder.put("recipes",recipes);

        // user log in
        User user = (User) session.getAttribute("user");

        return "recipes";
    }

    @RequestMapping(path = "/recipes", method = RequestMethod.POST)
    public String saveRecipeFromUniversal(@RequestParam Long recipe_id, ModelMap modelHolder, HttpSession session) {

        // user log in
        User user = (User) session.getAttribute("user");

        try {
            // save to cookbook
            cookbookDAO.addRecipeToCookbook(recipe_id, user.getId());
        } catch (Exception e) {
            return "redirect:/private";
        }

        return "redirect:/addNewRecipeConfirmation";
    }

    @RequestMapping(path = "/addNewRecipeConfirmation", method = RequestMethod.GET)
    public String addNewRecipeConfirmationPage() {
        return "addNewRecipeConfirmation";
    }


    @RequestMapping(path = "/addNewRecipe", method = RequestMethod.GET)
    public String displayAddNewRecipeForm(ModelMap modelHolder) {
        modelHolder.put("recipe", new Recipe());
        modelHolder.put("ingredients", ingredientDAO.getAllIngredients());
        modelHolder.put("categories", categoryDAO.getAllCategories());
        return "addNewRecipe";
    }

    @RequestMapping(path="/addNewRecipe", method = RequestMethod.POST)
    public String processAddNewRecipeInput(@Valid @ModelAttribute Recipe recipe, BindingResult result,
                                           RedirectAttributes flash) {
        flash.addFlashAttribute("recipe", recipe);

        if(result.hasErrors()){
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "recipe", result);
            return "redirect:/addNewRecipe";
        }

        recipeDAO.addRecipeToDB(recipe.getRecipeId(),recipe.getTitle(),recipe.getOverview(),recipe.getDifficulty(),
                recipe.getDateCreated(),recipe.getInstructions(), recipe.getIngredients(), recipe.getCategories());

        return "redirect:/recipes"; //Change this to redirect to the cookbook when jsp pages/controller exists

    }

    @RequestMapping(path = "/recipeDetails", method = RequestMethod.GET)
    public String displayRecipeDetails(@RequestParam Long recipe_id, ModelMap modelHolder, HttpSession session) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        modelHolder.put("recipe", recipe);
        List<Ingredient> ingredients = recipeDAO.getRecipeIngredients(recipe_id);
        modelHolder.put("ingredients", ingredients);
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUsername());

        return "recipeDetails";
    }

    @RequestMapping(path = "/modifyRecipe", method = RequestMethod.GET)
    public String displayModifyRecipe(ModelMap modelHolder) {
        Recipe recipe = (Recipe) modelHolder.get("recipe");
        List<Ingredient> ingredients = (List<Ingredient>) modelHolder.get("ingredients");
        return "modifyRecipe";
    }

    @RequestMapping(path = "/recipeDetails", method = RequestMethod.POST)
    public String displayModifyRecipePage(@RequestParam Long recipe_id, ModelMap modelHolder) {
        System.out.println(recipe_id);

        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        modelHolder.put("recipe", recipe);
        List<Ingredient> ingredients = recipeDAO.getRecipeIngredients(recipe_id);
        modelHolder.put("ingredients", ingredients);

        return "redirect:/modifyRecipe";
    }

    @RequestMapping(path = "/modifyRecipe", method = RequestMethod.POST)
    public String returnToRecipeDetailsAfterModifying() {
        return "redirect:/recipeDetails";
    }

    // add methods for modifying a recipe and deleting a recipe, those will have different method calls from the recipe class.
    // These will be implemented on the cookbookController, which handles a user's personal library of recipes. They can only
    // modify/delete the recipes they created.


}

