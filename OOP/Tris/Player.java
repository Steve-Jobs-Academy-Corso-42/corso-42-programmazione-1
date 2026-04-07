package OOP.Tris;

import java.util.Scanner;

public class Player {
    String name;
    String symbol;

    Scanner scanner = new Scanner(System.in);

    Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    void makeMove(Board board) {
        // Variabili per memorizzare l'input del giocatore
        int inputRow;
        int inputColumn;

        do {
            // Input per riga con validazione
            while (true) {
                // Chiedi al giocatore di inserire la riga
                System.out.print("Player " + this.name + ", enter your move (row): ");
                // Leggi l'input del giocatore e memorizzalo in inputRow
                inputRow = scanner.nextInt();

                // Valida la mossa
                if (inputRow < 0 || inputRow >= board.getRows()) {
                    System.out.println("Invalid move. Try again.");

                    // Continua a chiedere input finché non viene inserita una mossa valida
                    continue;
                }

                // Se la mossa è valida, esci dal ciclo
                break;
            }

            // Input per colonna con validazione
            while (true) {
                // Chiedi al giocatore di inserire la colonna
                System.out.print("Player " + this.name + ", enter your move (column): ");

                // Leggi l'input del giocatore e memorizzalo in inputColumn
                inputColumn = scanner.nextInt();

                // Valida la mossa
                if (inputColumn < 0 || inputColumn >= board.getColumns()) {
                    System.out.println("Invalid move. Try again.");

                    // Continua a chiedere input finché non viene inserita una mossa valida
                    continue;
                }

                // Se la mossa è valida, esci dal ciclo
                break;
            }

            // Aggiorna la board in base alla mossa
        } while (!board.insertMove(inputRow, inputColumn, this.symbol));
    }
}
