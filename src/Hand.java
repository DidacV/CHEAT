/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * TODO : ITERATOR
 * @author xdn15mcu
 */
public class Hand implements Serializable, Iterable<Card>{
    static final long serialVersionUID = 102;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private Iterator<Card> iterator = hand.iterator();
    private int[][] count = new int[13][4];
    private int total = 0;
    
    public Hand(){
        hand = new ArrayList<Card>();
    }
    
    public Hand(Card[] cards){
        for (int i = 0; i < cards.length; i++){
            hand.add(cards[i]);
        }
        
        // Update count
        for (Card c : hand){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
    
    /**
     * Copies a given hand to this hand
     * @param h 
     */
    public Hand(Hand h){
        for (Card c : h.hand){
            this.hand.add(c);
        }
        
        // Update count
        for (Card c : hand){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
    
    public void add(Card c){
        this.hand.add(c);
        // Update count
        for (Card c1 : hand){
            count[c1.rank.ordinal()][c1.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
    
    public void add(Collection<Card> c){
        for (Card card : c){
            this.hand.add(card);
        }
        
        // Update count
        for (Card c1 : hand){
            count[c1.rank.ordinal()][c1.suit.ordinal()]++;
            // Update total
            total += c1.getRank().value;
        }
    }
    
    public void add(Hand h){
        for (Card c : h.hand){
            this.hand.add(c);
        }
        
        // Update count
        for (Card c1 : hand){
            count[c1.rank.ordinal()][c1.suit.ordinal()]++;
            // Update total
            total += c1.getRank().value;
        }
    }
    
    public boolean remove(Card c){
        for (Card card : this.hand){
            if (c.equals(card))
                this.hand.remove(c);
        }
        
        // Update count
        for (Card c1 : hand){
            count[c1.rank.ordinal()][c1.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
        return false;
    }
    
    public boolean remove(Hand h){
        h.hand.clear();
        
        // Update count
        for (Card c : hand){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
        return false;
    }
    
    public void remove(int index){
        this.hand.remove(index);
        
        // Update count
        for (Card c : hand){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
/* *
    TODO : ITERATOR 
    */
//    @Override
//    public Iterator<Card> iterator() {
//        
//        while (iterator.hasNext()){
//            
//            iterator.next();
//        }
//    }
    
    /**
     * 
     */
    public void sortAscending(){
        Collections.sort(this.hand);
    }
    
    /**
     * 
     */
    public void sortDescending(){
        Card.CompareDescending cs = new Card.CompareDescending();
        this.hand.sort(cs);
    }
    
    /**
     * 
     * @param s
     * @return 
     */
    public int countSuit(Card.Suit s){
        int count = 0;
        for (Card c : this.hand){
            if (c.suit == s)
                count++;
        }
        return count;
    } 
    
    /**
     * 
     * @param r
     * @return 
     */
    public int countRank(Card.Rank r){
        int count = 0;
        for (Card c : this.hand){
            if (c.rank == r)
                count++;
        }
        return count;
    }
    
    /**
     * 
     * @return 
     */
    public int handValue(){
        int total = 0;
        for(Card c : hand){
            total += c.rank.value;
        }
        return total;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This hand contains: ");
        for (Card c : this.hand){
            sb.append(c.toString()).append("\n");
        }
        sb.append("_____________________");
        return sb.toString();
    }
    
    /**
     * 
     * @return 
     */
    public boolean isFlush(){
        for (Card c : this.hand){
            // Compare each card's suit to the first one
            if (c.suit == this.hand.get(0).suit)
                return true;
        }
        return false;
    }
    
    /**
     * Checks if the cards are in consecutive order
     * E.g: 10 Diamonds, 10 Spades, 8 Clubs, 9 Hearts is not a straight
     * but 10 Spades, 8 Clubs, 9 Hearts is
     * @return true if all cards are in consecutive order
     */
    public boolean isStraight(){
        
    }
}
