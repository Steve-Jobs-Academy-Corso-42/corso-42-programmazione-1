package OOP.Completi.Veicoli.demo;

import OOP.Completi.Veicoli.contratti.Guidabile;
import OOP.Completi.Veicoli.mezzi.AutoElettrica;
import OOP.Completi.Veicoli.mezzi.FurgoneConsegne;

// Demo completa:
// - extends: AutoElettrica e FurgoneConsegne estendono Veicolo
// - implements: i mezzi implementano i contratti Guidabile/Ricaricabile
public class EsempioInterfacceMain {
    public static void main(String[] args) {
        AutoElettrica tesla = new AutoElettrica("Tesla Model 3");
        FurgoneConsegne ducato = new FurgoneConsegne("Fiat Ducato", 720);

        // Polimorfismo: tratto mezzi diversi come Guidabile.
        Guidabile[] flotta = { tesla, ducato };

        // Ciclo sui mezzi per accelera e frena, dimostrando il polimorfismo.
        for (Guidabile mezzo : flotta) {
            mezzo.accelera(30);
            mezzo.frena(10);
        }

        tesla.ricarica(15);
        tesla.stampaBatteria();

        tesla.stampaStato();
        ducato.stampaStato();

        System.out.println("Limite urbano " + tesla.getModello() + ": " + tesla.limiteVelocitaUrbano() + " km/h");
        System.out.println("Limite urbano " + ducato.getModello() + ": " + ducato.limiteVelocitaUrbano() + " km/h");
    }
}
