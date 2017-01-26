/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheat;
/**
 *
 * @author xdn15mcu
 */
public class CardTest {
    public static void main(String[] args) {
        // Constructor
//        Card c = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
//        Card c1 = new Card(Card.Rank.TWO, Card.Suit.DIAMONDS);
//        Card c2 = new Card(Card.Rank.THREE, Card.Suit.HEARTS);
//        Card c3 = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
//        
        // Get
//        c.getRank();
//        c.getSuit();
//        Card.CompareDescending cd = new Card.CompareDescending();
//        System.out.println(cd.compare(c1, c2));
//        System.out.println(c1.compareTo(c2));
//        System.out.println(cd.compare(c3, c2));
//        System.out.println(c3.compareTo(c2));     
//        System.out.println(c2.compareTo(c2)); 
//        System.out.println(cd.compare(c2, c2));


        Deck d = new Deck();
        //System.out.println(d.toString());
        d.shuffle();
        System.out.println(d.toString());
    }
}
