//imports
import java.util.ArrayList;

public class MarchManor {
    ArrayList<String> floors;
    Character character;
    Boolean inHouse;
    Boolean newRoom;
    int index;
    String kitchen;
    Boolean inKitchen;
    Boolean fire;
    Boolean inBed;

    public MarchManor(Character character){

        ArrayList<String> floors = new ArrayList<String>();
        floors.add("Behind the door is a quaint living room complete with a fire place and a simple kitchen along the far wall.");
        floors.add("You enter a small attic bed room. On the desk sits a small blue bottle.");

        String kitchen = "On the kitchen counter is a decadant carrot cake, a fork and a bucket of water.";

        this.floors = floors;
        this.character = character;
        this.inHouse = false;
        this.newRoom = true;
        this.index = 0;
        this.kitchen = kitchen;
        this.inKitchen = false;
        this.fire = true;
        this.inBed = false;

    }

    public void play(){
        System.out.println("Type \"enter\" if you want to go into the house.");

        String start = this.character.command();
        userAction(start);

        String command;

        if (start.contains("enter")){

            while (this.inHouse){

                if (this.newRoom == true){
                    this.newRoom = false;

                    System.out.println(this.floors.get(this.index));
                }
                command = this.character.command();
                userAction(command);

            }

        }


    }
    // only enter manner when small 
    //she get too big in the house dies

    public void userAction(String command){
        if (command.contains("enter")|| command.contains(("ENTER"))|| command.contains("Enter")){
            actionEnter();

        } else if (command.contains("investigate") || command.contains("check out") || command.contains("go to")){
            actionInvestigate();

        } else if (command.contains("take") || command.contains("grab")){
            actionTake(command);

        } else if (command.contains("eat")){
            actionEat(command);

        } else if (command.contains("put out fire") || command.contains("use")){
            actionFire(command);

        } else if (command.contains("climb")){
            actionClimb(command);

        } else if (command.contains("get in")){
            actionGetIn(command);

        } else if (command.contains("sleep")){
            actionSleep(command);

        } else if (command.contains("swallow") || (command.contains("take") && command.contains("pill"))){
            actionPill(command);
        }
    }

    /**
     * Changes boolean for in house to true
     */
    public void actionEnter(){
        this.inHouse = true;

    }

    /**
     * If the user goes to the kitchen prints out kitchen description.
     */
    public void actionInvestigate(){
        if (this.floors.get(this.index).contains("kitchen")){
            this.inKitchen = true;
            System.out.println(this.kitchen);

        } else if (this.floors.get(this.index).contains("fireplace")){
            System.out.println("The fire is burning hot.");
        }
    }

    /**
     * Takes objects and adds them to the characters bag.
     * @param command String for user command.
     */
    public void actionTake(String command){
        if (this.inKitchen){
            if (command.contains("fork")){
                this.character.bag.add("fork");

            }else if(command.contains("bucket")){
                this.character.bag.add("bucket");

            }

        } else if (this.floors.get(this.index).contains("pills")){
            this.character.bag.add("pills");

        }else {
            System.out.println("You are not in the kitchen.");

        }
       
    }

    public void actionEat(String command){
        if (command.contains("cake")){
            if(this.character.bag.contains("fork")|| this.inKitchen){
                this.character.health += this.character.health/4;

            } else{
                this.character.health = 100;
            }
            System.out.println(this.character.name +"'s health is "+ this.character.health);

        } else {
            System.out.println("What do you want to eat?");
        }
    }

    public void actionFire(String command){
        if (this.character.bag.contains("bucket")){
            this.fire = false;
            System.out.println("You look up the chimmney and see a narrow ladder.");

        } else {
            System.out.println("You cannot put out the water because you do not have a bucket.");
        }
    }

    public void actionClimb(String command){
        if (this.fire == false){
            this.index += 1;
            this.character.health -= 5;
            this.newRoom = true;

        } else{
            System.out.println("The fire is still burning!");

        }
    }

    public void actionGetIn(String Command){
        if (this.floors.get(this.index).contains("bed")){
            this.inBed = true;

        }else {
            System.out.println("There is not bed in this room.");
        }
    }

    public void actionSleep(String command){
        if (this.inBed){
            this.character.health += 10;

        } else{
            System.out.println("You are not in bed, so you cannot sleep.");
        }
    }

    public void actionPill(String command){
        if (command.contains("pill") && this.character.bag.contains("pill")){
            this.character.size *=2;
            System.out.println("You begin to grow and grow until you ");

        } else {
            System.out.print("You may not have what you want to take.");

        }

    }

    public static void main(String[] args){
        Character a = new Character( 1, 1);
        MarchManor m = new MarchManor(a);
        m.play();
    }
}
