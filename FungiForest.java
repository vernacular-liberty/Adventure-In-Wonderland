//imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class FungiForest {
    
    Character character;
    Boolean inConversation;

    /**
     * Constructs Fungi Forest.
     * @param character the character playing the game
     */
    public FungiForest(Character character){
        this.character=character;
        this.inConversation =true;
    }

    public void conversation(){
        System.out.println();

        System.out.println("Blue and exactly 3 inches tall, the caterpillar is perched on the cap of a large mushroom. You want to talk to him. Mad or not, he seems like he might be able to help!");
        System.out.println("Intrigued by this strange creature, you hoist yourself up onto the mushroom to get his attention.");
        System.out.println("The caterpillar holds his breath, staring at you wordlessly. Finally, he opens his mouth, exhaling a ring of colorful smoke right into your face. You start to feel kind of funny, and your throat itches.");

        //List that stores canned responses
        ArrayList <String> canned_responses = new ArrayList<String>(Arrays.asList("Whyyy?", "Mmhm...", 
        "That is wrong beginning to end!", "Are you going to lose your temper?", "Why are you talking to me about this?",
        "Okay, fine, I'll give you some advice. Find the magic mushrooms and you'll never have to walk another step.", "Speak up!"));

        System.out.println();
        System.out.println("[HINT: The longer you stay here, the worse this will get. Try not to talk about yourself too much; it really gets him going. And don't forget--you can't leave without a proper \"goodbye\"! For some reason, the caterpillar is very particular about this sort of thing.]");
        System.out.println();

        character.health-=5;

        System.out.println("CATERPILLAR: Whooo are yooou?");

        //define scanner
        Scanner response = new Scanner(System.in);

        while ((inConversation)){
            
            String bot_response = "";

            String user_response = response.nextLine();
            String[] words = user_response.split(" ");

            //iterates through words in user_response
            //checks to see if user wants to end conversation
            for (int j=0; j < words.length; j++) {
                if((words[j].equals("goodbye") || (words[j].equals("Goodbye")))){
                    bot_response = "CATERPILLAR: Goodbye...";
                    inConversation=false;
                }
                else{ 
                    //generates caterpillar's response
                    for (int i=0; i < words.length; i++) {
                        if(words[i].equals("I") || words[i].equals("i")){
                            character.health-=2.5;
                            bot_response = "CATERPILLAR: You! Who are you!?";
                            break;
                        }else{
                            int randomResponse;
                            Random rand = new Random(); 
                            randomResponse = rand.nextInt(6);
                            bot_response = "CATERPILLAR: "+canned_responses.get(randomResponse);
                        }
                    }
                }
            }
            System.out.println(bot_response);
        }

        System.out.println();
        System.out.println("The caterpillar disappears into thin air. When you look up, you notice a blue butterfly fluttering about nearby.");
        System.out.println("You also notice that you can't stop coughing. After this conversation, your health is: " + this.character.health + ".");
        //close response scanner
        response.close();
    }
    

    public void userAction(String command){
        if((command.contains("goodbye") || command.contains("Goodbye"))){
            inConversation = false;
        }
        else if(command.contains("chat")){
            conversation();
        }
    }

    public static void main(String[] args){
        Character a = new Character( 1, 1);
        FungiForest m = new FungiForest(a);
        m.conversation();
    }
}
