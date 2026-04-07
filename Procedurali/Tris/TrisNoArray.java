package Procedurali.Tris;
import java.util.Scanner;

public class TrisNoArray {
    public static void main(String[] args) {
        char c1 = ' ';
        char c2 = ' ';
        char c3 = ' ';
        char c4 = ' ';
        char c5 = ' ';
        char c6 = ' ';
        char c7 = ' ';
        char c8 = ' ';
        char c9 = ' ';

        char player = 'X';

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the board
            System.out.println("  " + c1 + " | " + c2 + " | " + c3);
            System.out.println(" ---+---+---");
            System.out.println("  " + c4 + " | " + c5 + " | " + c6);
            System.out.println(" ---+---+---");
            System.out.println("  " + c7 + " | " + c8 + " | " + c9);

            // Get player input
            System.out.print("Player " + player + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            // Validate move
            if (move < 1 || move > 9) {
                System.out.println("Invalid move. Try again.");
                continue; // Skip the rest of the loop and ask for input again
            }

            // Update the board based on the move
            if (move == 1 && c1 == ' ') {
                c1 = player;
            } else if (move == 2 && c2 == ' ') {
                c2 = player;
            } else if (move == 3 && c3 == ' ') {
                c3 = player;
            } else if (move == 4 && c4 == ' ') {
                c4 = player;
            } else if (move == 5 && c5 == ' ') {
                c5 = player;
            } else if (move == 6 && c6 == ' ') {
                c6 = player;
            } else if (move == 7 && c7 == ' ') {
                c7 = player;
            } else if (move == 8 && c8 == ' ') {
                c8 = player;
            } else if (move == 9 && c9 == ' ') {
                c9 = player;
            } else {
                System.out.println("Cell " + "c" + move + " is already occupied. Try again.");
                continue;
            }

            // Check for a win
            if (c1 == c2 && c2 == c3 && c1 != ' ' ||
                    c4 == c5 && c5 == c6 && c4 != ' ' ||
                    c7 == c8 && c8 == c9 && c7 != ' ' ||
                    c1 == c4 && c4 == c7 && c1 != ' ' ||
                    c2 == c5 && c5 == c8 && c2 != ' ' ||
                    c3 == c6 && c6 == c9 && c3 != ' ' ||
                    c1 == c5 && c5 == c9 && c1 != ' ' ||
                    c3 == c5 && c5 == c7 && c3 != ' ') {
                System.out.println("Player " + player + " wins!");
                break;
            }

            // Check for a draw
            if (c1 != ' ' && c2 != ' ' && c3 != ' ' &&
                    c4 != ' ' && c5 != ' ' && c6 != ' ' &&
                    c7 != ' ' && c8 != ' ' && c9 != ' ') {
                System.out.println("It's a draw!");
                break;
            }

            // Switch players (using if-else)
            // if (player == 'X') {
            // player = 'O';
            // } else {
            // player = 'X';
            // }

            // Switch players (using boolean variable and ternary operator)
            // boolean isX = (player == 'X');
            // player = isX ? 'O' : 'X';

            // Switch players (using ternary operator)
            player = (player == 'X') ? 'O' : 'X';
        }
    }
}
