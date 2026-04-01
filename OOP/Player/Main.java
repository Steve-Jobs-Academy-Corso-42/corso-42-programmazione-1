package OOP.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crea un oggetto Player senza passare un nome (nome e simbolo inizialmente null)
        Player p1 = new Player();

        // Crea uno Scanner per leggere l'input dell'utente da console
        Scanner scanner = new Scanner(System.in);

        // Controlla se il giocatore non ha ancora un nome → hasName() restituisce false
        if (!p1.hasName()) {
            // Chiedi all'utente di inserire il nome
            System.out.println("Inserisci il nome del giocatore:");
            String name = scanner.nextLine();

            // Assegna il nome inserito al giocatore tramite il setter
            p1.setName(name);
        }

        // Controlla se il giocatore non ha ancora un simbolo → hasSymbol() restituisce false
        if (!p1.hasSymbol()) {
            // Chiedi all'utente di inserire il simbolo
            System.out.println("Inserisci il simbolo del giocatore (es. 🔵, X, O):");
            String symbol = scanner.nextLine();

            // Assegna il simbolo inserito al giocatore tramite il setter
            p1.setSymbol(symbol);
        }

        // Se il giocatore ha sia nome che simbolo validi → stampa le sue informazioni
        if (p1.hasName() && p1.hasSymbol()) {
            p1.print();
        }

        scanner.close();
    }
}
