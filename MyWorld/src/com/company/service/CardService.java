package com.company.service;

import com.company.model.Card;
import com.company.model.User;
import com.company.repository.CardRepository;
import com.company.utils.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CardService {

    public static Card createCard() {
        //let s get some random data to cardNumber, cardType and pin
        long cardNumber = Utilities.createCardNumber();
        double amount = 100.00;
        String cardType = Utilities.createTypeCard();
        int pin = Utilities.createCardPin();

        //with random data we will create a NEW CARD OBJECT, so
        //after that we will call the repo-DB
        Card cardCreated = new Card(cardNumber, amount, cardType, pin);
        CardRepository.create(cardCreated);

        return cardCreated;
    }


    public static String createDateKey(LocalDate dateOrder) {
        //let s concatenate month and year
        String month = String.valueOf(dateOrder.getMonthValue());
        String year = String.valueOf(dateOrder.getYear());
        String dateKey = month + year;

        return dateKey;
    }

    public static boolean isEnoughBalance(long cardNumber, Double amount) {
        //check if is enough money in origin card
        boolean isMoney = CardService.getCardById(cardNumber).getBalance() >= amount;
        return isMoney;
    }


    public static List<Card> makeTransfer( Card originCard, Card destinationCard, double amount) {
        List<Card> cardsUpdated = new ArrayList<>();
        //rest this qty amount from origin
        originCard.removeAmount(amount);
        Card originCardUpdated = CardService.update(originCard);
        cardsUpdated.add(originCardUpdated);
        //add this qty amount from destination
        destinationCard.addAmount(amount);
        Card destinationCardUpdated = CardService.update(destinationCard);
        cardsUpdated.add(destinationCardUpdated);
        return cardsUpdated;
    }


    public static Card getCardById(long cardNumber) {
        Card cardFound = CardRepository.getCardById(cardNumber);
        return cardFound;
    }

    public static Card update(Card cardFound) {
        Card cardUpdated = CardRepository.update(cardFound);
        return cardUpdated;
    }
}
