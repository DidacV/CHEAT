package Test;
import Cheat.Card;
import Cheat.Hand;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
/**
 *
 * @author Didac
 */
public class HandTest {
    private Hand hand;
    private Hand hand2;
    Card c;
    Card c1;
    Card c2;
    Card c3;
    private ArrayList<Card> cardArr = new ArrayList<Card>();

    @Before
    public void createHand(){
        c = new Card(Card.Rank.EIGHT, Card.Suit.CLUBS);
        c1 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        c2 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        c3 = new Card(Card.Rank.NINE, Card.Suit.HEARTS);
        cardArr.add(c);
        cardArr.add(c1);
        cardArr.add(c2);
        cardArr.add(c3);
        hand = new Hand();
        hand2 = new Hand();
        hand.add(cardArr);
        hand2.add(cardArr);
    }
    
    @Test
    public void testCountTotal(){
        System.out.println("HISTOGRAM:");
        System.out.println(hand.getHistogram());
    }
    
    @Test
    public void sortAscending(){
        System.out.println("ASCENDING:");
        hand.sortAscending();
        System.out.println(hand);
    }
    
    @Test
    public void sortDescending(){
        System.out.println("DESCENDING:");
        hand.sortDescending();
        System.out.println(hand);
    }
    
    @Test
    public void countSuit(){
        System.out.println("Counting Suit:");
        System.out.println(hand.countSuit(Card.Suit.CLUBS));
    }
    
    @Test
    public void countRank(){
        System.out.println("Counting Rank:");
        System.out.println(hand.countRank(Card.Rank.TEN));
    }
    
    @Test
    public void isStraight(){
        System.out.println("Checking if is straight:");
        System.out.println(hand.isStraight());
    }
    
    @Test
    public void isFlush(){
        System.out.println("Checking if it's flush:");
        System.out.println(hand.isFlush());
    }
    
    @Test
    public void handValue(){
        System.out.println("Getting total rank value:");
        System.out.println(hand.handValue());
    }
    
    @Test
    public void removeHand(){
//        System.out.println("Removing hand:");
//        System.out.println(hand.remove(hand));
    }
    
    @Test
    public void removeCard(){
//        System.out.println("Remove card:");
//        System.out.println(hand.remove(c));
//        System.out.println(hand);
    }
    
    @Test
    public void removeAtIndex(){
        System.out.println("Remove at index");
        System.out.println(hand.remove(0));
        System.out.println(hand);
    }
    
    @Test
    public void addHand(){
//        System.out.println("Adding a hand:");
//        hand.add(hand2);
//        System.out.println(hand);
    }
    
    @Test
    public void addCardsCollection(){
        System.out.println("Adding Collection:");
        hand.add(cardArr);
        System.out.println(hand);
    }
    
    @Test
    public void printHand(){
        System.out.println(hand);
    }
}
