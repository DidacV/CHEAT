package Cheat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * 
 * @author Diego Viteri
 */
public class Deck implements Serializable, Iterable<Card>{
    static final long serialVersionUID = 101;
    // Contains a list of cards (Linked list of cards)
    private ArrayList<Card> cards;
    
    public Deck(){
        cards = new ArrayList<Card>();
        for (int i = 0; i < Card.Suit.values().length; i++){
            for (int j = 0; j < Card.Rank.values().length; j++){
                Card c = new Card(Card.Rank.values()[j], Card.Suit.values()[i]);
                cards.add(c);
            }
        }
    }
    
    @Override
    public Iterator<Card> iterator(){
        //return cards.iterator();
        return new Iterator<Card>(){
            private int i = 0;
            
            @Override
            public boolean hasNext() {
                return (i != cards.size());
            }

            @Override
            public Card next() {
                return (cards.get(i++));
            }
            
            @Override
            public void remove() {
                cards.remove(i);
            }
        };
    }
    
    /**
     * 
     */
    public class OddEvenIterator implements Iterator<Card>{
        private int index = 0;
        private int last = cards.size();
        private boolean odds = true;
        
        @Override
        public Card next(){
            Card c = cards.get(index);
            index += 2;
            if (!hasNext() && odds){
                index = 1;
                odds = false;
            }
            return c;
        }

        @Override
        public boolean hasNext() {
            return index + 2 < last;
        }
    }
    
    /**
     * 
     * @return 
     */
    public Card deal(){
        Card dealtC = cards.remove(0);
        return dealtC;
    }
    
    /**
     * 
     * @return 
     */
    public int size(){
        return cards.size();
    }
    
    /**
     * 
     */
    public void newDeck(){
        cards.clear();
        for (int i = 0; i < Card.Suit.values().length; i++){
            for (int j = 0; j < Card.Rank.values().length; j++){
                Card c = new Card(Card.Rank.values()[j], Card.Suit.values()[i]);
                cards.add(c);
            }
        }
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Card> shuffle(){
        Random r = new Random();
        int n = cards.size();
        for (int i = 0; i < n; i++){
            int newPos = r.nextInt(cards.size()); // Size changing
            Card c = cards.remove(i);
            cards.add(newPos, c);
        }
        return cards;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Card> getCards(){
        return this.cards;
    }
    
    /**
     * 
     * @param out
     * @throws IOException 
     */
    private void writeObject(ObjectOutputStream out) throws IOException{
        OddEvenIterator iterator = new OddEvenIterator();
        Iterator<Card> it = iterator;
        
        ArrayList<Card> s = new ArrayList<Card>();
        while(it.hasNext()){
            Card c = it.next();
            s.add(c);
        }
        out.writeObject(s);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i).toString());
        }
        return sb.toString();
    }
}