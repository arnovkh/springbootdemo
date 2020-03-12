package com.example.demo.security.users;

public class AppUser {

    private String username;
    private String password;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
