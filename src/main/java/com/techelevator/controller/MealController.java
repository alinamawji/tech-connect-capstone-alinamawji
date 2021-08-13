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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MealController {

    @Autowired
    private JDBCMealDAO mealDAO;

    @RequestMapping(path="/meals", method = RequestMethod.GET)
    public String showAllMeals(ModelMap modelHolder) {
        List<Meal> meals = mealDAO.getAllMeals();
        modelHolder.put("meals", meals);
        return "meals";
    }

    @RequestMapping(path="/addNewMeal", method = RequestMethod.GET)
    public String displayAddNewMealForm(ModelMap modelHolder) {
        Meal meal = new Meal();
        modelHolder.put("meal", meal); 
        return "addNewMeal";
    }

    @RequestMapping(path="/addNewMeal", method = RequestMethod.POST)
    public String processAddNewMealInput(@Valid @ModelAttribute Meal meal, BindingResult result, RedirectAttributes flash) {
        flash.addFlashAttribute("meal", meal);

        return "meals";
    }

}
