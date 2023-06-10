/**
 * Clase de vista para la ventana general de partida.
 * Esta clase representa la ventana principal de la partida y proporciona métodos para mostrarla.
 * La ventana incluye botones para crear, leer, eliminar y salir del menu de partida.
 * Se debe proporcionar un mensaje de bienvenida, el ID de la partida y el repositorio de partidas al crear la instancia de la ventana.
 * La acción del botón "Crear" cierra la ventana actual y muestra la ventana de creación de partidas.
 * La acción del botón "Leer" cierra la ventana actual y muestra la ventana de lectura de partidas.
 * La acción del botón "Borrar" cierra la ventana actual y muestra la ventana de eliminación de partidas.
 * La acción del botón "Salir" cierra la aplicación.
 * Ejemplo de uso:
 * RepoFileBinPartida partidas = new RepoFileBinPartida();
 * ViewWindowPartida window = new ViewWindowPartida("¡Bienvenido!", 123456, partidas);
 * window.setVisible(true);
 * Nota: Esta clase solo representa la vista de la ventana y no implementa la lógica de creación, lectura o eliminación de partidas.
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

/**
 * Clase que representa la ventana de partida.
 */
public class ViewWindowPartida extends JFrame {

	private JPanel contentPane;

	/**
	 * Crea el marco de la ventana de partida.
	 *
	 * @param w        Saludo
	 * @param id       ID de la partida
	 * @param partidas Repositorio de partidas
	 */
	public ViewWindowPartida(String w, int id, RepoFileBinPartida partidas) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		JLabel welcome = new JLabel(w);
		contentPane.add(welcome);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 0, 0));

		JButton btnCrearPartida = new JButton("Crear");
		btnCrearPartida.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Crear Partida".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowCreatePartida vwcp = new ViewWindowCreatePartida(w, id);
				vwcp.setVisible(true);
			}
		});
		contentPane.add(btnCrearPartida);

		JButton btnLeerPartida = new JButton("Leer");
		btnLeerPartida.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Leer Partida".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowReadPartida vwrp = new ViewWindowReadPartida(w, partidas, id);
				vwrp.setVisible(true);
			}
		});
		contentPane.add(btnLeerPartida);

		JButton btnBorrarPartida = new JButton("Borrar");
		btnBorrarPartida.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Borrar Partida".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowDeletePartida vwdp = new ViewWindowDeletePartida(w, partidas, id);
				vwdp.setVisible(true);
			}
		});
		contentPane.add(btnBorrarPartida);

		JButton btnSalirPartida = new JButton("Salir");
		btnSalirPartida.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Salir Partida".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalirPartida);
	}
}
