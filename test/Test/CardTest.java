package Test;
import Cheat.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.junit.*;

/**
 *
 * @author Didac
 */
public class CardTest {
    
    private Card c;
    private Card c1;
    private Card c2;
    private Card c3;
    //private ArrayList<Card> cardArr = new ArrayList<Card>();
    private Card.CompareDescending cd;
    
    @Before
    public void createCard(){
        c = new Card(Card.Rank.TEN, Card.Suit.CLUBS);
        c1 = new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS);
//        c = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
//        c1 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
//        c2 = new Card(Card.Rank.TWO, Card.Suit.CLUBS);
//        c3 = new Card(Card.Rank.SIX, Card.Suit.HEARTS);
//        cardArr.add(c);
//        cardArr.add(c1);
//        cardArr.add(c2);
//        cardArr.add(c3);
        //cd = new Card.CompareDescending();
    }
    
    @Test
    public void getRank(){
        //System.out.println(c.getRank());
    }
    
    @Test
    public void getSuit(){
        //System.out.println(c.getSuit());
    }
    
    @Test
    public void difference(){
       //System.out.println(c.difference(c, c1));
    }
    
    @Test
    public void differenceValue(){
        System.out.println(c.differenceValue(c, c1));
    }
    
    @Test
    public void compareDes(){
//        System.out.println("Compare descending: ");
//        Collections.sort(cardArr, cd);
//        System.out.println(cardArr);
    }
    
    @Test
    public void compareAsc(){
//        System.out.println("Compare ascending: ");
//        
//        Collections.sort(cardArr,new Comparator<Card>() {
//            @Override
//            public int compare(Card c, Card c1) {
//                return c.compareTo(c1);   
//            }
//        });
//        
//        System.out.println(cardArr);
    }
}
