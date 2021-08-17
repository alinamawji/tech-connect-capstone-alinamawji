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
    public String showUserMealPlans(ModelMap modelHolder, HttpSession session) {
        List<MealPlan> plans = new ArrayList<>();
        // Checks to see if there is a logged in user (only members can view meal plans)
        User user = (User) session.getAttribute("user");
        try {
            plans = mealPlanDAO.getAllMealPlansByUser(user.getId());
        } catch (Exception e) {
            return "redirect:/private";
        }
        modelHolder.put("mealPlans", plans);
        return "mealPlans";
    }

//    @RequestMapping(path = "/addNewMealPlanConfirmation", method = RequestMethod.GET)
//    public String addNewMealPlanConfirmation() {
//        return "addNewMealPlanConfirmation";
//    }

    @RequestMapping(path = "/mealPlanDetails", method = RequestMethod.GET)
    public String showMealPlanDetails(@RequestParam Long plan_id, ModelMap modelHolder) {
        MealPlan plan = mealPlanDAO.getMealPlanByID(plan_id);
        plan.setPlannedMeals(mealPlanDAO.getPlannedMeals(plan_id));
        modelHolder.put("mealPlan", plan);

        return "mealPlanDetails";
    }

    @RequestMapping(path = "/addNewMealPlan", method = RequestMethod.GET)
    public String showAddNewMealPlan(HttpSession session, ModelMap modelHolder) {
        User user = (User) session.getAttribute("user");
        modelHolder.put("mealPlan", new MealPlan());
        modelHolder.put("meals", mealDAO.getAllMealsByUserID(user.getId()));
        return "addNewMealPlan";
    }

    @RequestMapping(path = "/addNewMealPlan", method = RequestMethod.POST)
    public String processAddNewMealPlan(@Valid @ModelAttribute("mealPlan") MealPlan mealPlan,
                                        BindingResult result, RedirectAttributes flash, HttpSession session,
                                        HttpServletRequest request) {
        User user = (User) session.getAttribute("user");

        List<String> mealIds = Arrays.asList(request.getParameterValues("meal_id"));
        List<Meal> selectedMeals = new ArrayList<>();
        for (String mealId : mealIds) {
            Long longMealId = Long.parseLong(mealId);
            selectedMeals.add(mealDAO.getMealByID(longMealId));
        }
        mealPlan.setSelectedMeals(selectedMeals);
        mealPlan.setUserId(user.getId());

        session.setAttribute("mealPlan", mealPlan);

        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "mealPlan" + result);
            return "redirect:/addNewMealPlan";
        }
        mealPlanDAO.addMealPlanOnly(user.getId(), mealPlan.getTitle(), mealPlan.getDescription());
        for (Meal meal : mealPlan.getSelectedMeals()) {
            mealPlanDAO.addMealToPlan(mealPlan.getUserId(), mealPlan.getTitle(), meal.getMealId());
        }
        return "redirect:/addMealsToPlan";
    }

    @RequestMapping(path = "/addMealsToPlan", method = RequestMethod.GET)
    public String showAddMealsToPlan(HttpSession session, ModelMap modelHolder, RedirectAttributes flash) {
        MealPlan mealPlan = (MealPlan) session.getAttribute("mealPlan");
        modelHolder.put("mealEvent", new MealEvent());
        // modelHolder.put("plannedMeals",) COME BACK TO AFTER MEAL PLAN DETAILS IS DONE

        return "addMealsToPlan";
    }

    @RequestMapping(path = "/addMealsToPlan", method = RequestMethod.POST)
    public String processAddMealsToPlan(@Valid @ModelAttribute("mealEvent") MealEvent mealEvent, BindingResult result,
                                        HttpSession session, ModelMap modelHolder, RedirectAttributes flash,
                                        HttpServletRequest request) {

        mealEvent.setMealId(Long.parseLong((request.getParameter("meal_id"))));
        mealEvent.setWeekday(Integer.parseInt((request.getParameter("weekday"))));
        mealEvent.setTimeOfDay(Integer.parseInt((request.getParameter("time_of_day"))));

        MealPlan mealPlan = (MealPlan) session.getAttribute("mealPlan");
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "mealEvent" + result);
            return "redirect:/addMealsToPlan";
        }
        mealPlanDAO.createMealEvent(mealEvent.getWeekday(), mealEvent.getTimeOfDay(), mealPlan.getUserId(),
                mealPlan.getTitle(), mealEvent.getMealId());
        return "redirect:/addMealsToPlan";
    }
    
}

