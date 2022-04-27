package com.company.model;

public class Credit extends Card {

    private double limitLoan;

    public Credit() {
    }

    public Credit(long number, double amount, String type, double limitLoan) {
        super(number, amount, type);
        this.limitLoan = limitLoan;
    }

    //now I am going to override the pay method from the superclass Card
    //causes this method, this pay, in this class WORKS differently
    //this is with different code hence ...
    @Override
    public void pay() {
    }

    public double getLimitLoan() {
        return limitLoan;
    }

    public void setLimitLoan(double limitLoan) {
        this.limitLoan = limitLoan;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "number=" + number +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", pin=" + pin +
                ", limitLoan=" + limitLoan +
                '}';
    }
}
