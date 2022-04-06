package com.company;

public class Card {

    int number;
    double amount;
    String type;
    int pin;

    public Card() {
    }

    public Card(int number, double amount, String type, int pin) {
        this.number = number;
        this.amount = amount;
        this.type = type;
        this.pin = 1234;
    }

    public int getNumber() {
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

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", pin=" + pin +
                '}';
    }
}