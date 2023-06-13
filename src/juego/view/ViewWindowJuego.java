/**

 Esta clase representa la ventana principal del juego.
 Proporciona opciones para crear, leer y borrar partidas, así como para borrar el usuario y salir del juego.
 También muestra un mensaje de bienvenida al jugador.
 */
package juego.view;

import jugador.model.Jugador;
import jugador.view.ViewDeathMessage;
import partida.view.viewWindowReadPartida;
import partida.view.viewWindowDeletePartida;
import jugador.repo.RepoFileBinJugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewWindowJuego extends JFrame {

    private final JPanel contentPane;

    /**
     * Crea una instancia de la ventana principal del juego.
     *
     * @param jugador El jugador que ha iniciado sesión.
     */
    public ViewWindowJuego(Jugador jugador) {
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
                CheckboxMatrixWindow checkboxMatrixWindow = new CheckboxMatrixWindow(jugador, 10, 10);
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
                fileJugador.removeP(jugador);
                ViewDeathMessage vdm = new ViewDeathMessage(jugador);
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
