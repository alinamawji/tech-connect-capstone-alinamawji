package com.techelevator.controller;

import com.techelevator.model.JDBCMealDAO;
import com.techelevator.model.Meal;
import com.techelevator.model.*;
import com.techelevator.model.Recipe;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
public class MealController {

    @Autowired
    private JDBCMealDAO mealDAO;

    @Autowired
    private JDBCCookbookDAO cookbookDAO;

    @Autowired
    private JDBCRecipeDAO recipeDAO;

    @RequestMapping(path="/meals", method = RequestMethod.GET)
    public String showAllMeals(ModelMap modelHolder, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            List<Meal> meals = mealDAO.getAllMealsByUserID(user.getId());
            session.setAttribute("meals", meals);

            for (Meal meal: meals) {
                meal.setRecipesInMeal(mealDAO.getRecipesInMeal(meal.getMealId()));
            }
            return "meals";
        }
        return "private";
    }

    @RequestMapping(path="/meals", method = RequestMethod.POST)
    public String deleteMeal(@RequestParam Long meal_id, HttpSession session, ModelMap modelHolder) {
        User user = new User();

        List <Meal> listOfMeals = (List<Meal>) session.getAttribute("meals");
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            session.setAttribute("deletedMeal", mealDAO.getMealByID(meal_id));
            for (Meal meal : listOfMeals) {
                if (meal.getMealId() == meal_id) {
                    for (String title: meal.getRecipesInMeal()) {
                        Recipe recipe = recipeDAO.getRecipeByTitle(title);
                        mealDAO.deleteMealFromMealRecipe(meal.getMealId(), recipe.getRecipeId());
                    }
                    mealDAO.deleteMealFromMeal(meal_id);
                }
            }

            return "redirect:/meals";
        }
        else {
            return "redirect:/private";
        }
    }

    @RequestMapping(path="/addNewMeal", method = RequestMethod.GET)
    public String displayAddNewMealForm(ModelMap modelHolder, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Meal meal = new Meal();
        modelHolder.put("meal", meal);
        modelHolder.put("cookbookRecipes", cookbookDAO.getRecipesFromMyCookbook(user.getId()));
        return "addNewMeal";
    }

    @RequestMapping(path="/addNewMeal", method = RequestMethod.POST)
    public String processAddNewMealInput(@RequestParam List<String> recipesInMeal, @Valid @ModelAttribute Meal meal,
                                         BindingResult result, RedirectAttributes flash,
                                         HttpSession session, HttpServletRequest request) {
        recipesInMeal = Arrays.asList(request.getParameterValues("recipesInMeal"));
        User user = (User) session.getAttribute("user");
        if (result.hasErrors() || recipesInMeal.size() == 0) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "meal" , meal);
            return "redirect:/meals";
        }
        mealDAO.createMeal(meal.getTitle(), user.getId());
        for (String recipe: recipesInMeal) {
            mealDAO.updateMealRecipeTable(meal.getTitle(), recipe);
        }
        return "redirect:/meals";
    }

}
