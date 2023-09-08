package com.nhnacademy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.nhnacademy.java.poker.Card;
import com.nhnacademy.java.poker.Judge;
import com.nhnacademy.java.poker.Rank;
import com.nhnacademy.java.poker.Suit;
import com.nhnacademy.java.poker.User;

public class Table {
    private static User[] users = new User[5];
    private static ArrayList<Card> cardSet = new ArrayList<Card>(52);
    private static int userNumber;
    private static int startNumber;
    private static int count;
    private static Random random = new Random();

    public Table(int userNumber) {
        this.userNumber = userNumber;
        playGame(userNumber);
    }

    public static ArrayList<Card> getCardSet() {
        return cardSet;
    }


    public static User[] getUsers() {
        return users;
    }

    public static int getNumber() {
        return userNumber;
    }
    public static int getCount() {
        return count;
    }

    public static void cardSetting() { // 카드를 섞는다. 52장 준비 
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
            cardSet.add(new Card(Suit.getSuits()[i], Rank.getRanks()[j]));
            }
        }
        // for(int i = 0; i < 52; i++) {
        //     System.out.println(cardSet.get(i).getSuit() + ", " + cardSet.get(i).getRank());
        // }
    }

    public static void playGame(int userNumber) {
        //몇명인지
        Scanner scanner = new Scanner(System.in);
        String name = "";

        cardSetting();

        for(int i = 0; i < userNumber; i++) {
            System.out.println("이름을 입력해주세요");
            name = scanner.nextLine();
            users[i] = new User(name);
        }

        initCardForUser();
        
        for(int i = 0; i < userNumber; i++) {
            System.out.print(users[i].getName() + ": ");
            users[i].getCard().get(2).cardOpen();
        }

        handOutCard();
        handOutCard();
        for(int i = 0; i< userNumber; i++) {
            System.out.println("After Sorting");
            for(int j = 0; j <= 2 + getCount(); j++) {
                users[i].getCard().get(j).cardOpen();
            }
        }
        System.out.println("winner is: "+ Judge.whoIsWinner(userNumber, users).getName());
        
    }


    private static void initCardForUser() { //게임 시작시에 각 플레이어 마다 5장의 카드를 나누어 줌.
        int randomIndex = 0;
        for(int i = 0; i < userNumber; i++) {
            ArrayList<Card> cards = new ArrayList<Card>(5);
            for(int j = 0; j < 3; j++) { //5장을 뽑는다.
            randomIndex = random.nextInt(cardSet.size());
            cards.add(cardSet.get(randomIndex));//카드셋에서 5장을 뽑는다.
            cardSet.remove(randomIndex); //해당 객체는 삭제
            }
            users[i].cardSet(cards);
        }
    }

    public static void handOutCard() { //카드를 한 장 씩 나누어 줌.
        count++;
        int randomIndex = 0;
        for(int i = 0; i < getNumber(); i++) {
            randomIndex = random.nextInt(cardSet.size());
            users[i].getCard().add(cardSet.get(randomIndex));//카드셋에서 1장을 뽑아 플레이어에게 전달.
            cardSet.remove(randomIndex); //해당 객체는 삭제
        }
        for(int i = 0; i < getNumber(); i++) {
            System.out.println(users[i].getName() + ": ");
            for(int j = 2; j <= 2 + getCount(); j++) {
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
