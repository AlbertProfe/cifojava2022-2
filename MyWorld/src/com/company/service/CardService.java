package com.company.service;

import com.company.model.Card;
import com.company.model.User;
import com.company.utils.Utilities;

import java.time.LocalDate;


public class CardService {

    public static Card createCard() {

        long cardNumber = Utilities.createCardNumber();
        double amount = 100.00;
        String cardType = Utilities.createTypeCard();
        int pin = Utilities.createCardPin();

        Card cardCreated = new Card(cardNumber, amount, cardType, pin);
        return cardCreated;
    }

    public static Card createCardByUser() {
        //
        return null;
    }

    public static String createDateKey(LocalDate dateOrder) {
        //let s concatenate month and year
        String month = String.valueOf(dateOrder.getMonthValue());
        String year = String.valueOf(dateOrder.getYear());
        String dateKey = month + year;

        return dateKey;
    }

    public static boolean isEnoughBalance(User user, long cardNumber, Double amount) {
        //check if is enough money in origin card
        boolean isMoney = user.getCards().get(cardNumber).getBalance() >= amount;
        return isMoney;
    }

    public static void makeTransfer(User originUser, User destinationUser, long originCardNumber, long destinationCardNumber, double amount) {
        //rest this qty amount from origin
        originUser.getCards().get(originCardNumber).removeAmount(amount);
        //add this qty amount from destination
        destinationUser.getCards().get(destinationCardNumber).addAmount(amount);
    }


}
