/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cheat;
import java.util.Comparator;

/**
 *
 * @author Didac
 */
public class DeckTest {
    public static void main(String[] args){
        Deck d = new Deck();
        Card.CompareDescending cs = new Card.CompareDescending();
        
        d.deck.sort(cs);
        System.out.println(d.toString());
//        Card c = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
//        Card c2 = new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS);
//        
//        Card[] cards = new Card[2];
//        cards[0] = c;
//        cards[1] = c2;
//        
//        
//        Hand h = new Hand(cards);
        
        //h.add(c);
        //h.add(c2);
        
        //d.shuffledDeck.sort(cs);
        
//        Collections.sort(d.shuffledDeck,new Comparator<Card>() {
//            @Override
//            public int compare(Card c1, Card c2) {
//                return c1.compareTo(c2);   //or whatever your sorting algorithm
//            }
//        });
        
        //System.out.println(d.toString());
        //System.out.println(d.size());
    }
}
