package OOP.Esempi.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crea un Player con nome e simbolo non impostati (null)
        Player p1 = new Player();

        // Crea uno Scanner per leggere l'input dell'utente da console
        Scanner scanner = new Scanner(System.in);

        // Controlla se manca il nome → hasName() è false
        if (!p1.hasName()) {
            // Chiedi all'utente di inserire il nome
            System.out.println("Inserisci il nome del giocatore:");
            String name = scanner.nextLine();

            // Assegna il nome inserito al giocatore tramite il setter
            p1.setName(name);
        }

        // Controlla se manca il simbolo → hasSymbol() è false
        if (!p1.hasSymbol()) {
            // Chiedi all'utente di inserire il simbolo
            System.out.println("Inserisci il simbolo del giocatore (es. 🔵, X, O):");
            String symbol = scanner.nextLine();

            // Assegna il simbolo inserito al giocatore tramite il setter
            p1.setSymbol(symbol);
        }

        // Se nome e simbolo sono validi → stampa le informazioni
        if (p1.hasName() && p1.hasSymbol()) {
            p1.print();
        }

        scanner.close();
    }
}
