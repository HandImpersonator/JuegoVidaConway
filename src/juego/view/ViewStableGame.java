/**

 Esta clase representa la ventana de juego estable, que se muestra cuando la partida se considera infinita.
 Proporciona un mensaje al jugador informándole que la partida es estable y no tendrá un final definido.
 Después de un tiempo determinado, redirige al jugador a la ventana principal del juego.
 */
package juego.view;

import jugador.model.Jugador;
import jugador.view.ViewWindowLoginJugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewStableGame extends JFrame {

    private final Jugador jugador;

    /**
     * Crea una instancia de la ventana de juego estable.
     *
     * @param jugador El jugador que ha participado en la partida.
     */
    public ViewStableGame(Jugador jugador) {
        this.jugador = jugador;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Partida estable, la partida es infinita.");
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