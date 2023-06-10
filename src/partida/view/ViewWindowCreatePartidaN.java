/**
 * Clase de vista para la creación de partidas normales en una ventana.
 * Esta clase proporciona métodos para mostrar la ventana de creación de partidas normales.
 * La ventana incluye campos de texto para ingresar el nombre de la partida, el número de celdas vivas y las reglas.
 * También incluye botones "Crear Partida" y "Volver".
 * La ventana utiliza el repositorio de partidas RepoFileBinPartida.
 * Se debe proporcionar un mensaje de bienvenida, el repositorio de partidas y el ID de expediente del jugador al crear la instancia de la ventana.
 * La acción del botón "Crear Partida" crea una nueva partida normal con los valores ingresados y la agrega al repositorio de partidas.
 * Luego, cierra la ventana actual y muestra la vista principal de la partida.
 * La acción del botón "Volver" cierra la ventana actual y muestra la vista principal de la partida.
 * Ejemplo de uso:
 * RepoFileBinPartida partidas = new RepoFileBinPartida();
 * ViewWindowCreatePartidaN window = new ViewWindowCreatePartidaN("¡Bienvenido!", partidas, 123456);
 * window.setVisible(true);
 *
 * @author User
 */

package partida.view;

import partida.model.Partida;
import partida.model.PartidaNormal;
import partida.repo.RepoFileBinPartida;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWindowCreatePartidaN extends JFrame {
	private RepoFileBinPartida partidas;
	private JPanel mainContentPane;
	private JPanel contentPane1;
	private JPanel contentPane2;
	private JTextField textNombre;
	private JTextField textNumero;
	private JTextField r1;
	private JTextField r2;
	private JTextField r3;

	/**
	 * Crea la ventana.
	 *
	 * @param wel      el mensaje de bienvenida
	 * @param partidas el repositorio de partidas
	 * @param idE      el ID de expediente del jugador
	 */
	public ViewWindowCreatePartidaN(String wel, RepoFileBinPartida partidas, int idE) {
		this.partidas = partidas;
		setBounds(100, 100, 450, 300);
		mainContentPane = new JPanel(new GridLayout(2, 1));
		setContentPane(mainContentPane);

		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane1.setLayout(new GridLayout(5, 2, 5, 5));

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

		JLabel lblR1 = new JLabel("Regla 1:");
		contentPane1.add(lblR1);
		r1 = new JTextField();
		contentPane1.add(r1);
		r1.setColumns(10);

		JLabel lblR2 = new JLabel("Regla 2:");
		contentPane1.add(lblR2);
		r2 = new JTextField();
		contentPane1.add(r2);
		r2.setColumns(10);

		JButton btnCrear = new JButton("Crear Partida");
		contentPane2.add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			/**
			 * Acción que se ejecuta cuando se hace clic en el botón "Crear Partida".
			 *
			 * @param e Evento de acción
			 */
			public void actionPerformed(ActionEvent e) {
				Partida partida = new PartidaNormal(idE, textNombre.getText(), Integer.parseInt(textNumero.getText()), Integer.parseInt(r1.getText()), Integer.parseInt(r2.getText()), 0);
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
