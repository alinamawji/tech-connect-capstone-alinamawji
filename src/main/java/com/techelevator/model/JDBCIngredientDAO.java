package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JDBCIngredientDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCIngredientDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addIngredientToDB(String ingredient) {
        String sqlAddIngredientToDB = "INSERT INTO ingredient (ingredient_name) values(?)";
        jdbcTemplate.update(sqlAddIngredientToDB, ingredient);
    }

    public List<String> getAllIngredients() {
        String sql = "SELECT ingredient_name from ingredient ORDER BY ingredient_name;";

                List <String> ingredients = jdbcTemplate.query(sql, new ingredientRowMapper());
                return ingredients;
    }

}

class ingredientRowMapper implements RowMapper {
    @Override
    public String mapRow(ResultSet results, int i) throws SQLException {
//        Ingredient ingredient = new Ingredient();
//        ingredient.setIngredientId(results.getLong("ingredient_id"));
//        ingredient.setName(results.getString("ingredient_name"));
//        return ingredient;
        return results.getString("ingredient_name");
    }
}


