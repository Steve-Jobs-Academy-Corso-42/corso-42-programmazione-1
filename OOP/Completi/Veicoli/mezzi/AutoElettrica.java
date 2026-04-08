package OOP.Completi.Veicoli.mezzi;

import OOP.Completi.Veicoli.base.Veicolo;
import OOP.Completi.Veicoli.interfacce.Guidabile;
import OOP.Completi.Veicoli.interfacce.Ricaricabile;

// Esempio di classe concreta che estende Veicolo e implementa due interfacce.
public class AutoElettrica extends Veicolo implements Guidabile, Ricaricabile {
    private int batteria;

    public AutoElettrica(String modello) {
        super(modello);
        this.batteria = 100;
    }

    @Override
    public void accelera(int kmh) {
        velocita += kmh;
        batteria = Math.max(0, batteria - (kmh / 4));
        System.out.println(modello + " accelera di " + kmh + " km/h");
    }

    @Override
    public void frena(int kmh) {
        velocita = Math.max(0, velocita - kmh);
        System.out.println(modello + " frena di " + kmh + " km/h");
    }

    @Override
    public void ricarica(int percentuale) {
        batteria = Math.min(100, batteria + percentuale);
        System.out.println(modello + " ricaricata al " + batteria + "%");
    }

    @Override
    public int limiteVelocitaUrbano() {
        return 50;
    }

    public void stampaBatteria() {
        System.out.println("Batteria: " + batteria + "%");
    }
}
