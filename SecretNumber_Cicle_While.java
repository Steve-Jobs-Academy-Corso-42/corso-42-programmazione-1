import java.util.Scanner;

public class SecretNumber_Cicle_While {
    public static void main(String[] args) {
        System.out.println("\n---------------------------------------------------");

        Scanner userGuess = new Scanner(System.in);

        int attempts = 0;

        while (true) {
            attempts++;

            // Generate a random number between 0 and 9
            double randomNumber = Math.random() * 10; // 3.4
            long roundedNumber = Math.round(randomNumber); // 3L

            int secretNumber = ((int) roundedNumber); // 3

            System.out.println("Attempts: " + attempts);

            // Ask the user to input a number
            System.out.println("Insert Number:");

            // Read the user's input
            int userNumber = userGuess.nextInt();

            if (userNumber == secretNumber) {
                System.out.println("Congratulations! You've guessed the secret number!");
                break; // Exit the loop if the user guesses the correct number
            } else {
                System.out.println("Wrong guess. Try again!");
                System.out.println("The secret number was: " + secretNumber);
            }

        }

        System.out.println("---------------------------------------------------/n");
    }
}
