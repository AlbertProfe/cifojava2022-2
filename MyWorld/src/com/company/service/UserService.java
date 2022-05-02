package com.company.service;

import com.company.controller.UserController;
import com.company.model.User;

import java.util.ArrayList;

public class UserService {


    public static User getUserByEmail(String userEmail) {

        User userFound = null;

        ArrayList<User> users = UserController.getFakeUsers();
        for (User userByEmail : users) {
            if (userByEmail.getEmail().equals(userEmail)) {
                userFound = userByEmail;
            }
        }

        return userFound;
    }
}
