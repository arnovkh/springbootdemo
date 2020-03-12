package com.example.demo.security.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;

public class UserRepository {


    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.dataSource);


    public Boolean createUser(User user) {
       jdbcInsert.withTableName("USERS");
       jdbcInsert.usingColumns("USERNAME", "PASSWORD");
        HashMap parameters = new HashMap<String, String>(2);
        parameters.put("USERNAME", user.getUsername());
        parameters.put("PASSWORD", user.getPassword());
        return jdbcInsert.execute(parameters) > 0;
    }
}
