package jugador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jugador.repo.IRepoJugador;
import jugador.repo.RepoFileBinJugador;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewWindowJugador extends JFrame {

	private JPanel contentPane;
	private IRepoJugador jugadores;

	/**
	 * Create the frame.
	 */
	public ViewWindowJugador() {
		jugadores = new RepoFileBinJugador();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnCrearJugador = new JButton("Crear");
		btnCrearJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowCreateJugador vwcj = new ViewWindowCreateJugador(jugadores);
				vwcj.setVisible(true);
			}
		});
		contentPane.add(btnCrearJugador);
		
		JButton btnLeerJugador = new JButton("Leer");
		btnLeerJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowReadJugador vwrj = new ViewWindowReadJugador(jugadores);
				vwrj.setVisible(true);
			}
		});
		contentPane.add(btnLeerJugador);
		
		JButton btnActualizarJugador = new JButton("Actualizar");
		btnActualizarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowUpdateJugador vwuj = new ViewWindowUpdateJugador(jugadores);
				vwuj.setVisible(true);
			}
		});
		contentPane.add(btnActualizarJugador);
		
		JButton btnBorrarJugador = new JButton("Borrar");
		btnBorrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowDeleteJugador vwdj = new ViewWindowDeleteJugador(jugadores);
				vwdj.setVisible(true);
			}
		});
		contentPane.add(btnBorrarJugador);
		
		JButton btnAnadirPartida = new JButton("Añadir partida");
		btnAnadirPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowAddPartidaJugador vwap = new ViewWindowAddPartidaJugador(jugadores);
				vwap.setVisible(true);
			}
		});
		contentPane.add(btnAnadirPartida);
		
	}

}
