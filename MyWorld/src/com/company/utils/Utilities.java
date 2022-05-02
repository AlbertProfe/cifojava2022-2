package com.company.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utilities {

    public static String ask(Scanner reader, String string) {
        System.out.println(string);
        return reader.nextLine();
    }

    public static String createEmail(String name, String surname) {
        // scope
        String email = name.charAt(0) + surname + "@helsinki.uni";
        return email;
    }

    public static String createPassword() {
        //
        String password = "";
        password = password + RandomUtils.createCharRandom() + RandomUtils.createIntRandom(10000) + RandomUtils.createCharRandom()
                + RandomUtils.createCharRandom() + RandomUtils.createIntRandom(596);
        return password;
    }

    public static long createCardNumber() {
        //
        String cardNumber = "";
        char firstDigit = RandomUtils.createCharNumberRandom(false);
        cardNumber += firstDigit;
        for (int i = 0; i < 15; i++){
            char digit = RandomUtils.createCharNumberRandom(true);
            cardNumber += digit;
        }
        long cardNumberLong = Long.parseLong(cardNumber);

        return cardNumberLong;
    }

    public static int createCardPin() {
        //
        String cardPin = "";
        for (int i = 0; i < 4; i++){
            char digit = RandomUtils.createCharNumberRandom(false);
            cardPin += digit;
        }
        int cardPinInt = Integer.parseInt(cardPin);

        return cardPinInt;
    }

    public static String createTypeCard() {
        //
        Random rand = new Random();
        List cardsTypeNames = Arrays.asList("Visa", "American Express", "MasterCard", "PayPal", "Stripe");
        // Generate random integers in range 0 to top, if top=10 random 0 to 9
        int intRandom = rand.nextInt(cardsTypeNames.size()-1);
        String cardType = (String) cardsTypeNames.get(intRandom);
        return cardType;
    }

}
