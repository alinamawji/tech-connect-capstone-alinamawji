package com.techelevator.controller;

import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
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
                                           RedirectAttributes flash, HttpServletRequest request, HttpSession session) {

        User user = (User) session.getAttribute("user");
        
        try {
            List<String> categoryList = Arrays.asList(request.getParameterValues("categories"));
            List<String> ingredientList = Arrays.asList(request.getParameterValues("ingredients"));

            recipe.setCategories(categoryList);
            recipe.setIngredients(ingredientList);

            flash.addFlashAttribute("recipe", recipe);

            if(result.hasErrors()){
                flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "recipe", result);
                return "redirect:/addNewRecipe";
            }
        } catch(Exception e) {
            e.getCause();
        }

        recipeDAO.addRecipeToDB(recipe.getTitle(), recipe.getOverview(), recipe.getDifficulty(),
                recipe.getInstructions(), recipe.getIngredients(), recipe.getCategories(), user.getUsername(), user.getId());

        return "redirect:/cookbook"; //Change this to redirect to the cookbook when jsp pages/controller exists
    }

    @RequestMapping(path = "/addNewIngredient", method = RequestMethod.GET)
    public String displayAddNewIngredientForm(ModelMap modelHolder) {
        modelHolder.put("ingredient", new Ingredient());
        return "addNewIngredient";
    }

    @RequestMapping(path = "/addNewIngredient", method = RequestMethod.POST)
    public String processAddingIngredient(@Valid @ModelAttribute Ingredient ingredient, BindingResult result, @RequestParam String name,
                                          RedirectAttributes flash, HttpSession session) {

        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "ingredient", ingredient);
            return "redirect:/addNewIngredient";
        }

        ingredientDAO.addIngredientToDB(name);
        session.setAttribute("newIngredient", name);
        return "redirect:/addIngredientConfirmation";
    }

    @RequestMapping(path = "/addIngredientConfirmation", method = RequestMethod.GET)
    public String displayAddedIngredientConfirmation(ModelMap modelMap) {
        Ingredient ingredient = (Ingredient) modelMap.get("ingredient");
        return "addIngredientConfirmation";
    }

    @RequestMapping(path = "/recipeDetails", method = RequestMethod.GET)
    public String displayRecipeDetails(@RequestParam Long recipe_id, ModelMap modelHolder, HttpSession session) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        modelHolder.put("recipe", recipe);
        List<String> ingredients = recipeDAO.getRecipeIngredients(recipe_id);
        modelHolder.put("ingredients", ingredients);
        User user = (User) session.getAttribute("user");

        return "recipeDetails";
    }

    @RequestMapping(path = "/recipeDetails", method = RequestMethod.POST)
    public String displayModifyRecipePage(@RequestParam Long recipe_id, ModelMap modelHolder, HttpSession session) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
//        modelHolder.put("recipe", recipe);
        session.setAttribute("recipe", recipe);
        List<String> ingredients = recipeDAO.getRecipeIngredients(recipe_id);
        session.setAttribute("ingredients", ingredients);
//        modelHolder.put("ingredients", ingredients);

        return "redirect:/modifyRecipe";
    }

    @RequestMapping(path = "/modifyRecipe", method = RequestMethod.GET)
    public String displayModifyRecipe(ModelMap modelHolder) {
        return "modifyRecipe";
    }

    @RequestMapping(path = "/modifyRecipe", method = RequestMethod.POST)
    public String returnToRecipeDetailsAfterModifying(ModelMap modelHolder) {
        Recipe recipe = (Recipe) modelHolder.get("recipe");
        List<String> ingredients = (List<String>) modelHolder.get("ingredients");
        List <String> ingredientsAvailable = ingredientDAO.getAllIngredients();
        modelHolder.put("ingredientsAvailable", ingredientsAvailable);
        return "redirect:/recipeDetails";
    }

    // add methods for modifying a recipe and deleting a recipe, those will have different method calls from the recipe class.
    // These will be implemented on the cookbookController, which handles a user's personal library of recipes. They can only
    // modify/delete the recipes they created.


}

