import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class WordBank {

  private static HashMap <Integer, String> answers = buildAnswers();
  private static HashMap <String, Boolean> dictionary = buildDictionary();

  //*Creates Integer and String pair to return puzzle number answers
  //*Using a hashmap ensures we only iterate through the answers file once
  private static HashMap <Integer,String> buildAnswers(){
    try {

      HashMap <Integer, String> answers = new HashMap<>();
      Scanner scanner = new Scanner(new File("answers.txt"));
      for (int i = 0; scanner.hasNextLine(); i++){
        answers.put(i, scanner.nextLine());
      } 

      return answers;

    } catch(FileNotFoundException exception){
        System.out.println("Answer file not found");
        return null;
    }
  }

  //*Creates HashMap to check if a guess is legal; a part of the wordle dictionary
  //*Using a hashmap ensures we only iterate through the dictionary file once
  private static HashMap <String, Boolean> buildDictionary(){
    try {

      HashMap <String, Boolean> dictionary = new HashMap<>();
      Scanner scanner = new Scanner(new File("dictionary.txt"));
      while(scanner.hasNext()){
        dictionary.put(scanner.nextLine(), true);
      } 
    
      return dictionary;

    } catch(FileNotFoundException exception){
        System.out.println("Dictionary file not found");
        return null;
    }
  }

  public static String getAnswerForPuzzleNumber(int puzzleNumber){
    return answers.get(puzzleNumber);
  }

   public static boolean checkInDictionary(String proposed) {
    return dictionary.containsKey(proposed);
  }

}