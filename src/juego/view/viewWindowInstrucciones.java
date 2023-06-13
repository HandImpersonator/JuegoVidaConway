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
        setBounds(100, 100, 900, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 0, 0));

        JLabel lblWelcome = new JLabel("¡Bienvenido, " + jugador.getNumExpediente() + "!");
        contentPane.add(lblWelcome);

        JTextArea textArea = new JTextArea();
        textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\\n\\n\"\n" +
                        "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\\n\\n\"\n" +
                        "                \"Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\\n\\n\"\n" +
                "                + \"Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
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
