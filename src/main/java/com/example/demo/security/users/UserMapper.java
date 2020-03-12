package com.example.demo.security.users;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<AppUser> {
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        AppUser appUser = new AppUser(
                rs.getString("USERNAME"),
                rs.getString("PASSWORD"));
        return appUser;
    }
}