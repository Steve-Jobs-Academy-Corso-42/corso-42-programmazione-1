package Procedurali.Tris;

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

        int leftMoves = 9;

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

            // Decrement the number of moves left
            leftMoves--;

            // initialize won boolean variable
            boolean won = false;

            // Check for a win
            // Check ROWS
            for (int row = 0; row < board.length; row++) {
                // Check COLUMNS
                for (int column = 0; column < board[row].length; column++) {
                    // Check if the current cell is empty
                    // Check if the current cell and the next cell are the same
                    if (board[row][column] == ' ' || board[row][column] != board[row][column + 1]) {
                        break;
                    }

                    // Check if column is the last column
                    // Use column - 2 because we are comparing the current cell with the next cell
                    if (column == board[row].length - 2) {
                        // Set won to true if the whole row matches
                        won = true;
                        break;
                    }

                }
            }

            // Check COLUMNS
            for (int column = 0; column < board[0].length; column++) {
                // Check ROWS
                for (int row = 0; row < board.length; row++) {
                    // Check if the current cell is empty
                    // Check if the current cell and the next cell are the same
                    if (board[row][column] == ' ' || board[row][column] != board[row + 1][column]) {
                        break;
                    }

                    // Check if row is the last row
                    // Use row - 2 because we are comparing the current cell with the next cell
                    if (row == board.length - 2) {
                        won = true;
                        break;
                    }
                }
            }

            // Check DIAGONALS
            // Check the first diagonal (top-left to bottom-right)
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] == ' ' || board[i][i] != board[i + 1][i + 1]) {
                    break;
                }

                // Check if we are at the last cell of the diagonal
                if (i == board.length - 2) {
                    won = true;
                    break;
                }
            }

            // Check the second diagonal (top-right to bottom-left)
            for (int i = 0; i < board.length; i++) {
                // Check if the current cell is empty
                // Check if the current cell and the next cell are the same
                if (board[i][board.length - 1 - i] == ' '
                        || board[i][board.length - 1 - i] != board[i + 1][board.length - 2 - i]) {
                    break;
                }

                // Check if we are at the last cell of the diagonal
                if (i == board.length - 2) {
                    won = true;
                    break;
                }
            }

            // X | O | O
            // ----------
            // O | X | O
            // ----------
            // O | X | O

            // Check for a draw using leftMoves variable
            if (leftMoves == 0) {
                System.out.println("It's a draw!");
                break;
            }

            // Check for remaining empty cells
            // boolean draw = true;

            // Check if there are any empty cells left on the board
            // for (int row = 0; row < board.length; row++) {
            //     for (int column = 0; column < board[row].length; column++) {
            //         // Check if the current cell is empty
            //         if (board[row][column] == ' ') {
            //             draw = false;
            //             break;
            //         }
            //     }

            //     // Check if we have already found an empty cell
            //     if (!draw) {
            //         break;
            //     }
            // }

            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    if (board[row][column] == ' ') {
                        break;
                    }

                    // Check if we are at the last cell of the board
                    if (row == board.length - 1 && column == board[row].length - 1) {
                        System.out.println("It's a draw!");
                        return;
                    }
                }
            }

            // Check WINNING CONDITIONS
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
                // Check if it's the first column
                if (column == 0) {
                    // Print a space before the first column
                    System.out.print(" ");
                }

                // Print the current cell value
                System.out.print(board[row][column]);

                // Print a separator if it's not the last column
                if (column < board[row].length - 1) {
                    System.out.print(" | ");
                }

                // Check if it's the last column
                if (column == board[row].length - 1) {
                    // Print a space after the last column
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