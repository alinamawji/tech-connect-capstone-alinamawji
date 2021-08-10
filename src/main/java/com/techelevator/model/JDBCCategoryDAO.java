package com.techelevator.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCategoryDAO {

}

class categoryRowMapper implements RowMapper {
    @Override
    public Category mapRow(ResultSet results, int i) throws SQLException {
        Category category = new Category();
        category.setCategory_id(results.getLong("category_id"));
        category.setName(results.getString("name"));
        return category;
    }
}
