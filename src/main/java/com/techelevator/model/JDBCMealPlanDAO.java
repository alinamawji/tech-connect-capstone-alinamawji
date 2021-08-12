package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JDBCMealPlanDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMealPlanDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRecipeToDB()


}

class mealPlanRowMapper implements RowMapper {
    @Override
    public MealPlan mapRow(ResultSet results, int i) throws SQLException {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setPlanId(results.getLong('plan_id'));
        mealPlan.setTitle(results.getString('title'));
        mealPlan.setDescription((results.getString('description')));
        mealPlan.setDateCreated('date_created');
    }
}