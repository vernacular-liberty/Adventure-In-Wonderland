//import
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class FungiForrest {
    
    public void conversation(){

        var user_input = new Scanner(System.in);

        //input = new Scanner(System.in);

        System.out.println("How many conversational rounds do you want?");

        //variable that stores the number of rounds.
        int num_rounds = user_input.nextInt();

        //List that stores canned responses
        ArrayList <String> canned_responses = new ArrayList<String>(Arrays.asList("Why?", "mmhm...", 
        "That is wrong beginning to end!", "Are you going to loose your temper?", "Why are you talking to me about this?",
        "Alright, I'm going to give you some advice, look for the magic mushrooms..."));

        System.out.println("Whooo are yooou?");

        //define scanner
        Scanner response = new Scanner(System.in);

        //for loop for the amount of rounds the user sellected
        for (int i= 0; i< num_rounds; i++){

            String user_response = response.nextLine();
            //user_response = user_response + " ";
            String bot_response;
            bot_response = " ";
            String [] words = user_response.split(" ");

            //iterate through the words in the user response, and replace mirror words.
            for (int j=0; j < words.length; j++) {
                
                if (words[j].equals("I") || words[j].equals("i")) {
                    bot_response = "You! Who are you!?";   

                } else{
                    int randomResponse;
                    Random rand = new Random(); 
                    randomResponse = rand.nextInt(5);
                    bot_response = canned_responses.get(randomResponse);

                }
            }

            System.out.println(bot_response);

        }

        System.out.println("You storm off in a furry");
         //close scanners
         user_input.close();
         //close response scanner
         response.close();
    }
}
