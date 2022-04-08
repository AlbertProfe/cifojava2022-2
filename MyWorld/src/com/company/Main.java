package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //jsut an arraylist to store users
        ArrayList<User> users = new ArrayList();
        Scanner reader = new Scanner(System.in);

        while (true){
            //let s explore this solution
            //print mini-menu with 4 options + quit

            //call-operation to createUserInputOutput
            //call-operation to create new user

            //call-operation to changePinInputOutput
            //call-operation to change pin

            //call-operation to transferInputOutput
            //call-operation to make transfer

            // call-operation to depositInputOutput
            //call-operation to deposit, to charge, to add some money to the card

            System.out.println("Option");

            String command = reader.nextLine();

            //now i am at new branch lop-main-improved-1
            if (command.equals("Quit")) {
                break;
            } else if (command.equals("createUser")) {
                createUser(reader, users);
            } else if (command.equals("changePin")) {
                changePin(reader, users);
            } else if (command.equals("transfer")) {
                transfer(reader, users);
            } else if (command.equals("deposit")) {
                deposit(reader, users);
            } else {
                System.out.println("Unknown command!");
            }
        }
    }

    public static void createUser(Scanner reader, ArrayList users) {
        System.out.println("Name");
        String name = reader.nextLine();

        //... rest of attributes and Card

        User userCreated = new User();
        users.add(userCreated);
    }

    public static void changePin(Scanner reader, ArrayList users) {

    }

    public static void transfer(Scanner reader, ArrayList users) {

    }

    public static void deposit(Scanner reader, ArrayList users) {

    }

    //public static String ask(Scanner reader, String string) {
    //   return null;
    //}


}