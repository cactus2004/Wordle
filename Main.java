import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner){
        
        //!Scanner should already be initialized before method is called
        int puzzleNumber = -1;
        boolean validNumber = false;
       

        while(!validNumber){
            System.out.println("asking for puzzle");
            puzzleNumber = scanner.nextInt();
            validNumber = (puzzleNumber > -1) && (puzzleNumber < 2315);
        }

        WordleGame game = new WordleGame(puzzleNumber);
        return game;  // TODO - implement and replace me
    
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) {
        while(!game.isGameOver()){
            System.out.println("make guess");
            String guess = scanner.next();
            game.guess(guess);
            System.out.println(game);
        }
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
        if (game.isGameWin()){
            System.out.println("You won!");
        }else{
            System.out.println("The answer was " + game.getAnswer());
        }
        // TODO - implement
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