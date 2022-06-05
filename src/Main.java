import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(in);

        while (true) {
            int numberToGuess = createNumberToGuess(rand);
            int guessTries = 0;

            out.println("""
                    Welcome to the random number guesser minigame.
                    You need to guess a number between 0 and 100,
                    while trying to use the lowest amount of guesses overall.""");

            while (true) {
                out.print("Guess the number: ");
                int guessedNumber = sc.nextInt();
                int guessCheck = Integer.compare(numberToGuess, guessedNumber);
                guessTries++;

                if (guessCheck > 0) {
                    out.println("The number to guess is higher...");
                } else if (guessCheck < 0) {
                    out.println("The number to guess is lower...");
                } else {
                    break;
                }
            }

            out.println("The number to guess was " + numberToGuess + "!\nCongrats on the win in " + guessTries + " tries!");
            out.println("Wanna play again?");
            out.print("Yes or no?: ");
            String answer = sc.next().toLowerCase();

            if ("no".equals(answer)) {
                break;
            }
        }

        out.println("Thanks for playing!");
    }

    private static int createNumberToGuess(Random rand) {
        return rand.nextInt(100);
    }
}