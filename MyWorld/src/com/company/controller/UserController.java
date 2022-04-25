package com.company.controller;

import com.company.model.Card;
import com.company.model.User;
import com.company.service.UserService;
import com.company.utils.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserController {
    //just an arraylist to store users
    static ArrayList<User> users = new ArrayList<>();

    public static HashMap<String, String> createUser(HashMap<String, String> dataToCreateUser) {

        String name = dataToCreateUser.get("name");
        String surname = dataToCreateUser.get("surname");
        int age = Integer.parseInt(dataToCreateUser.get("age"));
        long cardNumber = Long.parseLong((dataToCreateUser.get("cardNumber")));
        double amount = Double.parseDouble(dataToCreateUser.get("amount"));
        String cardType = dataToCreateUser.get("cardType");

        //Let s introduce data to create User
        User createdUser = new User(name, surname, age, new Card(cardNumber, amount, cardType));

        //Let s add this new User object to the main (and just one) array
        boolean statusOperation = users.add(createdUser);

        HashMap<String, String> createUserResponse = new HashMap<>();
        createUserResponse.put("response", "createUserResponse");

        if (statusOperation) createUserResponse.put("status", "created");
        else createUserResponse.put("status", "not created");

        return createUserResponse;
    }

    public static HashMap<String, String> changePin(HashMap<String, String> dataToChangePin) {
        //get data from hashmap
        long cardNumber = Long.parseLong((dataToChangePin.get("cardNumber")));
        int newPin = Integer.parseInt(dataToChangePin.get("newPin"));

        //and get the index from the array, if it does not exist, get -1
        int position = UserService.isCardNumber(cardNumber, users);
        HashMap<String, String> changePinResponse = new HashMap<>();
        changePinResponse.put("response", "changePinResponse");
        int oldPin = users.get(position).getCard().getPin();

        //if card number exists make the change Pin operation
        if (position > -1) {
            UserService.updatePin(newPin, users, position);
            changePinResponse.put("status", "pinUpdated");
            changePinResponse.put("message", "Pin changed success. From old Pin number ( #: " + oldPin + " ) to new Pin number ( # " + newPin + " )");
            //if card number does not exist monitor this to user
        } else {
            changePinResponse.put("status", "pinNotUpdated");
            changePinResponse.put("message", "This credit card number ( #: " + cardNumber + " ) does not exist");
        }

        return changePinResponse;
    }

    public static HashMap<String, String> transfer(HashMap<String, String> dataToTransfer) {
        //
        long originCardNumber = Long.valueOf((dataToTransfer.get("originCardNumber")));
        long destinationCardNumber = Long.valueOf((dataToTransfer.get("destinationCardNumber")));
        double amount = Double.parseDouble(dataToTransfer.get("amount"));

        int originPosition = UserService.isCardNumber(originCardNumber, users);
        boolean isOriginCardNumber = originPosition > -1;

        int destinationPosition = UserService.isCardNumber(destinationCardNumber, users);
        boolean isDestinationCardNumber = destinationPosition > -1;

        boolean isMoney = false;
        if (isOriginCardNumber) {
            isMoney = UserService.isEnoughAmount(users, originPosition, amount);
        }

        HashMap<String, String> transferResponse = new HashMap<>();
        transferResponse.put("response", "transferResponse");
        transferResponse.put("status", "transfer NOT done");

        if (!isOriginCardNumber) {
            transferResponse.put("message", "This credit card number (origin) ( #: " + originCardNumber + " ) does not exist");
        } else if (!isDestinationCardNumber) {
            transferResponse.put("message", "This credit card number (destination) ( #: " + destinationCardNumber + " ) does not exist");
        } else if (!isMoney) {
            transferResponse.put("message", "Check if credit card has not got enough money to make a transfer ...");
        } else {
            //now it is possible to make a transfer, call makeTransfer
            UserService.makeTransfer(originPosition, destinationPosition, amount, users);
            transferResponse.put("status", "transfer done");
            transferResponse.put("message", "From " + originCardNumber + " to " + destinationCardNumber + " " + amount);
        }

        return transferResponse;
    }

    public static void deposit(Scanner reader, ArrayList<User> users) {
        //just ask for amount and add this money to card
        int number = Integer.parseInt(Utilities.ask(reader, "Number Card?"));
        int position = UserService.isCardNumber(number, users);

        if (position > -1) {
            //now it is possible to make a deposit, call makeDeposit
            Double amount = Double.valueOf(Utilities.ask(reader, "Amount?"));
            UserService.makeDeposit(position, amount, users);
        } else {
            System.out.println("Check if credit card numbers are right ...");
        }
    }

    public static void loan() {
    }

    public static void createFakeUsers() {
        //just to work with them, no having a void arraylist
        User newUser1 = new User("Alex", "Pixel", 25, new Card(1234123412341234L, 500.00, "Visa"));
        User newUser2 = new User("Thomas", "Edison", 35, new Card(4321432143214321L, 1500.00, "Master Card"));
        User newUser3 = new User("Susan", "Lane", 46, new Card(1111222233334444L, 2500.00, "American Express"));
        User newUser4 = new User("Marta", "Gross", 86, new Card(4444333322221111L, 1900.00, "American Express"));
        users.add(newUser1);
        users.add(newUser2);
        users.add(newUser3);
        users.add(newUser4);
    }

    public static ArrayList<User> getFakeUsers() {
        return users;
    }
}
