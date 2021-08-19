package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JDBCMealPlanDAO implements MealPlanDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMealPlanDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    MealDAO mealDAO;

    @Override
    public void addMealPlanToDB(long user_id, String title, String description,Map<MealEvent, Meal> meals) {
        //insert mealPlan into meal plan table
        String sqlNewMealPlan = "INSERT INTO meal_plan(user_id,title,description,date_created) " +
                "VALUES (?,?,?,?)";
        jdbcTemplate.update(sqlNewMealPlan, user_id, title, description, LocalDate.now());

        //insert meal events into the meal_event table
        for (Map.Entry<MealEvent, Meal> plannedMeal : meals.entrySet()) {
            String sqlNewMealEvent = "INSERT INTO meal_event(weekday,time_of_day,plan_id,meal_id) " +
                    "VALUES (?,?,?,?)";
            MealEvent event = plannedMeal.getKey();
            jdbcTemplate.update(sqlNewMealEvent, event.getWeekday(),
                    event.getTimeOfDay(), event.getPlanId(), event.getMealId());
            //insert mealPlan meals into their associative table
            String sqlNewPlannedMeal = "INSERT INTO meal_plan_meal(plan_id,meal_id) VAlUES " +
                    "((SELECT plan_id FROM meal_plan WHERE title LIKE ? AND user_id = ? AND description LIKE ?), ?) ";
            Meal meal = plannedMeal.getValue();
            jdbcTemplate.update(sqlNewPlannedMeal, title, user_id, description, meal.getMealId());

        }

    }

    @Override
    public void addMealPlanOnly(long user_id, String title, String description){
        String sqlNewMealPlan = "INSERT INTO meal_plan(user_id,title,description,date_created) " +
                "VALUES (?,?,?,?)";
        jdbcTemplate.update(sqlNewMealPlan, user_id, title, description, LocalDate.now());
    }

    @Override
    public void deleteMealPlanFromDB(long plan_id) {
        String sqlDeleteFromMealEventTable = "DELETE FROM meal_event WHERE plan_id = ?";
        jdbcTemplate.update(sqlDeleteFromMealEventTable, plan_id);

        String sqlDeleteFromMealPlanTable = "DELETE FROM meal_plan WHERE plan_id = ?";
        jdbcTemplate.update(sqlDeleteFromMealPlanTable, plan_id);

        String sqlDeleteFromMealPlanAssocTable = "DELETE FROM meal_plan_meal WHERE plan_id = ?";
        jdbcTemplate.update(sqlDeleteFromMealPlanAssocTable, plan_id);

    }

    @Override
    public MealPlan getMealPlanByID(long plan_id) {
        String sql = "SELECT * FROM meal_plan WHERE plan_id = ? ";
        MealPlan mealPlan = (MealPlan) jdbcTemplate.queryForObject(sql, new mealPlanRowMapper(), plan_id);
        return mealPlan;
    }

    @Override
    public List<MealPlan> getAllMealPlansByUser(long user_id) {
        String sql = "SELECT * FROM meal_plan WHERE user_id = ?";
        List<MealPlan> mealPlans = jdbcTemplate.query(sql, new mealPlanRowMapper(), user_id);
        return mealPlans;
    }

    @Override
    public Map<MealEvent, Meal> getPlannedMeals(long plan_id) {
        String sqlMealEvent = "SELECT * FROM meal_event WHERE plan_id = ? " +
                "ORDER BY weekday ASC, time_of_day ASC ";
        List<MealEvent> mealKeys = jdbcTemplate.query(sqlMealEvent, new mealEventRowMapper(), plan_id);

        Map<MealEvent,Meal> plannedMeals = new HashMap<>();
        for(MealEvent event : mealKeys){
            long meal_id = event.getMealId();
            Meal mealValue = mealDAO.getMealByID(meal_id);
            plannedMeals.put(event, mealValue);
        }
        return plannedMeals;
    }

    @Override
    public long getMealPlanID(long user_id, String title, String description){
        String sql = "SELECT plan_id FROM meal_plan WHERE user_id = ? AND title = ? AND description = ?";
        long plan_id = jdbcTemplate.queryForObject(sql, Long.class, user_id, title, description);
        return plan_id;
    }

    public List <Meal> getMealsInAPlan(long plan_id) {
        String sqlMeal = "select *\n" +
                "from meal\n" +
                "join meal_plan_meal mpm on meal.meal_id = mpm.meal_id\n" +
                "where plan_id = ?;";
        List <Meal> mealsInAPlan = jdbcTemplate.query(sqlMeal, new mealRowMapper(), plan_id);
        return mealsInAPlan;
    }

    @Override
    public List <Meal> getMealsNotAlreadyInAPlan(long planId, long userId){
//        String sqlMeal = "select * from meal\n" +
//                "where meal_id NOT IN (select meal.meal_id\n" +
//                "    from meal\n" +
//                "    join meal_plan_meal mpm on meal.meal_id = mpm.meal_id\n" +
//                "    where plan_id = ?);";
        String sqlMeal = "select *\n" +
                "from meal\n" +
                "join meal_plan m on meal.user_id = m.user_id\n" +
                "where meal_id NOT IN (select meal.meal_id\n" +
                "    from meal\n" +
                "    join meal_plan_meal mpm on meal.meal_id = mpm.meal_id\n" +
                "    join meal_plan mp on mpm.plan_id = mp.plan_id\n" +
                "    where mp.plan_id = ?)\n" +
                "and m.user_id = ?;";

        List <Meal> mealsInAPlan = jdbcTemplate.query(sqlMeal, new mealRowMapper(), planId, userId);
        return mealsInAPlan;
    }

    @Override
    public void addMealToPlan(long user_id,String title, long meal_id) {
        String sqlMealAssocPlan = "INSERT INTO meal_plan_meal(plan_id,meal_id) " +
                "VALUES (" +
                "(SELECT plan_id FROM meal_plan WHERE user_id = ? AND title = ?)," +
                "?) ";
        jdbcTemplate.update(sqlMealAssocPlan, user_id, title, meal_id);
    }

    @Override
    public void createMealEvent(int weekday, int time_of_day, long user_id, String title, long meal_id){
        String sql = "INSERT INTO meal_event(weekday,time_of_day,plan_id,meal_id) " +
                "VALUES (?,?," +
                "(SELECT plan_id FROM meal_plan WHERE user_id = ? AND title = ?)," +
                "?) ";
        jdbcTemplate.update(sql,weekday,time_of_day,user_id,title,meal_id);
    }

    @Override
    public void removeMealFromPlan(long plan_id, long meal_id) {
        String sqlRemovePlannedMeal = "DELETE FROM meal_plan_meal WHERE plan_id = ? AND meal_id = ? ";
        jdbcTemplate.update(sqlRemovePlannedMeal, plan_id, meal_id);
    }

    @Override
    public void deleteMealEvent(long plan_id, long meal_id){
        String sql = "DELETE FROM meal_event WHERE plan_id = ? and meal_id = ? ";
        jdbcTemplate.update(sql, plan_id, meal_id);
    }

    @Override
    public void deleteMealEventByID(long event_id){
        String sql = "DELETE FROM meal_event WHERE event_id = ?";
        jdbcTemplate.update(sql, event_id);
    }

    @Override
    public void updateTitle(long plan_id, String title) {
        String sql = "UPDATE meal_plan SET title = ? WHERE plan_id = ? ";
        jdbcTemplate.update(sql,title,plan_id);
    }

    @Override
    public void updateDescription(long plan_id, String description) {
        String sql = "UPDATE meal_plan SET description = ? WHERE plan_id = ? ";
        jdbcTemplate.update(sql,description,plan_id);
    }

    @Override
    public List<String> generateGroceryList(long plan_id) {
        String groceryListSql = "SELECT DISTINCT ingredient_name FROM ingredient i " +
                "JOIN recipe_ingredient ri ON ri.ingredient_id = i.ingredient_id " +
                "JOIN recipe r ON r.recipe_id = ri.recipe_id " +
                "JOIN meal_recipe mr ON mr.recipe_id = r.recipe_id " +
                "JOIN meal m ON m.meal_id = mr.meal_id " +
                "JOIN meal_plan_meal mpm ON mpm.meal_id = m.meal_id " +
                "JOIN meal_plan mp ON mp.plan_id = mpm.plan_id " +
                "WHERE mp.plan_id = ?" +
                " ORDER BY ingredient_name";
        List<String> groceryList = jdbcTemplate.query(groceryListSql, new ingredientRowMapper(), plan_id);
        return groceryList;

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
        mealPlan.setDateCreated((results.getDate("date_created").toLocalDate()));
        return mealPlan;
    }
}

class  mealEventRowMapper implements RowMapper {
    @Override
    public MealEvent mapRow(ResultSet results, int i) throws SQLException {
        MealEvent mealEvent = new MealEvent();
        mealEvent.setEventId(results.getLong("event_id"));
        mealEvent.setPlanId(results.getLong("plan_id"));
        mealEvent.setMealId(results.getLong("meal_id"));
        mealEvent.setWeekday(results.getInt("weekday"));
        mealEvent.setTimeOfDay(results.getInt("time_of_day"));
        return mealEvent;
    }
}