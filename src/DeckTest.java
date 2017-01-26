/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheat;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Didac
 */
public class DeckTest {
    public static void main(String[] args){
        Deck d = new Deck();
        Card.CompareDescending cs = new Card.CompareDescending();
        
        d.shuffledDeck.sort(cs);
        
//        Collections.sort(d.shuffledDeck,new Comparator<Card>() {
//            @Override
//            public int compare(Card c1, Card c2) {
//                return c1.compareTo(c2);   //or whatever your sorting algorithm
//            }
//        });
        
        System.out.println(d.toString());
        System.out.println(d.size());
    }
}
