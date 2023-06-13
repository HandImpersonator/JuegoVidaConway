/**

 Clase que representa la ventana principal del jugador.
 Permite al jugador ingresar su ID de expediente y entrar al juego.
 */
package jugador.view;

import juego.view.ViewWindowInstrucciones;
import jugador.model.Jugador;
import jugador.repo.RepoFileBinJugador;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase que representa la ventana principal del jugador.
 */
public class ViewWindowLoginJugador extends JFrame {

	private final JPanel contentPane;
	private final JTextField textFieldIDExpediente;

	/**
	 * Crea la ventana.
	 */
	public ViewWindowLoginJugador() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 0, 0));

		JLabel lblIDExpediente = new JLabel("Introduce ID Expediente:");
		contentPane.add(lblIDExpediente);

		textFieldIDExpediente = new JTextField();
		contentPane.add(textFieldIDExpediente);
		textFieldIDExpediente.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			/**
			 * Método que se ejecuta al hacer clic en el botón "Entrar".
			 * Aquí puedes agregar el código para abrir la nueva ventana
			 * y usar el ID de expediente y el nombre del jugador ingresados.
			 */
			public void actionPerformed(ActionEvent e) {
				int idExpediente = Integer.parseInt(textFieldIDExpediente.getText());

				String dataFolder = "data";
				String fileName = "jugador_" + idExpediente + ".dat";
				File file = new File(dataFolder, fileName);

				if (file.exists()) {
					RepoFileBinJugador repoJugador = new RepoFileBinJugador();
					Jugador jugador = repoJugador.readJ(idExpediente);
					if (jugador == null) {
						jugador = new Jugador(idExpediente);
					} else {
						if (jugador.getPartidas() == null) {
							jugador.setPartidas(new ArrayList<>());
						}
					}
					abrirVentanaInstrucciones(jugador);
				} else {
					RepoFileBinJugador repoJugador = new RepoFileBinJugador();
					repoJugador.create(new Jugador(idExpediente));
					abrirVentanaInstrucciones(new Jugador(idExpediente));
				}
			}
		});
		contentPane.add(btnEntrar);
	}

	/**
	 * Abre la ventana de instrucciones y pasa el jugador como parámetro.
	 *
	 * @param jugador El jugador a pasar a la ventana de instrucciones.
	 */
	private void abrirVentanaInstrucciones(Jugador jugador) {
		ViewWindowInstrucciones ventanaInstrucciones = new ViewWindowInstrucciones(jugador);
		ventanaInstrucciones.setVisible(true);
		dispose();
	}
}
