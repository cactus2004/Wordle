public class WordleGame {
  // TODO - implement according to spec
  private WordleLetter[][] game = new WordleLetter[6][5];
  private int puzzleNumber;
  private int guessNumber = 0;
  private String guessWord = "hello";

  public WordleGame(int puzzleNumber){
    this.puzzleNumber = puzzleNumber;
  }

  public String getAnswer(){
    return WordBank.getAnswerForPuzzleNumber(this.puzzleNumber) ;
  }

  public void guess(String guessWord){
    if(WordBank.checkInDictionary(guessWord)){
      this.guessWord = guessWord;
      for (int i = 0; i < 5; i++){
        WordleLetter letter = new WordleLetter(guessWord.charAt(i));
        game[guessNumber][i] = letter;
        
        if(getAnswer().charAt(i) == guessWord.charAt(i)){
          game[guessNumber][i].setColor("green");

        }else if(isInWord(getAnswer(), guessWord.charAt(i))){
          game[guessNumber][i].setColor("yellow");
        }else{
          game[guessNumber][i].setColor("red");
        }

      }

      guessNumber++;

    }
  }

  public int getNumberGuessesSoFar(){
    return guessNumber;
  }

  public WordleLetter[] getGuess(int guessNumber){
    return game[guessNumber];
  }

  public boolean isGameWin(){
    for (int i = 0; i < 5; i++){
      if(getAnswer().charAt(i) != guessWord.charAt(i)){
        return false;
      }
    }
    return true;
  }

  public boolean isGameOver(){
    return guessNumber == 6 || isGameWin();
  }

  private boolean isInWord(String answer, char guess){
    
    for (int i = 0; i < 5; i++){
      if(answer.charAt(i) == guess){
        return true;
      }
    }

    return false;  
 
  }

  // private WordleLetter[] findDuplicate(){
    
  //   int constant = 71;
  //   //char[] charray = new char[5];
  //   int [] duplicates = new int[26];
  //   int duplicateCount = 0;
    
  //   //Counts how many times each letter appears
  //   for(int i = 0; i < getAnswer().length(); i++){
  //     duplicates[getAnswer().charAt(i) - constant]++;      
  //   }

  //   //Counts the letters that appear 2 
  //   for(int i = 0; i < 26; i++){
  //     if(duplicates[i] > 1){
  //       duplicateCount++;
  //     } 
  //   }

  //   WordleLetter[] charray = new WordleLetter[duplicateCount];
  //   for(int i = 0; i < charray.length; i++){
  //     for(int j = 0; j < duplicates.length; j++){
  //       if(duplicates[j] > 1){
  //         charray[i] = new WordleLetter((char)(j + constant));
  //       }
  //     }
  //   }

  //   for (WordleLetter letter : charray){
  //     System.out.println(letter);
  //   }

  //   return charray;
  // }


  // TODO - include the remainder of the below code back in once rest of class is implemented.
  // Do not modify this method implementation.
  public String toString() {
    // result will be used to build the full answer String
    String result = "";
    // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      // get each letter of each word
      for (int j = 0; j < 5; j++) {
        // concatenate it to the result
        // WordleLetter's toString() is automatically invoked here.
        result += getGuess(i)[j];
      }
      // new line separator between each word
      result += "\n";
    }
    return result;
  }
}
