package com.company.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Card {
    @Id
    public long cardNumber;
    public double balance;
    public String type;
    public int pin;
    public HashMap<String, ArrayList<Order>> ordersByMonth = new HashMap<>();
    //create table card(cardNumber bigInt not null, balance float, type varchar(25), pin integer, ordersByMonth varchar(255),primary key (cardNumber ))teger, ordersByMonth varchar(255),primary key (id))
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