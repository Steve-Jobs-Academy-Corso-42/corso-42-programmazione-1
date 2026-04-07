package OOP.Esempi.Player;

// Classe che rappresenta un giocatore generico
// Incapsula nome e simbolo come attributi privati
// esposti tramite getter e setter (incapsulamento OOP)
public class Player {
    // Nome del giocatore (es. "Mario")
    private String name;

    // Simbolo del giocatore (es. "🔵", "X", "O")
    private String symbol;

    // Costruttore senza parametri: nome e simbolo null
    Player() {
        this.name = null;
        this.symbol = null;
    }

    // Costruttore con parametri: inizializza nome e simbolo
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

    // Restituisce true se il nome è valido (non null e non vuoto)
    public boolean hasName() {
        return this.name != null && !this.name.isEmpty();
    }

    // Restituisce true se il simbolo è valido (non null e non vuoto)
    public boolean hasSymbol() {
        return this.symbol != null && !this.symbol.isEmpty();
    }

    @Override // Override del metodo toString()
    // toString(): "nome con simbolo 'simbolo'"
    public String toString() {
        return this.name + " con simbolo '" + this.symbol + "'";
    }

    // Stampa la rappresentazione testuale del giocatore
    public void print() {
        System.out.println(this.toString());
    }
}
