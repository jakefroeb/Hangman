import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by jakefroeb on 9/19/16.
 */
public class HangmanProjectTest {


//    Scenario 1 starting the game
//    given I just start the program
//    and I have been presented with a fresh game board
//
//    When I enter a matching letter
//
//    Then I would like to know it is correct
//    and I would like the game board to change to reflect my correct letter
//
//    When I enter a non matching letter
//
//    Then I would like to know it is incorrect
//    and I would like a notification to how many more guesses i have

    @Test

    public  void whenLetterIsAMatchTest(){
        String gameDisplay = new String("  _ _ _ _ _ _ _");
        String answer = new String("bicycle");
        String testGuess = "b";
        boolean correct = false;
        for (Character c: answer.toCharArray()) {
            if(c==testGuess.charAt(0)){
                correct = true;
            }

        }
        assertTrue(correct);
    }

    @Test

    public void whenLetterIsNotAMatchTest(){
        String gameDisplay = new String("  _ _ _ _ _ _ _");
        String answer = new String("bicycle");
        String testGuess = "a";
        boolean correct = false;
        for (Character c: answer.toCharArray()) {
            if(c==testGuess.charAt(0)){
                correct = true;
            }

        }
        assertTrue(!correct);
    }

    @Test
    public void gameEndsWithCorrectAnswerTest(){
        String gameDisplay = new String( "  b i c y c l e");
        boolean gameEnd=false;
        if (!gameDisplay.contains("_")){
            gameEnd= true;
        }
        assertTrue(gameEnd);
    }

    @Test
    public void gameEndsWithIncorrectAnswerTest(){
        int numberOfGuesses = 10;
        boolean gameEnd = false;

        if(numberOfGuesses >= 10){
            gameEnd = true;
        }
        assertTrue(gameEnd);
    }




}
