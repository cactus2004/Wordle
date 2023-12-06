import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner){
        
        //!Scanner should already be initialized before method is called
        //Used to check if puzzle number exists
        int puzzleNumber = -1;
        boolean validNumber = false;
       
        while(!validNumber){
            System.out.println("What puzzle would you like to attempt. Please enter a number between 0 and 2314");
            puzzleNumber = scanner.nextInt();
            //Checks if input is valid
            validNumber = (puzzleNumber > -1) && (puzzleNumber < 2315);
        }

        WordleGame game = new WordleGame(puzzleNumber);
        return game; 
    
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) {
        String guessNumberMessage;
        while(!game.isGameOver()){
            
            //Modifies message telling user the number of guesses left
            if(game.getNumberGuessesSoFar() == 5){
                guessNumberMessage = " guess left.";
            }else{
                guessNumberMessage = " guesses left.";
            }
            //Tells user how many guesses they have left
            System.out.println("Make a guess, you have " + (6 - game.getNumberGuessesSoFar())  + guessNumberMessage);
            //Takes in next guess
            String guess = scanner.next();
            game.guess(guess);
            System.out.println(game);
        
        }
    
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
        
        if(!game.isGameWin()){
            System.out.println("The answer was " + game.getAnswer());
            return;
        }

        System.out.println("You won!");
    }

    // This main method body should not be modified.
    public static void main(String[] args) throws FileNotFoundException {
        // Only use this Scanner for user input, do not create new ones via `new Scanner(System.in)`.
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);

    }
}