package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class MealPlan {
    private long plan_id;

    private long user_id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private LocalDate date_created;

    private Map<MealEvent,Meal> plannedMeals;

    private List<Meal> selectedMeals;

    public long getPlanId() {
        return plan_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() { return description; }

    public LocalDate getDateCreated() {
        return date_created;
    }

    public Map<MealEvent, Meal> getPlannedMeals() {
        return plannedMeals;
    }

    public void setPlanId(long plan_id) {
        this.plan_id = plan_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) { this.description = description; }

    public void setDateCreated(LocalDate date_created) {
        this.date_created = date_created;
    }

    public void setPlannedMeals(Map<MealEvent, Meal> plannedMeals) {
        this.plannedMeals = plannedMeals;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }

    public List<Meal> getSelectedMeals() {
        return selectedMeals;
    }
    public void setSelectedMeals(List<Meal> selectedMeals){
        this.selectedMeals = selectedMeals;
    }
}
