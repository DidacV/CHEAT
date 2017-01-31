/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cheat;

import java.util.Scanner;

/**
 *
 * @author Didac
 */
public class HumanStrategy implements Strategy{
    Scanner sc = new Scanner(System.in);
    
    @Override
    public boolean cheat(Bid b, Hand h) {
        // Check if hand holds current rank or next rank
        if (h.countRank(b.getRank()) <= 0)
            // You're only allowed to cheat
            return true;
        
        // if true, ask to cheat or play current or next (not cheat)
        
        // Ask if they want to cheat
        System.out.println("Do you want to cheat?");
        System.out.println("Type y to cheat, any other key to not cheat: ");
        String in = sc.nextLine().toUpperCase();
        //String inU = in.toUpperCase();
        // Check y / yes
        if (in.equals("Y")||in.equals("YES"))
            return true;
        
        return false;
    }

    @Override
    public Bid chooseBid(Bid b, Hand h, boolean cheat) {
        Hand newH = new Hand();
        Card.Rank rank = null;
        // Ask what bid to choose
        boolean chosen = false;
        
        if (cheat){
            // Ask to play the cards other than the current rank or next rank
            
            // Show the cards available to play
            
            
        }
        
        // Otherwise ask to play current or nextRank and how many 
        // Display only current and 
        while (!chosen){
            System.out.println("Your turn to bid.");
            int amount = 0;
            while (amount == 0){
                // Show rank being played and next rank
                System.out.println("Current rank being played: ");
                System.out.println(b.getRank());
                // Show current hand
                System.out.println("This is your hand: ");
                System.out.println(h);
                System.out.println("Choose how many do you want to play (More than 0): ");
                amount = sc.nextInt();
                
                // Needed so the next input is registered
                sc.nextLine(); 
            }
            
            System.out.println("Choose the rank.");
            System.out.println("two, three, four, etc..");
            String rIn = sc.nextLine().toUpperCase();
            
            // Check if the bid is in the hand
            // Check if rank exists
            try {
                rank = Card.Rank.valueOf(rIn);
            } catch ( IllegalArgumentException e ) {
                System.out.println("No such rank, try a different one. ");
            }
            
            if (h.countRank(rank) >= amount && rank != null)
                    chosen = true;
            else
                System.out.println("Not enough cards for the amount given. ");

            if (chosen){
                // Create array of cards with the rank
                for (int i = 0; i < h.size(); i++){
                    Card c = h.getCards().get(i);
                    if (c.getRank().equals(rank))
                        newH.add(c);
                }
            }
        }
        
            
        // Show "You're playing.. no of cards + rank
        System.out.println("You're playing: ");
        System.out.println(newH);
        
        // Remove played bid from hand
        h.remove(newH);
        return new Bid(newH, rank);
    }

        
        

    @Override
    public boolean callCheat(Hand h, Bid b) {
        // Ask whether to call cheat
        return false;
    }
    
}
