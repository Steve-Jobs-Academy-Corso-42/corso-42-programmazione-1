package Forza4;

// =============================================================
// FORZA 4 - Passaggi logici dettagliati
// =============================================================
//
// 1. SETUP INIZIALE
//    - Definire le costanti ROWS=6 e COLUMNS=7 per le dimensioni della griglia
//    - Definire i simboli dei giocatori: PLAYER_A="🔵", PLAYER_B="🔴"
//    - Creare la griglia come array bidimensionale String[ROWS][COLUMNS]
//      → ogni cella è null finché non viene occupata da un disco
//    - Impostare il giocatore corrente a PLAYER_A (inizia per primo)
//    - Creare lo Scanner per leggere l'input da tastiera
//    - Inizializzare leftMoves = ROWS * COLUMNS (42 mosse totali disponibili)
//
// 2. CICLO DI GIOCO (while true)
//
//    a. MOSTRA LA GRIGLIA
//       - Chiamare printBoard(board) per stampare lo stato attuale
//       - Le celle vuote (null) vengono stampate come "  " (due spazi)
//       - Le celle occupate mostrano il simbolo del giocatore
//
//    b. LEGGI L'INPUT DEL GIOCATORE
//       - Chiedere al giocatore corrente di inserire un numero di colonna (0-6)
//       - Leggere il valore con scanner.nextInt()
//
//    c. VALIDA LA COLONNA
//       - Se inputColumn < 0 oppure inputColumn >= COLUMNS → input non valido
//       - Stampare un messaggio di errore e ricominciare il loop (continue)
//
//    d. EFFETTO GRAVITÀ (trova la riga target)
//       - Scorrere le righe dal fondo verso l'alto (da ROWS-1 a 0)
//       - La prima riga con cella null è la riga target dove cade il disco
//       - Se nessuna riga è libera → targetRow rimane -1 (colonna piena)
//
//    e. COLONNA PIENA
//       - Se targetRow == -1 → la colonna è piena
//       - Stampare un messaggio di errore e ricominciare il loop (continue)
//
//    f. POSIZIONA IL DISCO
//       - Assegnare board[targetRow][inputColumn] = player
//       - Decrementare leftMoves di 1
//
//    g. CONTROLLA LA VITTORIA → checkWin(board)
//       - horizontalWin: scorrere ogni riga, cercare 4 celle consecutive uguali
//         Loop su row (0 → ROWS-1), loop su col (0 → COLUMNS-4)
//         Per ogni cella non nulla, usare un loop k (1→3) per confrontare
//         board[row][col] con board[row][col+k]
//       - verticalWin: scorrere ogni colonna, cercare 4 celle consecutive uguali
//         Loop su col (0 → COLUMNS-1), loop su row (0 → ROWS-4)
//         Per ogni cella non nulla, confrontare board[row][col] con board[row+k][col]
//       - diagonalWin (\): cercare 4 celle lungo la diagonale alto-sinistra→basso-destra
//         Loop su row (0 → ROWS-4), loop su col (0 → COLUMNS-4)
//         Per ogni cella non nulla, confrontare board[row][col] con board[row+k][col+k]
//       - diagonalNegativeWin (/): cercare 4 celle lungo la diagonale alto-destra→basso-sinistra
//         Loop su row (0 → ROWS-4), loop su col (3 → COLUMNS-1)
//         Per ogni cella non nulla, confrontare board[row][col] con board[row+k][col-k]
//       → Se uno dei quattro controlli è true: stampare il vincitore e uscire (break)
//
//    h. CONTROLLA IL PAREGGIO
//       - Se leftMoves == 0 e nessuno ha vinto → pareggio
//       - Stampare "It's a draw!" e uscire (break)
//
//    i. ALTERNA IL TURNO
//       - Se player == PLAYER_A → diventa PLAYER_B, e viceversa
//       - Ricominciare il loop dal punto a.
//
// 3. FINE DEL GIOCO
//    - Il loop termina con break dopo una vittoria o un pareggio
//
// =============================================================

