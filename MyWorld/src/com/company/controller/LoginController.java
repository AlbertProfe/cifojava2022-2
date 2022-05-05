package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;

import java.util.HashMap;

public class LoginController {

    public static HashMap<String, String> validateUser(HashMap<String, String> dataToValidateUser) {
        //let s unpack dataToValidateUser to extract data
        String userEmail = dataToValidateUser.get("userEmail");
        String userPassword = dataToValidateUser.get("userPassword");
        //let s fetch user form users by email account
        User userFound = UserService.getUserByEmail(userEmail);
        boolean isUser = userFound != null;
        boolean isPassword = false;
        if (isUser) {
            isPassword = userFound.getPassword().equals(userPassword);
        }

        HashMap<String, String> validationResponse = new HashMap<>();
        validationResponse.put("response", "validationResponse");

        if (!isUser) {
            validationResponse.put("status", "not validated");
            validationResponse.put("message", "email not valid: user not found");
        } else if (!isPassword) {
            validationResponse.put("status", "not validated");
            validationResponse.put("message", "email valid: wrong password");
        } else {
            validationResponse.put("status", "validated");
            validationResponse.put("message", "credentials right");
        }

        return validationResponse;
    }
}
