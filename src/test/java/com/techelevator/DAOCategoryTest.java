package com.techelevator;

import com.techelevator.model.JDBCCategoryDAO;
import com.techelevator.model.JDBCMealPlanDAO;
import com.techelevator.model.MealPlan;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DAOCategoryTest extends DAOIntegrationTest {

    private JDBCCategoryDAO jdbcCategoryDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        jdbcCategoryDAO = new JDBCCategoryDAO(dataSource);
    }

    @Test
    public void getAllCategories() {
        List<String> categories = jdbcCategoryDAO.getAllCategories();
        assertEquals("Categories list should be 15 strings long", 15, categories.size());
    }

}
