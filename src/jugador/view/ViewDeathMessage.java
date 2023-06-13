/**

 Clase de vista para mostrar un mensaje de muerte al usuario.
 Extiende JFrame y muestra un mensaje de muerte junto con el número de expediente del jugador.
 Después de un tiempo determinado, redirige al usuario a la ventana de inicio de sesión del jugador.
 */
package jugador.view;

import jugador.model.Jugador;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDeathMessage extends JFrame {

    private final Jugador jugador;

    /**
     * Crea una instancia de ViewDeathMessage para mostrar un mensaje de muerte al jugador.
     *
     * @param jugador El jugador asociado al mensaje de muerte.
     */
    public ViewDeathMessage(Jugador jugador) {
        this.jugador = jugador;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Se ha borrado el usuario " + jugador.getNumExpediente() + " correctamente");
        add(label);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewWindowLoginJugador viewLoginJugador = new ViewWindowLoginJugador();
                viewLoginJugador.setVisible(true);
                dispose();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

}