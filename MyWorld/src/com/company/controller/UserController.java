package com.company.controller;

import com.company.model.Card;
import com.company.model.User;
import com.company.service.CardService;

import java.util.ArrayList;
import java.util.HashMap;

public class UserController {
    //just an arraylist to store users
    static ArrayList<User> users = new ArrayList<>();

    public static HashMap<String, String> createUser(HashMap<String, String> dataToCreateUser) {

        String name = dataToCreateUser.get("name");
        String surname = dataToCreateUser.get("surname");
        int age = Integer.parseInt(dataToCreateUser.get("age"));
        //long cardNumber = Long.parseLong((dataToCreateUser.get("cardNumber")));
        //double amount = Double.parseDouble(dataToCreateUser.get("amount"));
        //String cardType = dataToCreateUser.get("cardType");

        Card cardCreated = CardService.createCard();
        //Let s introduce data to create User
        User createdUser = new User(name, surname, age);
        long cardNumber = cardCreated.getNumber();
        createdUser.getCards().put(cardNumber, cardCreated);

        //Let s add this new User object to the main (and just one) array
        boolean statusOperation = users.add(createdUser);

        HashMap<String, String> createUserResponse = new HashMap<>();
        createUserResponse.put("response", "createUserResponse");

        if (statusOperation) createUserResponse.put("status", "created");
        else createUserResponse.put("status", "not created");

        return createUserResponse;
    }

    public static void printMembers() {
        System.out.println("List members : ");
        System.out.println("There is " + users.size() + " members right now");
        System.out.println(users);
    }


    public static void createFakeUsers() {
        //let's create some cards
        Card cardCreated1 = CardService.createCard();
        Card cardCreated2 = CardService.createCard();
        Card cardCreated3 = CardService.createCard();
        Card cardCreated4 = CardService.createCard();
        //let's extract the card number from card
        long cardNumber1 = cardCreated1.getNumber();
        long cardNumber2 = cardCreated1.getNumber();
        long cardNumber3 = cardCreated1.getNumber();
        long cardNumber4 = cardCreated1.getNumber();
        //just to work with them, no having a void arraylist
        User newUser1 = new User("Alex", "Pixel", 25);
        User newUser2 = new User("Thomas", "Edison", 35);
        User newUser3 = new User("Susan", "Lane", 46);
        User newUser4 = new User("Marta", "Gross", 86);
        //let's fill the hashmap cards with the first card, key-value
        newUser1.getCards().put(cardNumber1, cardCreated1);
        newUser2.getCards().put(cardNumber2, cardCreated2);
        newUser3.getCards().put(cardNumber3, cardCreated3);
        newUser4.getCards().put(cardNumber4, cardCreated4);
        //add users to list
        users.add(newUser1);
        users.add(newUser2);
        users.add(newUser3);
        users.add(newUser4);
    }

    public static ArrayList<User> getFakeUsers() {
        return users;
    }
}
