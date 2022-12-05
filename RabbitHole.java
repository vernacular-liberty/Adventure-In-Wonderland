//import
import java.util.Scanner;

public class RabbitHole {
    int numTea;
    int numJam;
    int numScone;
    String book;
    Character character;

    public RabbitHole(Character character){
        this.numTea = 6;
        this.numJam = 8;
        this.numScone = 5;
        this.book = "\"Welcolme to Wonderland!\"";
        this.character = character;
    }
    
    /**
     * Runs rabit hole game loop.
     */
    public void play(){
    System.out.println("In an effort to avoid the plague of daily life you decide to take a walk by the pond. To your suprise you see a white rabit reach into his waist coat pocket and pull out a pocket watch.");
    System.out.println("    \"Excuse me Mr. Rabbit, may I ask...\", you call in confusion.");
    System.out.println("    \"Can you not see I'm late!\", the rabbit proclaims as he hops away. A rabbit who talks, bizzare, you must go after him!");
    System.out.println("    \" Wait for me Mr. Rabbit\", you call out as you chase him through the woods. As you round a bend you see the tip of his white tail disapear into a hole beneath some gnarly tree roots. Consumed by curiosity you go after him head first down the rabbit hole.");
    System.out.println("The tunnel is lined with furniture, books on shelves, floating tables set with tea,");
    System.out.println(" As you float by wondering how long it will take to reach the bottom you become hungry");
    System.out.println("Try a simple comand to interact with your surroundings. EX: read book");

    int count = 5;

    Scanner inputCommand = new Scanner(System.in);
    while (count >=0) {
        count -= 1;
        //create scanner 
        String command = inputCommand.nextLine();
        userAction(command);
     
    }
    
    inputCommand.close();
    
    }

    /**
     * Based on command carries out function.
     * @param Command
     */
    public void userAction(String command){

        if (command.contains("read")){

            if (command.contains("book")){
                System.out.println("You open the book, on the first page it says: " + this.book);
            }
        } if (command.contains("eat")){
            this.character.health +=5;

        }else {
            System.out.print("I don't know that command yet.");
        }
    }

    public static void main(String[] args){
        Character a = new Character("name", 1, 1);
        RabbitHole r = new RabbitHole(a);
        r.play();
    }
}
