package Tris;

import java.util.Scanner;

public class Tris {
    public static void main(String[] args) {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };

        char player = 'X';

        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (true) {
            // Display the board
            printBoard(board);

            // Get player input for ROW
            System.out.print("Player " + player + ", enter your move (row): ");
            int inputRow = scanner.nextInt();

            // Validate move
            if (inputRow < 0 || inputRow >= board.length) {
                System.out.println("Invalid move. Try again.");
                continue; // Skip the rest of the loop and ask for input again
            }

            // Get player input for COLUMN
            System.out.print("Player " + player + ", enter your move (column): ");
            int inputColumn = scanner.nextInt();

            // Validate move
            if (inputColumn < 0 || inputColumn >= board[0].length) {
                System.out.println("Invalid move. Try again.");
                continue; // Skip the rest of the loop and ask for input again
            }

            // Update the board based on the move
            if (board[inputRow][inputColumn] == ' ') {
                board[inputRow][inputColumn] = player;
            } else {
                System.out.println("Cell " + inputRow + "," + inputColumn + " is already occupied. Try again.");
                continue;
            }

            boolean won = false;

            // Check for a win
            // Check ROWS
            for (int row = 0; row < board.length; row++) {
                // Check COLUMNS
                for (int column = 0; column < board[row].length; column++) {
                    if (column == board[row].length - 1) {
                        won = true;
                        break;
                    }

                    if (board[row][column] == ' ' || // Check if the current cell is empty
                    // Check if the current cell and the next cell are the same
                            board[row][column] != board[row][column + 1]) {
                        break;
                    }

                }
            }

            // X | O | O
            // ----------
            // O | X | O
            // ----------
            // O | X | O

            // Check COLUMNS
            for (int column = 0; column < board[0].length; column++) {
                // Check ROWS
                for (int row = 0; row < board.length; row++) {
                    if (row == board.length - 1) {
                        won = true;
                        break;
                    }

                    if (board[row][column] == ' ' || // Check if the current cell is empty
                    // Check if the current cell and the next cell are the same
                            board[row][column] != board[row + 1][column]) {
                        break;
                    }

                }
            }

            if (won) {
                printBoard(board);

                System.out.println("Player " + player + " wins!");

                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
        }

    }

    // Method to print the board
    public static void printBoard(char[][] board) {
        // Display the board (rows and columns)
        for (int row = 0; row < board.length; row++) { // Row
            for (int column = 0; column < board[row].length; column++) { // Column
                if (column == 0) {
                    System.out.print(" ");
                }

                // Print the current cell value
                System.out.print(board[row][column]);

                // Print a separator if it's not the last column
                if (column < board[row].length - 1) {
                    System.out.print(" | ");
                }

                if (column == board[row].length - 1) {
                    System.out.print(" ");
                }
            }

            // Print a separator line if it's not the last row
            System.out.println();

            // Print a separator line if it's not the last row
            if (row < board.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }
}