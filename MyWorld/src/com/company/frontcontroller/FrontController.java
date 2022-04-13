package com.company.frontcontroller;

import com.company.controller.UserController;
import com.company.model.User;
import com.company.utils.Utilities;
import com.company.view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontController {

    public static void mainLoop(ArrayList<User> users) {
        //just scanner object to manage io
        Scanner reader = new Scanner(System.in);

        while (true) {
            //print main menu
            Menu.mainMenu();
            String command = Utilities.ask(reader, "Option?");

            //to quit the loop write Quit
            if (command.equals("Quit")) {
                break;
            } else if (command.equals("createUser")) {
                //call-operation to create new user
                UserController.createUser(reader, users);
            } else if (command.equals("changePin")) {
                //call-operation to change pin
                UserController.changePin(reader, users);
            } else if (command.equals("transfer")) {
                //call-operation to make transfer
                UserController.transfer(reader, users);
            } else if (command.equals("deposit")) {
                //call-operation to deposit, to charge, to add some money to the card
                UserController.deposit(reader, users);
            } else {
                System.out.println("Unknown command!");
            }

        }
    }
}
