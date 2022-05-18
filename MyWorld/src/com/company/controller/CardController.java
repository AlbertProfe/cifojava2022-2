package com.company.controller;

import com.company.model.Card;
import com.company.model.Order;
import com.company.model.User;
import com.company.repository.CardRepository;
import com.company.repository.OrderRepository;
import com.company.service.CardService;
import com.company.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardController {

    public static HashMap<String, String> createCard(HashMap<String, String> userEmailToCreateCard) {
        //unpack data: user email
        String userEmail = userEmailToCreateCard.get("userEmail");
        //get user by email
        User user = UserService.getUserByEmail(userEmail);
        //create a Card
        Card cardCreated = CardService.createCard();
        long cardNumber = cardCreated.getCardNumber();
        user.addCardNumber(cardNumber);
        User userUpdated = UserService.update(user);

        HashMap<String, String> createCardResponse = new HashMap<>();
        createCardResponse.put("response", "createCardResponse");
        createCardResponse.put("status", "card created");
        createCardResponse.put("card data", cardCreated.toString());
        createCardResponse.put("user updated", String.valueOf(userUpdated));

        return createCardResponse;
    }

    public static HashMap<String, String> changePin(HashMap<String, String> dataToChangePin) {
        //get data from hashmap
        long cardNumber = Long.parseLong((dataToChangePin.get("cardNumber")));
        int newPin = Integer.parseInt(dataToChangePin.get("newPin"));

        Card cardFound = CardService.getCardById(cardNumber);

        HashMap<String, String> changePinResponse = new HashMap<>();
        changePinResponse.put("response", "changePinResponse");
        int oldPin = cardFound.getPin();

        //if card number exists make the change Pin operation
        if (cardFound != null) {
            //update pin
            cardFound.setPin(newPin);
            Card cardUpdated = CardService.update(cardFound);
            changePinResponse.put("status", "pinUpdated");
            changePinResponse.put("message", "Pin changed success. From old Pin number ( #" + oldPin + " ) to new Pin number ( #" + newPin + " )");
            changePinResponse.put("cardUpdated", cardUpdated.toString() );
            //if card number does not exist monitor this to user
        } else {
            changePinResponse.put("status", "pinNotUpdated");
            changePinResponse.put("message", "This credit card number ( #" + cardNumber + " ) does not exist");
        }

        return changePinResponse;
    }

    public static HashMap<String, String> transfer(HashMap<String, String> dataToTransfer) {
        //unpack
        long originCardNumber = Long.valueOf((dataToTransfer.get("originCardNumber")));
        long destinationCardNumber = Long.valueOf((dataToTransfer.get("destinationCardNumber")));
        double amount = Double.parseDouble(dataToTransfer.get("amount"));
        //create hash response
        HashMap<String, String> transferResponse = new HashMap<>();
        transferResponse.put("response", "transferResponse");
        transferResponse.put("status", "transfer NOT done");
        //check weather there is balance and check cards numbers
        boolean isEnoughBalance = CardService.isEnoughBalance(originCardNumber, amount);
        Card originCard = CardService.getCardById(originCardNumber);
        Card destinationCard =  CardService.getCardById(destinationCardNumber);
        boolean isOriginCardNumber = originCard != null;
        boolean isDestinationCardNumber = destinationCard != null;

        if (!isOriginCardNumber) {
            transferResponse.put("message", "This user (origin) from ( #" + originCardNumber + " ) does not exist");
        } else if (!isDestinationCardNumber) {
            transferResponse.put("message", "This user (destination) from ( #" + destinationCardNumber + " ) does not exist");
        } else if (!isEnoughBalance) {
            transferResponse.put("message", "Check if credit card has not got enough money to make a transfer ...");
        } else {
            //now it is possible to make a transfer, call makeTransfer
            double originBalance = originCard.getBalance();
            double destinationBalance = destinationCard.getBalance();
            //call make transfer and repo-db
            List<Card> cardsUpdated = CardService.makeTransfer(originCard, destinationCard, amount);
            double originBalanceAfter = cardsUpdated.get(0).getBalance();
            double destinationBalanceAfter = cardsUpdated.get(1).getBalance();

            transferResponse.put("status", "transfer done");
            transferResponse.put("message", "From " + originCardNumber + " to " + destinationCardNumber + " " + amount
                    + "\nBalance Origin account: " + originBalance + " to " + originBalanceAfter
                    + "\nBalance Destination account: " + destinationBalance + " to " + destinationBalanceAfter);
        }

        return transferResponse;
    }

    public static HashMap<String, String> deposit(HashMap<String, String> dataToDeposit) {
        //
        long originCardNumber = Long.valueOf((dataToDeposit.get("originCardNumber")));
        double amount = Double.parseDouble(dataToDeposit.get("amount"));
        Card originCard = CardService.getCardById(originCardNumber);
        boolean isOriginCardNumber = originCard != null;

        HashMap<String, String> depositResponse = new HashMap<>();
        depositResponse.put("response", "depositResponse");
        depositResponse.put("status", "deposit NOT done");

        if (isOriginCardNumber) {
            double balance = originCard.getBalance();
            originCard.addAmount(amount);
            Card originCardUpdated = CardService.update(originCard);
            double originBalanceAfter = originCardUpdated.getBalance();


            depositResponse.put("message", "Deposit " + originCardNumber + " of " + amount + ". Balance account: " + balance + " to " + originBalanceAfter);
            depositResponse.put("status", "transfer done");
        } else {
            depositResponse.put("message", "This credit card number (origin) ( #: " + originCardNumber + " ) does not exist");
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

        Card cardToBuy = CardService.getCardById(cardNumber);
        boolean isOriginCardNumber = cardToBuy != null;

        //check weather there is balance
        boolean isEnoughBalance = CardService.isEnoughBalance(cardNumber, amountProduct);
        //creating response hashmap
        HashMap<String, String> buyResponse = new HashMap<>();
        buyResponse.put("response", "buyResponse");

        //main business logic method
        if (!isEnoughBalance || !isOriginCardNumber ) {
            buyResponse.put("status", "order not done");
            buyResponse.put("message", "not enough money");
        } else {
            Order orderCreated = new Order(productDescription, amountProduct);
            LocalDate dateOrder = orderCreated.getDate();
            String dataKey = CardService.createDateKey(dateOrder);
            if (!cardToBuy.getDateKeys().contains(dataKey)) cardToBuy.addDateKeys(dataKey);
            orderCreated.setDateKeyCard(dataKey);
            //operation pay the buy
            cardToBuy.removeAmount(amountProduct);
            //updated balance
            OrderRepository.create(orderCreated);
            Card cardUpdated = CardRepository.update(cardToBuy);

            double balanceUpdated = cardUpdated.getBalance();
            buyResponse.put("status", "buy done");
            buyResponse.put("message", amountProduct + " Euros payed on card " + cardNumber + ". Balance updated: " + balanceUpdated);
        }

        return buyResponse;
    }
}
