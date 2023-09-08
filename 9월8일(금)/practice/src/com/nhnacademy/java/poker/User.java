package com.nhnacademy.java.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class User {
    private String name;
    private ArrayList<Card> cards= new ArrayList<Card>();
    // private static Card[] card = new Card[5];

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCard() {
        return cards;
    }

    public void cardSet(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void sortingCard() {
        Collections.sort(cards);
    }


}
