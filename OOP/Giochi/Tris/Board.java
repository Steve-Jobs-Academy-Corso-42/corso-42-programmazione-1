package OOP.Giochi.Tris;

public class Board {
    private String[][] board = {
            { " ", " ", " " },
            { " ", " ", " " },
            { " ", " ", " " }
    };

    private int leftMoves = this.getRows() * this.getColumns();

    public Board() {
        this.print();
    }

    public int getRows() {
        return board.length;
    }

    public int getColumns() {
        return board[0].length;
    }

    // Inserisce una mossa sulla board, restituendo true se la mossa è stata
    // inserita con successo, altrimenti false
    public boolean insertMove(int row, int column, String symbol) {
        // Update the board based on the move
        if (board[row][column].equals(" ")) {
            board[row][column] = symbol;
            leftMoves--;
            return true;
        } else {
            System.out.println("Cell " + row + "," + column + " is already occupied. Try again.");
            return false;
        }
    }

    // Controlla se un giocatore ha vinto
    public boolean checkWin() {
        return this.checkWinRow() || this.checkWinColumn() || this.checkWinDiagonal();
    }

    // Controlla le righe
    private boolean checkWinRow() {
        for (int row = 0; row < this.getRows(); row++) {
            // Controlla le colonne
            for (int column = 0; column < this.getColumns(); column++) {
                // Controlla se la cella corrente è vuota
                // Controlla se la cella corrente e la successiva sono uguali
                if (board[row][column].equals(" ") || !board[row][column].equals(board[row][column + 1])) {
                    break;
                }

                // Controlla se la colonna è la penultima
                // Usiamo -2 perché confrontiamo la cella corrente con la successiva
                if (column == this.getColumns() - 2) {
                    // Restituisce true se tutta la riga coincide
                    return true;

                }

            }
        }

        return false;
    }

    // Controlla le colonne
    private boolean checkWinColumn() {
        for (int column = 0; column < this.getColumns(); column++) {
            // Controlla le righe
            for (int row = 0; row < this.getRows(); row++) {
                // Controlla se la cella corrente è vuota
                // Controlla se la cella corrente e la successiva sono uguali
                if (board[row][column].equals(" ") || !board[row][column].equals(board[row + 1][column])) {
                    break;
                }

                // Controlla se la riga è la penultima
                // Usiamo -2 perché confrontiamo la cella corrente con la successiva
                if (row == this.getRows() - 2) {
                    return true;
                }
            }
        }

        return false;
    }

    // Controlla le diagonali
    private boolean checkWinDiagonal() {
        // Controlla la prima diagonale (da alto-sinistra a basso-destra)
        for (int i = 0; i < this.getRows(); i++) {
            if (board[i][i].equals(" ") || !board[i][i].equals(board[i + 1][i + 1])) {
                break;
            }

            // Controlla se siamo all'ultima cella della diagonale
            if (i == this.getRows() - 2) {
                return true;
            }
        }

        // Controlla la seconda diagonale (da alto-destra a basso-sinistra)
        for (int i = 0; i < this.getRows(); i++) {
            // Controlla se la cella corrente è vuota
            // Controlla se la cella corrente e la successiva sono uguali
            if (board[i][this.getColumns() - 1 - i].equals(" ")
                    || !board[i][this.getColumns() - 1 - i].equals(board[i + 1][this.getColumns() - 2 - i])) {
                break;
            }

            // Controlla se siamo all'ultima cella della diagonale
            if (i == this.getRows() - 2) {
                return true;
            }
        }

        return false;
    }

    // Controlla se la partita è finita in pareggio
    public boolean checkDraw() {
        // Controlla se ci sono mosse rimanenti
        return leftMoves == 0;
    }

    // Metodo per stampare la board
    public void print() {
        // Mostra la board (righe e colonne)
        for (int row = 0; row < this.getRows(); row++) { // Riga
            for (int column = 0; column < this.getColumns(); column++) { // Colonna
                // Controlla se è la prima colonna
                if (column == 0) {
                    // Stampa uno spazio prima della prima colonna
                    System.out.print(" ");
                }

                // Stampa il valore della cella corrente
                System.out.print(board[row][column]);

                // Stampa un separatore se non è l'ultima colonna
                if (column < this.getColumns() - 1) {
                    System.out.print(" | ");
                }

                // Controlla se è l'ultima colonna
                if (column == this.getColumns() - 1) {
                    // Stampa uno spazio dopo l'ultima colonna
                    System.out.print(" ");
                }
            }

            // Stampa un separatore se non è l'ultima riga
            System.out.println();

            // Stampa una linea separatrice se non è l'ultima riga
            if (row < this.getRows() - 1) {
                System.out.println("---+---+---");
            }
        }
    }

}
