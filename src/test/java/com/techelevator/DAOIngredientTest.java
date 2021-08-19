package com.techelevator;

import com.techelevator.model.JDBCCategoryDAO;
import com.techelevator.model.JDBCIngredientDAO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;
import java.util.List;

public class DAOIngredientTest extends DAOIntegrationTest {

    private JDBCIngredientDAO jdbcIngredientDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        jdbcIngredientDAO = new JDBCIngredientDAO(dataSource);
    }

    @Test
    public void addIngredientsToDB() {
        jdbcIngredientDAO.addIngredientToDB("cat food");
        List<String> allIngredients = jdbcIngredientDAO.getAllIngredients();
        assertEquals("Size of category list should be 36, after cat food is added", 36, allIngredients.size());
    }

    @Test
    public void getAllIngredients() {
        List<String> allIngredients = jdbcIngredientDAO.getAllIngredients();
        assertEquals("Size of category list should be 35", 35, allIngredients.size());
    }

}
