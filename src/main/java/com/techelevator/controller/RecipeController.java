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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
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
    public String saveRecipeFromUniversal(@RequestParam Long recipe_id, HttpSession session) {

        // user log in
        User user = (User) session.getAttribute("user");
        try {
            // save to cookbook
            cookbookDAO.addRecipeToCookbook(recipe_id, user.getId());
        } catch (Exception e) {
            return "redirect:/errorPage";
        }
        session.setAttribute("addedRecipe", recipeDAO.getRecipeByID(recipe_id));
        return "redirect:/cookbook";
    }

    @RequestMapping(path = "/errorPage", method = RequestMethod.GET)
    public String showAlreadyInCookbookPage() {
        return "errorPage";
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
            Integer difficulty = Integer.parseInt(request.getParameter("difficulty"));

            recipe.setCategories(categoryList);
            recipe.setIngredients(ingredientList);
            recipe.setDifficulty(difficulty);

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

        return "redirect:/cookbook";
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
        flash.addFlashAttribute("mealingredient", name);
        return "redirect:/addNewIngredient";
    }

    @RequestMapping(path = "/addIngredientConfirmation", method = RequestMethod.GET)
    public String displayAddedIngredientConfirmation(ModelMap modelMap) {
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


    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String processSearch(@RequestParam String string, @RequestParam String filter, ModelMap modelHolder){
        List <Recipe> recipes = new ArrayList<>();
        if (filter.equals("ingredient")) {
           recipes = recipeDAO.getRecipeByIngredient(string);
        }
        else if (filter.equals("category")) {
          recipes =  recipeDAO.getRecipeByCategory(string);
        }
        modelHolder.put("recipes", recipes);
        modelHolder.put("string", string);
        return "search";
    }

    @RequestMapping(path = "/changeInstructions", method = RequestMethod.GET)
    public String showEditInstructionsPage(@RequestParam long recipe_id, HttpSession session, ModelMap modelHolder) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        session.setAttribute("recipe", recipe);
        modelHolder.put("recipe", recipe);
        modelHolder.put("instructions", "");

        return "changeInstructions";
    }

    @RequestMapping(path = "/changeInstructions", method = RequestMethod.POST)
    public String processEditedInstructions(@Valid @ModelAttribute String instructions, BindingResult result,
                                            RedirectAttributes flash,
                                            @RequestParam String newInstructions, ModelMap modelHolder,
                                            HttpServletRequest request) {
        Recipe oldRecipe = recipeDAO.getRecipeByID(Long.parseLong(request.getParameter("recipeId")));
        newInstructions = (request.getParameter("newInstructions"));

        if (newInstructions != null) {
            recipeDAO.modifyInstructions(oldRecipe.getRecipeId(), newInstructions);
            return "redirect:/cookbook";
        }

        return "redirect:/private";
    }

    @RequestMapping(path = "/deleteIngredientsFromRecipe", method = RequestMethod.GET)
    public String displayDeleteIngredientsForm(@RequestParam long recipe_id, ModelMap modelHolder) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        List <String> ingredients = recipeDAO.getRecipeIngredients(recipe_id);
        modelHolder.put("recipe", recipe);
        modelHolder.put("ingredients", ingredients);
        modelHolder.put("ingredient", "");
        return "deleteIngredientsFromRecipe";
    }

    @RequestMapping(path = "deleteIngredientsFromRecipe", method = RequestMethod.POST)
    public String handleRemovalOfIngredients(@Valid @ModelAttribute String ingredient, BindingResult result,
                                             RedirectAttributes flash, @RequestParam List <String> removeTheseIngredients, HttpServletRequest request) {
        Recipe oldRecipe = recipeDAO.getRecipeByID(Long.parseLong(request.getParameter("recipeId")));

        if (result.hasErrors() || removeTheseIngredients.size() == 0) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "ingredient", ingredient);
            return "redirect:/private";
        }
        else {
            for (String removeThisIngredient: removeTheseIngredients) {
                recipeDAO.removeIngredientFromList(oldRecipe.getRecipeId(), removeThisIngredient);
            }
            return "redirect:/cookbook";
        }
    }

    @RequestMapping(path = "addNewIngredientsToRecipe", method = RequestMethod.GET)
    public String displayAddNewIngredientsToRecipe(@RequestParam long recipe_id, ModelMap modelHolder) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        List <String> allIngredients = recipeDAO.getIngredientsNotInRecipe(recipe_id);

        modelHolder.put("recipe", recipe);
        modelHolder.put("allIngredients", allIngredients);
        modelHolder.put("newIngredients", "");

        return "addNewIngredientsToRecipe";
    }

    @RequestMapping(path = "addNewIngredientsToRecipe", method = RequestMethod.POST)
    public String handleAddNewIngredientsToRecipe(@Valid @ModelAttribute String ingredient, BindingResult result,
                                                  RedirectAttributes flash, @RequestParam List <String> newIngredients,
                                                  HttpServletRequest request) {

        Recipe oldRecipe = recipeDAO.getRecipeByID(Long.parseLong(request.getParameter("recipe_id")));
        if (result.hasErrors() || newIngredients.size() == 0) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "ingredient", ingredient);
            return "redirect:/private";
        }
        else {
            for (String addThisIngredient : newIngredients) {
                recipeDAO.addIngredientToList(oldRecipe.getRecipeId(), addThisIngredient);
            }
            return "redirect:/cookbook";
        }
    }

}

