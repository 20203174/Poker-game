package com.nhnacademy.java.poker;

import java.util.Random;

public enum Suit {
    spades,
    diaomonds,
    hearts,
    clubs;

    private static Random random = new Random();
    private static Suit[] suits = values();

    public static Suit randomSuit() {
        return suits[random.nextInt(3)];
    }
    
    // public static void main(String[] args) {
    //     Suit suit = Suit.randomSuit();
    //     System.out.println(suit);
    // }
}
