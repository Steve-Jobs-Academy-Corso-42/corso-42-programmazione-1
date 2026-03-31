package Forza4;

import java.util.Scanner;

public class Forza4Hardcoded {
    public static void main(String[] args) {
        // --- Costanti della griglia ---
        final int ROWS = 6;    // 6 righe
        final int COLUMNS = 7; // 7 colonne

        // --- Simboli dei due giocatori ---
        final String PLAYER_A = "🔵"; // Giocatore 1
        final String PLAYER_B = "🔴"; // Giocatore 2

        // --- Griglia di gioco ---
        // Ogni cella è null se vuota, oppure contiene il simbolo del giocatore
        String[][] board = new String[ROWS][COLUMNS];

        // Il giocatore 1 inizia per primo
        String player = PLAYER_A;

        Scanner scanner = new Scanner(System.in);

        // Contatore delle mosse rimanenti: parte dal numero totale di celle
        int leftMoves = ROWS * COLUMNS;

        // --- Ciclo di gioco principale ---
        // Continua finché un giocatore non vince o la griglia è piena (pareggio)
        while (true) {
            // Mostra lo stato attuale della griglia
            printBoard(board);

            // Chiedi al giocatore corrente di scegliere una colonna
            System.out.print("Player " + player + ", enter your move (column 0-" + (COLUMNS - 1) + "): ");
            int inputColumn = scanner.nextInt();

            // Valida l'input: la colonna deve essere compresa tra 0 e COLUMNS-1
            if (inputColumn < 0 || inputColumn >= COLUMNS) {
                System.out.println("Invalid column. Try again.");
                continue;
            }

            // Trova la riga più bassa libera nella colonna scelta (effetto gravità)
            // Si parte dal fondo (ROWS-1) e si sale finché si trova una cella vuota
            int targetRow = -1;
            for (int row = ROWS - 1; row >= 0; row--) {
                if (board[row][inputColumn] == null) {
                    targetRow = row;
                    break;
                }
            }

            // Se targetRow è rimasto -1, la colonna è piena: chiedi di nuovo
            if (targetRow < 0) {
                System.out.println("Invalid column (full). Try again.");
                continue;
            }

            // Posiziona il disco del giocatore nella cella trovata
            board[targetRow][inputColumn] = player;

            // Diminuisce il contatore delle mosse disponibili
            leftMoves--;

            // Controlla se il giocatore corrente ha vinto
            if (checkWin(board)) {
                System.out.println("Player " + player + " wins!");
                printBoard(board);
                break;
            }

            // Controlla il pareggio: nessuna mossa rimasta e nessun vincitore
            if (leftMoves == 0) {
                System.out.println("It's a draw!");
                printBoard(board);
                break;
            }

            // Alterna il turno: se era PLAYER_A passa a PLAYER_B e viceversa
            player = player.equals(PLAYER_A) ? PLAYER_B : PLAYER_A;
        }
    }

    // Stampa la griglia a schermo con separatori visivi tra le celle
    public static void printBoard(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                // Spazio iniziale prima della prima colonna
                if (column == 0) {
                    System.out.print(" ");
                }

                // Stampa il simbolo del giocatore oppure due spazi se la cella è vuota
                System.out.print(board[row][column] == null ? "  " : board[row][column]);

                // Separatore verticale tra le celle (tranne dopo l'ultima)
                if (column < board[row].length - 1) {
                    System.out.print(" | ");
                }

                // Spazio finale dopo l'ultima colonna
                if (column == board[row].length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            // Riga separatrice orizzontale tra le righe (non dopo l'ultima riga)
            if (row < board.length - 1) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print("----");

                    // Incrocio "+" tra le celle (non dopo l'ultima colonna)
                    if (col < board[row].length - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    // Controlla tutte le condizioni di vittoria possibili
    // Restituisce true se uno dei quattro controlli rileva 4 dischi allineati
    public static boolean checkWin(String[][] board) {
        return horizontalWin(board) || verticalWin(board) || diagonalWin(board) || diagonalNegativeWin(board);
    }

    // Controlla se ci sono 4 dischi uguali consecutivi su una riga orizzontale
    // I 4 confronti sono hardcodati: col+1, col+2, col+3
    public static boolean horizontalWin(String[][] board) {
        boolean won = false;

        for (int row = 0; row < board.length; row++) {
            // Si scorre fino a COLUMNS-4 perché servono almeno 4 celle consecutive
            for (int col = 0; col < board[0].length - 3; col++) {
                // Confronta la cella di partenza con le 3 successive nella stessa riga
                if (board[row][col] != null &&
                        board[row][col] == board[row][col + 1] &&
                        board[row][col] == board[row][col + 2] &&
                        board[row][col] == board[row][col + 3]) {
                    won = true;
                    break;
                }
            }

            if (won)
                break;
        }

        return won;
    }

    // Controlla se ci sono 4 dischi uguali consecutivi su una colonna verticale
    // I 4 confronti sono hardcodati: row+1, row+2, row+3
    public static boolean verticalWin(String[][] board) {
        boolean won = false;

        for (int col = 0; col < board[0].length; col++) {
            // Si scorre fino a ROWS-4 perché servono almeno 4 celle consecutive
            for (int row = 0; row < board.length - 3; row++) {
                // Confronta la cella di partenza con le 3 sottostanti nella stessa colonna
                if (board[row][col] != null &&
                        board[row][col] == board[row + 1][col] &&
                        board[row][col] == board[row + 2][col] &&
                        board[row][col] == board[row + 3][col]) {
                    won = true;
                    break;
                }
            }

            if (won)
                break;
        }

        return won;
    }

    // Controlla la diagonale dall'alto-sinistra verso il basso-destra (\)
    // I 4 confronti sono hardcodati: (row+1,col+1), (row+2,col+2), (row+3,col+3)
    public static boolean diagonalWin(String[][] board) {
        boolean won = false;

        // Limiti: row <= ROWS-4 e col <= COLUMNS-4 per avere spazio per 4 celle
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < board[0].length - 3; col++) {
                // Confronta la cella di partenza con le 3 lungo la diagonale \
                if (board[row][col] != null &&
                        board[row][col] == board[row + 1][col + 1] &&
                        board[row][col] == board[row + 2][col + 2] &&
                        board[row][col] == board[row + 3][col + 3]) {
                    won = true;
                    break;
                }
            }

            if (won)
                break;
        }

        return won;
    }

    // Controlla la diagonale dall'alto-destra verso il basso-sinistra (/)
    // I 4 confronti sono hardcodati: (row+1,col-1), (row+2,col-2), (row+3,col-3)
    public static boolean diagonalNegativeWin(String[][] board) {
        boolean won = false;

        // Limiti: row <= ROWS-4, col parte da 3 perché si va verso sinistra (-k)
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 3; col < board[0].length; col++) {
                // Confronta la cella di partenza con le 3 lungo la diagonale /
                if (board[row][col] != null &&
                        board[row][col] == board[row + 1][col - 1] &&
                        board[row][col] == board[row + 2][col - 2] &&
                        board[row][col] == board[row + 3][col - 3]) {
                    won = true;
                    break;
                }
            }

            if (won)
                break;
        }

        return won;
    }
}
