//imports
import java.util.Scanner;
import java.util.Random;

public class Wonderland{
    String[][] map = new String[5][5];
    private Croquet croquet;
    private FungiForrest fungiForrest;
    private RabbitHole rabbitHole;
    private MarchManner marchManner;
    private TugleyWoods tugleyWoods;
    Character character;


    public Wonderland(Character character){
        this.map = new String[][]{{"You have reached the edge of Wonderland. The sky and sea melt together into one grey plain.", "You walk along the beach to find a bottle of pills washed up on the shore.", "You have reached the light house at the endless sea... ", "After a long treck throught the mountains you have reached the top of Mont Jubjub! You can see anything from here", "The far castle!"}, 
        {"You have entered the croquet grounds. An intense game is taking place between Tweedledee and Tweedledum.","You have reached the grandest Castle in all the land, the castle of the queen of hearts.", "Court House", "You have reached the royal rose gardens.", "You are at the base of the mountains of division."}, 
        {"You have reached the Mad Hatters house. It appear there is a tea party in session!", "You have reached the duchesses manner.", "You emerge from the woods into a meadow surrounding a small gabled house. You enter the house on the table is a container of pills.", "You enter a grove of massive mushrooms. Your eyes meet those of caterpillar who ignores you and takes a drag of a long hookah.", "Chilled to the bone you hurry on through the woods in the hopes of finding shelter."}, 
        {"Welcome to the dismal mire...","You found a river. Should you drink the water? It could be dangerous...Strange things happen in Wonderland...", "Giant dragonflies swarm through the sky over your head squabling over potential perches.","The trees around you begin to morph into oversized mushrooms. You are pleased pick some fungi and arrange them into a bouquet. Your stomache growls...", "You sense someone is watching you in the darkness! Move faster"}, 
        {"You cross the water to find a small door.","You reach the edge of a calm pond. Thirsty, you cup the water to your lips only to spit out a mouthful of tears.","","The forrest thicken. A sign points east saying, 'Enter at your own peril!'", "You wander down another one of the Tulgey woods winding purple roads. Will you ever escape?"}};
        
        this.character = character;
        this.croquet = new Croquet();
        this.fungiForrest = new FungiForrest();
        this.marchManner = new MarchManner();
        this.tugleyWoods = new TugleyWoods();
        this.rabbitHole = new RabbitHole(this.character);

    }

    /**
     * Plays the rabbitHole sequence
     */
    public void start(){
        this.rabbitHole.play();
    }
    
    public void investigate(){
        if (this.map[this.character.locationC][this.character.locationR].contains("pill")){
            System.out.println("You can use grab(\"pill\") to learn more.");

        } if (this.map[this.character.locationC][this.character.locationR].contains("fungi")){
            System.out.println("You can use grab(\"fungi\") to learn more.");

        } if (this.map[this.character.locationC][this.character.locationR].contains("water")){
            System.out.println("You can use use(\"water\") to learn more.");

        } if (this.map[this.character.locationC][this.character.locationR].contains("door")){
            System.out.println("You can use use(\"door\") to learn more.");    

        } if (this.map[this.character.locationC][this.character.locationR].contains("croquet")){
            System.out.println("Play Croquet");
            this.croquet.play(this.character.size, this.character.health);

        } if (this.map[this.character.locationC][this.character.locationR].contains("caterpillar")){
            this.fungiForrest.conversation();
            System.out.println("Caterpillar Conversation");

        } if (this.map[this.character.locationC][this.character.locationR].contains("Tugley woods")){
            this.tugleyWoods.play();
            System.out.println("Tugley Woods");

        } if (this.map[this.character.locationC][this.character.locationR].contains("gabeled")){
            this.marchManner.play();
            System.out.println("March Manner");

        }if (this.character.canFly && (this.map[this.character.locationC][this.character.locationR].contains("pill") || this.map[this.character.locationC][this.character.locationR].contains("fungi") 
        || this.map[this.character.locationC][this.character.locationR].contains("water") || this.map[this.character.locationC][this.character.locationR].contains("door") 
        || this.map[this.character.locationC][this.character.locationR].contains("croquet") || this.map[this.character.locationC][this.character.locationR].contains("caterpillar"))){
          
            System.out.println("Note: If you grab an item you will loose the ability to fly.");
    
        }
    }

    // public void promptEnterKey(){
    //     Scanner readinput = new Scanner(System.in);

    //     String enterkey = "Press \"ENTER\" to continue...";
    //     System.out.print(enterkey);
    
    
    //     enterkey = readinput.nextLine();
    //      System.out.print(enterkey);
    
    //     if(enterkey.equals("")){
    
    //         System.out.println("It works!");
    //     }
    //     readinput.close();
    //  }

    public String toString(){
        return "Character:" + this.character.health;
    }

    public static void main(String[] args){

        System.out.println("Welcome to your adventure in wonderland!");

        //game loop
        boolean runGame = true;

        while (runGame == true){
            System.out.println("Chose your character!!");
            System.out.println("***********************");

            System.out.println("Enter your characters name: ");
            Scanner inputName = new Scanner(System.in);
            String name = inputName.nextLine();
            inputName.close();
            Random random = new Random();

            Character character = new Character(name, random.nextInt(5), random.nextInt(5));
            Wonderland wonderland = new Wonderland(character);

            System.out.println("***********************");
            //wonderland.promptEnterKey();

            wonderland.start();
            System.out.println(wonderland.toString());

        }


    }
}