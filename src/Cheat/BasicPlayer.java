package Cheat;
/**
 *
 * @author Diego Viteri
 */
public class BasicPlayer implements Player{
    
    private Hand h;
    private Strategy strat;
    private CardGame game;
    
    /**
     * 
     * @param strat
     * @param cheat 
     */
    public BasicPlayer(Strategy strat, CardGame cheat){
        h = new Hand();
        this.strat = strat;
        this.game = cheat;
    }
    
    /**
     * 
     * @param c 
     */
    @Override
    public void addCard(Card c) {
        this.h.add(c);
    }

    /**
     * 
     * @param h 
     */
    @Override
    public void addHand(Hand h) {
        this.h.add(h);
    }

    /**
     * 
     * @return 
     */
    @Override
    public int cardsLeft() {
        return h.size();
    }

    /**
     * 
     * @param g 
     */
    @Override
    public void setGame(CardGame g) {
        this.game = g;
    }

    /**
     * 
     * @param s 
     */
    @Override
    public void setStrategy(Strategy s) {
        this.strat = s;
    }

    /**
     * 
     * @param b
     * @return 
     */
    @Override
    public Bid playHand(Bid b) {
        return strat.chooseBid(b, h, strat.cheat(b, h));
    }

    /**
     * 
     * @param b
     * @return 
     */
    @Override
    public boolean callCheat(Bid b) {
        return strat.callCheat(h, b);
    }
}
