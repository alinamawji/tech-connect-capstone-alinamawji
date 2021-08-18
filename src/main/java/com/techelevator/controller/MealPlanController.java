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
import java.lang.reflect.Array;
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
    public String showMealPlanDetails(@RequestParam Long plan_id, ModelMap modelHolder, HttpSession session){
        MealPlan plan = mealPlanDAO.getMealPlanByID(plan_id);
        plan.setPlannedMeals(mealPlanDAO.getPlannedMeals(plan_id));
        modelHolder.put("mealPlan", plan);

        User user = (User) session.getAttribute("user");

        // initialize arrays for each day/time meal
        ArrayList<String> sundayBreakfast = new ArrayList<>();
        ArrayList<String> sundayLunch = new ArrayList<>();
        ArrayList<String> sundayDinner = new ArrayList<>();
        ArrayList<String> sundaySnacks = new ArrayList<>();

        ArrayList<String> mondayBreakfast = new ArrayList<>();
        ArrayList<String> mondayLunch = new ArrayList<>();
        ArrayList<String> mondayDinner = new ArrayList<>();
        ArrayList<String> mondaySnacks = new ArrayList<>();

        ArrayList<String> tuesdayBreakfast = new ArrayList<>();
        ArrayList<String> tuesdayLunch = new ArrayList<>();
        ArrayList<String> tuesdayDinner = new ArrayList<>();
        ArrayList<String> tuesdaySnacks = new ArrayList<>();

        ArrayList<String> wednesdayBreakfast = new ArrayList<>();
        ArrayList<String> wednesdayLunch = new ArrayList<>();
        ArrayList<String> wednesdayDinner = new ArrayList<>();
        ArrayList<String> wednesdaySnacks = new ArrayList<>();

        ArrayList<String> thursdayBreakfast = new ArrayList<>();
        ArrayList<String> thursdayLunch = new ArrayList<>();
        ArrayList<String> thursdayDinner = new ArrayList<>();
        ArrayList<String> thursdaySnacks = new ArrayList<>();

        ArrayList<String> fridayBreakfast = new ArrayList<>();
        ArrayList<String> fridayLunch = new ArrayList<>();
        ArrayList<String> fridayDinner = new ArrayList<>();
        ArrayList<String> fridaySnacks = new ArrayList<>();

        ArrayList<String> saturdayBreakfast = new ArrayList<>();
        ArrayList<String> saturdayLunch = new ArrayList<>();
        ArrayList<String> saturdayDinner = new ArrayList<>();
        ArrayList<String> saturdaySnacks = new ArrayList<>();

        for (Map.Entry<MealEvent, Meal> entry : plan.getPlannedMeals().entrySet()) {
            switch (entry.getKey().getWeekday()) {
                case 1:
                    if (entry.getKey().getTimeOfDay() == 1) {
                        sundayBreakfast.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 2) {
                        sundayLunch.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 3) {
                        sundayDinner.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 4) {
                        sundaySnacks.add(entry.getValue().getTitle());
                    }
                    break;
                case 2:
                    if (entry.getKey().getTimeOfDay() == 1) {
                        mondayBreakfast.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 2) {
                        mondayLunch.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 3) {
                        mondayDinner.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 4) {
                        mondaySnacks.add(entry.getValue().getTitle());
                    }
                    break;
                case 3:
                    if (entry.getKey().getTimeOfDay() == 1) {
                        tuesdayBreakfast.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 2) {
                        tuesdayLunch.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 3) {
                        tuesdayDinner.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 4) {
                        tuesdaySnacks.add(entry.getValue().getTitle());
                    }
                    break;
                case 4:
                    if (entry.getKey().getTimeOfDay() == 1) {
                        wednesdayBreakfast.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 2) {
                        wednesdayLunch.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 3) {
                        wednesdayDinner.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 4) {
                        wednesdaySnacks.add(entry.getValue().getTitle());
                    }
                    break;
                case 5:
                    if (entry.getKey().getTimeOfDay() == 1) {
                        thursdayBreakfast.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 2) {
                        thursdayLunch.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 3) {
                        thursdayDinner.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 4) {
                        thursdaySnacks.add(entry.getValue().getTitle());
                    }
                    break;
                case 6:
                    if (entry.getKey().getTimeOfDay() == 1) {
                        fridayBreakfast.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 2) {
                        fridayLunch.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 3) {
                        fridayDinner.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 4) {
                        fridaySnacks.add(entry.getValue().getTitle());
                    }
                    break;
                case 7:
                    if (entry.getKey().getTimeOfDay() == 1) {
                        saturdayBreakfast.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 2) {
                        saturdayLunch.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 3) {
                        saturdayDinner.add(entry.getValue().getTitle());
                    } else if (entry.getKey().getTimeOfDay() == 4) {
                        saturdaySnacks.add(entry.getValue().getTitle());
                    }
                    break;
            }
        }

        modelHolder.put("sundayBreakfast", sundayBreakfast);
        modelHolder.put("sundayLunch", sundayLunch);
        modelHolder.put("sundayDinner", sundayDinner);
        modelHolder.put("sundaySnacks", sundaySnacks);

        modelHolder.put("mondayBreakfast", mondayBreakfast);
        modelHolder.put("mondayLunch", mondayLunch);
        modelHolder.put("mondayDinner", mondayDinner);
        modelHolder.put("mondaySnacks", mondaySnacks);

        modelHolder.put("tuesdayBreakfast", tuesdayBreakfast);
        modelHolder.put("tuesdayLunch", tuesdayLunch);
        modelHolder.put("tuesdayDinner", tuesdayDinner);
        modelHolder.put("tuesdaySnacks", tuesdaySnacks);

        modelHolder.put("wednesdayBreakfast", wednesdayBreakfast);
        modelHolder.put("wednesdayLunch", wednesdayLunch);
        modelHolder.put("wednesdayDinner", wednesdayDinner);
        modelHolder.put("wednesdaySnacks", wednesdaySnacks);

        modelHolder.put("thursdayBreakfast", thursdayBreakfast);
        modelHolder.put("thursdayLunch", thursdayLunch);
        modelHolder.put("thursdayDinner", thursdayDinner);
        modelHolder.put("thursdaySnacks", thursdaySnacks);

        modelHolder.put("fridayBreakfast", fridayBreakfast);
        modelHolder.put("fridayLunch", fridayLunch);
        modelHolder.put("fridayDinner", fridayDinner);
        modelHolder.put("fridaySnacks", fridaySnacks);

        modelHolder.put("saturdayBreakfast", saturdayBreakfast);
        modelHolder.put("saturdayLunch", saturdayLunch);
        modelHolder.put("saturdayDinner", saturdayDinner);
        modelHolder.put("saturdaySnacks", saturdaySnacks);

        return "mealPlanDetails";
    }

    @RequestMapping(path = "/addNewMealPlan", method = RequestMethod.GET)
    public String showAddNewMealPlan(HttpSession session, ModelMap modelHolder) {
        User user = (User) session.getAttribute("user");
        modelHolder.put("mealPlan", new MealPlan());
        modelHolder.put("meals", mealDAO.getAllMealsByUserID(user.getId()));
        return "addNewMealPlan";
    }

    @RequestMapping(path = "/groceryList", method = RequestMethod.GET)
    public String showGroceryList(@RequestParam Long plan_id, ModelMap modelHolder) {
        List<String> groceryList = mealPlanDAO.generateGroceryList(plan_id);
        MealPlan mealPlan = mealPlanDAO.getMealPlanByID(plan_id);
        modelHolder.put("mealPlan", mealPlan);
        modelHolder.put("groceryList", groceryList);
        return "groceryList";
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

    @RequestMapping(path = "/modifyMealPlan", method = RequestMethod.GET)
    public String showModifyMealPlanPage(@RequestParam long plan_id, ModelMap modelHolder) {
        MealPlan plan = mealPlanDAO.getMealPlanByID(plan_id);
        plan.setPlannedMeals(mealPlanDAO.getPlannedMeals(plan_id));
        modelHolder.put("mealPlan", plan);
        return "modifyMealPlan";
    }

    @RequestMapping(path = "/addSelectedMeal", method = RequestMethod.GET)
    public String showAddSelectedMealPage(@RequestParam long plan_id, ModelMap modelHolder){
        return "addSelectedMeal";
    }


    @RequestMapping(path = "/deleteSelectedMeal", method = RequestMethod.GET)
    public String showDeleteSelectedMealPage(@RequestParam long plan_id, ModelMap modelHolder){
        return "deleteSelectedMeal";
    }


    @RequestMapping(path = "/addScheduledMeal", method = RequestMethod.GET)
    public String showAddScheduledMealPage(@RequestParam long plan_id, ModelMap modelHolder){
        Map<MealEvent, Meal> plannedMeals = mealPlanDAO.getPlannedMeals(plan_id);
        modelHolder.put("plannedMeals", plannedMeals);
        modelHolder.put("mealEvent", new MealEvent());
        return "addScheduledMeal";
    }


    @RequestMapping(path = "/deleteScheduledMeal", method = RequestMethod.GET)
    public String showDeleteScheduledMealPage(@RequestParam long plan_id, ModelMap modelHolder){
        Map<MealEvent, Meal> plannedMeals = mealPlanDAO.getPlannedMeals(plan_id);
        modelHolder.put("plannedMeals", plannedMeals);
        modelHolder.put("mealEvent", new MealEvent());
        return "deleteScheduledMeal";
    }
    @RequestMapping(path = "/deleteScheduledMeal", method = RequestMethod.POST)
    public String processDeleteScheduledMeal(@Valid@ModelAttribute("mealEvent") MealEvent event, BindingResult result,
                                             RedirectAttributes flash, @RequestParam List<String> removeTheseMealEvents){
        if(result.hasErrors() || removeTheseMealEvents.size() == 0){
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "mealEvent" + result);
            return "redirect:/deleteScheduledMeal";
        }
        for(String removeMealEvent : removeTheseMealEvents){
            mealPlanDAO.deleteMealEvent(Long.parseLong(removeMealEvent));
        }
        return "redirect:/mealPlans";
    }


    
}

