package com.company.controller;

import com.company.model.Order;
import com.company.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CardController {

    public static HashMap<String, String> changePin(HashMap<String, String> dataToChangePin) {
//        //get data from hashmap
//        long cardNumber = Long.parseLong((dataToChangePin.get("cardNumber")));
//        int newPin = Integer.parseInt(dataToChangePin.get("newPin"));
//
//        //and get the index from the array, if it does not exist, get -1
//        int position = UserService.isCardNumber(cardNumber, users);
//        HashMap<String, String> changePinResponse = new HashMap<>();
//        changePinResponse.put("response", "changePinResponse");
//        int oldPin = users.get(position).getCard().getPin();
//
//        //if card number exists make the change Pin operation
//        if (position > -1) {
//            UserService.updatePin(newPin, users, position);
//            changePinResponse.put("status", "pinUpdated");
//            changePinResponse.put("message", "Pin changed success. From old Pin number ( #: " + oldPin + " ) to new Pin number ( # " + newPin + " )");
//            //if card number does not exist monitor this to user
//        } else {
//            changePinResponse.put("status", "pinNotUpdated");
//            changePinResponse.put("message", "This credit card number ( #: " + cardNumber + " ) does not exist");
//        }
//
//        return changePinResponse;
        return null;
    }

    public static HashMap<String, String> transfer(HashMap<String, String> dataToTransfer) {
//        //
//        long originCardNumber = Long.valueOf((dataToTransfer.get("originCardNumber")));
//        long destinationCardNumber = Long.valueOf((dataToTransfer.get("destinationCardNumber")));
//        double amount = Double.parseDouble(dataToTransfer.get("amount"));
//
//        int originPosition = UserService.isCardNumber(originCardNumber, users);
//        boolean isOriginCardNumber = originPosition > -1;
//
//        int destinationPosition = UserService.isCardNumber(destinationCardNumber, users);
//        boolean isDestinationCardNumber = destinationPosition > -1;
//
//        boolean isMoney = false;
//        if (isOriginCardNumber) {
//            isMoney = UserService.isEnoughAmount(users, originPosition, amount);
//        }
//
//        HashMap<String, String> transferResponse = new HashMap<>();
//        transferResponse.put("response", "transferResponse");
//        transferResponse.put("status", "transfer NOT done");
//
//        if (!isOriginCardNumber) {
//            transferResponse.put("message", "This credit card number (origin) ( #: " + originCardNumber + " ) does not exist");
//        } else if (!isDestinationCardNumber) {
//            transferResponse.put("message", "This credit card number (destination) ( #: " + destinationCardNumber + " ) does not exist");
//        } else if (!isMoney) {
//            transferResponse.put("message", "Check if credit card has not got enough money to make a transfer ...");
//        } else {
//            //now it is possible to make a transfer, call makeTransfer
//            double originBalance = users.get(originPosition).getCard().getAmount();
//            double depositBalance = users.get(destinationPosition).getCard().getAmount();
//            UserService.makeTransfer(originPosition, destinationPosition, amount, users);
//            double originBalanceAfterDeposit = users.get(originPosition).getCard().getAmount();
//            double destinationBalanceAfterDeposit = users.get(destinationPosition).getCard().getAmount();
//
//            transferResponse.put("status", "transfer done");
//            transferResponse.put("message", "From " + originCardNumber + " to " + destinationCardNumber + " " + amount
//                    + "\nBalance Origin account: " + originBalance + " to " + originBalanceAfterDeposit
//                    + "\nBalance Destination account: " + depositBalance + " to " + destinationBalanceAfterDeposit);
//        }
//
//        return transferResponse;
        return null;
    }

    public static HashMap<String, String> deposit(HashMap<String, String> dataToDeposit) {
//        //
//        long originCardNumber = Long.valueOf((dataToDeposit.get("originCardNumber")));
//        double amount = Double.parseDouble(dataToDeposit.get("amount"));
//
//        int originPosition = UserService.isCardNumber(originCardNumber, users);
//        boolean isOriginCardNumber = originPosition > -1;
//
//        HashMap<String, String> depositResponse = new HashMap<>();
//        depositResponse.put("response", "depositResponse");
//        depositResponse.put("status", "deposit NOT done");
//
//        if (isOriginCardNumber) {
//            double balance = users.get(originPosition).getCard().getAmount();
//            UserService.makeDeposit(originPosition, amount, users);
//            double balanceAfterDeposit = users.get(originPosition).getCard().getAmount();
//
//            depositResponse.put("message", "Deposit " + originCardNumber + " of " + amount + ". Balance account: " + balance + " to " + balanceAfterDeposit);
//            depositResponse.put("status", "transfer done");
//        } else {
//            depositResponse.put("message", "This credit card number (origin) ( #: " + originCardNumber + " ) does not exist");
//        }
//
//        return depositResponse;
        return null;
    }

    public static HashMap<String, String> buy(HashMap<String, String> dataToBuy) {
        //long cardNumber = Long.parseLong((dataToCreateUser.get("cardNumber")));
        //double amount = Double.parseDouble(dataToCreateUser.get("amount"));
        //String cardType = dataToCreateUser.get("cardType");

        //unpack dataToBuy
        String userEmail = dataToBuy.get("userEmail");
        long cardNumber = Long.parseLong(dataToBuy.get("cardNumber"));

        String productDescription = dataToBuy.get("productDescription");
        double amountProduct = Double.parseDouble(dataToBuy.get("amountProduct"));

        ArrayList<User> users = UserController.getFakeUsers();

        Order orderCreated = new Order(productDescription, amountProduct);
        Date dateOrder = orderCreated.getDate();
        //get user from users
        //check if there is balance
        //let s think to test that there is balance
        //to-do check balance

        //String dataKey = createDataKey(dateOrder);
        String dataKey = "042022";

        User userPlaceHolder = users.get(0);

        boolean isKeyMonth = userPlaceHolder.getCards().get(cardNumber).getOrdersByMonth().containsKey(dataKey);


        if (!isKeyMonth) {
            //we need to create a new entry on hashmap
            ArrayList<Order> ordersList = new ArrayList<>();
            ordersList.add(orderCreated);
            userPlaceHolder.getCards().get(cardNumber).getOrdersByMonth().put(dataKey, ordersList);

        } else {
            //entry exists we do a ADD
            userPlaceHolder.getCards().get(cardNumber).getOrdersByMonth().get(dataKey).add(orderCreated);
        }
        userPlaceHolder.getCards().get(cardNumber).removeAmount(amountProduct);

        HashMap<String, String> boyResponse = new HashMap<>();
        boyResponse.put("response", "buyResponse");
        boyResponse.put("status", "order done");

        return boyResponse;
    }
}
