//import
import java.util.ArrayList;

public class RabbitHole {
    ArrayList<String> events;
    int numTea;
    int numScone;
    String book;
    Character character;
    Boolean readBook;
    Boolean inBed;
    int index;
    Boolean changeFloor;

    public RabbitHole(Character character){

		ArrayList<String> eventsL = new ArrayList<String>();
        eventsL.add("As you fall a table floats by. You peer over to see a gingham tabel cloth set with three cups of tea and a plate of scones. A small knife sticks out of a pot of jam.");
        eventsL.add("A beautiful feather bed floats by you.");
        eventsL.add("You plop into an antique wingback chair and spin towards a desk with an open book.");

        this.events = eventsL;
        this.numTea = 3;
        this.numScone = 5;
        this.book = "\"Welcolme to Wonderland!\"";
        this.character = character;
        this.readBook = false;
        this.inBed = false;
        this.index = 0;
        this.changeFloor = true;

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
     * Finds Action key word and calls object
     * @param Command String for user command
     */
    public void userAction(String command){

        if (command.contains("read") && this.events.get(this.index).contains("book")){
          actionRead(command);

        } else if (command.contains("drink")){
            actionDrink(command);

        }else if(command.contains("take")){
            actionTake(command);

        }else if (command.contains("get in")){
           actionGetIn(command);

        }else if (command.contains("sleep")){
            actionSleep(command);
           
        }else if(command.contains("spread")  && this.events.get(this.index).contains(" jam")){
           actionSpread(command);

        }else if (command.contains("eat")){
            actionEat(command);

        }else if(command.contains("down") && this.index < 2){
            this.index += 1;
            this.changeFloor = true;

        } else {
            System.out.println("I don't know that command yet.");
        }
        
    }

    public void actionTake(String command){
        if (command.contains("knife") && this.events.get(this.index).contains("knife")){
            this.character.bag.add("knife");
            System.out.println("You now have a knife. What do you want to do with it?");
    
        } else {
            System.out.println("What do you want to take?");
    
        }
    }

    public void actionSpread(String command){
        if (command.contains("jam") && this.character.bag.contains("knife")){
            this.character.bag.add("jam");
            System.out.println("Mmmm, what do you want to do now?");
            
        } else {
            System.out.println("What do you want to spread? Do you need a knife?");
        
        }
    }

    public void actionEat(String command){
        if(this.character.bag.contains("jam") && this.character.health <= 92 && this.numScone >= 1){
            this.character.health +=8;
            this.numScone -= 1;
            System.out.println(this.character.name + "'s health: " + this.character.health);

        } else if (this.character.health <= 95 && this.numScone >= 1){
            this.character.health += 5;
            System.out.println(this.character.name + "'s health: " + this.character.health);

        } else {
            System.out.println("What do you want to eat?");

        }
    }

    public void actionDrink(String command){
        if (command.contains("tea") && this.events.get(this.index).contains("tea") && numTea >= 1 && this.character.health <= 95){
            this.character.health +=5;
            this.numTea -= 1;
            System.out.println(this.character.name + "'s health: " + this.character.health);

        } else {
            System.out.println("What do you want to drink?");

        }
    }

    public void actionGetIn(String command){
        if (command.contains("bed") && this.events.get(this.index).contains("bed")){
            this.inBed = true;
            System.out.println("Maybe you should try to sleep before your journey...");

        } else{
            System.out.println("What do you want to get in?");

        }
    }

    public void actionRead(String command){
        if (command.contains("book")){
            System.out.println("You open the book, on the first page it says: " + this.book);
            this.readBook = true;

        } else {
            System.out.println("What do you want to read?");

        }
    }

    public void actionSleep(String command){

        if (this.character.health <= 90 && this.inBed){
            this.character.health += 10;
            this.character.toString();

        } else {
            System.out.println("You can't sleep there...");

        }

    }
    

    public static void main(String[] args){
        Character a = new Character( 1, 1);
        RabbitHole r = new RabbitHole(a);
        r.play();
    }
}
