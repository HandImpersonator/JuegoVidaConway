/**
 * Clase de vista para la ventana de lectura de partidas.
 * Esta clase representa la ventana de lectura de partidas y proporciona métodos para mostrarla.
 * La ventana muestra todas las partidas de un jugador en un JTextPane, permitiendo al jugador ver la información de cada partida.
 * Se debe proporcionar un mensaje de bienvenida, el repositorio de partidas y el ID de la entidad al crear la instancia de la ventana.
 * La acción del botón "Volver" cierra la ventana actual y muestra la ventana de partida.
 * Nota: Esta clase solo representa la vista de la ventana y no implementa la lógica de lectura de partidas.
 *
 */

package partida.view;

import juego.view.ViewWindowJuego;
import jugador.model.Jugador;
import jugador.repo.RepoFileBinJugador;
import partida.model.Partida;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase que representa la ventana de lectura de partidas.
 */
public class ViewWindowReadPartida extends JFrame {
	private final RepoFileBinJugador jugador;
	private final JPanel contentPane;

	/**
	 * Crea el marco de la ventana de lectura de partidas.
	 *
	 * @param j      Saludo
	 * @param jugador Repositorio de jugador
	 * @param idE      ID de la entidad
	 */
	public ViewWindowReadPartida(Jugador j, RepoFileBinJugador jugador, int idE) {
		this.jugador = jugador;
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		JLabel welcome = new JLabel("¡Bienvenido, " + j.getNumExpediente() + "!");
		contentPane.add(welcome);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));


		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		setContentPane(contentPane);

		JTextPane textPaneLeer = new JTextPane();
		textPaneLeer.setEditable(false);
		scrollPane.setViewportView(textPaneLeer);

		List<Partida> p = jugador.read(idE);
		StringBuilder concLeer = new StringBuilder();
		if (p == null || p.isEmpty()) {
			concLeer.append("No hay partidas para mostrar.").append("\n\n");
		} else {
			for (Partida element : p) {
				concLeer.append(element).append("\n\n");
			}
		}
		textPaneLeer.setText(concLeer.toString());

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Volver".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowJuego vwp = new ViewWindowJuego(j);
				vwp.setVisible(true);
			}
		});
		contentPane.add(btnVolver, BorderLayout.SOUTH);
	}
}
