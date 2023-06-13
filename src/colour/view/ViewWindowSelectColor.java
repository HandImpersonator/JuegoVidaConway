package colour.view;

import juego.view.TextFieldMatrixWindow;
import jugador.model.Jugador;
import jugador.repo.RepoFileBinJugador;
import partida.model.Partida;
import partida.model.PartidaPorDefecto;
import colour.model.Colour;
import regla.model.Regla;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de selección de color para una partida.
 */
public class ViewWindowSelectColor extends JFrame {

	private final JPanel contentPane;
	private final JTextField textNombre;
	private final JLabel lblEligeColor;
	private final JPanel colorPanel;

	/**
	 * Crea una nueva instancia de ViewWindowSelectColor.
	 *
	 * @param j    El jugador asociado.
	 * @param res  La matriz de juego.
	 */
	public ViewWindowSelectColor(Jugador j, int[][] res) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 10));

		JLabel lblNombre = new JLabel("Nombre partida:");
		contentPane.add(lblNombre);
		textNombre = new JTextField();
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JButton btnContinuar = new JButton("Continuar");
		contentPane.add(btnContinuar);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textNombre.getText().isEmpty()) {
					lblEligeColor.setVisible(true);
					colorPanel.setVisible(true);
					enableColorButtons();
				}
			}
		});

		lblEligeColor = new JLabel("Selecciona color:");
		lblEligeColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeColor.setVisible(false);
		contentPane.add(lblEligeColor);

		colorPanel = new JPanel(new GridLayout(0, 6, 5, 5));
		colorPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
		colorPanel.setVisible(false);
		contentPane.add(colorPanel);

		Color[] colors = {
				Color.RED, Color.BLUE, Color.BLACK, Color.CYAN, Color.DARK_GRAY,
				Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
				Color.PINK, Color.YELLOW
		};

		for (Color color : colors) {
			JButton colorButton = new JButton();
			colorButton.setBackground(color);
			colorButton.setOpaque(true);
			colorButton.setBorder(new EmptyBorder(8, 8, 8, 8));
			colorButton.setEnabled(false);

			textNombre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorButton.setEnabled(!textNombre.getText().isEmpty());
				}
			});

			colorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Colour c = new Colour(color);
					Partida partida = new PartidaPorDefecto(j.getNumExpediente(), textNombre.getText(), res, c, new Regla(2, 3, 3));
					j.addPartida(partida);
					RepoFileBinJugador repoJugador = new RepoFileBinJugador();
					repoJugador.update(j);
					TextFieldMatrixWindow tfmw = new TextFieldMatrixWindow(j, partida, res.length, res.length, partida.getIdColor());
					tfmw.initializeValues(res);
					dispose();
				}
			});
			colorPanel.add(colorButton);
		}
	}

	/**
	 * Método para habilitar o deshabilitar los botones de colores.
	 */
	private void enableColorButtons() {
		for (Component component : colorPanel.getComponents()) {
			if (component instanceof JButton) {
				component.setEnabled(true);
			}
		}
	}
}
