//Student Name: Austin Cao
//Student ID:   897714076

import java.util.*;
import java.io.*;

public class TextTranslator{
    public static void main(String[] args) throws FileNotFoundException{

        HashMap<String, String> library = new HashMap<>();  //creates hashmap
        File infile = new File("acronyms.txt");
        Scanner input = new Scanner(infile);

        while(input.hasNextLine()){     //split the input of file into a value and key
            String inputs = input.nextLine();
            String[] arr = inputs.split("\\t");         //Splits the acronyms and correct saying
            String acro = arr[0].trim();
            String key = arr[1].trim();
            library.put(acro, key);     //Stores the value and key into the Hashmap
        }

        Scanner in = new Scanner(System.in);        //Gets the input from the user
        System.out.println("Enter your translation:");
        String sent = in.nextLine();
        translateText(sent, library);               //Calls the translation method to print / replace the acronyms
        in.close();
        input.close();
        }

/*
 * TranslateText - Translates the acronyms and replaces them with the correct words and punctuation
 * @param1 sentence - The string inputted from the user
 * @param2 Hashmap <String, String> library - The HashMap with all the acronym translations
 */
    
    public static void translateText(String sentence, HashMap<String, String> library){

        String[] words = sentence.split("\\s+");    //splits each word to into an array
        for(String word: words){    //Stores each split of the array into a string of seperate words
            char punctuation = word.charAt(word.length()-1);    
            if((punctuation < 'A' || punctuation > 'Z') && (punctuation < 'a' || punctuation > 'z')){   //Checks between the ASCII values to determine if there is a punctuation and cuts off the whole word until the punctuation
                word = word.substring(0,word.length()-1);
            }
            if(library.containsKey(word.toUpperCase())){        //UpperCases the acronym and replaces it with the appropriate saying
                System.out.print(library.get(word.toUpperCase())); 
            }else{
                System.out.print(word);     //prints back the word if it is not an acronym
            }

            if((punctuation < 'A' || punctuation > 'Z') && (punctuation < 'a' || punctuation > 'z')){   //Prints out the punctuation by comparing the ASCII values
                System.out.print(punctuation);
            }
            System.out.print(" ");
        }
    }
}