import java.util.Scanner;

public class SecretNumber_If_Else {
    public static void main(String[] args) {
        System.out.println("\n---------------------------------------------------");

        // Generate a random number between 0 and 9
        double randomNumber = Math.random() * 10; // 3.4
        long roundedNumber = Math.round(randomNumber); // 3L

        int secretNumber = ((int) roundedNumber); // 3

        // int secretNumber = ((int) Math.round(Math.random() * 100)); // 0 to 99

        // Math.random() will return a double between 0.0 (inclusive) and 1.0
        // (exclusive), so we need to multiply it by 100 to get a number between 0 and
        // 99, and then cast it to an int to get a whole number.

        // Math.floor(34.8) will return 34.0, which is a double, so we need to cast it
        // to an int to get 34.

        // Math.ceil(34.2) will return 35.0, which is a double, so we need to cast it to
        // an int to get 35.

        // Math.round(34.2) will return 34, which is an int, so we don't need to cast
        // it.

        System.out.println("Welcome to the Secret Number Game!\nInsert number: ");
        Scanner userInput = new Scanner(System.in);
        int userGuess = userInput.nextInt();

        if (userGuess == secretNumber) {
            System.out.println("Congratulations! You guessed the secret number!");
        } else {
            System.out.println("Sorry, you guessed the wrong number");
            System.out.println("The secret number was " + secretNumber + ".");
            System.out.println("Try again!");
        }

        System.out.println("---------------------------------------------------\n");
    }
}
