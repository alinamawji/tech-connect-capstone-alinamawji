package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.Map;

public interface MealPlanDAO {

    public void addMealPlanToDB(long plan_id, long user_id, String title, String description,
                                DateTimeFormat date_created, Map<MealEvent,Meal> meals); //might need to add List<Meal> to store

    public void deleteMealPlanFromDB(long plan_id);

    public MealPlan getMealPlanByID(long plan_id);

    public List<MealPlan> getAllMealPlans();

    public Map<MealEvent,Meal> getPlannedMeals(long plan_id);

    public void addMealToPlan(long plan_id, Meal meal);

    public void removeMealFromPlan(long plan_id, Meal meal);


}
