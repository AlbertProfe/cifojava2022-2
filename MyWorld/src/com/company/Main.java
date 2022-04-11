package com.company;

import com.company.frontcontroller.FrontController;
import com.company.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //just an arraylist to store users
        ArrayList<User> users = new ArrayList<User>();
        Scanner reader = new Scanner(System.in);

        //we are starting our software, we are booting it
        FrontController.mainLoop(reader);

        //Exit program
        System.out.println("Bye, bye, you have created " + users.size() + " users: " + users);
    }

}