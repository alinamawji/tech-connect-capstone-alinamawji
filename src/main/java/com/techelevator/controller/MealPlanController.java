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
import java.util.*;

@Controller
public class MealPlanController {

    @Autowired
    private JDBCMealPlanDAO mealPlanDAO;

    @Autowired
    private JDBCMealDAO mealDAO;

    @RequestMapping(path = "/mealPlans", method = RequestMethod.GET)
    public String showUserMealPlans(ModelMap modelHolder, HttpSession session){
        List<MealPlan> plans = new ArrayList<>();
        // Checks to see if there is a logged in user (only members can view meal plans)
        User user = (User) session.getAttribute("user");
        try {
            plans = mealPlanDAO.getAllMealPlansByUser(user.getId());
        } catch (Exception e){
            return "redirect:/private";
        }
        modelHolder.put("mealPlans", plans);
        return "mealPlans";
    }

    @RequestMapping(path = "/addNewMealPlanConfirmation", method = RequestMethod.GET)
    public String addNewMealPlanConfirmation() {
        return "addNewMealPlanConfirmation";
    }

    @RequestMapping(path = "/mealPlanDetails", method = RequestMethod.GET)
    public String showMealPlanDetails(@RequestParam Long plan_id, ModelMap modelHolder){
        MealPlan plan = mealPlanDAO.getMealPlanByID(plan_id);
        plan.setPlannedMeals(mealPlanDAO.getPlannedMeals(plan_id));
        modelHolder.put("mealPlan", plan);

        return "mealPlanDetails";
    }

    @RequestMapping(path = "/addNewMealPlan", method = RequestMethod.GET)
    public String showAddNewMealPlan(HttpSession session, ModelMap modelHolder){
        User user = (User) session.getAttribute("user");
        modelHolder.put("mealPlan", new MealPlan());
        modelHolder.put("meals", mealDAO.getAllMealsByUserID(user.getId()));
        return "addNewMealPlan";
    }

    @RequestMapping(path = "/addNewMealPlan", method = RequestMethod.POST)
    public String processAddNewMealPlan(@Valid@ModelAttribute("mealPlan") MealPlan mealPlan,
                                        BindingResult result, RedirectAttributes flash, HttpSession session,
                                        HttpServletRequest request) {
        flash.addFlashAttribute("mealPlan", mealPlan);
        User user = (User) session.getAttribute("user");
        session.setAttribute("mealPlan",mealPlan);

        if(result.hasErrors()){
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "mealPlan" + result);
            return "redirect:/addNewMealPlan";
        }
        List <Long> mealIds = Arrays.asList(Long.parseLong(request.getParameter("meal_id")));
        List <Meal> selectedMeals = new ArrayList<>();
        for (Long mealId: mealIds) {
            selectedMeals.add(mealDAO.getMealByID(mealId));
        }
        mealPlan.setSelectedMeals(selectedMeals);
        mealPlanDAO.addMealPlanOnly(user.getId(), mealPlan.getTitle(), mealPlan.getDescription());
        return "redirect:/addMealsToPlan";
    }

    @RequestMapping(path = "/addMealsToPlan", method = RequestMethod.GET)
    public String showAddMealsToPlan(HttpSession session, ModelMap modelHolder){
        MealPlan mealPlan = (MealPlan) session.getAttribute("mealPlan");
        modelHolder.put("planTitle", mealPlan.getTitle());
        //modelHolder.put()
        modelHolder.put("planDescription", mealPlan.getDescription());
        return "addMealsToPlan";
    }

    @RequestMapping(path = "/addMealsToPlan", method = RequestMethod.POST)
    public String processAddMealsToPlan(HttpSession session, @RequestParam long meal_id, @RequestParam int weekday,
                                        @RequestParam int time_of_day) {
        MealPlan mealPlan = (MealPlan) session.getAttribute("mealPlan");
        mealPlanDAO.createMealEvent(weekday, time_of_day, mealPlan.getPlanId(), meal_id);
        session.removeAttribute("mealPlan"); //removes variable so we can submit another meal plan in a single session
        return "redirect:/addMealsToPlan";
    }

//    @RequestMapping(path = "/addMealToMealPlan", method = RequestMethod.POST)
//    public String handleAddMealToMealPlan(@Valid @ModelAttribute Meal meal, @RequestParam List <String> meals, BindingResult result, RedirectAttributes flash,
//                                          ModelMap modelHolder, HttpSession session) {
//        MealPlan mealPlan = (MealPlan) modelHolder.get("mealPlan");
//
//        if (result.hasErrors()) {
//            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "meal", meal);
//            return "redirect:/private";
//        }
//        for (String newMeal :meals) {
//            mealPlanDAO.addMealToPlan(mealPlan.getPlanId(), newMeal);
//        }
//        return "redirect:/mealPlans";
//    }
}

