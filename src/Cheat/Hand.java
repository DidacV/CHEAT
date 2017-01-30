package Cheat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * TODO : ITERATOR
 * @author xdn15mcu
 */
public class Hand implements Serializable, Iterable<Card>{
    static final long serialVersionUID = 102;
    private ArrayList<Card> cards = null;
    //private final Iterator<Card> iterator = cards.iterator();
    private final int[] histogram = new int[17];
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
        
        update();
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
        
        update();
    }
    
    /**
     * Adds a single card to this hand
     * @param c 
     */
    public void add(Card c){
        this.cards.add(c);
        update();
    }
    
    /**
     * Adds a list of cards to this hand
     * @param c 
     */
    public void add(Collection<Card> c){
        for (Card card : c){
            this.cards.add(card);
        }
        
        update();
    }
    
    /**
     * Adds the cards of a given hand to this hand
     * @param h 
     */
    public void add(Hand h){
        
        for (Card c : h.cards){
            this.add(c);
        }

        update();
    }
    
    /**
     * Removes a given card from the hand
     * @param c
     * @return true if the card given has been removed
     *         false otherwise
     */
    public boolean remove(Card c){
        Iterator<Card> it = cards.iterator();
        
        while(it.hasNext()){
            Card iterC = it.next();
            
            if(c.equals(iterC))
                it.remove();
            
        }
        
        update();
        return true;
    }
    
    /**
     * Remove all cards from the hand passed
     * @param h
     * @return true if all cards were removed
     *         false otherwise
     */
    public boolean remove(Hand h){
        h.cards.clear();
        return h.cards.isEmpty();
    }
    
    /**
     * Removes a card at a specific position in the hand
     * @param index 
     */
    public Card remove(int index){
        Card card = this.cards.get(index);
        this.cards.remove(card);
        
        update();
        
        return card;
    }
    
    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
    
    /**
     * Sorts hand into ascending order
     * It uses Card compareTo
     */
    public void sortAscending(){
        Collections.sort(cards, new Comparator<Card>(){
            @Override
            public int compare(Card c, Card c1){
                return c.compareTo(c1);
            }
        });
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
        boolean flag = false;
        for (Card c : this.cards){
            // Compare each card's suit to the first one
            if (c.getSuit() == this.cards.get(0).getSuit())
                flag = true;
            else
                return false;
        }
        return flag;
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
        
        int currentC = this.cards.get(0).getRank().ordinal();
        // Compare
        for (Card c : cards){
            currentC++;
            if (c.getRank().getNext().ordinal() != currentC)
                return false;
        }
        return true;
    }
    
    /**
     * Gets this hand size
     * @return the arrayList size
     */
    public int size(){
        return this.cards.size();
    }
    
    
    public void update(){
        // Update count
        for (Card c : cards){
            histogram[c.rank.ordinal()]++;
            histogram[Card.Rank.values().length + c.suit.ordinal()]++;
            total += c.getRank().value;
        }
    }
    
    public String getHistogram(){
        StringBuilder sb = new StringBuilder();
        Card.Rank[] rank = Card.Rank.values();
        Card.Suit[] suit = Card.Suit.values();
        for (int i = 0; i < rank.length; i++){
            sb.append(rank[i].name()).append("\t\t").append("- ");
            for (int j = 0; j < histogram[i]; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 0; i < suit.length; i++){
            sb.append(suit[i].name()).append("   \t").append("- ");
            for (int j = 0; j < histogram[rank.length + i]; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
//        for (Card.Rank r : Card.Rank.values()){
//            sb.append(r.name());
//            sb.append("*");
//            for (int i = 0; i < histogram.length; i++){
//                
//            }
//        }
        return sb.toString();
    }
    
    public ArrayList<Card> getHand(){
        return this.cards;
    }
    
    /**
     * Displays the cards in the hand
     * @return Cards in the hand
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This hand contains: \n");
        for (Card c : this.cards){
            sb.append(c.toString());
        }
        sb.append("-------------------");
        return sb.toString();
    }
    
}
