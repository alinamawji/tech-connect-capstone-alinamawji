package com.techelevator.model;

import org.hibernate.validator.constraints.NotBlank;

public class Category {
    private long category_id;

    @NotBlank(message = "Name is required")
    private String name;

    public long getCategoryId() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public void setCategoryId(long category_id) {
        this.category_id = category_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
