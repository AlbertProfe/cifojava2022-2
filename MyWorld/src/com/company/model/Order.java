package com.company.model;

import java.util.Date;

public class Order {
    private String concept;
    private Double amount;
    private Date date;

    public Order() {
    }

    public Order(String concept, Double amount, Date date) {
        this.concept = concept;
        this.amount = amount;
        this.date = date;
    }

    public Order(String concept, Double amount) {
        this.concept = concept;
        this.amount = amount;
        this.date = new Date();
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "concept='" + concept + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
