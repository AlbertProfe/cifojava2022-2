package com.company.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Card {

    public long cardNumber;
    public double balance;
    public String type;
    public int pin;
    public HashMap<String, ArrayList<Order>> ordersByMonth = new HashMap<>();

    public Card() {
    }

    public Card(long cardNumber, double balance, String type, int pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.type = type;
        this.pin = pin;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void pay() {
    }

    public HashMap<String, ArrayList<Order>> getOrdersByMonth() {
        return ordersByMonth;
    }

    public void setOrdersByMonth(HashMap<String, ArrayList<Order>> ordersByMonth) {
        this.ordersByMonth = ordersByMonth;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                ", pin=" + pin +
                ", \n\t ordersByMonth=" + ordersByMonth +
                '}';
    }

    //update -getter/setter- amount of object card with qty from parameter
    public void removeAmount(Double amount) {
        this.setBalance(this.getBalance() - amount);
    }

    public void addAmount(Double amount) {
        this.setBalance(this.getBalance() + amount);
    }
}