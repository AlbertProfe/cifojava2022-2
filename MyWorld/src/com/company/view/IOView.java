package com.company.view;

import com.company.controller.UserController;
import com.company.frontcontroller.FrontController;
import com.company.utils.Utilities;

import java.util.HashMap;
import java.util.Scanner;

public class IOView {

    public static void devLoopView() {
        //just scanner object to manage io
        Scanner reader = new Scanner(System.in);
        //create fake users to work with them
        //this is a very BAD solution, so it is temporal
        //just for having some users to work with them
        //to-do: create a JSON to import when boot soft
        //or just a DB
        UserController.createFakeUsers();
        while (true) {
            //print mode menu
            Menu.devMenu();
            String command = Utilities.ask(reader, "Mode?");

            if (command.equals("quit")) {
                break;
            } else if (command.equals("test")) {
                //We create this feature to test our soft
                //UserTest.userTest();
                //CardTest.cardTest();
            } else if (command.equals("release")) {
                //Call the loop release
                mainLoopView(reader);
            } else System.out.println("Unknown command");
        }
    }

    public static void mainLoopView(Scanner reader) {
        //release loop starting
        while (true) {
            //print main menu
            Menu.mainMenu();
            String command = Utilities.ask(reader, "Option?");

            if (command.equals("quit")) {
                break;
            } else if (command.equals("user")) {
                //call the loop user
                loopUser(reader);
            } else if (command.equals("admin")) {
                //call the loop admin
                loopAdmin(reader);
            } else System.out.println("Unknown command");
        }
    }

    public static void loopAdmin(Scanner reader) {
        //release Admin loop starting
        while (true) {
            //print main menu
            Menu.adminMenu();
            String command = Utilities.ask(reader, "Option?");

            if (command.equals("quit")) {
                break;
            } else if (command.equals("createUser")) {
                //call-operation to create new user
                createUser(reader);
            } else if (command.equals("createAdmin")) {
                //call-operation to create new user
                //createAdmin(reader);
            } else if (command.equals("createCard")) {
                //call-operation to create new card
                //createCard(reader);
            } else if (command.equals("listMembers")) {
                //call-operation to list all members
                listMembers();
            } else System.out.println("Unknown command");
        }
    }

    public static void loopUser(Scanner reader) {
        //release User loop starting
        while (true) {
            //print user menu
            Menu.userMenu();
            String command = Utilities.ask(reader, "Option?");

            if (command.equals("quit")) {
                break;
            } else if (command.equals("changePin")) {
                //call-operation to change pin
                changePin(reader);
            } else if (command.equals("transfer")) {
                //call-operation to make a transfer
                transfer(reader);
            } else if (command.equals("deposit")) {
                //call-operation to deposit some amount
                deposit(reader);
            } else if (command.equals("buy")) {
                //call-operation to create new user
                buy(reader);
            } else if (command.equals("changePassword")) {
                //call-operation to create new user
                //changePassword(reader);
            } else System.out.println("Unknown command");
        }
    }

    public static String createUser(Scanner reader) {
        //Let s introduce data to create User's card
        String name = Utilities.ask(reader, "Name?");
        String surname = Utilities.ask(reader, "Surname?");
        String age = Utilities.ask(reader, "Age?");
        //String number = Utilities.ask(reader, "Card Number?");
        //String amount = Utilities.ask(reader, "Amount?");
        //String type = Utilities.ask(reader, "Type?");
        //create hashmap to send data to controller
        HashMap<String, String> createUserRequest = new HashMap<>();
        //fill data hashmap object
        createUserRequest.put("operation", "createUser");
        createUserRequest.put("name", name);
        createUserRequest.put("surname", surname);
        createUserRequest.put("age", age);
        //createUserRequest.put("cardNumber", number);
        //createUserRequest.put("amount", amount);
        //createUserRequest.put("cardType", type);

        //send data to controller and get the response
        HashMap<String, String> createUserResponse = FrontController.mainLoopController(createUserRequest);
        String createUserStatus = createUserResponse.get("status");
        System.out.println("status user: " + createUserStatus + "\n");

        return createUserStatus;
    }

    public static int listMembers() {
        //
        HashMap<String, String> printMembersRequest = new HashMap<>();
        //fill data hashmap object
        printMembersRequest.put("operation", "printMembers");
        //send data to controller and get the response
        HashMap<String, String> printMembersResponse = FrontController.mainLoopController(printMembersRequest);
        System.out.println("List members : ");
        System.out.println("There is " + printMembersResponse.get("listMembersSize") + " members right now");
        System.out.println(printMembersResponse.get("listMembers"));

        return  Integer.parseInt(printMembersResponse.get("listMembersSize"));

    }

