package com.company.model;

public class Debit extends Card {

    private int points;

    public Debit() {
    }

    public Debit(long number, double amount, String type, int points) {
        super(number, amount, type);
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
                "number=" + number +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", pin=" + pin +
                ", points=" + points +
                '}';
    }
}
