/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cheat;

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
    public ArrayList<Card> cards = new ArrayList<Card>();
    public Deck(){
        for (int i = 0; i < Card.Suit.values().length; i++){
            for (int j = 0; j < Card.Rank.values().length; j++){
                Card c = new Card(Card.Rank.values()[j], Card.Suit.values()[i]);
                cards.add(c);
            }
        }
    }
    
    public class OddEvenIterator implements Iterator<Card>{
        private final static int flag = 0;
        private final static int i = 0;
        // Getting iterator
        Iterator it = cards.iterator();
        
        @Override
        public Card next(){
            return null;
        }

        @Override
        public boolean hasNext() {
            return !(cards.size() == i);
        }
    }
    
    public Card deal(){
        Card dealtC = cards.get(0);
        cards.remove(dealtC);
        return dealtC;
    }
    
    public int size(){
        return cards.size();
    }
    
    public void newDeck(){
        cards.clear();
        for (int i = 0; i < Card.Suit.values().length; i++){
            for (int j = 0; j < Card.Rank.values().length; j++){
                Card c = new Card(Card.Rank.values()[j], Card.Suit.values()[i]);
                cards.add(c);
            }
        }
    }
    
    public ArrayList<Card> shuffle(){
        Random r = new Random();
        int n = cards.size();
        for (int i = 0; i < n; i++){
            int newPos = r.nextInt(cards.size()); // Size changing
            Card c = cards.get(i);
            cards.remove(i);
            cards.add(newPos, c);
        }
        return cards;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i).toString());
        }
        return sb.toString();
    }
}