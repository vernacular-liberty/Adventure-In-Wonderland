//imports
import java.util.Arrays;
import java.util.List;

public class Croquet {
    /**
     * Changes health status when user plays croquet based on size.
     * @return 
     */

     public List<Double> play(double size, double health){
        System.out.println("The queen spotted you! She gave you a choice to play or \"OFF WITH YOUR HEAD\".");

        if (size<= 30.0){
            health -= health/2;
            System.out.println("You are too small to be a player, so the Queen decided you would be more useful as a ball. After the game your health is: " + health + ".");

        } else if (size >= 100){
            health -= health / 8;
            System.out.println("You play a few games. Although, you could use a rest due to your massive size the physical excertion is not too taxing. After the game your health is: " + health + ".");

        } else {
            health -= health / 4;
            System.out.println("You play a few games to keep your head. After the games your health is: " + health + ".");
        }

        return Arrays.asList(size, health);
    }
}
