/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author xdn15mcu
 */
public class Hand implements Serializable{
    static final long serialVersionUID = 102;
    private ArrayList<Card> hand;
    private int[][] count;
    
    public Hand(){
        hand = new ArrayList<Card>();
    }
    
    public Hand(Card[] cards){
        for (Card c : cards){
            hand.add(c);
        }
    }
    
    /**
     * This constructor will copy the given hand and copy it to this hand
     * @param h 
     */
    public Hand(Hand h){
        for (Card c : h.hand){
            this.hand.add(c);
        }
        
    }
    
    public void add(Card c){
        this.hand.add(c);
    }
    
    public void add(Collection<Card> c){
        for (Card card : c){
            this.hand.add(card);
        }
    }
    
    public void add(Hand h){
        for (Card c : h.hand){
            this.hand.add(c);
        }
    }
    
    public void remove(Card c){
        for (Card card : this.hand){
            if (c.equals(card))
                this.hand.remove(c);
        }
    }
    
    public void remove(Hand h){
        h.hand.clear();
    }
    
    public void remove(int index){
        this.hand.remove(index);
    }
    
}
