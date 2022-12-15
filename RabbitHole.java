//import
import java.util.ArrayList;

/**
 * Represents the rabbit hole 
 * @param events array list for the different events as you fall down the rabbit hole.
 * @param numTea int for the number of cups of tea 
 * @param numScone int for the number of scones
 * @param book string for first page of the book
 * @param character Character representing the user
 * @param readBook Boolean for whether the book has been read
 * @param index int for the current index in events
 * @param changeFloor boolean for whether the floor changed 
 * @param spreadJam whether jam was spread
 */
public class RabbitHole {
    ArrayList<String> events;
    int numTea;
    int numScone;
    String book;
    Character character;
    Boolean readBook;
    int index;
    Boolean changeFloor;
    Boolean hasJam;

    /**
     * Constructs rabbit hole.
     * @param character the character playing the game
     */
    public RabbitHole(Character character){

		ArrayList<String> eventsL = new ArrayList<String>();
        eventsL.add("As you fall a table floats by. You peer over to see a gingham table cloth set with three cups of tea and a plate of scones. A small knife sticks out of a pot of jam.");
        eventsL.add("A beautiful feather bed floats by you.");
        eventsL.add("You plop into an antique wingback chair and spin towards a desk with an open book.");

        this.events = eventsL;
        this.numTea = 3;
        this.numScone = 5;
        this.book = "\"Welcome to Wonderland!\"";
        this.character = character;
        this.readBook = false;
        this.index = 0;
        this.changeFloor = true;
        this.hasJam = false;

    }
    
    /**
     * Runs rabbit hole game loop.
     */
    public void play(){
        System.out.println("In an effort to avoid the plague of daily life you decide to take a walk by the pond. To your surprise you see a white rabbit reach into his waist coat pocket and pull out a pocket watch.");
        System.out.println("    \"Excuse me Mr. Rabbit, may I ask...\", you call in confusion.");
        System.out.println("    \"Can you not see I'm late!\", the rabbit proclaims as he hops away. A rabbit who talks, bizarre, you must go after him!");
        System.out.println("    \" Wait for me Mr. Rabbit\", you call out as you chase him through the woods. As you round a bend you see the tip of his white tail disappear into a hole beneath some gnarly tree roots. Consumed by curiosity you go after him head first down the rabbit hole.");
        System.out.println("The tunnel goes straight down towards the center of the earth. At first you fall quickly, but soon physics wanes and you slow to a downward float.");
        System.out.println("Try a simple command to interact with your surroundings. EX: read book");

        while (this.readBook == false) {
            while (this.changeFloor){
                System.out.println(this.events.get(this.index));
                this.changeFloor = false;

            }

            String command = this.character.command();
            userAction(command);

        }
    
    }

    /**
     * Finds Action key word and calls the specific actions function.
     * @param command String for user input.
     */
    public void userAction(String command){

        if (command.contains("read") && this.events.get(this.index).contains("book")){
          actionRead(command);

        } else if (command.contains("drink")){
            actionDrink(command);

        } else if(command.contains("take")){
            actionTake(command);

        } else if (command.contains("get in")){
           this.character.actionGetIn(command, this.events.get(this.index));

        } else if (command.contains("sleep")){
            this.character.actionSleep();     

        } else if(command.contains("spread")  && this.events.get(this.index).contains(" jam")){
           actionSpread(command);

        } else if (command.contains("eat")){
            actionEat(command);

        } else if(command.contains("down") && this.index < 2){
            this.index += 1;
            this.changeFloor = true;

        } else if (command.contains("check")){
            actionCheck(command);

        } else if (command.contains("drop")){
            this.character.drop(command);

        } else if (command.contains("clue")) {
            actionClue();

        }else {
            System.out.println("I don't know that command yet.");

        }
        
    }

    /**
     * Completes user action for take command.
     * @param command String for user command
     */
    public void actionTake(String command){
        if (command.contains("knife") && this.events.get(this.index).contains("knife")){
            this.character.bag.add("knife");
            System.out.println("You now have a knife. What do you want to do with it?");
    
        } else if (command.contains("scone") && this.events.get(this.index).contains("scone") && this.numScone>=1){
            this.character.bag.add("scone");
            this.numScone-=1;
            System.out.println("You now have a scone. What do you want to do with it?");

        }else {
            System.out.println("What do you want to take?");
    
        }
    }

    /**
     * Completes user action for spread command.
     * @param command String for user command,
     */
    public void actionSpread(String command){
        if (command.contains("jam") && this.character.bag.contains("knife")){
            this.hasJam = true;
            System.out.println("Mmmm, what do you want to do now?");
            
        } else {
            System.out.println("What do you want to spread? Do you need a knife?");
        
        }
    }

    /**
     * Completes user action for eat command.
     * @param command String for user command.
     */
    public void actionEat(String command){

        if (command.contains("scone")){

            if (this.character.bag.contains("scone")){

                if (this.hasJam){
                    if(this.character.health <= 92){
                        this.character.health +=8;
            
                    } else if(this.character.health > 92 ){
                        this.character.health = 100;
            
                    }

                    this.hasJam = false;

                } else {
                    if (this.character.health <= 95 ){
                        this.character.health += 5;
            
                    } else if (this.character.health > 95){
                        this.character.health =100;

                    }

                }

                this.character.drop("scone");


            } else {
                System.out.println("You do not have a scone in your inventory.");

            }

        } else {
            System.out.println("What do you want to eat?");

        }
    }



    /**
     * Completes user action for drink command.
     * @param command String for user command.
     */
    public void actionDrink(String command){
        if (command.contains("tea") && this.events.get(this.index).contains("tea") && numTea >= 1 && this.character.health <= 95){
            this.character.health +=5;
            this.numTea -= 1;

        } else {
            System.out.println("What do you want to drink?");

        }
    }

    /**
     * Completes user action for read command.
     * @param command String for user command.
     */
    public void actionRead(String command){
        if (command.contains("book")){
            System.out.println("You open the book, on the first page it says: " + this.book);
            this.readBook = true;

        } else {
            System.out.println("What do you want to read?");

        }
    }    


    /**
     * Checks inventory and checks health.
     * @param command string for user input.
     */
    public void actionCheck(String command){
        if (command.contains("inventory")){
            this.character.inventoryToString();

        } else if (command.contains("health")){
            this.character.healthToString();

        }
    }

    public void actionClue(){
        System.out.println("+--------------------------------+");
        System.out.println("|   Some Commands to try:        |");
        System.out.println("|   - 'take'                     |");
        System.out.println("|   - 'drop'                     |");
        System.out.println("|   - 'sleep'                    |");
        System.out.println("|   - 'eat'                      |");
        System.out.println("|   - 'spread'                   |");
        System.out.println("+--------------------------------+");

    }

    public static void main(String[] args){
        Character a = new Character( 1, 1);
        RabbitHole r = new RabbitHole(a);
        r.play();
        
    }
}
