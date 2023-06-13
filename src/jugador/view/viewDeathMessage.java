package jugador.view;

import jugador.model.Jugador;

import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.SwingUtilities;
        import javax.swing.Timer;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class viewDeathMessage extends JFrame {

    private Jugador jugador;

    public viewDeathMessage(Jugador jugador) {
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

        timer.setRepeats(false); // Ejecutar solo una vez
        timer.start();
    }
}