package OOP.Completi.Veicoli.base;

// Classe astratta: contiene lo stato comune a tutti i veicoli.
public abstract class Veicolo {
    protected String modello;
    protected int velocita;

    protected Veicolo(String modello) {
        this.modello = modello;
        this.velocita = 0;
    }

    public String getModello() {
        return modello;
    }

    public int getVelocita() {
        return velocita;
    }

    // Ogni veicolo concreto puo avere regole diverse per il limite urbano.
    public abstract int limiteVelocitaUrbano();

    public void stampaStato() {
        System.out.println(modello + " -> velocita attuale: " + velocita + " km/h");
    }
}
