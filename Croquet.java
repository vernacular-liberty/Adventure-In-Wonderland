public class Croquet {
    /**
     * Changes health status when user plays croquet based on size.
     */
    public void playCroquet(){
        System.out.println("The queen spotted you! She gave you a choice to play or \"OFF WITH YOUR HEAD\".");

        if (this.size<= 30.0){
            this.health /= 2;
            System.out.println("You are too small to be a player, so the Queen decided you would be more useful as a ball. After the game your health is: " + this.health + ".");

        } else if (this.size >= 100){
            this.health -= this.health / 8;
            System.out.println("You play a few games. Although, you could use a rest due to your massive size the physical excertion is not too taxing. After the game your health is: " + this.health + ".");

        } else {
            this.health -= this.health / 4;
            System.out.println("You play a few games to keep your head. After the games your health is: " + this.health + ".");
        }
    }
}
