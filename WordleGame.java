public class WordleGame {

  //* An entire wordle game can be represented in a 6 by 5 grid of guessed letters
  private WordleLetter[][] game = new WordleLetter[6][5];
  private int puzzleNumber;
  private int guessNumber = 0;
  private String guessWord;

  public WordleGame(int puzzleNumber){
    this.puzzleNumber = puzzleNumber;
  }

  public String getAnswer(){
    return WordBank.getAnswerForPuzzleNumber(this.puzzleNumber) ;
  }

  public void guess(String guessWord){

    if(WordBank.checkInDictionary(guessWord)){
      
      String temp = getAnswer();
      //Needed to check if the answer and guesses match
      this.guessWord = guessWord;
      for (int i = 0; i < 5; i++){

        //Initializes wordleLetters and adds them to wordle array
        WordleLetter wordleLetter = new WordleLetter(guessWord.charAt(i));
        game[guessNumber][i] = wordleLetter;

      }

      /*Applying colors to each letter
      *
      *
      */

      //Applies green
      for (int i = 0; i < 5; i++){
        WordleLetter wordleLetter = game[guessNumber][i];
        if(wordleLetter.getLetter() == getAnswer().charAt(i)){
          wordleLetter.setColor("green");
          //Removes the green letters from our temporary answer to prevent double "yellow" letters
          temp = temp.replaceFirst(repeatedLetter(temp, game[guessNumber][i].getLetter()), " ");
        }
      }

       //Applies Yellow
       for (int i = 0; i < 5; i++){
         WordleLetter wordleLetter = game[guessNumber][i];
         //Uses helper function to check that a letter exists in our temp string
         if(isInWord(temp, wordleLetter.getLetter()) && !wordleLetter.isGreen()){
           wordleLetter.setColor("yellow");
           //Removes the yellow letter from our temporary answer to prevent double "yellow" letters
           temp = temp.replaceFirst(repeatedLetter(temp, wordleLetter.getLetter()), " ");
         }
       }

       //Applies red
       for (int i = 0; i < 5; i++){
        //If statement needed to not overide previous colors
         if(!game[guessNumber][i].isColorSet()){
           game[guessNumber][i].setColor("i have the best TA's");
         }
       }

      guessNumber++;

    }
  }

  public int getNumberGuessesSoFar(){
    return guessNumber;
  }

  //Helper function that retutns the repeated character in a string
  private String repeatedLetter(String answer, char letter){
    for (int i = 0; i < 5 ; i++ ){
      if(answer.charAt(i) == letter){
        return Character.toString(answer.charAt(i));
      }
    }
    return null;
  }

  public WordleLetter[] getGuess(int guessNumber){
    return game[guessNumber];
  }

  public boolean isGameWin(){
    if (guessWord == null){
      return false;
    }
    return guessWord.equals(getAnswer());    
  }

  public boolean isGameOver(){
    //Game stops after 6 guesses
    return guessNumber == 6 || isGameWin();
  }

  //Helper function for coloring yellow letters
  private boolean isInWord(String answer, char guess){
    for (int i = 0; i < 5; i++){
      if(answer.charAt(i) == guess){
        return true;
      }
    }

    return false;  
 
  }


  public String toString() {

    String result = "";
    // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      // get each letter of each word
      for (int j = 0; j < 5; j++) {
        result += getGuess(i)[j];
      }
      // new line separator between each word
      result += "\n";
    }

    return result;
  
  }
}
