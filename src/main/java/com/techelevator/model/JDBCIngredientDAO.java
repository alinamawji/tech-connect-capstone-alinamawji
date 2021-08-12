package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JDBCIngredientDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCIngredientDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addIngredientToDB(Ingredient ingredient) {
        String sqlAddIngredientToDB = "INSERT INTO ingredient(ingredient_id, ingredient_name) values(?, ?)";
        jdbcTemplate.update(sqlAddIngredientToDB, ingredient.getIngredientId(), ingredient.getName());
    }

}

class ingredientRowMapper implements RowMapper {
    @Override
    public Ingredient mapRow(ResultSet results, int i) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(results.getLong("ingredient_id"));
        ingredient.setName(results.getString("ingredient_name"));
        return ingredient;
    }
}


