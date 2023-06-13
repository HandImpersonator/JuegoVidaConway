/**

 Esta clase representa la ventana de fin de juego, que se muestra cuando todas las células han muerto en la partida.
 Proporciona un mensaje al jugador informándole que la partida ha terminado.
 Después de un tiempo determinado, redirige al jugador a la ventana principal del juego.
 */
package juego.view;
import jugador.model.Jugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEndGame extends JFrame {

    private final Jugador jugador;

    /**
     * Crea una instancia de la ventana de fin de juego.
     *
     * @param jugador El jugador que ha participado en la partida.
     */
    public ViewEndGame(Jugador jugador) {
        this.jugador = jugador;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Partida terminada, todas las células han muerto.");
        add(label);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewWindowJuego vwj = new ViewWindowJuego(jugador);
                vwj.setVisible(true);
                dispose();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }
}