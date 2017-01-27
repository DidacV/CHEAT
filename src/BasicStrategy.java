
import java.util.Random;

/**
 * Basic strategy:
 * 1. Never cheats unless it's required.
 *    If a cheat is required, play single card selected randomly
 * 2. If not cheating, play the maximum n of cards possible of
 *    the lowest rank possible
 * 3. Call another player a cheat only when certain (based on your hand)
 * @author Didac
 */
public class BasicStrategy implements Strategy{
    public BasicStrategy(){
        
    }
    
    /**
     * Decides on whether to cheat or not	
     * @param b   the bid this player has to follow (i.e the 
     * bid prior to this players turn. 
     * @param h	  The players current hand	
     * @return true if the player will cheat, false if not
     */
    @Override
    public boolean cheat(Bid b, Hand h) {
        boolean cheating = true;
        Random r = new Random();
        // Select random card
        int c = r.nextInt();
        // Get cards in hand of the lowest rank
        if (!cheating){
            // get lowest rank of this hand
            h.sortAscending();
            
        }
        return false;
    }

    /**
     * 
     * @param b
     * @param h
     * @param cheat
     * @return 
     */
    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param h
     * @param b
     * @return 
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
