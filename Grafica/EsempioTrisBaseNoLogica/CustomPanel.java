package Grafica.EsempioTrisBaseNoLogica;

import javax.swing.JPanel;
import java.awt.Graphics;

// CustomPanel estende JPanel: è il "foglio" su cui disegniamo.
// Ogni volta che la finestra viene ridisegnata, Java chiama paintComponent().
public class CustomPanel extends JPanel {

    // "Gino" è semplicemente un soprannome simpatico per getGraphics(),
    // un metodo già presente in JPanel che restituisce l'oggetto Graphics del pannello.
    // Lo richiamiamo qui per poterlo usare comodamente dall'esterno (es. in Main.java).
    //
    // Con l'oggetto Graphics puoi fare quello che vuoi, non ci sono limiti!
    // Esempi:
    //
    //   g.setColor(Color.RED);                        → cambia colore
    //   g.drawLine(x1, y1, x2, y2);                  → disegna una linea
    //   g.drawRect(x, y, larghezza, altezza);         → rettangolo (solo bordo)
    //   g.fillRect(x, y, larghezza, altezza);         → rettangolo pieno
    //   g.drawOval(x, y, larghezza, altezza);         → ovale/cerchio (bordo)
    //   g.fillOval(x, y, larghezza, altezza);         → ovale/cerchio pieno
    //   g.drawArc(x, y, w, h, angStart, angExt);      → arco
    //   g.setFont(new Font("Arial", Font.BOLD, 20));  → cambia font
    //   g.drawString("Ciao!", x, y);                  → scrivi testo
    //   g.drawImage(immagine, x, y, this);            → disegna un'immagine
    public Graphics getGino() {
        return getGraphics();
    }

    // paintComponent viene chiamato automaticamente da Java quando:
    // - la finestra viene aperta per la prima volta
    // - la finestra viene ridimensionata o riportata in primo piano
    // Qui disegniamo la griglia del Tris con 4 linee (2 verticali + 2 orizzontali)
    protected void paintComponent(Graphics gino) {
        // Chiamata obbligatoria: pulisce il pannello prima di ridisegnarlo
        super.paintComponent(gino);

        // Linee verticali: dividono il pannello in 3 colonne da 100px
        gino.drawLine(100, 0, 100, 300); // prima linea verticale
        gino.drawLine(200, 0, 200, 300); // seconda linea verticale

        // Linee orizzontali: dividono il pannello in 3 righe da 100px
        gino.drawLine(0, 100, 300, 100); // prima linea orizzontale
        gino.drawLine(0, 200, 300, 200); // seconda linea orizzontale
    }
}
