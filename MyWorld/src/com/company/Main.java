package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //jsut an arraylist to store users
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

    public static void createUser(Scanner reader, ArrayList users) {

        //Let s introduce data to create User
        String name = ask(reader, "Name?");
        String surname = ask(reader, "Surname?");
        Integer age = Integer.valueOf(ask(reader, "Age?"));
        //Let s introduce data to create User's card
        Long number = Long.valueOf(ask(reader, "Number Card?"));
        Double aomunt = Double.valueOf(ask(reader, "Amount?"));
        String type = ask(reader, "Type?");
        //Integer pin = Integer.valueOf(ask(reader, "Pin Card?"));

        //Let s create User object with previous data
        User createdUser = new User(name, surname, age, new Card(number, aomunt, type));
        System.out.println("User created: " + createdUser);
        //Let s add this new User object to the main (and just one) array
        users.add(createdUser);
        System.out.println("User added to users: " + users);

    }

    public static void changePin(Scanner reader, ArrayList<User> users) {
        //ask for card number and check if this card number exists within users
        //and get the index from the array, if it does not exists, get -1
        Integer number = Integer.valueOf(ask(reader, "Number Card?"));
        int position = isCardNumber(number, users);

        //if card number exists make the change Pin operation
        if (position > -1) {
            Integer newPin = Integer.valueOf(ask(reader, "New Pin?"));
            int oldPin = users.get(position).getCard().getPin();
            users.get(position).getCard().setPin(newPin);
            System.out.println("Pin cahnged success. From old Pin number ( #: " + oldPin + " ) to new Pin number ( # " + newPin + " )");
            //if card number does not exist monitor this to user
        } else {
            System.out.println("This credit card number ( #: " + number + " ) does not exist");
        }
    }

    public static void transfer(Scanner reader, ArrayList users) {

    }

    public static void deposit(Scanner reader, ArrayList users) {

    }

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
        int positon = -1;
        for (User user : users) {
            if (user.getCard().getNumber() == cardNumber) positon = users.indexOf(user);
        }
        return positon;
    }

}