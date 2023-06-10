/**
 * Clase de vista para la creación de partidas en una ventana.
 * Esta clase proporciona métodos para mostrar la ventana de creación de partidas.
 * La ventana muestra dos botones: "Crear Partida Reglas por Defecto" y "Crear Partida Normal".
 * También incluye un botón "Volver" para regresar a la vista principal de la partida.
 * La ventana utiliza el repositorio de partidas RepoFileBinPartida.
 * Se debe proporcionar un mensaje de bienvenida y el ID de expediente del jugador al crear la instancia de la ventana.
 * La acción de los botones "Crear Partida Reglas por Defecto" y "Crear Partida Normal" abre ventanas de creación de partidas
 * específicas correspondientes.
 * Ejemplo de uso:
 * ViewWindowCreatePartida window = new ViewWindowCreatePartida("¡Bienvenido!", 123456);
 * window.setVisible(true);
 * Nota: Esta clase solo representa la vista de la ventana y no implementa la lógica de creación de partidas.
 *
 * @author User
 */

package partida.view;

import partida.repo.RepoFileBinPartida;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWindowCreatePartida extends JFrame {

	private JPanel contentPane;

	/**
	 * Crea la ventana.
	 *
	 * @param w   el mensaje de bienvenida
	 * @param idE el ID de expediente del jugador
	 */
	public ViewWindowCreatePartida(String w, int idE) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 1, 1));

		JButton btnCrear = new JButton("Crear Partida Reglas por Defecto");
		btnCrear.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Crear Partida Reglas por Defecto".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowCreatePartidaD vwcpd = new ViewWindowCreatePartidaD(w, new RepoFileBinPartida(), idE);
				vwcpd.setVisible(true);
			}
		});

		contentPane.add(btnCrear);

		JButton btnCrearN = new JButton("Crear Partida Normal");
		btnCrearN.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Crear Partida Normal".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowCreatePartidaN vwcpn = new ViewWindowCreatePartidaN(w, new RepoFileBinPartida(), idE);
				vwcpn.setVisible(true);
			}
		});
		contentPane.add(btnCrearN);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Volver".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowPartida vwp = new ViewWindowPartida(w, idE, new RepoFileBinPartida());
				vwp.setVisible(true);
			}
		});
		contentPane.add(btnVolver);
	}
}
