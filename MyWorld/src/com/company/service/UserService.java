package com.company.service;

import com.company.controller.UserController;
import com.company.model.User;
import com.company.repository.CardRepository;
import com.company.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static User getUserByEmail(String userEmail) {
        //call against DB h2
        User userFound = UserRepository.getUserByEmail(userEmail);
        return userFound;
    }


    public static boolean create (User userToCreate ){
        //call to repo DB to create user on DB
        boolean resultOperation = UserRepository.create(userToCreate);
        return resultOperation;
    }

    public static List<User> getAllUsers() {
        return UserRepository.getAllUsers();
    }

    public static User update(User userToUpdate) {
        //to repo-db
        User userUpdated = UserRepository.update(userToUpdate);
        return userUpdated;
    }
}
