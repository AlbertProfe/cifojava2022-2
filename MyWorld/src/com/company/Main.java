package com.company;

import com.company.frontcontroller.FrontController;
import com.company.model.User;
import com.company.utils.Utilities;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //just an arraylist to store users
        ArrayList<User> users = new ArrayList<User>();
        Scanner reader = new Scanner(System.in);
        //We create this feature to test our soft
        Utilities.createFakeUsers(users);
        Utilities.printUsers(users);

        //we are starting our software, we are booting it
        FrontController.mainLoop(reader, users);

        //Exit program
        System.out.println("Bye, bye, you have created " + users.size() + " users: " + users);
    }

}