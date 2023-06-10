package juego.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import juego.model.Juego;
import juego.repositorio.IRepoJuego;
import jugador.model.Jugador;

public class ViewWindowLeerJuego extends JFrame {

	private JPanel contentPane;
	private IRepoJuego juegos;
	

	/**
	 * Create the frame.
	 */
	public ViewWindowLeerJuego(IRepoJuego juegos) {
		this.juegos = juegos;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JTextPane textPaneLeer = new JTextPane();
		textPaneLeer.setEditable(false);
		contentPane.add(textPaneLeer);
		List<Juego> j = juegos.read();
		String concLeer = "";
		for (int i = 0; i < j.size(); i++) {
			concLeer+=j.get(i) + "\n";
		}
		textPaneLeer.setText(concLeer);
	}

}
