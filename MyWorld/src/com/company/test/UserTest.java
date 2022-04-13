package com.company.test;

import com.company.model.Card;
import com.company.model.User;
import com.company.service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class UserTest {

    public static void test(ArrayList<User> users) {
        createFakeUsers(users);
        //printUsers(users);
        testChangePinOK(users);
        testChangePinFAIL(users);
        testTransferOK(users);
        //testDeposit(users);
        //testLoan(users);
        //testTransferCompleteProcessOK(users);
    }

    public static void createFakeUsers(ArrayList<User> users) {

        User newUser1 = new User("Alex", "Pixel", 25, new Card(1234123412341234L, 500.00, "Visa"));
        User newUser2 = new User("Thomas", "Edison", 35, new Card(4321432143214321L, 1500.00, "Master Card"));
        User newUser3 = new User("Susan", "Lane", 46, new Card(1111222233334444L, 2500.00, "American Express"));
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

    public static void testTransferOK(ArrayList<User> users) {
        //test: check 4 methods to make a transfer
        int positionOrigin = UserService.isCardNumber(1234123412341234L, users);
        int positionDestination = UserService.isCardNumber(4321432143214321L, users);

        if (positionOrigin >= 0 && positionDestination >= 0) System.out.println("Test #testTransferCardsOK OK");
        else System.out.println("Test # #testTransferCardsOK FAIL");

        boolean isMoney = UserService.isEnoughAmount(users, positionOrigin, 50.00);
        if (isMoney) System.out.println("Test #testTransferIsMoneyOK OK");
        else System.out.println("Test # #testTransferIsMoneyOK FAIL");

        UserService.makeTransfer(positionOrigin, positionDestination, 50.00, users);

        double rightAmountAfterMakeTransferOrigin = users.get(positionOrigin).getCard().getAmount();
        if (rightAmountAfterMakeTransferOrigin == 450.00) System.out.println("Test #testTransferMakeOriginOK OK");
        else System.out.println("Test # #testTransferMakeOriginOK FAIL");

        double rightAmountAfterMakeTransferDestination = users.get(positionDestination).getCard().getAmount();
        if (rightAmountAfterMakeTransferDestination == 1550.00)
            System.out.println("Test #testTransferMakeDestinationOK OK");
        else System.out.println("Test # #testTransferMakeDestinationOK FAIL");

    }

    public static void testTransferFAIL(ArrayList<User> users) {
        //to-do
    }

    public static void testTransferCompleteProcessOK(ArrayList<User> users) {
        //to-do: we need to create a fake scanner to test the WHOLE method as a unitary test
        Long cardNumberOrigin = 1234123412341234L;
        Long cardNumberDestination = 4321432143214321L;
        double amountToTransfer = 50.00;

        //OPTION A) method overload: remove reader and send two longs and one int
        //UserController.transfer(cardNumberOrigin, cardNumberOrigin, amount, users);


        String testInput = "1234123412341234L\n" + "4321432143214321L\n" + "50.00\n";
        Scanner readerTest = new Scanner(testInput);

        //OPTION B) send reader
        //UserController.transfer(readerTest, users);


        //OPTION C) replicate method here

        double rightAmountAfterMakeTransferOrigin = users.get(0).getCard().getAmount();
        if (rightAmountAfterMakeTransferOrigin == 450.00)
            System.out.println("Test #testTransferCompleteProcessOriginOK OK");
        else System.out.println("Test # #testTransferCompleteProcessOriginOK FAIL");

        double rightAmountAfterMakeTransferDestination = users.get(1).getCard().getAmount();
        if (rightAmountAfterMakeTransferDestination == 1550.00)
            System.out.println("Test #testTransferCompleteProcessnDestinationOK OK");
        else System.out.println("Test # #testTransferCompleteProcessDestinationOK FAIL");
    }

    public static void testDeposit(ArrayList<User> users) {
        //to-do
    }

    public static void loan(ArrayList<User> users) {
        //to-do
    }


}
