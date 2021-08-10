package com.techelevator.controller;

import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RecipeController {
//    @Autowired
//    private Recipe recipe;
//
//    @RequestMapping(path = "/recipes", method = RequestMethod.GET)
//    public String showUniversalRecipes() {
//        return "recipes";
//    }
//
//    @RequestMapping(path = "/addNewRecipe", method = RequestMethod.GET)
//    public String displayAddNewRecipeForm() {
//        return "addNewRecipe";
//    }
//
//    @RequestMapping(path = "/recipeDetails", method = RequestMethod.GET)
//    public String displayRecipeDetails() {
//        return "recipeDetails";
//    }
//
//    @RequestMapping(path = "/addNewRecipe", method = RequestMethod.POST)
//    public String displayAddNewRecipeForm(@Valid @ModelAttribute Recipe recipe, BindingResult result, RedirectAttributes flash) {
//        flash.addFlashAttribute("recipe", recipe);
//        if (result.hasErrors()) {
//            flash.addFlashAttribute("recipe", recipe);
//            return "addNewRecipe";
//        }
//        return "redirect:/recipes";
//    }


    // add methods for modifying a recipe and deleting a recipe, those will have different method calls from the recipe class
}

