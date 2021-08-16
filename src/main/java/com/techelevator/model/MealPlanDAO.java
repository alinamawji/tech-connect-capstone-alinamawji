package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MealPlanDAO {

    public void addMealPlanToDB(long user_id, String title, String description,
                                Map<MealEvent,Meal> meals); //might need to add List<Meal> to store

    public void deleteMealPlanFromDB(long plan_id);

    public MealPlan getMealPlanByID(long plan_id);

    public List<MealPlan> getAllMealPlansByUser(long user_id);

    public Map<MealEvent,Meal> getPlannedMeals(long plan_id);

    public void addMealToPlan(long plan_id, Meal meal);

    public void createMealEvent(MealEvent event);

    public void removeMealFromPlan(long plan_id, Meal meal);

    public void deleteMealEvent(MealEvent event);

    public void updateTitle(long plan_id,String title);

    public void updateDescription(long plan_id, String description);

    public List<String> generateGroceryList(long plan_id); //this might have to be a list of string


}
