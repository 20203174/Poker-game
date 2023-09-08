package com.nhnacademy.java.poker;

//need card 52 
public class Card implements Comparable<Card>{
    
    private Suit suit;
    private Rank rank;


    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void cardOpen() {
        System.out.println("[" + suit + ", " + rank + "]");
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }



    @Override
    public int compareTo(Card card) {
        // if(this.getRank().compareTo(card.getRank()) == 0){
        //     if(this.getSuit().compareTo(card.getSuit()) == 0)return 0;
        //     else{
        //         if(this.get)
        //     }
        // }
        int rank = this.getRank().compareTo(card.getRank());
        int suit = this.getSuit().compareTo(card.getSuit());

        if(rank == 0 && suit == 0)return 0;
        if(rank < 0 || (rank == 0 && suit < 0))return -1;
        
        return 1;
    }


}

