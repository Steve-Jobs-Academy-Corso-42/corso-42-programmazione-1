package OOP.Player;

// Classe che rappresenta un giocatore generico
// Incapsula nome e simbolo (es. emoji o carattere) come attributi privati
// e li espone tramite metodi getter e setter (principio di incapsulamento OOP)
public class Player {
    // Nome del giocatore (es. "Mario")
    private String name;

    // Simbolo del giocatore (es. "🔵", "X", "O")
    private String symbol;

    // Costruttore senza parametri: crea un giocatore con nome e simbolo non impostati (null)
    Player() {
        this.name = null;
        this.symbol = null;
    }

    // Costruttore con parametri: inizializza il giocatore con nome e simbolo
    Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    // --- GETTER ---

    // Restituisce il nome del giocatore
    public String getName() {
        return this.name;
    }

    // Restituisce il simbolo del giocatore
    public String getSymbol() {
        return this.symbol;
    }

    // --- SETTER ---

    // Imposta (o aggiorna) il nome del giocatore
    public void setName(String name) {
        this.name = name;
    }

    // Imposta (o aggiorna) il simbolo del giocatore
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // Restituisce true se il giocatore ha un nome valido (non null e non vuoto)
    public boolean hasName() {
        return this.name != null && !this.name.isEmpty();
    }

    // Restituisce true se il giocatore ha un simbolo valido (non null e non vuoto)
    public boolean hasSymbol() {
        return this.symbol != null && !this.symbol.isEmpty();
    }

    @Override // Override del metodo toString()
    // Restituisce una rappresentazione testuale del giocatore nel formato: "nome con simbolo 'simbolo'"
    public String toString() {
        return this.name + " con simbolo '" + this.symbol + "'";
    }

    // Stampa la rappresentazione testuale del giocatore
    public void print() {
        System.out.println(this.toString());
    }
}
