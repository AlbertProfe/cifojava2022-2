package com.company.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ORDER_TABLE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private String concept;
    private Double amount;
    private LocalDate date;
    private String dateKeyCard;


    public Order() {
    }


    public Order(String concept, Double amount, LocalDate date) {
        this.concept = concept;
        this.amount = amount;
        this.date = date;
    }

    public Order(String concept, Double amount, LocalDate date, String dateKeyCard) {
        this.concept = concept;
        this.amount = amount;
        this.date = date;
        this.dateKeyCard = dateKeyCard;
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

    public String getDateKeyCard() {
        return dateKeyCard;
    }

    public void setDateKeyCard(String dateKeyCard) {
        this.dateKeyCard = dateKeyCard;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
