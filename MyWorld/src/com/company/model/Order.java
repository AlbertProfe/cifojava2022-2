package com.company.model;

import java.time.LocalDate;


public class Order {
    private String concept;
    private Double amount;
    private LocalDate date;

    public Order() {
    }

    public Order(String concept, Double amount, LocalDate date) {
        this.concept = concept;
        this.amount = amount;
        this.date = date;
    }

    public Order(String concept, Double amount) {
        this.concept = concept;
        this.amount = amount;
        this.date = createLocalDate();
    }

    private LocalDate createLocalDate() {
        LocalDate date = LocalDate.now();
        return date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
