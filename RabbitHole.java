//import
import java.util.Scanner;
import java.util.ArrayList;

public class RabbitHole {
    ArrayList<String> events;
    int numTea;
    int numScone;
    String book;
    Character character;
    Boolean hasKnife;
    Boolean hasJam;
    Boolean readBook;

    public RabbitHole(Character character){

		ArrayList<String> eventsL = new ArrayList<String>();
        eventsL.add("As you fall a table floats by. You peer over to see a gingham tabel cloth set with three cups of tea and a plate of scones. A small knife sticks out of a pot of jam.");
        eventsL.add("You plop into an antique wingback chair and spin towards a desk with an open book.");

        this.events = eventsL;
        this.numTea = 3;
        this.numScone = 5;
        this.book = "\"Welcolme to Wonderland!\"";
        this.character = character;
        this.hasKnife = false;
        this.hasJam = false;
        this.readBook = false;
    }
    
    /**
     * Runs rabit hole game loop.
     */
    public void play(){
    System.out.println("In an effort to avoid the plague of daily life you decide to take a walk by the pond. To your suprise you see a white rabit reach into his waist coat pocket and pull out a pocket watch.");
    System.out.println("    \"Excuse me Mr. Rabbit, may I ask...\", you call in confusion.");
    System.out.println("    \"Can you not see I'm late!\", the rabbit proclaims as he hops away. A rabbit who talks, bizzare, you must go after him!");
    System.out.println("    \" Wait for me Mr. Rabbit\", you call out as you chase him through the woods. As you round a bend you see the tip of his white tail disapear into a hole beneath some gnarly tree roots. Consumed by curiosity you go after him head first down the rabbit hole.");
    System.out.println("The tunnel goes straight down towards the center of the earth. At first you fall quickly, but soon physics waines and you slow to a downward float.");
    System.out.println("Try a simple comand to interact with your surroundings. EX: read book");

    int count = 7;
    int index = 0;

    Scanner inputCommand = new Scanner(System.in);
    while (this.readBook == false) {
        count -= 1;

        System.out.println(this.events.get(index));

        //create scanner 
        String command = inputCommand.nextLine();
        userAction(command, index);

        //manage index of this.events
        if (index == 0 && count == 2){
            index += 1;

        }
     
    }

    inputCommand.close();
    
    }

    /**
     * Based on command carries out function.
     * @param Command
     */
    public void userAction(String command, int index){
       
        
        if (command.contains("read") && this.events.get(index).contains("book")){

            if (command.contains("book")){
                System.out.println("You open the book, on the first page it says: " + this.book);
                this.readBook = true;

            } else {
                System.out.println("What do you want to read?");

            }

        } else if (command.contains("drink")){
            if (command.contains("drink") && command.contains("tea") && this.events.get(index).contains("tea") && numTea >= 1 && this.character.health <= 95){
                this.character.health +=5;
                this.numTea -= 1;
                System.out.println(this.character.name + "'s health: " + this.character.health);

            } else {
                System.out.println("What do you want to drink?");

            }

        }else if(command.contains("take")){
            if (command.contains("take") && command.contains("knife") && this.events.get(index).contains("knife")){
                this.hasKnife = true;
                System.out.println("You now have a knife. What doe you want to do with it?");

            } else {
                System.out.println("What do you want to take?");

            }

        }else if(command.contains("spread")  && this.events.get(index).contains(" jam")){
            if (command.contains("jam") && this.hasKnife == true){
                this.hasJam = true;
                System.out.println("Mmmm, what do you want to do now?");

            } else {
                System.out.println("What do you want to spread? Do you need a knife?");

            }
        }else if (command.contains("eat")){
            if (command.contains("eat") && command.contains("scone")){
                if(this.hasJam && this.character.health <= 92 && this.numScone >= 1){
                    this.character.health +=8;
                    this.numScone -= 1;
                    System.out.println(this.character.name + "'s health: " + this.character.health);

                } else if (hasJam == false && this.character.health <= 95 && this.numScone >= 1){
                    this.character.health += 5;
                    System.out.println(this.character.name + "'s health: " + this.character.health);

                } else {
                    System.out.println("What do you want to eat?");

                }
            }
        }else {
            System.out.println("I don't know that command yet.");
        }
    }

    public static void main(String[] args){
        Character a = new Character("name", 1, 1);
        RabbitHole r = new RabbitHole(a);
        r.play();
    }
}
