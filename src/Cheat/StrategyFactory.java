package Cheat;

import java.util.Scanner;

/**
 *
 * @author Diego Viteri
 */
public class StrategyFactory {
    
    public static Strategy getStrategy(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice < 1 || choice > 4){
            System.out.println("Choose strategy for player: ");
            System.out.println("1. Human, 2. Mine, 3.Basic, 4. Thinker");
            if (sc.hasNextInt()){
                choice = sc.nextInt();
            } else {
                System.out.println("Try again: ");
                sc.nextLine();
            }
        }
        
        switch (choice){
            case 1:
                return new HumanStrategy();
            case 2:
                return new MyStrategy();
            case 3:
                return new BasicStrategy();
            default:
                return new ThinkerStrategy();
               
        }
    }
    
}
