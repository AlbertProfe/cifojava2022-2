package com.company.controller;

import com.company.model.Card;
import com.company.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public static void createUser(Scanner reader, ArrayList users) {
        //Let s introduce data to create User
        String name = ask(reader, "Name?");
        String surname = ask(reader, "Surname?");
        Integer age = Integer.valueOf(ask(reader, "Age?"));
        //Let s introduce data to create User's card
        Long number = Long.valueOf(ask(reader, "Number Card?"));
        Double amount = Double.valueOf(ask(reader, "Amount?"));
        String type = ask(reader, "Type?");
        //Integer pin = Integer.valueOf(ask(reader, "Pin Card?"));

        //Let s create User object with previous data
        User createdUser = new User(name, surname, age, new Card(number, amount, type));
        System.out.println("User created: " + createdUser);
        //Let s add this new User object to the main (and just one) array
        users.add(createdUser);
        System.out.println("User added to users: " + users);

    }

    public static void changePin(Scanner reader, ArrayList<User> users) {
        //ask for card number and check if this card number exists within users
        //and get the index from the array, if it does not exist, get -1
        Integer number = Integer.valueOf(ask(reader, "Number Card?"));
        int position = isCardNumber(number, users);

        //if card number exists make the change Pin operation
        if (position > -1) {
            updatePin(reader, users, position);
            //if card number does not exist monitor this to user
        } else {
            System.out.println("This credit card number ( #: " + number + " ) does not exist");
        }
    }

    public static void transfer(Scanner reader, ArrayList users) {
        //ask for both credit card numbers and make a transfer
        Integer originCardNumber = Integer.valueOf(ask(reader, "Number Card from?"));
        int originPosition = isCardNumber(originCardNumber, users);
        Integer destinationCardNumber = Integer.valueOf(ask(reader, "Number Card to?"));
        int destinationPosition = isCardNumber(destinationCardNumber, users);

        if (originPosition > -1 && destinationPosition > -1) {
            Double amount = Double.valueOf(ask(reader, "Amount?"));
            boolean isMoney = isEnoughAmount(reader, users, originPosition, amount);
            if (isMoney) {
                //now it is possible to make a transfer, call makeTransfer
                makeTransfer(originPosition, destinationPosition, amount, users);
            } else {
                System.out.println("Check if credit card has not got enough money to make a transfer ...");
            }
        } else {
            System.out.println("Check if credit card numbers are right ...");
        }
    }

    public static void deposit(Scanner reader, ArrayList users) {
        //just ask for amount and add this money to card
        Integer number = Integer.valueOf(ask(reader, "Number Card?"));
        int position = isCardNumber(number, users);

        if (position > -1) {
            //now it is possible to make a deposit, call makeDeposit
            Double amount = Double.valueOf(ask(reader, "Amount?"));
            makeDeposit(position, amount, users);
        } else {
            System.out.println("Check if credit card numbers are right ...");
        }
    }

}
