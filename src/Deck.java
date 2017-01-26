/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * TODO: Iterator, serializable
 * @author xdn15mcu
 */

// ASSUMING WE ALWAYS USE THE SHUFFLED DECK
public class Deck implements Serializable /*, Iterator<Card>*/{
    static final long serialVersionUID = 101;
    // Contains a list of cards (Linked list of cards)
    private ArrayList<Card> deck = new ArrayList<Card>();
     ArrayList<Card> shuffledDeck = new ArrayList<Card>();
    public Deck(){
        for (int i = 0; i < Card.Suit.values().length; i++){
            for (int j = 0; j < Card.Rank.values().length; j++){
                Card c = new Card(Card.Rank.values()[j], Card.Suit.values()[i]);
                deck.add(c);
            }
        }
        /*********************************************
         * ASSUMING WE ALWAYS USE A SHUFFLED DECK  *
         *********************************************/
        shuffle(); 
    }
    
//    public class OddEvenIterator implements Iterator<Card>{
//        
//        // Getting iterator
//        Iterator it = shuffledDeck.iterator();
//        
//        @Override
//        public Card next(){
//            return null;
//        }
//
//        @Override
//        public boolean hasNext() {
//            while (it.hasNext()){
//                
//            }
//        }
//    }
    
    public Card deal(){
        Card dealtC = shuffledDeck.get(0);
        shuffledDeck.remove(dealtC);
        return dealtC;
    }
    
    public int size(){
        return shuffledDeck.size();
    }
    
    public void newDeck(){
        shuffledDeck.clear();
        for (int i = 0; i < Card.Suit.values().length; i++){
            for (int j = 0; j < Card.Rank.values().length; j++){
                Card c = new Card(Card.Rank.values()[j], Card.Suit.values()[i]);
                shuffledDeck.add(c);
            }
        }
        /*********************************************
         * ASSUMING WE ALWAYS USE A SHUFFLED DECK  *
         *********************************************/
        shuffle();
    }
    
    public ArrayList<Card> shuffle(){
        Random r = new Random();
        int n = deck.size();
        for (int i = 0; i < n; i++){
            int newPos = r.nextInt(deck.size()); // Size changing
            shuffledDeck.add(deck.get(newPos)); // Gets random card
            deck.remove(newPos); // Remove card that's inserted
        }
        return shuffledDeck;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shuffledDeck.size(); i++) {
            sb.append(shuffledDeck.get(i).toString());
        }
        return sb.toString();
    }
}