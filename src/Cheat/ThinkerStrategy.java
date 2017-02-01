package Cheat;

import java.util.Random;

/**
 *
 * @author Diego Viteri
 */
public class ThinkerStrategy implements Strategy{
    
    private Hand pile = new Hand();
    
    /**
     * 
     * @param b
     * @param h
     * @return 
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
        double chance;
        Random r = new Random();
        Card.Rank rBid;
        
        // check if cheating or not
        if (cheat){
            while(newH.size() == 0){
                chance = r.nextInt(h.size());
                Card c = h.getCards().get((int)chance);
                chance = Math.random();
                
                if (c.getRank().ordinal() >= 5 && chance > 0.7 && 
                        !c.getRank().equals(b.getRank()) && 
                        !c.getRank().equals(b.getRank().getNext())){
                    //choose higher ranks
                    newH.add(c);
                    
                } else if (c.getRank().ordinal() < 5 && chance < 0.3 && 
                        !c.getRank().equals(b.getRank()) && 
                        !c.getRank().equals(b.getRank().getNext())){
                    newH.add(c);
                }
            }
            
            chance = r.nextInt(5);
            h.remove(newH);
            
            rBid = b.getRank();
            if (chance >= 2.5){
                rBid = b.getRank().getNext();
            }
            pile.add(newH);
            return new Bid(newH, rBid);
        }
        
        rBid = b.getRank();
        if (h.countRank(rBid) == 0){
            rBid = b.getRank().getNext();
        }
        
        for (Card c : h){
            if(c.getRank().equals(rBid))
                newH.add(c);
        }
        
        pile.add(newH);
        h.remove(newH);
        
        return new Bid(newH, rBid);
    }

    /**
     * 
     * @param h
     * @param b
     * @return 
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        // Get value of bid
        int total = b.getCount();
        int cAmount = h.countRank(b.getRank());
        double prob;
        double chance = Math.random();
        total += cAmount;
        total += pile.countRank(b.getRank());
        
        switch (total){
            case 4:
                prob = 0.22;
                break;
            case 3:
                prob = 0.18;
                break;
            case 2:
                prob = 0.14;
                break;
            default:
                prob = 0.1;
        }
        
        if (chance < 0.04){
            return false;
        } else if (total > 4 || chance < prob){
            return true;
        } else {
            return false;
        }
    }
    
}
