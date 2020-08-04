package com.example.alarmalogin.models;

public class LoginResponse {

    private String usuario;
    private String pasword;

    public LoginResponse() {

    }

    public String getUsuario() {
        return usuario;
    }

    public String getPasword() {
        return pasword;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
