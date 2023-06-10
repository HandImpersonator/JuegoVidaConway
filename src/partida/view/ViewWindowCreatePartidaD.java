/**
 * Clase de vista para la creación de partidas por defecto en una ventana.
 * Esta clase proporciona métodos para mostrar la ventana de creación de partidas con reglas por defecto.
 * La ventana incluye campos de texto para ingresar el nombre de la partida y el número de celdas vivas.
 * También incluye botones "Crear Partida" y "Volver".
 * La ventana utiliza el repositorio de partidas RepoFileBinPartida.
 * Se debe proporcionar un mensaje de bienvenida, el repositorio de partidas y el ID de expediente del jugador al crear la instancia de la ventana.
 * La acción del botón "Crear Partida" crea una nueva partida por defecto con los valores ingresados y la agrega al repositorio de partidas.
 * Luego, cierra la ventana actual y muestra la vista principal de la partida.
 * La acción del botón "Volver" cierra la ventana actual y muestra la vista principal de la partida.
 * Ejemplo de uso:
 * RepoFileBinPartida partidas = new RepoFileBinPartida();
 * ViewWindowCreatePartidaD window = new ViewWindowCreatePartidaD("¡Bienvenido!", partidas, 123456);
 * window.setVisible(true);
 *
 * @author User
 */

package partida.view;

import partida.model.Partida;
import partida.model.PartidaPorDefecto;
import partida.repo.RepoFileBinPartida;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWindowCreatePartidaD extends JFrame {
	private RepoFileBinPartida partidas;
	private JPanel mainContentPane;
	private JPanel contentPane1;
	private JPanel contentPane2;
	private JTextField textNombre;
	private JTextField textNumero;

	/**
	 * Crea la ventana.
	 *
	 * @param wel      el mensaje de bienvenida
	 * @param partidas el repositorio de partidas
	 * @param idE      el ID de expediente del jugador
	 */
	public ViewWindowCreatePartidaD(String wel, RepoFileBinPartida partidas, int idE) {
		this.partidas = partidas;
		setBounds(100, 100, 450, 300);
		mainContentPane = new JPanel(new GridLayout(2, 1));
		setContentPane(mainContentPane);

		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane1.setLayout(new GridLayout(2, 2, 5, 5));

		contentPane2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

		mainContentPane.add(contentPane1);
		mainContentPane.add(contentPane2);

		JLabel lblNombre = new JLabel("Nombre partida:");
		contentPane1.add(lblNombre);
		textNombre = new JTextField();
		contentPane1.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblCeldas = new JLabel("Numero de celdas vivas:");
		contentPane1.add(lblCeldas);
		textNumero = new JTextField();
		contentPane1.add(textNumero);
		textNumero.setColumns(10);

		JButton btnCrear = new JButton("Crear Partida");
		contentPane2.add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Crear Partida".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				Partida partida = new PartidaPorDefecto(idE, textNombre.getText(), Integer.parseInt(textNumero.getText()));
				partidas.create(partida);
				dispose();
				ViewWindowPartida vwp = new ViewWindowPartida(wel, idE, partidas);
				vwp.setVisible(true);
			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Volver".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewWindowPartida vwp = new ViewWindowPartida(wel, idE, partidas);
				vwp.setVisible(true);
			}
		});
		contentPane2.add(btnVolver, BorderLayout.SOUTH);
	}
}
