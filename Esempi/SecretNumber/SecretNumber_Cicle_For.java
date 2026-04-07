package Esempi.SecretNumber;
import java.util.Scanner;

public class SecretNumber_Cicle_For {
    public static void main(String[] args) {
        System.out.println("\n---------------------------------------------------");

        Scanner userGuess = new Scanner(System.in);

        int secretNumber = ((int) Math.round(Math.random() * 10));

        final int LIFES = 3;

        // Inverse For loop
        for (int lifes = LIFES; lifes > 0; lifes--) {
            System.out.println("Lifes " + lifes);
            System.out.print("Guess the secret number (between 0 and 10): ");
            int guess = userGuess.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations! You've guessed the secret number!");
                break;
            } else {
                System.out.println("Wrong guess. Try again.");
            }
        }

        // Normal For loop
        for (int attempts = 0; attempts < LIFES; attempts++) {
            System.out.println("Attempt " + (attempts + 1) + " of " + LIFES);
            System.out.print("Guess the secret number (between 0 and 10): ");
            int guess = userGuess.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations! You've guessed the secret number!");
                break;
            } else {
                System.out.println("Wrong guess. Try again.");
            }
        }

        System.out.println("---------------------------------------------------/n");
    }
}