import java.util.Scanner;

public class Forza4 {
    public static void main(String[] args) {
        // --- Costanti della griglia ---
        final int ROWS = 6; // 6 righe
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
    public static boolean horizontalWin(String[][] board) {
        boolean won = false;

        for (int row = 0; row < board.length; row++) {
            // Si scorre fino a COLUMNS-4 perché servono almeno 4 celle consecutive
            for (int col = 0; col < board[0].length - 3; col++) {
                if (board[row][col] != null) {
                    boolean match = true;
                    // Confronta le 3 celle successive con la cella di partenza
                    for (int k = 1; k < 4; k++) {
                        if (!board[row][col].equals(board[row][col + k])) {
                            match = false;
                            break;
                        }
                    }

                    // Se tutte e 4 le celle sono uguali, il giocatore ha vinto
                    if (match) {
                        won = true;
                        break;
                    }
                }
            }

            // Se un giocatore ha già vinto, non serve continuare a controllare
            if (won)
                break;
        }

        return won;
    }

    // Controlla se ci sono 4 dischi uguali consecutivi su una colonna verticale
    public static boolean verticalWin(String[][] board) {
        boolean won = false;

        for (int col = 0; col < board[0].length; col++) {
            // Si scorre fino a ROWS-4 perché servono almeno 4 celle consecutive
            for (int row = 0; row < board.length - 3; row++) {
                if (board[row][col] != null) {
                    boolean match = true;
                    // Confronta le 3 celle sottostanti con la cella di partenza
                    for (int k = 1; k < 4; k++) {
                        if (!board[row][col].equals(board[row + k][col])) {
                            match = false;
                            break;
                        }
                    }

                    // Se tutte e 4 le celle sono uguali, il giocatore ha vinto
                    if (match) {
                        won = true;
                        break;
                    }
                }

                // Se un giocatore ha già vinto, non serve continuare a controllare
                if (won)
                    break;
            }
        }

        return won;
    }

    // Controlla la diagonale dall'alto-sinistra verso il basso-destra (\)
    public static boolean diagonalWin(String[][] board) {
        boolean won = false;

        // Limiti: row <= ROWS-4 e col <= COLUMNS-4 per avere spazio per 4 celle
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < board[0].length - 3; col++) {
                if (board[row][col] != null) {
                    boolean match = true;
                    // Avanza di k sia sulle righe che sulle colonne (+k, +k)
                    for (int k = 1; k < 4; k++) {
                        if (!board[row][col].equals(board[row + k][col + k])) {
                            match = false;
                            break;
                        }
                    }

                    // Se tutte e 4 le celle sono uguali, il giocatore ha vinto
                    if (match) {
                        won = true;
                        break;
                    }
                }
            }

            // Se un giocatore ha già vinto, non serve continuare a controllare
            if (won)
                break;
        }

        return won;
    }

    // Controlla la diagonale dall'alto-destra verso il basso-sinistra (/)
    public static boolean diagonalNegativeWin(String[][] board) {
        boolean won = false;

        // Limiti: row <= ROWS-4, col parte da 3 perché si va verso sinistra (-k)
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 3; col < board[0].length; col++) {
                if (board[row][col] != null) {
                    boolean match = true;
                    // Avanza di k sulle righe e arretra di k sulle colonne (+k, -k)
                    for (int k = 1; k < 4; k++) {
                        if (!board[row][col].equals(board[row + k][col - k])) {
                            match = false;
                            break;
                        }
                    }

                    // Se tutte e 4 le celle sono uguali, il giocatore ha vinto
                    if (match) {
                        won = true;
                        break;
                    }
                }
            }

            // Se un giocatore ha già vinto, non serve continuare a controllare
            if (won)
                break;
        }

        return won;
    }
}
