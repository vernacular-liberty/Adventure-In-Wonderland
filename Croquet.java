//imports
import java.util.Scanner;

public class Croquet {
    int health;
    int size;
    String flamingo;
    String hedgehog;
    int score;
    Character character;

    public Croquet(Character character){
        this.character = character;
        this.score = 0;
        this.flamingo = "flamingo";
        this.hedgehog = "hedgehog";
        
    }

    /**
     * Changes health status when user plays croquet based on size.
     * @return 
     */
     public void play(){
        System.out.println("The queen demands that you play a game of croquet with her. Answer yes or no.");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        System.out.println(response + "Too bad! You play or you die!!"); 
        sc.close();

        System.out.println("The queen spotted you! She gave you a choice to play or \"OFF WITH YOUR HEAD\".");

        if (size<= 30.0){
            this.character.health -= this.character.health/2;
            System.out.println("You are too small to be a player, so the Queen decided you would be more useful as a ball. After the game your health is: " + health + ".");

        } else if (size >= 100){
            this.character.health -= this.character.health / 8;
            System.out.println("You play a few games. Although, you could use a rest due to your massive size the physical excertion is not too taxing. After the game your health is: " + health + ".");

        } else {
            this.character.health -= this.character.health / 4;
            System.out.println("You play a few games to keep your head. After the games your health is: " + this.character.health + ".");
        }
    }
}