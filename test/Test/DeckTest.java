package Test;
import Cheat.Deck;
import org.junit.*;
/**
 *
 * @author Didac
 */
public class DeckTest {
    private Deck deck;
    
    @Before
    public void createDeck(){
        deck = new Deck();
    }
    
    @Test
    public void deal(){
        System.out.println(deck.getCards().get(0));
        deck.deal();
        System.out.println(deck.getCards().get(0));
//        deck.deal();
//        System.out.println("after dealing: ");  
//        System.out.println(deck.cards.get(0));
    }
    
    @Test
    public void shuffle(){
//        System.out.println("Before shuffling");
//        System.out.println(deck);
//        System.out.println("After shuffling");
//        deck.shuffle();
//        System.out.println(deck);
    } 
    
}
