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

    public MarchManor(Character character){

        ArrayList<String> floors = new ArrayList<String>();
        floors.add("Behind the door is a quaint living room complete with a fire place and a simple kitchen along the far wall.");
        floors.add("Enters a small attic bed room. On the desk sits a small blue bottle.");

        String kitchen = "On the kitchen counter is a decadant carrot cake, a fork and a bucket of water.";

        this.floors = floors;
        this.character = character;
        this.inHouse = false;
        this.newRoom = true;
        this.index = 0;
        this.kitchen = kitchen;

        this.inKitchen = false;

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

        } else if (command.contains("investigate") || command.contains("check out")){
            actionInvestigate();

        } else if (command.contains("take") || command.contains("grab")){
            actionTake(command);

        } else if (command.contains("eat")){
            actionEat(command);
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
            System.out.println(this.kitchen);

        } else if (this.floors.get(this.index).contains("fireplace")){
            System.out.println("The fir");
        }
    }

    /**
     * Takes objects and adds them to the characters bag.
     * @param command String for user command.
     */
    public void actionTake(String command){
        if (command.contains("fork")){
            this.character.bag.add("fork");

        }
    }

    public void actionEat(String command){
        if (command.contains("cake")){
            if(this.character.bag.contains("fork")){
                this.character.health += this.character.health/4;

            } else{
                this.character.health = 100;
            }
        }
    }

    public static void main(String[] args){
        Character a = new Character( 1, 1);
        MarchManor m = new MarchManor(a);
        m.play();
    }
}
