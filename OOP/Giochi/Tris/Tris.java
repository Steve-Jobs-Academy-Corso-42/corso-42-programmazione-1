package OOP.Giochi.Tris;

public class Tris {
    public static void main(String[] args) {
        // Creazione del board
        Board board = new Board();

        // Creazione dei giocatori
        Player p1 = new Player("Mario", "X");
        Player p2 = new Player("Luigi", "O");

        // Inizializza il giocatore corrente a p1
        Player currentPlayer = p1;

        // Ciclo di gioco
        while (true) {
            // Esegui la mossa del giocatore corrente
            currentPlayer.makeMove(board);

            // Controlla se il giocatore corrente ha vinto
            if (board.checkWin()) {
                // Stampa la board
                board.print();

                System.out.println("Player " + currentPlayer.name + " wins!");
                break;
            }

            // Controlla se la partita finisce in pareggio
            if (board.checkDraw()) {
                // Stampa la board
                board.print();

                System.out.println("It's a draw!");
                break;
            }

            // Cambia il giocatore corrente
            currentPlayer = (currentPlayer == p1) ? p2 : p1;

            // Stampa la board
            board.print();
        }
    }
}
