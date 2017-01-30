package Cheat;
/**
 *
 * @author Didac
 */
public class BasicPlayer implements Player{
    
    Hand h;
    Strategy strat;
    CardGame game;
    
    public BasicPlayer(BasicStrategy strat, BasicCheat cheat){
        h = new Hand();
        this.strat = strat;
        this.game = cheat;
    }

    @Override
    public void addCard(Card c) {
        this.h.add(c);
    }

    @Override
    public void addHand(Hand h) {
        this.h.add(h);
    }

    @Override
    public int cardsLeft() {
        return h.size();
    }

    @Override
    public void setGame(CardGame g) {
        this.game = g;
    }

    @Override
    public void setStrategy(Strategy s) {
        this.strat = s;
    }

    @Override
    public Bid playHand(Bid b) {
        return strat.chooseBid(b, h, strat.cheat(b, h));
    }

    @Override
    public boolean callCheat(Bid b) {
        return strat.callCheat(h, b);
    }
}
