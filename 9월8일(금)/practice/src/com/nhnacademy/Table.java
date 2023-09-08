package com.nhnacademy;

import java.util.Scanner;

import com.nhnacademy.java.poker.Card;
import com.nhnacademy.java.poker.Rank;
import com.nhnacademy.java.poker.Suit;
import com.nhnacademy.java.poker.User;

public class Table {
    private static User[] users = new User[5];
    private static int number;
    private static int startNumber;
    private static int count;

    public Table(int number) {
        this.number = number;
        playGame(number);
    }


    public static User[] getUsers() {
        return users;
    }

    public static int getNumber() {
        return number;
    }
    public static int getCount() {
        return count;
    }

    public static void playGame(int number) {
        //몇명인지
        Scanner scanner = new Scanner(System.in);
        String name = "";
        for(int i = 0; i < number; i++) {
            System.out.println("이름을 입력해주세요");
            name = scanner.nextLine();
            users[i] = new User(name);
        }
        for(int i = 0; i < number; i++) {
            System.out.print(users[i].getName() + ": ");
            users[i].getCard().get(4).cardOpen();
        }

        handOutCard();
    }
    public static void handOutCard() {
        count++;
        for(int i = 0; i < getNumber(); i++) {
            users[i].getCard().add(new Card(Suit.randomSuit(), Rank.randomRank()));
        }
        for(int i = 0; i < getNumber(); i++) {
            System.out.println(users[i].getName() + ": ");
            for(int j = 4; j <= 4 + getCount(); j++) {
                users[i].getCard().get(j).cardOpen();
            }
        }
    }
    public static void whoIsTop() {
        // 기준 모르겠음.. 일단 순서대로!
    }

    public static void main(String[] args) {
        Table table= new Table(4);
        // playGame(4);
    }
}