    public static String changePin(Scanner reader) {
        //ask for card number and check if this card number exists within users
        String cardNumber = Utilities.ask(reader, "Number Card?");
        //just ask for new pin and set new pin to users-user-card-pin
        String newPin = Utilities.ask(reader, "New Pin?");
        HashMap<String, String> changePinRequest = new HashMap<>();
        //fill data hashmap object
        changePinRequest.put("operation", "changePin");
        changePinRequest.put("cardNumber", cardNumber);
        changePinRequest.put("newPin", newPin);

        HashMap<String, String> changePinResponse = FrontController.mainLoopController(changePinRequest);
        String changePinStatus = changePinResponse.get("status");
        System.out.println("status user: " + changePinStatus + "\n" + changePinResponse.get("message"));

        return changePinStatus;

    }

    public static String transfer(Scanner reader) {
        //ask for card number and check if this card number exists within users
        String originCardNumber = Utilities.ask(reader, "Origin Number Card?");
        String destinationCardNumber = Utilities.ask(reader, "Destination Number Card?");
        String amount = Utilities.ask(reader, "Amount?");

        HashMap<String, String> transferRequest = new HashMap<>();
        //fill data hashmap object
        transferRequest.put("operation", "transfer");
        transferRequest.put("originCardNumber", originCardNumber);
        transferRequest.put("destinationCardNumber", destinationCardNumber);
        transferRequest.put("amount", amount);

        HashMap<String, String> transferResponse = FrontController.mainLoopController(transferRequest);
        String transferStatus = transferResponse.get("status");
        System.out.println("status transfer: " + transferStatus + "\n" + transferResponse.get("message"));

        return transferStatus;

    }

    public static String deposit(Scanner reader) {
        //ask for card number and check if this card number exists within users
        String originCardNumber = Utilities.ask(reader, "Origin Number Card?");
        String amount = Utilities.ask(reader, "Amount?");

        HashMap<String, String> depositRequest = new HashMap<>();
        //fill data hashmap object
        depositRequest.put("operation", "deposit");
        depositRequest.put("originCardNumber", originCardNumber);
        depositRequest.put("amount", amount);

        HashMap<String, String> depositResponse = FrontController.mainLoopController(depositRequest);
        String depositStatus = depositResponse.get("status");
        System.out.println("status deposit: " + depositStatus + "\n" + depositResponse.get("message"));

        return depositStatus;

    }

    public static String buy(Scanner reader) {
        //cards
        //call to loop ShowAndPickCard
        String cardToBuy = loopShowAndPickCard(reader);
        String buyResult = "error buy";
        if (!cardToBuy.equals("quit")) {
            //with a particular card this user will buy something
            String productDescription = Utilities.ask(reader, "Product description");
            String amountProduct = Utilities.ask(reader, "Amount Product");

            HashMap<String, String> buyRequest = new HashMap<>();
            //fill data hashmap object
            buyRequest.put("operation", "buy");

            buyRequest.put("userEmail", "APixel@helsinki.uni");
            buyRequest.put("cardNumber", cardToBuy);

            buyRequest.put("productDescription", productDescription);
            buyRequest.put("amountProduct", amountProduct);
            //
            HashMap<String, String> buyResponse = FrontController.mainLoopController(buyRequest);
            String buyStatus = buyResponse.get("status");
            System.out.println("status buyResponse: " + buyStatus + "\n" + buyResponse.get("message"));
        }

        return buyResult;
    }

    public static String loopShowAndPickCard(Scanner reader) {
        //user will select ONE card to buy or quit
        String cardSelected = "quit";
        while (true) {
            String cardsToShow = showCardsByUser(reader);
            System.out.println("cards : " + cardsToShow);
            String command = Utilities.ask(reader, "Card?");
            if (command.equals("quit")) {
                break;
            } else if (cardsToShow.contains(command)) {
                cardSelected = command;
                break;
            }
        }
        return cardSelected;
    }

    public static String showCardsByUser(Scanner reader) {
        //get all cards from this user
        HashMap<String, String> getCardsByUserRequest = new HashMap<>();
        getCardsByUserRequest.put("operation", "getCardsByUser");
        //to-do console loop to ask for user
        String userEmail = Utilities.ask(reader, "User email?");
        getCardsByUserRequest.put("userEmail", userEmail);
        //getCardsByUserRequest.put("userEmail", "APixel@helsinki.uni");

        //send request hashMap
        HashMap<String, String> getCardsByUserResponse = FrontController.mainLoopController(getCardsByUserRequest);
        String showCardsByUserResponse = "";
        if (getCardsByUserResponse.get("status").equals("cards found")) {
            showCardsByUserResponse = getCardsByUserResponse.get("cardsByUser");
        }

        return showCardsByUserResponse;
    }

}


