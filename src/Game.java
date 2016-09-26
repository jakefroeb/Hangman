import java.util.ArrayList;

/**
 * Created by jakefroeb on 9/23/16.
 */
public class Game {
    static String answer = new String("bicycle");
    static String previousGameDisplay = new String("");
    static String gameDisplay = new String("  _ _ _ _ _ _ _");
    static int numberOfGuesses = 0;

    static void addLetterToDisplay(String a) {
        int displayIndex = 2;
        for (Character c : answer.toCharArray()) {
            if (a.equals(c.toString())) {
                gameDisplay = gameDisplay.substring(0, displayIndex) + c + gameDisplay.substring(displayIndex + 1);
            }
            displayIndex = displayIndex + 2;
        }
        previousGameDisplay = gameDisplay;
    }

    static void incorrectGuess() {
        numberOfGuesses++;
        HangmanBoard.changeHangman();
    }


    static void newGame() {
        gameDisplay = "  _ _ _ _ _ _ _";
        numberOfGuesses = 0;
        HangmanBoard.newHangmanBoard();
    }

    static boolean isGuessCorrect() {
        return gameDisplay.equals(previousGameDisplay);
    }
}

