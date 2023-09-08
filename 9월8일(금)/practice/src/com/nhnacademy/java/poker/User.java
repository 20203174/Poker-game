package com.nhnacademy.java.poker;

import java.util.ArrayList;
import java.util.Random;

public class User {
    private String name;
    private ArrayList<Card> cards= new ArrayList<Card>(5);
    // private static Card[] card = new Card[5];

    public User(String name) {
        this.name = name;
        cardSet();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCard() {
        return cards;
    }

    public void cardSet() {
        for(int i = 0; i < 5; i++) {
            cards.add(new Card(Suit.randomSuit(), Rank.randomRank()));
        }
    }

}
