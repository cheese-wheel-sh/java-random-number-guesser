import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(in);
        boolean isPlaying = true;

        while (Boolean.TRUE.equals(isPlaying)) {
            boolean numberGuessedCorrectly = false;
            int numberToGuess = createNumberToGuess(rand);
            int guessTries = 0;

            out.println("""
                    Welcome to the random number guesser minigame.
                    You need to guess a number between 0 and 100,
                    while trying to use the lowest amount of guesses overall.""");

            while (!numberGuessedCorrectly) {
                out.print("Guess the number: ");
                Integer guessedNumber = sc.nextInt();
                String guessCheck = numberGuessChecker(guessedNumber, numberToGuess);
                guessTries += 1;

                switch (guessCheck) {
                    case "correct" -> numberGuessedCorrectly = true;
                    case "lower" -> out.println("The number to guess is lower...");
                    case "higher" -> out.println("The number to guess is higher...");
                    default -> out.println("Error! Couldn't check input!");
                }
            }

            out.println("The number to guess was " + numberToGuess + "!\nCongrats on the win in " + guessTries + " tries!");

            out.println("Wanna play again?");
            out.print("Yes or no?: ");
            String answer = sc.next().toLowerCase();

            if ("no".equals(answer)) {
                isPlaying = false;
            }
        }

        out.println("Thanks for playing!");
    }

    private static int createNumberToGuess(Random rand) {
        return rand.nextInt(100);
    }

    private static String numberGuessChecker(Integer numberGuessed, Integer numberToGuess) {
        String returnMessage;

        if (Objects.equals(numberGuessed, numberToGuess)) {
            returnMessage = "correct";
        } else if (numberGuessed > numberToGuess) {
            returnMessage = "lower";
        } else {
            returnMessage = "higher";
        }

        return returnMessage;
    }
}