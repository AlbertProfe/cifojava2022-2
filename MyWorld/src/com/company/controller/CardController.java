package com.company.controller;

import com.company.model.Card;
import com.company.model.Order;
import com.company.model.User;
import com.company.service.CardService;
import com.company.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CardController {

    public static HashMap<String, String> changePin(HashMap<String, String> dataToChangePin) {
        //get data from hashmap
        long cardNumber = Long.parseLong((dataToChangePin.get("cardNumber")));
        int newPin = Integer.parseInt(dataToChangePin.get("newPin"));
        //get user from card
        User user = UserService.getUserByCard(cardNumber);

        HashMap<String, String> changePinResponse = new HashMap<>();
        changePinResponse.put("response", "changePinResponse");
        int oldPin = user.getCards().get(cardNumber).getPin();

        //if card number exists make the change Pin operation
        if (user != null) {
            //update pin
            user.getCards().get(cardNumber).setPin(newPin);
            changePinResponse.put("status", "pinUpdated");
            changePinResponse.put("message", "Pin changed success. From old Pin number ( #: " + oldPin + " ) to new Pin number ( # " + newPin + " )");
            //if card number does not exist monitor this to user
        } else {
            changePinResponse.put("status", "pinNotUpdated");
            changePinResponse.put("message", "This credit card number ( #: " + cardNumber + " ) does not exist");
        }

        return changePinResponse;
    }

    public static HashMap<String, String> transfer(HashMap<String, String> dataToTransfer) {
        //unpack
        long originCardNumber = Long.valueOf((dataToTransfer.get("originCardNumber")));
        long destinationCardNumber = Long.valueOf((dataToTransfer.get("destinationCardNumber")));
        double amount = Double.parseDouble(dataToTransfer.get("amount"));

        //get user from card
        User originUser = UserService.getUserByCard(originCardNumber);
        User destinationUser = UserService.getUserByCard(destinationCardNumber);

        //check weather there is balance
        boolean isEnoughBalance = CardService.isEnoughBalance(originUser, originCardNumber, amount);

        HashMap<String, String> transferResponse = new HashMap<>();
        transferResponse.put("response", "transferResponse");
        transferResponse.put("status", "transfer NOT done");

        if (originUser == null) {
            transferResponse.put("message", "This user (origin) from ( #: " + originCardNumber + " ) does not exist");
        } else if (destinationUser == null) {
            transferResponse.put("message", "This user (destination) from ( #: " + destinationCardNumber + " ) does not exist");
        } else if (!isEnoughBalance) {
            transferResponse.put("message", "Check if credit card has not got enough money to make a transfer ...");
        } else {
            //now it is possible to make a transfer, call makeTransfer
            double originBalance = originUser.getCards().get(originCardNumber).getBalance();
            double depositBalance = destinationUser.getCards().get(originCardNumber).getBalance();
            CardService.makeTransfer(originUser, destinationUser, originCardNumber, destinationCardNumber, amount);
            double originBalanceAfterDeposit = originUser.getCards().get(originCardNumber).getBalance();
            double destinationBalanceAfterDeposit = destinationUser.getCards().get(originCardNumber).getBalance();

            transferResponse.put("status", "transfer done");
            transferResponse.put("message", "From " + originCardNumber + " to " + destinationCardNumber + " " + amount
                    + "\nBalance Origin account: " + originBalance + " to " + originBalanceAfterDeposit
                    + "\nBalance Destination account: " + depositBalance + " to " + destinationBalanceAfterDeposit);
        }

        return transferResponse;
    }

    public static HashMap<String, String> deposit(HashMap<String, String> dataToDeposit) {
        //
        long cardNumber = Long.valueOf((dataToDeposit.get("originCardNumber")));
        double amount = Double.parseDouble(dataToDeposit.get("amount"));
        //get user from card
        User user = UserService.getUserByCard(cardNumber);

        HashMap<String, String> depositResponse = new HashMap<>();
        depositResponse.put("response", "depositResponse");
        depositResponse.put("status", "deposit NOT done");

        if (user != null) {
            double balance = user.getCards().get(cardNumber).getBalance();
            user.getCards().get(cardNumber).addAmount(amount);
            double balanceUpdated = user.getCards().get(cardNumber).getBalance();

            depositResponse.put("message", "Deposit " + cardNumber + " of " + amount + ". Balance account: " + balance + " to " + balanceUpdated);
            depositResponse.put("status", "transfer done");
        } else {
            depositResponse.put("message", "This credit card number (origin) ( #: " + cardNumber + " ) does not exist");
        }

        return depositResponse;
    }

    public static HashMap<String, String> buy(HashMap<String, String> dataToBuy) {
        //unpack dataToBuy: user and card
        String userEmail = dataToBuy.get("userEmail");
        long cardNumber = Long.parseLong(dataToBuy.get("cardNumber"));
        //unpack dataToBuy: data to create order
        String productDescription = dataToBuy.get("productDescription");
        double amountProduct = Double.parseDouble(dataToBuy.get("amountProduct"));
        //get user by email
        User user = UserService.getUserByEmail(userEmail);
        //get users list: no need to user this getter
        //ArrayList<User> users = UserController.getUsers();
        //create order object
        Order orderCreated = new Order(productDescription, amountProduct);
        LocalDate dateOrder = orderCreated.getDate();
        String dataKey = CardService.createDateKey(dateOrder);

        //check weather there is balance
        boolean isEnoughBalance = CardService.isEnoughBalance(user, cardNumber, amountProduct);
        //creating response hashmap
        HashMap<String, String> buyResponse = new HashMap<>();
        buyResponse.put("response", "buyResponse");

        //main business logic method
        if (!isEnoughBalance) {
            buyResponse.put("status", "order not done");
            buyResponse.put("message", "not enough money");
        } else {
            boolean isKeyMonthEntry = user.getCards().get(cardNumber).getOrdersByMonth().containsKey(dataKey);
            if (!isKeyMonthEntry) {
                // we need to create a new entry on hashma
                //with a new list where we ADD the new created order
                // PUT operation: key (String: dataKey) and value (List: ordersList)
                ArrayList<Order> ordersList = new ArrayList<>();
                ordersList.add(orderCreated);
                user.getCards().get(cardNumber).getOrdersByMonth().put(dataKey, ordersList);
            } else {
                //entry exists we do an ADD to the old entry, we update the list
                user.getCards().get(cardNumber).getOrdersByMonth().get(dataKey).add(orderCreated);
            }
            //operation pay the buy
            user.getCards().get(cardNumber).removeAmount(amountProduct);
            //updated balance
            double balanceUpdated = user.getCards().get(cardNumber).getBalance();
            buyResponse.put("status", "buy done");
            buyResponse.put("message", amountProduct + " Euros payed on card " + cardNumber + ". Balance updated: " + balanceUpdated);
        }

        return buyResponse;
    }

    public static HashMap<String, String> createCard(HashMap<String, String> userEmailToCreateCard) {
        //unpack data: user email
        String userEmail = userEmailToCreateCard.get("userEmail");
        //get user by email
        User user = UserService.getUserByEmail(userEmail);
        //create a Card
        Card cardCreated = CardService.createCard();
        long cardNumber = cardCreated.getCardNumber();
        user.getCards().put(cardNumber, cardCreated);

        HashMap<String, String> createCardResponse = new HashMap<>();
        createCardResponse.put("response", "createCardResponse");
        createCardResponse.put("status", "card created");
        createCardResponse.put("card data", cardCreated.toString());

        return createCardResponse;
    }
}
