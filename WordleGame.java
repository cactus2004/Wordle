public class WordleGame {
  // TODO - implement according to spec
  private int puzzleNumber;

  public WordleGame(int puzzleNumber){
    this.puzzleNumber = puzzleNumber;
  }

  public String getAnswer(){
    return WordBank.getAnswerForPuzzleNumber(this.puzzleNumber) ;
  }

  public void guess(String guessWord){
    if(WordBank.checkInDictionary(guessWord)){
      
      char[] charray = new char[guessWord.length()];
      for (int i = 0; i < guessWord.length(); i++){
        charray[i] = guessWord.charAt(i);
      }

    }
  }

  public int getNumberGuessesSoFar(){
    return 0;
  }

  public char[] getGuess(int guessNumber){
    return new char[5];
  }

  // TODO - include the remainder of the below code back in once rest of class is implemented.
  // Do not modify this method implementation.
  public String toString() {
    // result will be used to build the full answer String
    String result = "";
  //   // for each word guessed so far
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
