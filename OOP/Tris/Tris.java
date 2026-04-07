package OOP.Tris;

public class Tris {
    public static void main(String[] args) {
        // Creazione del board
        Board board = new Board();

        // Creazione dei giocatori
        Player p1 = new Player("Mario", "X");
        Player p2 = new Player("Luigi", "O");

        // Inizializza il giocatore corrente a p1
        Player currentPlayer = p1;

        boolean gameOver = false;

        // Ciclo di gioco
        while (!gameOver) {
            // Esegui la mossa del giocatore corrente
            currentPlayer.makeMove(board);

            // Controlla se il giocatore corrente ha vinto
            if (board.checkWin()) {
                System.out.println("Player " + currentPlayer.name + " wins!");
                gameOver = true;
            }

            // Controlla se la partita finisce in pareggio
            if (board.checkDraw()) {
                System.out.println("It's a draw!");
                gameOver = true;
            }

            // Cambia il giocatore corrente
            currentPlayer = (currentPlayer == p1) ? p2 : p1;

            // Stampa la board
            board.print();
        }
    }
}
