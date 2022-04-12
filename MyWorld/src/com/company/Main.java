package com.company;

import com.company.model.User;
import com.company.test.UserTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //we are starting our software, we are booting it
        System.out.println("\nStarting myWorld, hello!\n");
        //just an arraylist to store users
        // and scanner object to manage io
        ArrayList<User> users = new ArrayList<User>();
        Scanner reader = new Scanner(System.in);

        //We create this feature to test our soft
        UserTest.test(users);

        //we are starting the main loop
        //FrontController.mainLoop(reader, users);

        //Exit program
        System.out.println("\nFinishing myWorld, bye, bye!");
    }

}