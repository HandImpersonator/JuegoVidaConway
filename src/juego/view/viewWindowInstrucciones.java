package juego.view;

import jugador.model.Jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que representa la ventana de instrucciones.
 */
public class viewWindowInstrucciones extends JFrame {

    private JPanel contentPane;

    /**
     * Crea la ventana.
     */
    public viewWindowInstrucciones(Jugador jugador) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 0, 0));

        JLabel lblWelcome = new JLabel("¡Bienvenido, " + jugador.getNumExpediente() + "!");
        contentPane.add(lblWelcome);

        JTextArea textArea = new JTextArea();
        textArea.setText("A continuación se mostrará el juego de la vida de Conway, no sin \n" +
                "antes unas pequeñas instrucciones. El juego de la vida consta de \n" +
                "elegir estratégicamente que celdas quieren que sean las vivas, \n" +
                "para así revivir a las muertas, y que celdas quieres que sean las \n" +
                "muertas, para que no maten a las vivas. Elegirás esto en un \n" +
                "tablero de 30x30 antes de empezar a jugar. Además, podrás \n" +
                "también crear una partida,leerlas o borrarlas. También podrás \n" +
                "borrar tu propio ID de jugador. En cuyo caso, volveras a la \n" +
                "pantalla de inicio. Podrás también elegir tus propias reglas, es \n" +
                "decir, cuantas celdas vivas quieres que sean necesarias para \n" +
                "revivir a una muerta y con cuantas celdas muertas quieres que \n" +
                "maten a una viva. Una vez hecho esto, solo hace falta darle al \n" +
                "botón start y comprobar que tus estrategias fueron o no correctas");
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Establecer la política de la barra de desplazamiento horizontal a "nunca"
        contentPane.add(scrollPane);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewWindowJuego viewJuego = new viewWindowJuego(jugador);
                viewJuego.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnContinuar);
    }
}
