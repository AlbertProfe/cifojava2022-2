package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //just an arraylist to store users
        ArrayList<User> users = new ArrayList<User>();
        Scanner reader = new Scanner(System.in);

        while (true) {
            //print mini-menu with 4 options + quit
            System.out.println("1-createUser");
            System.out.println("2-changePin");
            System.out.println("3-transfer");
            System.out.println("4-deposit");

            String command = ask(reader, "Option?");

            //to quit the loop write Quit
            if (command.equals("Quit")) {
                break;
            } else if (command.equals("createUser")) {
                //call-operation to create new user
                createUser(reader, users);
            } else if (command.equals("changePin")) {
                //call-operation to change pin
                changePin(reader, users);
            } else if (command.equals("transfer")) {
                //call-operation to make transfer
                transfer(reader, users);
            } else if (command.equals("deposit")) {
                //call-operation to deposit, to charge, to add some money to the card
                deposit(reader, users);
            } else {
                System.out.println("Unknown command!");
            }
        }
        //Exit program
        System.out.println("Bye, bye, you have created " + users.size() + " users: " + users);
    }

    //************************************************************************************
    //************************************** features ************************************
    //************************************************************************************

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

    //************************************************************************************
    //************************************** utils ***************************************
    //************************************************************************************

    public static String ask(Scanner reader, String string) {
        System.out.println(string);
        return reader.nextLine();
    }

    /*public static boolean isCardNumber (int cardNumber, ArrayList<User> users){
        boolean isCard = false;
        for (User user : users){
            if (user.getCard().getNumber() == cardNumber)  isCard= true;
         }
        return isCard;
    }*/

    public static int isCardNumber(int cardNumber, ArrayList<User> users) {
        //find out if cardNumber exists in users
        int position = -1;
        for (User user : users) {
            if (user.getCard().getNumber() == cardNumber) position = users.indexOf(user);
        }
        return position;
    }

    public static int isCardNumberError(int cardNumber, ArrayList<User> users) {
        //find out if cardNumber exists in users
        //position is able to value : -3, -2, -1, 0..n
        // if cardNumber is right : 0 .. n (position within array users)
        // if card does not exist : -1
        // if card exists but card number is wrong : -2
        // if there are some error undefined : -3
        int position = -3;
        for (User user : users) {
            boolean isCard = user.getCard() != null;
            if (isCard) {
                if (user.getCard().getNumber() == cardNumber) {
                    position = users.indexOf(user);
                } else position = -2;
            } else position = -1;
        }
        return position;
    }

    public static void updatePin(Scanner reader, ArrayList<User> users, int position) {
        //just ask for new pin and set new pin to users-user-card-pin
        Integer newPin = Integer.valueOf(ask(reader, "New Pin?"));
        int oldPin = users.get(position).getCard().getPin();
        //set the new value of pin
        users.get(position).getCard().setPin(newPin);
        System.out.println("Pin changed success. From old Pin number ( #: " + oldPin + " ) to new Pin number ( # " + newPin + " )");
    }

    public static boolean isEnoughAmount(Scanner reader, ArrayList<User> users, int position, Double amount) {
        //check if is enough money in origin card
        boolean isMoney = users.get(position).getCard().getAmount() >= amount;
        return isMoney;
    }

    public static void makeTransfer(int originPosition, int destinationPosition, Double amount, ArrayList<User> users) {
        //rest this qty amount from origin
        users.get(originPosition).getCard().removeAmount(amount);
        //add this qty amount from destination
        users.get(destinationPosition).getCard().addAmount(amount);
    }

    private static void makeDeposit(int position, Double amount, ArrayList<User> users) {
        //add this qty amount from position
        users.get(position).getCard().addAmount(amount);
    }

}