/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cheat;

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
            
        protected final int value;
        
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
    
    public static class CompareSuit implements Comparator<Card>{
        @Override
        public int compare(Card c1, Card c2){
            int flag = c1.getSuit().compareTo(c2.getSuit());
            if (flag == 0)
                flag = c1.getRank().compareTo(c2.getRank());
            return flag;
        }
    }
    
    public static class CompareDescending implements Comparator<Card>{
        @Override
        public int compare(Card c1, Card c2){
            int flag = -1 * (c1.rank.ordinal() - c2.rank.ordinal());
            if (flag == 0) {
                flag = c1.suit.ordinal() - c2.suit.ordinal();
            }
//            int flag = 0;
//            flag = c1.getSuit().compareTo(c2.getSuit());
//            if (flag >= 0)
//                flag = c1.getRank().compareTo(c2.getRank());
//          return flag;
            //int flag = -1 * c1.compareTo(c2);
            return flag;
        }
    }
    
    @Override
    public int compareTo (Card card){
          int flag = 0;
          flag = this.getRank().compareTo(card.getRank());
          if (flag == 0)
              flag = this.getSuit().compareTo(card.getSuit());
          
          return flag;
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