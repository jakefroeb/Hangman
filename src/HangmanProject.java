import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jakefroeb on 9/19/16.
 */
public class HangmanProject {
    static String warning;
    static HangmanBoard hangmanBoard = new HangmanBoard();

    public static void main(String[] args) {
        Spark.init();
        Spark.get("/",
                ((request, response) -> {
                    HashMap m = new HashMap();
                    if (!Game.gameDisplay.contains("_")) {
                        warning = "You win the answer is " + Game.answer;
                        Game.newGame();
                    } else if (Game.numberOfGuesses >= 10) {
                        warning = "No more guesses You lose Try again if you dare";
                        Game.newGame();
                    }
                    m.put("line2", hangmanBoard.line2);
                    m.put("line3", hangmanBoard.line3);
                    m.put("line4", hangmanBoard.line4);
                    m.put("line5", hangmanBoard.line5);
                    m.put("line6", hangmanBoard.line6);
                    m.put("warning", warning);
                    m.put("gameDisplay", Game.gameDisplay);
                    return new ModelAndView(m, "home.html");
                }), new MustacheTemplateEngine());

        Spark.post("/guess",
                ((request, response) -> {
                    Game.previousGameDisplay = "";
                    String guess = request.queryParams("guess");
                    if (guess == null) {
                        warning = "Please enter a guess";
                    } else {
                        if (guess.length() > 1) {
                            warning = "Please enter a 1 letter guess";
                        } else {
                            for (Character a : Game.answer.toCharArray()) {
                                if (a.toString().equalsIgnoreCase(guess)) {
                                    Game.addLetterToDisplay(guess);
                                }
                            }
                            if (Game.isGuessCorrect()) {
                                warning = "Correct guess you have " + (10 - Game.numberOfGuesses) + " guesses left";
                            } else {
                                Game.incorrectGuess();
                                warning = "Incorrect guess you have " + (10 - Game.numberOfGuesses) + " guesses left";
                            }
                        }
                    }
                    response.redirect("/");
                    return "";
                }));

    }
}