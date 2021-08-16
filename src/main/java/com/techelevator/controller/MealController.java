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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MealController {

    @Autowired
    private JDBCMealDAO mealDAO;

    @Autowired
    private JDBCCookbookDAO cookbookDAO;

    @RequestMapping(path="/meals", method = RequestMethod.GET)
    public String showAllMeals(ModelMap modelHolder) {
        List<Meal> meals = mealDAO.getAllMeals();
        modelHolder.put("meals", meals);
        return "meals";
    }

    @RequestMapping(path="/meals", method = RequestMethod.POST)
    public String saveMeal(@RequestParam Long meal_id, ModelMap modelHolder, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Recipe recipe = (Recipe) session.getAttribute("title");
        try {
            mealDAO.addRecipesToMeal(meal_id, recipe.getRecipeId());
        } catch (Exception e) {
            return "redirect:/private";
        }
        return "redirect:/addNewMealConfirmation";
    }
    @RequestMapping(path = "/addNewMealConfirmation", method = RequestMethod.GET)
    public String addNewMealConfirmationPage() {
        return "addNewMealConfirmation";
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
    public String processAddNewMealInput(@Valid @ModelAttribute Meal meal, BindingResult result, RedirectAttributes flash, HttpSession session) {
        flash.addFlashAttribute("meal", meal);
        User user = (User) session.getAttribute("user");
        mealDAO.createMeal(meal.getTitle(), user.getId());

        return "meals";
    }

}
