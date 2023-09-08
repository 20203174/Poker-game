package com.nhnacademy.java.poker;

import java.util.Random;

public enum Rank {
    two,
    three,
    four,
    five,
    six,
    seven,
    eight,
    nine,
    ten,
    J,
    Q,
    K,
    A;

    private static Random random = new Random();
    private static Rank[] ranks = values();

    public static Rank randomRank() {
        return ranks[random.nextInt(12)];
    }

    // public static void main(String[] args) {
    //     Rank rank = Rank.randomRank();
    //     System.out.println(rank);
    // }
}
