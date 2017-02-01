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
        if (h.countRank(playedRank) == 0 && h.countRank(nextRank) == 0)
            return true;
        
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
        Hand newH = new Hand();
        Random rd = new Random();
        Card.Rank rank;
        
        if(rd.nextInt(4)<2)
            rank = b.getRank();
        else
            rank = b.getRank().getNext();
        
        // check if cheating or not
        if (cheat){
            Random r = new Random();
            Card c = h.remove(r.nextInt(h.getCards().size()));
            // if player's cheating single card selected randomly
            newH.add(c);
            return new Bid(newH, rank);
        }
        
        // Gets current and next bidding ranks
        Card.Rank biddingRank = b.getRank();
        Card.Rank nextBRank = biddingRank.getNext();
        
        // Current Rank
        for (Card c : h){
            Card.Rank cRank = c.getRank();
            if (cRank.equals(biddingRank) && newH.countRank(nextBRank) == 0){
                newH.add(c);
                rank = c.getRank();
            }
            else if (cRank.equals(nextBRank) && newH.countRank(biddingRank)==0){
                newH.add(c);
                rank = c.getRank();
            }
        }
        
        h.remove(newH);
        return new Bid(newH, rank);
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
        int cAmount = h.countRank(b.getRank());
        
        total += cAmount;
        return total > 4;
    }
}
