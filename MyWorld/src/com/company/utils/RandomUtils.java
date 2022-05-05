package com.company.utils;


import java.util.Random;

public class RandomUtils {

    public static int createIntRandom(int top) {
        //
        Random rand = new Random();
        // Generate random integers in range 0 to top, if top=10 random 0 to 9
        int intRandom = rand.nextInt(top);
        return intRandom;
    }

    public static long createLongRandom(int top) {
        //
        Random rand = new Random();
        // Generate random long in range 0 to top, if top=10 random 0 to 9
        long longRandom = rand.nextLong(top);
        return longRandom;
    }

    public static char createCharRandom() {
        // Random rand = new Random();
        // String alphabetChars =
        // "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        // String alphabetChars2 = "!·$%&/()=?¿?=)()/*-+^*Ç¨_:;;:_+/";
        String alphabetChars3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!$%&/()=?¿?=)()/*-+^*_:;;:_+/+/";
        // Generate random char in range 0 to top, if top=10 random 0 to 9
        char charRandom = alphabetChars3.charAt(createIntRandom(alphabetChars3.length()));

        return charRandom;

    }

    public static char createCharNumberRandom(boolean withZero) {
        //
        String alphabetChars4 = "0123456789";
        String alphabetChars5 = "123456789";
        // Generate random char in range 0 to top, if top=10 random 0 to 9
        char charRandom;
        if (withZero) {  charRandom = alphabetChars4.charAt(createIntRandom(alphabetChars4.length())); }
        else {  charRandom = alphabetChars5.charAt(createIntRandom(alphabetChars5.length())); }

        return charRandom;

    }





}
