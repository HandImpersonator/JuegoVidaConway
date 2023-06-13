package juego.view;

import jugador.model.Jugador;
import jugador.view.viewDeathMessage;
import partida.view.viewWindowReadPartida;
import partida.view.viewWindowDeletePartida;
import jugador.view.ViewWindowLoginJugador;
import jugador.repo.RepoFileBinJugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Clase que representa la ventana de juego.
 */
public class viewWindowJuego extends JFrame {

    private JPanel contentPane;

    /**
     * Crea la ventana.
     */
    public viewWindowJuego(Jugador jugador) {
        RepoFileBinJugador fileJugador = new RepoFileBinJugador();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 5));

        JLabel lblWelcome = new JLabel("¡Bienvenido, " + jugador.getNumExpediente() + "!");
        contentPane.add(lblWelcome);

        JButton btnCrearPartida = new JButton("Crear partida");
        btnCrearPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckboxMatrixWindow checkboxMatrixWindow = new CheckboxMatrixWindow(jugador, 30, 30);
                checkboxMatrixWindow.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnCrearPartida);

        JButton btnLeerPartidas = new JButton("Leer partidas");
        btnLeerPartidas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewWindowReadPartida vwrp = new viewWindowReadPartida(jugador, fileJugador, jugador.getNumExpediente());
                vwrp.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnLeerPartidas);

        JButton btnBorrarPartida = new JButton("Borrar partida");
        btnBorrarPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewWindowDeletePartida vwdp = new viewWindowDeletePartida(jugador, fileJugador, jugador.getNumExpediente());
                vwdp.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBorrarPartida);

        JButton btnBorrarUsuario = new JButton("Borrar usuario");
        btnBorrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idExpediente = ""; // Obtener el idExpediente del jugador
                fileJugador.removeP(jugador);
                viewDeathMessage vdm = new viewDeathMessage(jugador);
                vdm.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBorrarUsuario);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
        contentPane.add(btnSalir);
    }
}
