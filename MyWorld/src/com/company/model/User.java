package com.company.model;

import java.util.HashMap;

public class User {

    public String name;
    public String surname;
    public int age;
    //field cards is a set of CARD object
    //each Card has its orders by Month
    //that is, the orders will be in HashMap
    //key-String-Month and value-List-Order
    public HashMap<Long, Card> cards;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cards = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HashMap<Long, Card> getCards() {
        return cards;
    }

    public void setCards(HashMap<Long, Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", cards=" + cards +
                '}';
    }
}