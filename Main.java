import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {
        return null;  // TODO - implement and replace me
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {
        // TODO - implement
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
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
