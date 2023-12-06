import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordBank {

  // This first method implementation is completed for you already.
  // Do not modify the method signature.
  public static String getAnswerForPuzzleNumber(int puzzleNumber){
    // Create a file scanner to read answers.txt.
    
    try{
      Scanner scanner = new Scanner(new File("answers.txt"));
    // Skip the first puzzleNumber number of words in the file.
      for (int i = 0; i < puzzleNumber; i++) {
        scanner.next();
      }
    
    // Return the very next word.
    return scanner.next();
    }

    //* handles exception 
    catch(FileNotFoundException exception){
      System.out.println("Answer file not found");
      return null;
    }

  }

  // Do not modify the method signature.
  public static boolean checkInDictionary(String proposed) {

    //*Gatekeeping section of code that makes sure the guess fits some parameters before looping 
    //*through the txt file.

    //Early return if the word isnt 5 letters long
    if(proposed.length() != 5){
      return false;
    }

    //Early return if theres numbers or symbols
    for (int i = 0; i < 5; i++){
      char letter = proposed.charAt(i);
      if(!Character.isAlphabetic(letter) || Character.isUpperCase(letter)){
        return false;
      }
    }

    //Finally checks if the word is legal
    try {
        Scanner scanner = new Scanner(new File("dictionary.txt"));

        while(scanner.hasNext()){
          if(scanner.next().equals(proposed)){
          return true;
        }

    }
      
    //* handles exception 
    } catch (FileNotFoundException exception) {
        System.out.println("Dictionary file not found");
    }
   
    
    return false;
  
  }
}
