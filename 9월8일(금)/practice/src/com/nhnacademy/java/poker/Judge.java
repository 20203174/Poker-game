package com.nhnacademy.java.poker;

import java.util.ArrayList;

public class Judge {
    private static int[] userRankNumber = new int[5];

    public static User whoIsWinner(int number, User[] users) {
        int tmp = 0;
        for(int i = 0; i < number; i++) {
            for(int j = 1; j < number; j++){
                if(ranking(isPair(users[i].getCard())) <= ranking(isPair(users[j].getCard()))){
                    tmp = i;
                }
            }
        }
        return users[tmp];
    }

    public static int ranking(int[] pair) {
        for(int i = 0; i < 5; i++) {
            if(pair[i] == 1){
                for(int j = i; j < 5; j++) {
                    if(pair[j] == 1) return 1;//1. twopair
                    else return 2;//onepair
                }
            }
        }
        return 3;//nothing
    }

    public static int[] isPair(ArrayList<Card> cards) {
        int pair[] = {0, 0, 0, 0, 0, 0, 0, 0};
        for(int i = cards.size()-1; i >= 0; i--) {
            for(int j = cards.size()-1; j >= 0; j--) {
                if(isSameRank(cards.get(i),cards.get(j))){
                    pair[i] += 1;
                }
            }
        }
        return pair;
    }


    private static int pairNumber(ArrayList<Card> cards) {
        int count = 1;
        for(int i = 0; i < cards.size(); i++) {
            int tmp = 1;
            for(int j = 1; j < cards.size(); j++){
                if(isSameRank(cards.get(i), cards.get(j))){
                    // newCards.add(compareSuit(cards.get(i), cards.get(j)));
                    tmp ++;
                    if(count < tmp) count = tmp;
                }
            }
        }
        return count;
    }

    public static Boolean isSameRank(Card cardA, Card cardB) {
        if(cardA.getRank().equals(cardB.getRank())){
            return true;
        }
        return false;
    }
    
    public static Card compareSuit(Card cardA, Card cardB) {
        if(cardA.getSuit().compareTo(cardB.getSuit()) >= 0){ //cardA가 크면 양수, cardB가 크면 음수
            return cardA;
        }
        else{
            return cardB;
        }
    }

}
