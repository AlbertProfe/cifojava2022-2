package com.company.model;

public class Card {

    long number;
    double amount;
    String type;
    int pin;

    public Card() {
    }

    public Card(long number, double amount, String type) {
        this.number = number;
        this.amount = amount;
        this.type = type;
        this.pin = 1234;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", pin=" + pin +
                '}';
    }

    //update -getter/setter- amount of object card with qty from parameter
    public void removeAmount(Double amount) {
        this.setAmount(this.getAmount() - amount);
    }

    public void addAmount(Double amount) {
        this.setAmount(this.getAmount() + amount);
    }
}