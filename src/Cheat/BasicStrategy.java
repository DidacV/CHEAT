package Cheat;


import java.util.Iterator;
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
    /**
     * Decides on whether to cheat or not	
     * @param b   the bid this player has to follow (i.e the 
     * bid prior to this players turn. 
     * @param h	  The players current hand	
     * @return true if the player will cheat, false if not
     */
    @Override
    public boolean cheat(Bid b, Hand h) {
        Card.Rank playedRank = b.getRank();
        Card.Rank nextRank = playedRank.getNext();
        
        return h.countRank(playedRank) == 0 && h.countRank(nextRank) == 0;
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
        Hand newH = new Hand();
        // check if cheating or not
        if (cheat){
            int rPos = r.nextInt(h.size());
            // if player's cheating single card selected randomly
            Card c = h.remove(rPos);
            newH.add(c);
            return new Bid(newH, b.getRank());
        // if not cheating
        } else {
            // Gets current and next bidding ranks
            Card.Rank biddingRank = b.getRank();
            Card.Rank nextBRank = biddingRank.getNext();
            
            // Set the bidding rank according to what we have
            if (h.countRank(biddingRank) < h.countRank(nextBRank)){
                biddingRank = nextBRank;
            }
            
            // Add cards of either current rank of next rank
            for (Card c : h){
                if (c.getRank().equals(biddingRank))
                    newH.add(c);
            }
            
            h.remove(newH);
            return new Bid(newH, b.getRank());
        }
        
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
        int total = b.getHand().size();
        int cAmount = h.countRank(b.getRank());
        
        total += cAmount;
        return total > 4;
    }
}
