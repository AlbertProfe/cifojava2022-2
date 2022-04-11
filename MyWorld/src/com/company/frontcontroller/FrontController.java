package com.company.frontcontroller;

import com.company.controller.Controller;
import com.company.utils.Utilities;

import java.util.Scanner;

public class FrontController {


    public static void mainLoop(Scanner reader) {

        while (true) {

            String command = Utilities.ask(reader, "Option?");

            //to quit the loop write Quit
            if (command.equals("Quit")) {
                break;
            } else if (command.equals("createUser")) {
                //call-operation to create new user
                Controller.createUser(reader, users);
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
    }
}
