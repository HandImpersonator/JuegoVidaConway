/**
 * Clase de vista para eliminar una partida en una ventana.
 * Esta clase proporciona métodos para mostrar la ventana de eliminación de partidas.
 * La ventana incluye un campo de texto para ingresar el número de partida a eliminar, un botón "Borrar" y un botón "Volver".
 * También muestra un mensaje informativo en caso de éxito o error al eliminar la partida.
 * La ventana utiliza el repositorio de partidas RepoFileBinPartida.
 * Se debe proporcionar un mensaje de bienvenida, el repositorio de partidas y el ID de expediente del jugador al crear la instancia de la ventana.
 * La acción del botón "Borrar" busca la partida en el repositorio de partidas utilizando el ID de expediente del jugador y el número de partida ingresado.
 * Si se encuentra la partida, se elimina del repositorio y se actualiza el contenido de la ventana.
 * Si no se encuentra la partida, se muestra un mensaje de error.
 * La acción del botón "Volver" cierra la ventana actual y muestra la vista principal de la partida.
 * La ventana también actualiza automáticamente el estado de los botones y campos de texto dependiendo de si hay partidas disponibles para eliminar.
 * Si no hay partidas, los botones y campos de texto se desactivan.
 * La actualización con el contenido de la lista de partidas se realiza mediante el método updateTextPane().
 * El método isPartidasEmpty() se utiliza para verificar si hay partidas disponibles.
 * Nota: Esta clase solo representa la vista de la ventana y no implementa la lógica de eliminación de partidas.
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
 * Ventana para eliminar una partida.
 */
public class ViewWindowDeletePartida extends JFrame {

	private RepoFileBinJugador fileJugador = new RepoFileBinJugador();
	private final JPanel contentPane;
	private final JLabel lblMsg = new JLabel(" - ");
	private final JTextField textPartida;
	private final JScrollPane scrollPane;
	private final JTextPane textPaneLeer;
	private final JButton btnBorrar;

	/**
	 * Crea la ventana.
	 *
	 * @param j      el mensaje de bienvenida
	 * @param jugador el repositorio de jugador
	 * @param idE      el ID de expediente del jugador
	 */
	public ViewWindowDeletePartida(Jugador j, RepoFileBinJugador jugador, int idE) {
		this.fileJugador = fileJugador;
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		textPaneLeer = new JTextPane();
		textPaneLeer.setEditable(false);
		scrollPane.setViewportView(textPaneLeer);
		updateTextPane(j);

		JPanel inputPanel = new JPanel();
		contentPane.add(inputPanel, BorderLayout.SOUTH);
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblExpediente = new JLabel("Introduce ID de partida:");
		inputPanel.add(lblExpediente);

		textPartida = new JTextField();
		inputPanel.add(textPartida);
		textPartida.setColumns(10);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Borrar".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				List<Partida> ps = fileJugador.read(idE);
				int partidaBorrar = fileJugador.buscar(ps, Integer.parseInt(textPartida.getText()));
				if (partidaBorrar == -1) {
					lblMsg.setText("No se ha encontrado la partida");
				} else {
					fileJugador.remove(j, Integer.parseInt(textPartida.getText()));
					lblMsg.setText("Se ha eliminado correctamente.");
					updateTextPane(j);
				}
			}
		});
		inputPanel.add(btnBorrar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Volver".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowJuego vwj = new ViewWindowJuego(j);
				vwj.setVisible(true);
			}
		});
		inputPanel.add(btnVolver);

		JPanel msgPanel = new JPanel();
		msgPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		msgPanel.add(lblMsg);
		contentPane.add(msgPanel, BorderLayout.NORTH);

		if (btnBorrar != null) {
			btnBorrar.setEnabled(!isPartidasEmpty(j));
		}
		if (textPartida != null) {
			textPartida.setEnabled(!isPartidasEmpty(j));
		}
	}

	/**
	 * Actualiza el JTextPane con el contenido actual de la lista de partidas.
	 *
	 * @param jug el ID de expediente del jugador
	 */
	private void updateTextPane(Jugador jug) {
		List<Partida> p = jug.getPartidas();
		StringBuilder concLeer = new StringBuilder();
		if (p == null || p.isEmpty()) {
			concLeer.append("No hay partidas para mostrar.").append("\n\n");
		} else {
			for (Partida element : p) {
				concLeer.append(element).append("\n\n");
			}
		}
		textPaneLeer.setText(concLeer.toString());

		if (btnBorrar != null) {
			btnBorrar.setEnabled(!isPartidasEmpty(jug));
		}
		if (textPartida != null) {
			textPartida.setEnabled(!isPartidasEmpty(jug));
		}
	}

	/**
	 * Verifica si no hay partidas para el jugador.
	 *
	 * @param jug el ID de expediente del jugador
	 * @return true si no hay partidas, false de lo contrario
	 */
	private boolean isPartidasEmpty(Jugador jug) {
		List<Partida> p = jug.getPartidas();
		return p == null || p.isEmpty();
	}
}
