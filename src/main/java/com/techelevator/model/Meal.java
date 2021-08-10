package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;

public class Meal {
    private long meal_id;

    @NotBlank(message = "Title is required")
    private String title;
}
