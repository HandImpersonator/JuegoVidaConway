package jugador.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jugador.model.Jugador;
import jugador.repo.IRepoJugador;
import javax.swing.JTextPane;

public class ViewWindowReadJugador extends JFrame {
	private IRepoJugador jugadores;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ViewWindowReadJugador(IRepoJugador jugadores) {
		this.jugadores = jugadores;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JTextPane textPaneLeer = new JTextPane();
		textPaneLeer.setEditable(false);
		contentPane.add(textPaneLeer);
		List<Jugador> j = jugadores.read();
		String concLeer = "";
		for (int i = 0; i < j.size(); i++) {
			concLeer+=j.get(i) + "\n";
		}
		textPaneLeer.setText(concLeer);
	}

}
