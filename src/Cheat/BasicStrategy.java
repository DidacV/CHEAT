package Cheat;


import java.util.Random;

/**
 * Basic strategy:
 * 1. Never cheats unless it's required.
 *    If a cheat is required, play single card selected randomly
 * 2. If not cheating, play the maximum n of cards possible of
 *    the lowest rank possible
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
        boolean cheat = false;
        
        // Go through hand
        for (Card c : h){
            // if there's no same rank or next
            Card.Rank playedRank = b.getRank();
            Card.Rank nextRank = playedRank.getNext();
            if (!c.getRank().equals(playedRank) && !c.getRank().equals(nextRank))
                cheat = true;
        }
        
        return cheat;
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
        Random r = new Random();
        Hand newH;
        // check if cheating or not
        if (cheat){
            int rPos = r.nextInt(h.size());
            // if player's cheating single card selected randomly
            Card c = h.getHand().get(rPos);
            newH = new Hand();
            newH.add(c);
        // if not cheating
        } else {
            // max n of cards of lowest rank
            newH = new Hand();
            // Check current rank being played
            for (Card c : h){
                if (b.getRank().equals(c.getRank()))
                    newH.add(c);
            }
            
            // Check next rank
            if (newH.size() == 0){
                for (Card c : h){
                if (b.getRank().equals(c.getRank().getNext()))
                    newH.add(c);
                }
            }
        }
        return new Bid(newH, b.getRank());
        
    }

    /**
     * Call another player a cheat only when certain (based on your hand)
     * @param h
     * @param b
     * @return 
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        // Get value of bid
        int total = b.getCount();
        
        // Go through the hand
        for (Card c : h){
            // if card = the bid's rank
            if (c.getRank().equals(b.getRank()))
                // increase total
                total++;
        }
        
        if (total > 4)
            return true;
        
        return false;
    }
    
    
}
