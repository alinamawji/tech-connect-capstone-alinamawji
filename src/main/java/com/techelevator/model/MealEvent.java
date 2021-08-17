package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class MealEvent {

    private long event_id;
    private long plan_id;
    private long meal_id;

    @NotNull(message = "Please choose what day your meal is planned for")
    private int weekday;

    @NotNull(message = "Please choose what time of day your meal is planned for")
    private int time_of_day;

    public long getEventId() {
        return event_id;
    }

    public void setEventId(long event_id) {
        this.event_id = event_id;
    }

    public long getPlanId() {
        return plan_id;
    }

    public void setPlanId(long plan_id) {
        this.plan_id = plan_id;
    }

    public long getMealId() {
        return meal_id;
    }

    public void setMealId(long meal_id) {
        this.meal_id = meal_id;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getTimeOfDay() {
        return time_of_day;
    }

    public void setTimeOfDay(int time_of_day) {
        this.time_of_day = time_of_day;
    }
}
