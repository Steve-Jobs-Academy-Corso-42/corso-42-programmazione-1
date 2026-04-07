package OOP.Completi.Veicoli.mezzi;

import OOP.Completi.Veicoli.base.Veicolo;
import OOP.Completi.Veicoli.contratti.Guidabile;

// Esempio di classe concreta che implementa solo Guidabile.
public class FurgoneConsegne extends Veicolo implements Guidabile {
    private int caricoKg;

    public FurgoneConsegne(String modello, int caricoKg) {
        super(modello);
        this.caricoKg = caricoKg;
    }

    @Override
    public void accelera(int kmh) {
        int riduzionePerPeso = caricoKg > 500 ? 5 : 0;
        velocita += Math.max(0, kmh - riduzionePerPeso);
        System.out.println(modello + " accelera con carico di " + caricoKg + " kg");
    }

    @Override
    public void frena(int kmh) {
        velocita = Math.max(0, velocita - kmh);
        System.out.println(modello + " frena di " + kmh + " km/h");
    }

    @Override
    public int limiteVelocitaUrbano() {
        return 50;
    }
}
