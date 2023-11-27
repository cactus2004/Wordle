public class WordleGame {
  // TODO - implement according to spec
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
    return guessNumber == 5 || isGameWin();
  }

  private boolean isInWord(String answer, char guess){
    
    for (int i = 0; i < 5; i++){
      if(answer.charAt(i) == guess){
        return true;
      }
    }

    return false;  
 
  }

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
