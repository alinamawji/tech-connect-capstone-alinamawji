package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class JDBCMealPlanDAO implements MealPlanDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMealPlanDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addMealPlanToDB(long plan_id, long user_id, String title, String description,
                              DateTimeFormat date_created, Map<MealEvent,Meal> meals){
        //insert mealPlan into meal plan table
        String sqlNewMealPlan = "INSERT INTO meal_plan(plan_id,user_id,title,description,date_created) " +
                "VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sqlNewMealPlan, plan_id, user_id, title, description, date_created);

        //insert mealPlan meals into their associative table
        for(Map.Entry<MealEvent, Meal> plannedMeal : meals.entrySet()) {

        }


        //insert meal events into the meal_event table
    }

    @Override
    public void deleteMealPlanFromDB(long plan_id) {

    }

    @Override
    public MealPlan getMealPlanByID(long plan_id) {
        return null;
    }

    @Override
    public List<MealPlan> getAllMealPlans() {
        return null;
    }

    @Override
    public Map<MealEvent, Meal> getPlannedMeals(long plan_id) {
        return null;
    }

    @Override
    public void addMealToPlan(long plan_id, Meal meal) {

    }

    @Override
    public void removeMealFromPlan(long plan_id, Meal meal) {

    }


}

class mealPlanRowMapper implements RowMapper {
    @Override
    public MealPlan mapRow(ResultSet results, int i) throws SQLException {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setPlanId(results.getLong("plan_id"));
        mealPlan.setUserId(results.getLong("user_id"));
        mealPlan.setTitle(results.getString("title"));
        mealPlan.setDescription((results.getString("description")));
        mealPlan.setDateCreated((DateTimeFormat) results.getDate("date_created"));
        return mealPlan;
    }
}