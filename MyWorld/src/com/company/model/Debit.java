package com.company.model;

public class Debit extends Card {

    private int points;

    public Debit() {
    }

    public Debit(long number, double amount, String type, int pin, int points) {
        super(number, amount, type, pin);
        this.points = points;
    }

    @Override
    public void pay() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Debit{" +
                "number=" + cardNumber +
                ", amount=" + balance +
                ", type='" + type + '\'' +
                ", pin=" + pin +
                ", points=" + points +
                '}';
    }
}
