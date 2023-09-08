package com.nhnacademy.java.poker;

public class Deck {
    Card[] cardSet;

    public Deck(){
        int i = 0;
        for(Suit card : Suit.values()){
            for(Number number : Number.values()){
                cardSet[i] = new Card(card, number);
                i ++;
            }
        }
    }
    
}
