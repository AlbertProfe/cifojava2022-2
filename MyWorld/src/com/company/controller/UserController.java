package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import com.company.utils.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserController {

    //just an arraylist to store users
    static ArrayList<User> users = new ArrayList<User>();

    public static void createUser(HashMap<String, String> dataToCreateUser) {

        String name = dataToCreateUser.get("name");
        String surname = dataToCreateUser.get("surname");
        int age = Integer.valueOf(dataToCreateUser.get("age"));

        //Let s introduce data to create User
        User createddUser = new User(name, surname, age);
        //User createddUser = new User(name, surname, age, new Card(number, amount, type));
        System.out.println("User created: " + createddUser);
        //Let s add this new User object to the main (and just one) array
        users.add(createddUser);


        System.out.println("User added to users: " + users);

    }

    public static void changePin(Scanner reader, ArrayList<User> users) {
        //ask for card number and check if this card number exists within users
        //and get the index from the array, if it does not exist, get -1
        Integer number = Integer.valueOf(Utilities.ask(reader, "Number Card?"));
        int position = UserService.isCardNumber(number, users);

        //if card number exists make the change Pin operation
        if (position > -1) {
            UserService.updatePin(reader, users, position);
            //if card number does not exist monitor this to user
        } else {
            System.out.println("This credit card number ( #: " + number + " ) does not exist");
        }
    }

    public static void transfer(Scanner reader, ArrayList<User> users) {
        //ask for both credit card numbers and make a transfer
        Long originCardNumber = Long.valueOf(Utilities.ask(reader, "Number Card from?"));
        int originPosition = UserService.isCardNumber(originCardNumber, users);
        Long destinationCardNumber = Long.valueOf(Utilities.ask(reader, "Number Card to?"));
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

    public static void deposit(Scanner reader, ArrayList users) {
        //just ask for amount and add this money to card
        Integer number = Integer.valueOf(Utilities.ask(reader, "Number Card?"));
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

}
