/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheat;

import java.io.Serializable;
import java.util.ArrayList;
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
     ArrayList<Card> deck = new ArrayList<Card>();
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
    
    public class OddEvenIterator implements Iterator<Card>{
        private final static int flag = 0;
        private final static int i = 0;
        // Getting iterator
        Iterator it = deck.iterator();
        
        
        
        @Override
        public Card next(){
            return null;
        }

        @Override
        public boolean hasNext() {
            return !(deck.size() == i);
        }
    }
    
    public Card deal(){
        Card dealtC = deck.get(0);
        deck.remove(dealtC);
        return dealtC;
    }
    
    public int size(){
        return deck.size();
    }
    
    public void newDeck(){
        deck.clear();
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
    
    public ArrayList<Card> shuffle(){
        Random r = new Random();
        int n = deck.size();
        for (int i = 0; i < n; i++){
            int newPos = r.nextInt(deck.size()); // Size changing
            Card c = deck.get(i);
            deck.remove(i);
            deck.add(newPos, c);
        }
        return deck;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.size(); i++) {
            sb.append(deck.get(i).toString());
        }
        return sb.toString();
    }
}