//import
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Character{
    String[][] map = new String[5][5];
    String name;
    double size;
    final double originalSize;
    int locationC;
    int locationR;
    Boolean canFly;
    Boolean canWalk;
    double health;
    ArrayList<String> bag;
    Scanner scan;


     /**
     * Constructs a wonderland character.
     * @param name string that stores the characters name.
     * @param locationC the location of the character column on the map.    
     * @param locationR the location of the character row on the map.
     */
    public Character(int locationC, int locationR){
        this.map = new String[][]{{"You have reached the edge of Wonderland. The sky and sea melt together into one grey plain.", "You walk along the beach to find a bottle of pills washed up on the shore.", "You have reached the light house at the endless sea... ", "After a long trek through the mountains you have reached the top of Mont Jubjub! You can see anything from here", "The far castle!"}, 
        {"You have entered the croquet grounds. An intense game is taking place between Tweedledee and Tweedledum.","You have reached the grandest Castle in all the land, the castle of the queen of hearts.", "Court House", "You have reached the royal rose gardens.", "You are at the base of the mountains of division."}, 
        {"You have reached the Mad Hatters house. It appear there is a tea party in session!", "You have reached the duchesses manner.", "You emerge from the woods into a meadow surrounding a small gabled house. You enter the house on the table is a container of pills.", "You enter a grove of massive mushrooms. Your eyes meet those of caterpillar who ignores you and takes a drag of a long hookah.", "Chilled to the bone you hurry on through the woods in the hopes of finding shelter."}, 
        {"Welcome to the dismal mire...","You found a river. Should you drink the water? It could be dangerous...Strange things happen in Wonderland...", "Giant dragonflies swarm through the sky over your head squabbling over potential perches.","The trees around you begin to morph into oversized mushrooms. You are pleased pick some fungi and arrange them into a bouquet. Your stomache growls...", "You sense someone is watching you in the darkness! Move faster"}, 
        {"You cross the water to find a small door.","You reach the edge of a calm pond. Thirsty, you cup the water to your lips only to spit out a mouthful of tears.","","The forrest thicken. A sign points east saying, 'Enter at your own peril!'", "You wander down another one of the Tulgey woods winding purple roads. Will you ever escape?"}};
        
        int s = ThreadLocalRandom.current().nextInt(36, 84 + 1);
        ArrayList<String> bag = new ArrayList<String>(10);
        this.bag = bag;
        this.size = s;
        this.originalSize = s;
        this.locationC = locationC;
        this.locationR = locationR;
        this.canFly = false;
        this.canWalk = true;
        this.health = 50;
        Scanner scan = new Scanner(System.in);
        this.scan = scan;

    }
    public void play(){
        System.out.println("Chose your character!!");
        System.out.println("***********************");

        System.out.println("Enter your characters name: ");
        String name = scan.nextLine();

        this.name = name;
    }

    public String command(){
        System.out.println("***********************");
        String command = "Not command";

        if(this.scan.hasNextLine()){
            command = this.scan.nextLine();

        }
        return command;

    }

    /**
     * Picks up item to call examine and prevents movement
     * @param command string describing the user action
     */
    public void grab(String command){
        int openSpots = 0;

        for(String item: bag){
            if (item == null){
                openSpots ++;
            }
        }
        if (openSpots >= 1){

            if (this.map[this.locationC][this.locationR].contains("pill")){
                this.bag.add("pill");

            } else if (this.map[this.locationC][this.locationR].contains("fungi")){
                this.bag.add("fungi");

            } else{
                System.out.println("You cannot grab that item.");
            }
        } else {
            System.out.println("You are out of space in your bag. Try using the drop function.");
        }
    }

    /**
     * Creates string to describe character.
     * @return string that describes the character.
     */
    public String toString(){
        String fly;

        if (this.canFly){
            fly = "can";
        } else {
            fly = "cannot";
        }
        return this.name + " is " + this.size + " inches tall. " + this.name + " is located at coordinates (" + this.locationR +", " + this.locationC + ") on the map of Wonderland. Currently alice " + fly + " fly. According to the map: " + this.map[this.locationC][this.locationR];
    }

    /**
     * Prints out user inventory.
     */
    public void inventoryToString(){
        int count = 0;

        System.out.println("***********************");
        System.out.println("Inventory: ");

        for (String item : this.bag){
            System.out.println("- " + item);
            count+=1;
        }

        int spaceLeft = 10 - count;

        System.out.println("Spaces left: " + spaceLeft);

    }

    public void healthToString(){

        if (this.health>= 95){
            System.out.println(this.name + "'s health is: " + this.health + " 🔋 ");

        } else if (this.health <= 10){
            System.out.println(this.name + "'s health is: " + this.health + " 🪫 ");

        } else {
            System.out.println(this.name + "'s health is: " + this.health);

        }
    }

    public static void main(String[] args){

    }
}
