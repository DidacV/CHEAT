package cheat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * TODO : ITERATOR
 * @author xdn15mcu
 */
public class Hand implements Serializable, Iterable<Card>{
    static final long serialVersionUID = 102;
    protected ArrayList<Card> cards = null;
    private final Iterator<Card> iterator = cards.iterator();
    private final int[][] count = new int[13][4];
    private int total = 0;
    
    public Hand(){
        cards = new ArrayList<Card>();
    }
    
    /**
     * Constructs this hand with an array of given cards
     * @param cards 
     */
    public Hand(Card[] cards){
        for (int i = 0; i < cards.length; i++){
            this.cards.add(cards[i]);
        }
        
        // Update count
        for (Card c : cards){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
    
    /**
     * Constructs this hand copying the cards
     * of a given hand to this hand
     * @param h 
     */
    public Hand(Hand h){
        for (Card c : h.cards){
            this.cards.add(c);
        }
        
        // Update count
        for (Card c : cards){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
    
    /**
     * Adds a single card to this hand
     * @param c 
     */
    public void add(Card c){
        this.cards.add(c);
        // Update count
        for (Card card : cards){
            count[card.rank.ordinal()][card.suit.ordinal()]++;
            // Update total
            total += card.getRank().value;
        }
    }
    
    /**
     * Adds a list of cards to this hand
     * @param c 
     */
    public void add(Collection<Card> c){
        for (Card card : c){
            this.cards.add(card);
        }
        
        // Update count
        for (Card c1 : cards){
            count[c1.rank.ordinal()][c1.suit.ordinal()]++;
            // Update total
            total += c1.getRank().value;
        }
    }
    
    /**
     * Adds the cards of a given hand to this hand
     * @param h 
     */
    public void add(Hand h){
        for (Card c : h.cards){
            this.cards.add(c);
        }
        
        // Update count
        for (Card c : cards){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
    
    /**
     * Removes a given card from the hand
     * @param c
     * @return true if the card given has been removed
     *         false otherwise
     */
    public boolean remove(Card c){
        for (Card card : this.cards){
            if (!c.equals(card)) return false;
            else this.cards.remove(c);
        }
        
        // Update count
        for (Card card : cards){
            count[card.rank.ordinal()][card.suit.ordinal()]++;
            // Update total
            total += card.getRank().value;
        }
        return true;
    }
    
    /**
     * Remove all cards from the hand passed
     * @param h
     * @return true if all cards were removed
     *         false otherwise
     */
    public boolean remove(Hand h){
        boolean removed = false;
        // See which cards are the same between hands
        for (Card c1 : h){
            for (Card c2 : this){
                if (c1.compareTo(c2) == 0){
                    // remove
                    h.remove(c1);
                    removed = true;
                }
            }
        }
        return removed;
    }
    
    /**
     * Removes a card at a specific position in the hand
     * @param index 
     */
    public void remove(int index){
        this.cards.remove(index);
        
        // Update count
        for (Card c : cards){
            count[c.rank.ordinal()][c.suit.ordinal()]++;
            // Update total
            total += c.getRank().value;
        }
    }
/* *
    TODO : ITERATOR 
    */
    @Override
    public Iterator<Card> iterator() {
        
        while (iterator.hasNext()){
            
            iterator.next();
        }
        return iterator;
    }
    
    /**
     * Sorts hand into ascending order
     * It uses Card compareTo
     */
    public void sortAscending(){
        Collections.sort(this.cards);
    }
    
    /**
     * Sorts hand into descending order
     * It uses Card compareTo
     */
    public void sortDescending(){
        Card.CompareDescending cs = new Card.CompareDescending();
        this.cards.sort(cs);
    }
    
    /**
     * Counts the amount of cards with the same given suit
     * @param s
     * @return Amount of cards in hand of given suit
     */
    public int countSuit(Card.Suit s){
        int count = 0;
        for (Card c : this.cards){
            if (c.suit == s)
                count++;
        }
        return count;
    } 
    
    /**
     * Counts the amount of cards with the same given rank
     * @param r
     * @return Amount of cards in hand of given rank
     */
    public int countRank(Card.Rank r){
        int count = 0;
        for (Card c : this.cards){
            if (c.rank == r)
                count++;
        }
        return count;
    }
    
    /**
     * Adds the ranks of the cards in the hand
     * @return Total rank values of the cards
     */
    public int handValue(){
        int total = 0;
        for(Card c : cards){
            total += c.rank.value;
        }
        return total;
    }

    /**
     * Check to see if the hand is the same suit
     * @return true if it's flush
     */
    public boolean isFlush(){
        for (Card c : this.cards){
            // Compare each card's suit to the first one
            if (c.suit == this.cards.get(0).suit)
                return true;
        }
        return false;
    }
    
    /**
     * Checks if the cards are in consecutive order
     * E.g: 10 Diamonds, 10 Spades, 8 Clubs, 9 Hearts is not a straight
     * but 10 Spades, 8 Clubs, 9 Hearts is
     * @return true if all cards are in consecutive order
     */
    public boolean isStraight(){
        // put them in ascending order
        this.sortAscending();
        // check if there are duplicates
        
        // if there aren't and they are consecutive return true
        for (Card c : this.cards){
            // This will avoid duplicates
            Card.Rank nextRank = c.rank.getNext(c.rank);
            if (c.rank.equals(nextRank)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Displays the cards in the hand
     * @return Cards in the hand
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This hand contains: ");
        for (Card c : this.cards){
            sb.append(c.toString()).append("\n");
        }
        sb.append("_____________________");
        return sb.toString();
    }
    
}
