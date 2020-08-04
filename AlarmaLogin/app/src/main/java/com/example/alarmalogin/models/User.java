package com.example.alarmalogin.models;

import java.util.Arrays;

public class User {

    /*ESTA CLASE ES PARA EL REGISTRO*/

    private int id;
    private String email, user,token;
    private String []roll;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String[] getRoll() {
        return roll;
    }

    public void setRoll(String[] roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                ", token='" + token + '\'' +
                ", roll=" + Arrays.toString(roll) +
                '}';
    }
}
