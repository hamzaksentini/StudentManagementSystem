package edu.sesame.bank.controller.model;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
    private Boolean rememberMe;

}