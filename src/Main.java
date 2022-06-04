import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean numberGuessedCorrectly = false;
        int numberToGuess = createNumberToGuess();
        int guessTries = 0;

        System.out.println("Welcome to the random number guesser minigame.\n" + "You need to guess a number between 0 and 100,\n" + "while trying to use the lowest amount of guesses overall.");

        while (!numberGuessedCorrectly) {
            System.out.println("Guess the number:");
            Integer guessedNumber = sc.nextInt();
            String guessCheck = numberGuessChecker(guessedNumber, numberToGuess);
            guessTries += 1;

            switch (guessCheck) {
                case "correct" -> numberGuessedCorrectly = true;
                case "lower" -> System.out.println("The number to guess is lower...");
                case "higher" -> System.out.println("The number to guess is higher...");
            }
        }

        System.out.println("The number to guess was " + numberToGuess + "!\nCongrats on the win in " + guessTries + " tries!");
    }

    private static int createNumberToGuess() {
        Random rand = new Random();

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