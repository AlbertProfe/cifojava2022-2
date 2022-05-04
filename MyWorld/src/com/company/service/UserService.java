package com.company.service;

import com.company.controller.UserController;
import com.company.model.User;

import java.util.ArrayList;

public class UserService {


    public static User getUserByEmail(String userEmail) {

        User userFound = null;

        ArrayList<User> users = UserController.getUsers();
        for (User userByEmail : users) {
            if (userByEmail.getEmail().equals(userEmail)) {
                userFound = userByEmail;
            }
        }

        return userFound;
    }

    public static User getUserByCard(long cardNumber) {

        User userFound = null;

        ArrayList<User> users = UserController.getUsers();
        for (User userByCardNumber : users) {
            if (userByCardNumber.getCards().containsKey(cardNumber)) {
                userFound = userByCardNumber;
            }
        }

        return userFound;

    }

}
