package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;

public class MealPlan {
    private long plan_id;

    @NotBlank(message = "Title is required")
    private String title;

    private LocalDateTime date_created;

    @NotEmpty(message =  "Meal list cannot be empty")
    private List<Meal> mealList;

    public long getPlanId() {
        return plan_id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateCreated() {
        return date_created;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setPlanId(long plan_id) {
        this.plan_id = plan_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateCreated(LocalDateTime date_created) {
        this.date_created = date_created;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }
}