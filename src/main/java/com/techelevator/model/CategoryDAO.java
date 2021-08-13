package com.techelevator.model;

import org.springframework.stereotype.Component;

import java.util.List;


public interface CategoryDAO {
    public List<String> getAllCategories();

}
