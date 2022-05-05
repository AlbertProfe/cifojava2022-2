package com.company.view;

public class Menu {

    public static void devMenu() {
        //print mini-menu with 4 options + quit
        System.out.println("dev menu");
        System.out.println("1-test");
        System.out.println("2-release");
        System.out.println("3-quit");
    }

    public static void mainMenu() {
        //print mini-menu with 4 options + quit
        System.out.println("main menu");
        System.out.println("2-user");
        System.out.println("3-admin");
        System.out.println("4-quit");
    }

    public static void adminMenu() {
        //print mini-menu with 4 options + quit
        System.out.println("admin menu");
        System.out.println("1-createAdmin");
        System.out.println("2-createUser");
        System.out.println("3-createCard");
        System.out.println("4-listMembers");
        System.out.println("5-quit");
    }

    public static void userMenu() {
        //print mini-menu with 4 options + quit
        System.out.println("user menu");
        System.out.println("1-changePin");
        System.out.println("2-transfer");
        System.out.println("3-deposit");
        System.out.println("4-buy");
        System.out.println("5-changePassword");
        System.out.println("6-printData");
        System.out.println("7-quit");

    }
}
