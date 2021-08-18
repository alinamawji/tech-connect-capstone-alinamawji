package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MealPlanDAO {

    public void addMealPlanToDB(long user_id, String title, String description,
                                Map<MealEvent,Meal> meals);

    public void addMealPlanOnly(long user_id, String title, String description);

    public void deleteMealPlanFromDB(long plan_id);

    public MealPlan getMealPlanByID(long plan_id);

    public List<MealPlan> getAllMealPlansByUser(long user_id);

    public Map<MealEvent,Meal> getPlannedMeals(long plan_id);

    public long getMealPlanID(long user_id, String title, String description);

    public void addMealToPlan(long user_id, String title, long meal_id);

    public void createMealEvent(int weekday, int time_of_day, long user_id, String title, long meal_id);

    public void removeMealFromPlan(long plan_id, long meal_id);

    public void deleteMealEvent(long plan_id, long meal_id);

    public void deleteMealEventByID(long event_id);

    public void updateTitle(long plan_id,String title);

    public void updateDescription(long plan_id, String description);

    public List<String> generateGroceryList(long plan_id); //this might have to be a list of string


}
