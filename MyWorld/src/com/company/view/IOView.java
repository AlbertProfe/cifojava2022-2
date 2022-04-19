package com.company.view;

import com.company.frontcontroller.FrontController;
import com.company.utils.Utilities;

import java.util.HashMap;
import java.util.Scanner;

public class IOView {

    public static void mainLoopView() {
        //just scanner object to manage io
        Scanner reader = new Scanner(System.in);

        while (true) {
            //print main menu
            Menu.mainMenu();
            String command = Utilities.ask(reader, "Option?");

            if (command.equals("Quit")) {
                break;
            } else if (command.equals("createUser")) {
                //call-operation to create new user
                createUser(reader);
            }
        }
    }

    public static void createUser(Scanner reader) {
        //Let s introduce data to create User's card
        String name = Utilities.ask(reader, "Name?");
        String surname = Utilities.ask(reader, "Surname?");
        String age = Utilities.ask(reader, "Age?");
        String number = Utilities.ask(reader, "Number Card?");
        String amount = Utilities.ask(reader, "Amount?");
        String type = Utilities.ask(reader, "Type?");
        //create hashmap to send data to controller
        HashMap<String, String> dataFromViewToController = new HashMap<>();
        //fill data hashmap object
        dataFromViewToController.put("operation", "createUser");
        dataFromViewToController.put("name", name);
        dataFromViewToController.put("surname", surname);
        dataFromViewToController.put("age", age);
        dataFromViewToController.put("number", number);
        dataFromViewToController.put("amount", amount);
        dataFromViewToController.put("type", type);
        //send data to controller
        FrontController.mainLoopController(dataFromViewToController);

    }

}
