package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //jsut an arraylist to store users
        ArrayList<User> users = new ArrayList();
        Scanner reader = new Scanner(System.in);

        while (true){

            //print mini-menu with 4 options + quit

            //call-operation to createUserInputOutput
            //call-operation to create new user

            //call-operation to changePinInputOutput
            //call-operation to change pin

            //call-operation to transferInputOutput
            //call-operation to make transfer

            // call-operation to depositInputOutput
            //call-operation to deposit, to charge, to add some money to the card

            //String command = ask(scanner, "Option?");
            String command = reader.nextLine();

            if (command.equals("Quit")) {
                break;
            } else if (command.equals("Add")) {
                createUser(reader, users);
            } else if (command.equals("Observation")) {
                changePin(reader, users);
            } else if (command.equals("Show")) {
                transfer(reader, users);
            } else if (command.equals("Statistics")) {
                deposit(reader, users);
            } else {
                System.out.println("Unknown command!");
            }
        }
    }

    public static void createUser(Scanner reader, ArrayList users) {

    }

    public static void changePin(Scanner reader, ArrayList users) {

    }

    public static void transfer(Scanner reader, ArrayList users) {

    }

    public static void deposit(Scanner reader, ArrayList users) {

    }

    public static  void createUserInputOutput(){

    }

    public static  void changePinInputOutput(){

    }

    public static  void transferInputOutput (){

    }

    public static void depositInputOutput() {

    }
}