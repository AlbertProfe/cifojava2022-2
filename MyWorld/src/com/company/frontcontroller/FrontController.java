package com.company.frontcontroller;

import com.company.controller.CardController;
import com.company.controller.UserController;
import java.util.HashMap;

public class FrontController {

    public static HashMap<String, String> mainLoopController(HashMap<String, String> request) {
        //
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "error");
        //
        if (request.get("operation").equals("createUser")) response = UserController.createUser(request);
        else if (request.get("operation").equals("printMembers")) response = UserController.printMembers();
        else if (request.get("operation").equals("changePin")) response = CardController.changePin(request);
        else if (request.get("operation").equals("transfer")) response = CardController.transfer(request);
        else if (request.get("operation").equals("deposit")) response = CardController.deposit(request);
        else if (request.get("operation").equals("buy")) response = CardController.buy(request);
        //else if (request.get("operation").equals( "loan"))  UserController.loan(request);

        return response;
    }
}