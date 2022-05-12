package com.company.model;

import com.company.utils.Utilities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name="USER_TABLE")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long userId;
    public String name;
    public String surname;
    public int age;
    public String email;
    public String password;
    //field cards is a set of CARD object
    //each Card has its orders by Month
    //that is, the orders will be in HashMap
    //key-String-Month and value-List-Order
    @Transient
    public HashMap<Long, Card> cards;
    @ElementCollection
    @CollectionTable(
            name="CARDS_BY_USER",
            joinColumns=@JoinColumn(name="USER_ID")
    )
    @Column(name="CARD_NUMBER")
    public List<Long> cardNumbersList;


    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = Utilities.createEmail(name, surname);
        this.password = Utilities.createPassword();
        this.cards = new HashMap<>();
        this.cardNumbersList = new ArrayList<Long>(cards.keySet());
    }

    public User(String name, String surname, int age, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cards = new HashMap<>();
        this.cardNumbersList = new ArrayList<Long>(cards.keySet());
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getCardNumbersList() {
        return cardNumbersList;
    }

    public void setCardNumbersList(List<Long> cardNumbersList) {
        this.cardNumbersList = cardNumbersList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email=" + email +
                ", password=" + password +
                ", \n\t cards=" + cards +
                "}\n";
    }
}