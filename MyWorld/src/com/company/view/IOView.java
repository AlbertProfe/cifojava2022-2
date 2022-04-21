package com.company.view;

import com.company.frontcontroller.FrontController;
import com.company.test.UserTest;
import com.company.utils.Utilities;

import java.util.HashMap;
import java.util.Scanner;

public class IOView {

    public static void mainLoopView() {
        //just scanner object to manage io
        Scanner reader = new Scanner(System.in);
        while (true) {
            //print mode menu
            Menu.modeMenu();
            String command = Utilities.ask(reader, "Mode?");

            if (command.equals("Quit")) {
                break;
            } else if (command.equals("test")) {
                //We create this feature to test our soft
                UserTest.test();
            } else if (command.equals("release")) {
                //We call the release loop
                releaseLoopView(reader);
            } else System.out.println("Unknown command");
        }
    }

    public static void releaseLoopView(Scanner reader) {
        //main loop starting
        while (true) {
            //print main menu
            Menu.mainMenu();
            String command = Utilities.ask(reader, "Option?");

            if (command.equals("Quit")) {
                break;
            } else if (command.equals("createUser")) {
                //call-operation to create new user
                createUser(reader);
            } else if (command.equals("changePin")) {
                //call-operation to change pin
                changePin(reader);
            } else if (command.equals("transfer")) {
                //call-operation to make a transfer
                transfer(reader);
            } else if (command.equals("deposit")) {
                //call-operation to deposit some amount
                deposit(reader);
            } else System.out.println("Unknown command");
        }
    }

    public static String createUser(Scanner reader) {
        //Let s introduce data to create User's card
        String name = Utilities.ask(reader, "Name?");
        String surname = Utilities.ask(reader, "Surname?");
        String age = Utilities.ask(reader, "Age?");
        String number = Utilities.ask(reader, "Card Number?");
        String amount = Utilities.ask(reader, "Amount?");
        String type = Utilities.ask(reader, "Type?");
        //create hashmap to send data to controller
        HashMap<String, String> createUserRequest = new HashMap<>();
        //fill data hashmap object
        createUserRequest.put("operation", "createUser");
        createUserRequest.put("name", name);
        createUserRequest.put("surname", surname);
        createUserRequest.put("age", age);
        createUserRequest.put("cardNumber", number);
        createUserRequest.put("amount", amount);
        createUserRequest.put("cardType", type);

        //send data to controller and get the response
        HashMap<String, String> createUserResponse = FrontController.mainLoopController(createUserRequest);
        String createUserStatus = createUserResponse.get("status");
        System.out.println("status user: " + createUserStatus + "\n");

        return createUserStatus;
    }

    public static void changePin(Scanner reader) {

    }

    public static void transfer(Scanner reader) {

    }

    public static void deposit(Scanner reader) {

    }

}
