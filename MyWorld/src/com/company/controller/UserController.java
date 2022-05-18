package com.company.controller;

import com.company.model.Card;
import com.company.model.User;
import com.company.repository.CardRepository;
import com.company.repository.UserRepository;
import com.company.service.CardService;
import com.company.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserController {
    //toi-delete
    static ArrayList<User> users = new ArrayList<>();

    public static HashMap<String, String> createUser(HashMap<String, String> dataToCreateUser) {
        //unpack dataToCreateUser hashmap to get data
        String name = dataToCreateUser.get("name");
        String surname = dataToCreateUser.get("surname");
        int age = Integer.parseInt(dataToCreateUser.get("age"));

        //call to create a RANDOM card and return an object CARD
        //and create User with a cardNumber long
        Card cardCreated = CardService.createCard();
        User createdUser = new User(name, surname, age);
        long cardNumber = cardCreated.getCardNumber();
        createdUser.addCardNumber(cardNumber);

        //Let s add this new User object to DB
        boolean statusOperation = UserService.create(createdUser);

        //let s create a response HashMap
        HashMap<String, String> createUserResponse = new HashMap<>();
        createUserResponse.put("response", "createUserResponse");
        //if user has been created or not
        if (statusOperation) createUserResponse.put("status", "created");
        else createUserResponse.put("status", "not created");

        return createUserResponse;
    }

    public static HashMap<String, String> printData(HashMap<String, String> dataToPrint) {
        //let s unpack dataToPrint to extract data
        String userEmail = dataToPrint.get("userEmail");
        //let s fetch user form users by email account
        User userFound = UserService.getUserByEmail(userEmail);
        boolean isUser = userFound != null;

        HashMap<String, String> printDataResponse = new HashMap<>();
        printDataResponse.put("response", "printDataResponse");

        if (isUser) {
            printDataResponse.put("status", "user exists");
            printDataResponse.put("message", userFound.toString());
        } else {
            printDataResponse.put("status", "user no found");
            printDataResponse.put("message", "no data user available: user not found");
        }

        return printDataResponse;
    }

    public static HashMap<String, String> printMembers() {
        //get all users from DB USER_TABLE
        List<User> users = UserService.getAllUsers();
        //hashmap response
        HashMap<String, String> printMembersResponse = new HashMap<>();
        printMembersResponse.put("response", "printMembersResponse");
        printMembersResponse.put("listMembersSize", String.valueOf(users.size()));
        printMembersResponse.put("listMembers", users.toString());

        return printMembersResponse;
    }

    public static HashMap<String, String> getCardsByUser(HashMap<String, String> dataToGetCardsByUser) {
        //let s unpack dataToGetCardsByUser to extract data
        String userEmail = dataToGetCardsByUser.get("userEmail");
        //let s fetch user form users by email account
        User userFound = UserService.getUserByEmail(userEmail);
        //hashMap response with cards
        HashMap<String, String> getCardsByUserResponse = new HashMap<>();
        getCardsByUserResponse.put("status", "cards not found");

        //if user exists let s get its cards from hashmap
        String cardsByUser = "";
        int cardsQty = 0;
        if (userFound != null) {
            cardsByUser = String.valueOf(userFound.getCardNumbersList());
            cardsQty = userFound.getCardNumbersList().size();
            getCardsByUserResponse.put("status", "cards found");
        } else {
            cardsByUser = "user not found";
        }
        getCardsByUserResponse.put("cardsByUser", cardsByUser);
        getCardsByUserResponse.put("cardsQty", String.valueOf(cardsQty));
        getCardsByUserResponse.put("response", "getCardsByUserResponse");

        return getCardsByUserResponse;
    }

    public static HashMap<String, String> getUserEmails() {
        //
        HashMap<String, String> userEmailsResponse = new HashMap<>();
        userEmailsResponse.put("response", "userEmailsResponse");

        List<User> users = UserService.getAllUsers();
        String userEmails = "";
        for (User user : users) {
            userEmails = userEmails + user.getEmail() + ",\n";
        }
        userEmailsResponse.put("userEmails", userEmails);

        return userEmailsResponse;
    }

    //to-delete
    public static ArrayList<User> getUsers() {
        return users;
    }
}
