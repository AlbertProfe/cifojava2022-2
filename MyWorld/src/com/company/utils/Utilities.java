package com.company.utils;

import com.company.model.Card;
import com.company.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {

    public static String ask(Scanner reader, String string) {
        System.out.println(string);
        return reader.nextLine();
    }

    public static void createFakeUsers(ArrayList<User> users) {

        User newUser1 = new User("Alex", "Pixel", 25, new Card(1234123412341234L, 500.00, "Visa"));
        User newUser2 = new User("Thomas", "Edison", 35, new Card(4321432143214321L, 500.00, "Visa"));
        User newUser3 = new User("Susan", "Loiss", 46, new Card(1111222233334444L, 500.00, "Visa"));
        User newUser4 = new User("Marta", "Gross", 86, new Card(4444333322221111L, 500.00, "Visa"));

        users.add(newUser1);
        users.add(newUser2);
        users.add(newUser3);
        users.add(newUser4);

    }

    public static void printUsers(ArrayList<User> users) {
        System.out.println(users);
    }
}
