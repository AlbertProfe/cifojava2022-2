package com.company.test;

import com.company.model.Card;
import com.company.model.User;
import com.company.service.UserService;

import java.util.ArrayList;

public class UserTest {

    public static void test(ArrayList<User> users) {
        createFakeUsers(users);
        //printUsers(users);
        testChangePinOK(users);
        testChangePinFAIL(users);
        testTransfer(users);
        testDeposit(users);
    }

    public static void createFakeUsers(ArrayList<User> users) {

        User newUser1 = new User("Alex", "Pixel", 25, new Card(1234123412341234L, 500.00, "Visa"));
        User newUser2 = new User("Thomas", "Edison", 35, new Card(4321432143214321L, 1500.00, "Master Card"));
        User newUser3 = new User("Susan", "Loiss", 46, new Card(1111222233334444L, 2500.00, "American Express"));
        User newUser4 = new User("Marta", "Gross", 86, new Card(4444333322221111L, 1900.00, "American Express"));

        users.add(newUser1);
        users.add(newUser2);
        users.add(newUser3);
        users.add(newUser4);

        if (users.size() == 4) System.out.println("Test #createFakeUsers OK");
        else System.out.println("Test #createFakeUsers FAIL");
    }

    public static void printUsers(ArrayList<User> users) {
        System.out.println("Users:" + users + "\n");
    }

    public static void testChangePinOK(ArrayList<User> users) {
        //test: check that if card number is ok
        int position = UserService.isCardNumber(1234123412341234L, users);
        if (position >= 0) System.out.println("Test #testChangePinOK OK");
        else System.out.println("Test #testChangePinOK FAIL");

    }

    public static void testChangePinFAIL(ArrayList<User> users) {
        //test: check that if card number is wrong
        int position = UserService.isCardNumber(1234123445841234L, users);
        if (position < 0) System.out.println("Test #testChangePinFAIL OK");
        else System.out.println("Test #testChangePinFAIL FAIL");
    }

    public static void testTransfer(ArrayList<User> users) {

    }

    public static void testDeposit(ArrayList<User> users) {


    }


}
