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
public class JDBCCategoryDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCategoryDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getAllCategories(){
        String sql = "SELECT category_name from category ORDER BY category_name";

        List <String> categories = jdbcTemplate.query(sql, new categoryRowMapper());
        return categories;
    }

}

class categoryRowMapper implements RowMapper {
    @Override
    public String mapRow(ResultSet results, int i) throws SQLException {
//        Category category = new Category();
//        category.setCategoryId(results.getLong("category_id"));
//        category.setName(results.getString("category_name"));
//        return category;
        return results.getString("category_name");
    }
}
