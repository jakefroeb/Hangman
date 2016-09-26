/**
 * Created by jakefroeb on 9/23/16.
 */
public class HangmanBoard {

    static String line2 = " ";
    static String line3 = " ";
    static String line4 = " ";
    static String line5 = " ";
    static String line6 = " ";

    public HangmanBoard() {
    }

    public static void newHangmanBoard() {
        line2 = " ";
        line3 = " ";
        line4 = " ";
        line5 = " ";
        line6 = " ";
    }

    public static void changeHangman() {
        switch (Game.numberOfGuesses) {
            case 1:
                line2 = "|";
                break;
            case 2:
                line3 = "()";
                break;
            case 3:
                line4 = "\\";
                break;
            case 4:
                line4 = "\\|";
                break;
            case 5:
                line4 = "\\||";
                break;
            case 6:
                line4 = "\\||/";
                break;
            case 7:
                line5 = " |";
                break;
            case 8:
                line5 = " ||";
                break;
            case 9:
                line6 = "/";
                break;
            case 10:
                line6 = "/  \\";
                break;
        }
    }
}

