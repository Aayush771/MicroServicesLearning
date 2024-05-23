package com.todo.restfulwebservices.Models;

import java.time.LocalDate;

public class User {

    private Integer userId;
    private String userName;
    private LocalDate birthDate;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public User(Integer userId, String userName, LocalDate birthDate) {
        this.userId = userId;
        this.userName = userName;
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", birthDate=" + birthDate + "]";
    }

    
    
}
