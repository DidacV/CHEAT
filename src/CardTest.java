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
        Card c = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Card c1 = new Card(Card.Rank.TWO, Card.Suit.DIAMONDS);
        Card c2 = new Card(Card.Rank.THREE, Card.Suit.HEARTS);
        Card c3 = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        
        // Get
        c.getRank();
        c.getSuit();
        System.out.println(c.compareTo(c1));     
    }
}
