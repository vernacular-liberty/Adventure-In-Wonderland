//import
import java.util.concurrent.ThreadLocalRandom;

public class Character {
    String[][] map = new String[5][5];
    String name;
    double size;
    final double originalSize;
    int locationC;
    int locationR;
    Boolean canFly;
    Boolean canWalk;
    double health;
    Boolean hasPill;
    Boolean hasFungi;
    Bag bag;

     /**
     * Constructs a wonderland character.
     * @param name string that stores the characters name.
     * @param locationC the location of the character column on the map.    
     * @param locationR the location of the character row on the map.
     */
    public Character(String n, int locationC, int locationR){
        this.map = new String[][]{{"You have reached the edge of Wonderland. The sky and sea melt together into one grey plain.", "You walk along the beach to find a bottle of pills washed up on the shore.", "You have reached the light house at the endless sea... ", "After a long treck throught the mountains you have reached the top of Mont Jubjub! You can see anything from here", "The far castle!"}, 
        {"You have entered the croquet grounds. An intense game is taking place between Tweedledee and Tweedledum.","You have reached the grandest Castle in all the land, the castle of the queen of hearts.", "Court House", "You have reached the royal rose gardens.", "You are at the base of the mountains of division."}, 
        {"You have reached the Mad Hatters house. It appear there is a tea party in session!", "You have reached the duchesses manner.", "You emerge from the woods into a meadow surrounding a small gabled house. You enter the house on the table is a container of pills.", "You enter a grove of massive mushrooms. Your eyes meet those of caterpillar who ignores you and takes a drag of a long hookah.", "Chilled to the bone you hurry on through the woods in the hopes of finding shelter."}, 
        {"Welcome to the dismal mire...","You found a river. Should you drink the water? It could be dangerous...Strange things happen in Wonderland...", "Giant dragonflies swarm through the sky over your head squabling over potential perches.","The trees around you begin to morph into oversized mushrooms. You are pleased pick some fungi and arrange them into a bouquet. Your stomache growls...", "You sense someone is watching you in the darkness! Move faster"}, 
        {"You cross the water to find a small door.","You reach the edge of a calm pond. Thirsty, you cup the water to your lips only to spit out a mouthful of tears.","","The forrest thicken. A sign points east saying, 'Enter at your own peril!'", "You wander down another one of the Tulgey woods winding purple roads. Will you ever escape?"}};
        
        int s = ThreadLocalRandom.current().nextInt(36, 84 + 1);

        this.name = n;
        this.size = s;
        this.originalSize = s;
        this.locationC = locationC;
        this.locationR = locationR;
        this.canFly = false;
        this.canWalk = true;
        this.health = 50;
        this.hasPill = false;
        this.hasFungi = false;
        this.bag = new Bag();

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
}
