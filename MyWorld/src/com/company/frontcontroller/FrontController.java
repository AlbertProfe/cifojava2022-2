package com.company.frontcontroller;

import com.company.controller.UserController;

import java.util.HashMap;

public class FrontController {

    public static HashMap<String, String> mainLoopController(HashMap<String, String> request) {
        //
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "error");
        //
        if (request.get("operation").equals("createUser")) response = UserController.createUser(request);
        else if (request.get("operation").equals("changePin")) response = UserController.changePin(request);
        else if (request.get("operation").equals("transfer")) response = UserController.transfer(request);
        else if (request.get("operation").equals("deposit")) response = UserController.deposit(request);
        //else if (request.get("operation").equals( "loan"))  UserController.loan(request);

        return response;
    }
}
