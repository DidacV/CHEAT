/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheat;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author xdn15mcu
 */
public class Card implements Serializable, Comparable<Card>{
    
    static final long serialVersionUID = 100;
    public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
            EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
            
        private final int value;
        
        private Rank(int value){
            this.value = value;
        }
        
        public Rank getNext(Rank currentRank){
            if (this.ordinal() < Rank.values().length - 1)
                return Rank.values()[currentRank.ordinal() + 1];
            else
                return Rank.values()[0];
        }
        
    }
    
    Rank rank;
    Suit suit;
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    public Rank getRank(){
        return this.rank;
    }
    
    public Suit getSuit(){
        return this.suit;
    }
    
    public static int difference(Card card1, Card card2){
        // Gets the difference between card ranks
        return card1.getRank().ordinal() - card2.getRank().ordinal();
    }
    
    public static int differenceValue(Card card1, Card card2){
        return card1.getRank().value - card2.getRank().value;
    }
    
    public static class CompareDescending implements Comparator<Card>{
        @Override
        public int compare(Card card1, Card card2){
            CompareSuit cs = new CompareSuit();
            return cs.compare(card1, card2);
            //return card1.getRank().ordinal() - card2.getRank().ordinal();
        }
        public static class CompareSuit implements Comparator<Card>{
            @Override
            public int compare(Card card1, Card card2){
                return card1.getSuit().ordinal() - card2.getRank().ordinal();
            }
        }
    }
    
    @Override
    public int compareTo (Card card){
        CompareDescending cd = new CompareDescending();
        cd.
        cd.compare(this, card);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This card is the: ");
        sb.append(this.rank.toString() + " " +this.suit.toString());
        sb.append(("\n"));
        return sb.toString();
    }
}
