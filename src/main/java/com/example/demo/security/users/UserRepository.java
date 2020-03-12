package com.example.demo.security.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

@Component
public class UserRepository {

    private final DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;


    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(this.dataSource);

    }


    public Boolean createUser(AppUser appUser) {
       jdbcInsert.withTableName("APP_USERS");
       jdbcInsert.usingColumns("USERNAME", "PASSWORD");
        HashMap parameters = new HashMap<String, String>(2);
        parameters.put("USERNAME", appUser.getUsername());
        parameters.put("PASSWORD", appUser.getPassword());
        return jdbcInsert.execute(parameters) > 0;
    }

    public  List<AppUser> getUsers(AppUser appUser) {
        String query = "SELECT USERNAME , PASSWORD FROM APP_USERS WHERE USERNAME = ? ";
        List<AppUser> resultAppUsers = jdbcTemplate.query(query,
                new Object[] {appUser.getUsername()},
                new UserMapper());
        return resultAppUsers;
    }
}
