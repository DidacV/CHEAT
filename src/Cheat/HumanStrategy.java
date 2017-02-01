package Cheat;

import java.util.Scanner;

/**
 *
 * @author Diego Viteri
 */
public class HumanStrategy implements Strategy{
    Scanner sc = new Scanner(System.in);
    
    /**
     * 
     * @param b
     * @param h
     * @return 
     */
    @Override
    public boolean cheat(Bid b, Hand h) {
        // Check if hand holds current rank or next rank
        if (h.countRank(b.getRank()) == 0 && h.countRank(b.getRank().getNext()) == 0)
            // You're only allowed to cheat
            return true;
        
        // If theres one card or more of the current rank
        // Player is allowed to cheat or not to cheat
        int chose = 0;
        while (chose < 1 || chose > 2){
            // Ask if they want to cheat
            System.out.println("Do you want to cheat?");
            System.out.println("1 for yes, 2 for no: ");
            if (sc.hasNextInt()){
                chose = sc.nextInt();
            } else {
                System.out.println("Try again: ");
                sc.nextLine();
            }
        }
        
        if (chose == 1)
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
    public Bid chooseBid(Bid b, Hand h, boolean cheat){
        Scanner sc = new Scanner(System.in);
        Hand newH = new Hand();
        Card.Rank rank = b.getRank();
        if (cheat){
            System.out.println("You're cheating.");
            System.out.println("This is your hand: ");
            System.out.println(h);
            int maxCards = maxBiddingCheatHand(h);
            
            // Let player choose
            while (newH.size() < maxCards){
                // enter the while
                int chosenCard = h.size(); 
                while (chosenCard >= h.size()){
                    
                    System.out.println("This is your hand: ");
                    for (int i = 0; i < h.size(); i++){
                        System.out.println(i + ". " + h.getCards().get(i));
                    }
                    if (newH.size() < 1)
                        System.out.println("Select your first bidding card:");
                    else 
                        System.out.println("Select next card to add: ");
                    
                    
                    if(sc.hasNextInt()){
                        chosenCard = sc.nextInt();
                    }else{
                       System.out.println("Not a number");
                       sc.nextLine();
                    }
                    
                }
                
                // Add
                newH.add(h.getCards().get(chosenCard));
                if (newH.size() == maxCards){
                    if(newH.countRank(b.getRank()) == newH.size() || 
                            newH.countRank(b.getRank().getNext()) == newH.size()){
                        h.add(newH);
                        newH.getCards().clear();
                        System.out.println("Playing this wouldn't be cheating!");
                    }
                }
                h.getCards().remove(chosenCard);
            }
            int d = 0;
            while (d < 1 || d > 2){
                System.out.println("Do you want to say you're playing with 1. " 
                        + b.getRank() + " or 2. " + b.getRank().getNext());
                if (sc.hasNextInt()){
                    d = sc.nextInt();
                } else {
                    System.out.println("Not a number.");
                    sc.nextLine();
                }
            }
            if (d == 1){
                rank = b.getRank();
            } else {
                rank = b.getRank().getNext();
            }
            
            return new Bid(newH, rank);
        }
        
        // If not cheating 
        System.out.println("You're not cheating.");
        int d=0;
        
        if (h.countRank(b.r) > 0 && h.countRank(b.getRank().getNext()) > 0){
            while (d < 1 || d > 2){
                System.out.println("Would you like to play with 1. "
                    + b.getRank() + " or 2. " + b.getRank().getNext());
                if (sc.hasNextInt()){
                    d = sc.nextInt();
                } else{
                    System.out.println("Not a number.");
                    sc.nextLine();
                }
            }
            Hand hToRemove = new Hand();
            if (d == 1){
                // Prepare hand by removing cards not gonna be used
                for (Card c : h){
                    if (!c.getRank().equals(b.getRank()))
                        hToRemove.add(c);
                }
                // Remove
                h.remove(hToRemove);
            } else {
                // Prepare hand by removing cards not gonna be used
                for (Card c : h){
                    if (!c.getRank().equals(b.getRank().getNext()))
                        hToRemove.add(c);
                }
                // Remove
                h.remove(hToRemove);
            }
        } else {
            Hand hToRemove = new Hand();
            // Prepare hand by removing cards not gonna be used
            for (Card c : h){
                if (!c.getRank().equals(b.getRank()) && 
                            !c.getRank().equals(b.getRank().getNext()))
                    hToRemove.add(c);
            }
            // Remove
            h.remove(hToRemove);
        }
        
        System.out.println("This is your playable hand: ");
        System.out.println(h);
        
        int maxCards = maxBiddingNoCheatHand(h, b);
        while (newH.size() < maxCards){
            int chosenCard = h.size(); 
            while (chosenCard >= h.size()){
                System.out.println("Cards left to choose: ");
                for (int i = 0; i < h.size(); i++){
                        System.out.println(i + ". " + h.getCards().get(i));
                    }
                if (newH.size() < 1)
                    System.out.println("Select your first bidding card:");
                else 
                    System.out.println("Select next card to add: ");


                if(sc.hasNextInt()){
                    chosenCard = sc.nextInt();
                    while (chosenCard > h.size() || chosenCard < 0){
                        System.out.println("Try again:");
                        if (sc.hasNextInt())
                            chosenCard = sc.nextInt();
                        else {
                            System.out.println("Not a number!");
                            sc.nextLine();
                        }
                    }
                    //Card c = h.getCards().get(chosenCard);
                }else{
                   System.out.println("Not a number");
                   sc.nextLine();
                }
            }
            newH.add(h.getCards().get(chosenCard));
            if(newH.size() == maxCards){
                h.add(newH);
            }
            Card c = h.remove(chosenCard);
            rank = c.getRank();
        }
        
        return new Bid(newH, rank);
    }
    
    /**
     * 
     * @param h
     * @param b
     * @return 
     */
    @Override
    public boolean callCheat(Hand h, Bid b) {
        System.out.println("Do you want to call cheat? ");
        
        System.out.println("1 for yes, 2 for no: ");
        int chose = 0;
        while (chose < 1 || chose > 2){
            if (sc.hasNextInt()){
                chose = sc.nextInt();
            } else {
                System.out.println("Try again: ");
                sc.nextLine();
            }
        }
        
        if (chose == 1)
            return true;
        
        return false;
    }
    
    /**
     * 
     * @param h
     * @return 
     */
    public int maxBiddingCheatHand(Hand h){
        int maxCards = 0;
        while (maxCards < 1 || maxCards > 4){
            System.out.println("How many cards do you want to play?: ");
            if(sc.hasNextInt()){
                    maxCards = sc.nextInt();
            }else{
               System.out.println("Not a number");
               sc.nextLine();
            }
        }
        return maxCards;
    }
    
    /**
     * 
     * @param h
     * @param b
     * @return 
     */
    public int maxBiddingNoCheatHand(Hand h, Bid b){
        int maxCards = 0;
        while (maxCards < 1 || maxCards > h.countRank(b.getRank()) + h.countRank(b.getRank().getNext())){
            System.out.println("How many cards do you want to play?: ");
            if(sc.hasNextInt()){
                    maxCards = sc.nextInt();
            }else{
               System.out.println("Not a number");
               sc.nextLine();
            }
        }
        return maxCards;
    }
    
}
