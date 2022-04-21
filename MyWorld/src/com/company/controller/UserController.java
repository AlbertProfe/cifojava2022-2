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

    public static void transfer(Scanner reader, ArrayList<User> users) {
        //ask for both credit card numbers and make a transfer
        long originCardNumber = Long.parseLong(Utilities.ask(reader, "Number Card from?"));
        int originPosition = UserService.isCardNumber(originCardNumber, users);
        long destinationCardNumber = Long.parseLong(Utilities.ask(reader, "Number Card to?"));
        int destinationPosition = UserService.isCardNumber(destinationCardNumber, users);

        if (originPosition > -1 && destinationPosition > -1) {
            Double amount = Double.valueOf(Utilities.ask(reader, "Amount?"));
            //validate transfer depends on amount
            boolean isMoney = UserService.isEnoughAmount(reader, users, originPosition, amount);
            if (isMoney) {
                //now it is possible to make a transfer, call makeTransfer
                UserService.makeTransfer(originPosition, destinationPosition, amount, users);
            } else {
                System.out.println("Check if credit card has not got enough money to make a transfer ...");
            }
        } else {
            System.out.println("Check if credit card numbers are right ...");
        }
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
        User newUser1 = new User("Alex", "Pixel", 25, new Card(1234123412341234L, 500.00, "Visa"));
        User newUser2 = new User("Thomas", "Edison", 35, new Card(4321432143214321L, 1500.00, "Master Card"));
        User newUser3 = new User("Susan", "Lane", 46, new Card(1111222233334444L, 2500.00, "American Express"));
        User newUser4 = new User("Marta", "Gross", 86, new Card(4444333322221111L, 1900.00, "American Express"));
        users.add(newUser1);
        users.add(newUser2);
        users.add(newUser3);
        users.add(newUser4);
    }
}
