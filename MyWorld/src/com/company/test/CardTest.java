package com.company.test;

import com.company.model.Card;
import com.company.model.Credit;
import com.company.model.Debit;

import java.util.ArrayList;

public class CardTest {

    public static void cardTest() {

        createCards();
        System.out.println("Tests CARD ending... \n");

    }

    public static void createCards() {

        Card card1 = new Card(1234123412341234L, 50.00, "Visa", 2564);
        Card card2 = new Debit(5659568956842L, 545.00, "American Express", 120, 1546);
        Card card3 = new Credit(7894562584782564L, 230.00, "MasterCard", 1538, 1000.00);

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        System.out.println(cards);

    }
}
