package Grafica.EsempioTrisBaseNoLogica;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // JFrame è la finestra vera e propria dell'applicazione.
        // Gli passiamo il titolo come stringa.
        JFrame frame = new JFrame("GINO!");

        frame.setSize(300, 300); // dimensioni in pixel: larghezza x altezza
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // chiude il programma quando si chiude la finestra

        // CustomPanel è il nostro "foglio da disegno" (estende JPanel).
        // Lo aggiungiamo al frame prima di renderlo visibile.
        CustomPanel panel = new CustomPanel();
        frame.add(panel);

        // Rendiamo la finestra visibile: solo ora Java chiama paintComponent() per la
        // prima volta.
        frame.setVisible(true);

        // MouseAdapter ci permette di ascoltare i click del mouse sul pannello.
        // Sovrascriviamo solo mouseClicked, che viene chiamato ad ogni click.
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // e.getX() e e.getY() restituiscono le coordinate in pixel del click
                int x = e.getX();
                int y = e.getY();

                // Convertiamo le coordinate pixel in numero di cella (0, 1 o 2).
                // Ogni cella è larga/alta 100px, quindi dividendo per 100 otteniamo l'indice.
                int colonna = Math.round(x / 100);
                int riga = Math.round(y / 100);

                // Ricalcoliamo le coordinate in pixel dell'angolo in alto a sinistra della
                // cella
                int r = riga * 100;
                int c = colonna * 100;

                // Disegniamo una X nella cella cliccata:
                // due diagonali che si incrociano nel centro della cella.
                // Un margine di 10px rende la X più piccola della cella.
                Graphics gino = panel.getGino();
                gino.drawLine(c + 10, r + 10, c + 90, r + 90); // diagonale \
                gino.drawLine(c + 90, r + 10, c + 10, r + 90); // diagonale /
            }
        });
    }
}