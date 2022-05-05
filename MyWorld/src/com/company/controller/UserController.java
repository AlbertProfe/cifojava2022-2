package com.company.controller;

import com.company.model.Card;
import com.company.model.User;
import com.company.service.CardService;
import com.company.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;

public class UserController {
    //just an arraylist to store users
    //
    static ArrayList<User> users = new ArrayList<>();

    public static HashMap<String, String> createUser(HashMap<String, String> dataToCreateUser) {
        //unpack dataToCreateUser hashmap to get data
        String name = dataToCreateUser.get("name");
        String surname = dataToCreateUser.get("surname");
        int age = Integer.parseInt(dataToCreateUser.get("age"));

        //call to create a RANDOM card and return an object CARD
        Card cardCreated = CardService.createCard();
        //Let s introduce data to create User
        User createdUser = new User(name, surname, age);
        long cardNumber = cardCreated.getCardNumber();
        //we PUT a card object to cards
        createdUser.getCards().put(cardNumber, cardCreated);

        //Let s add this new User object to the main (and just one) array
        boolean statusOperation = users.add(createdUser);
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
        //
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
            cardsByUser = String.valueOf(userFound.getCards().keySet());
            cardsQty = userFound.getCards().size();
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

        String userEmails = "";
        for (User user : users) {
            userEmails = userEmails + user.getEmail() + ",\n";
        }
        userEmailsResponse.put("userEmails", userEmails);

        return userEmailsResponse;
    }

    public static void createFakeUsers() {
        //let's create some cards
        Card cardCreated1 = CardService.createCard();
        Card cardCreated2 = CardService.createCard();
        Card cardCreated3 = CardService.createCard();
        Card cardCreated4 = CardService.createCard();
        Card cardCreated5 = new Card(12341234123412354L, 10000.00, "PayPal", 1234);
        //let's extract the card number from card
        long cardNumber1 = cardCreated1.getCardNumber();
        long cardNumber2 = cardCreated2.getCardNumber();
        long cardNumber3 = cardCreated3.getCardNumber();
        long cardNumber4 = cardCreated4.getCardNumber();
        long cardNumber5 = cardCreated5.getCardNumber();
        //just to work with them, no having a void arraylist
        User newUser1 = new User("Alex", "Pixel", 25);
        User newUser2 = new User("Thomas", "Edison", 35);
        User newUser3 = new User("Susan", "Lane", 46);
        User newUser4 = new User("Marta", "Gross", 86);
        User newUser5 = new User("Elon", "Musk", 56, "elon@musk.mars", "1234");
        //let's fill the hashmap cards with the first card, key-value
        newUser1.getCards().put(cardNumber1, cardCreated1);
        newUser2.getCards().put(cardNumber2, cardCreated2);
        newUser3.getCards().put(cardNumber3, cardCreated3);
        newUser4.getCards().put(cardNumber4, cardCreated4);
        newUser5.getCards().put(cardNumber5, cardCreated5);
        //add users to list
        users.add(newUser1);
        users.add(newUser2);
        users.add(newUser3);
        users.add(newUser4);
        users.add(newUser5);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
