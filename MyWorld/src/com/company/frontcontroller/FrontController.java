package com.company.frontcontroller;

import com.company.controller.UserController;

import java.util.HashMap;

public class FrontController {

    public static void mainLoopController(HashMap datafromVew) {
        //
        if (datafromVew.get("operation").equals("createUser")) UserController.createUser(datafromVew);
        //else if (datafromVew.get("operation").equals( "changePin"))  UserController.changePin(datafromVew);
        //else if (datafromVew.get("operation").equals( "transfer"))  UserController.transfer(datafromVew);
        //else if (datafromVew.get("operation").equals( "deposit"))  UserController.deposit(datafromVew);
        //else if (datafromVew.get("operation").equals( "loan"))  UserController.loan(datafromVew);


    }
}
