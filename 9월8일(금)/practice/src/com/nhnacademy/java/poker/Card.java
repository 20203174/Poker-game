package com.nhnacademy.java.poker;

//need card 52 
public class Card {
    
    private Suit suit;
    private Rank rank;


    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void cardOpen() {
        System.out.println("[" + suit + ", " + rank + "]");
    }

}

