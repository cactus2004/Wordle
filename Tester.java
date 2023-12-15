import java.util.Scanner;

public class Tester {
  public static void main(String[] args) {

    //Tests for WordleBank
    System.out.println(WordBank.checkInDictionary("hello"));  // true
    System.out.println(WordBank.checkInDictionary("asdfg"));  // false
    System.out.println(WordBank.checkInDictionary("heyy"));  // false
    System.out.println(WordBank.checkInDictionary("Hello"));  // false
    System.out.println(WordBank.checkInDictionary("!!!!!"));  // false

    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(0)); // bused
    System.out.println(WordBank.getAnswerForPuzzleNumber(1)); // plumb

    //Tests for WordleLetter
    WordleLetter a = new WordleLetter('a');
    a.setColor("green");
    System.out.println(a.isGreen());
    System.out.println(a.isColorSet());
    System.out.println(a);
    a.setColor("red");
    System.out.println(a);
    a.setColor("yellow");
    System.out.println(a);

    //Tests for WordleGame
    WordleGame g = new WordleGame(1326);
    g.guess("about");
    g.guess("trail");
    g.guess("basic");
    g.guess("basic");
    g.guess("basic");
    System.out.println(g);
    System.out.println(g.isGameWin());
    System.out.println(g.isGameOver());

    //Tests for Main
    Scanner scanner = new Scanner(System.in);
    WordleGame game = Main.startGame(scanner);
    Main.playGame(scanner, game);
    Main.reportGameOutcome(game);
  
  }
}
