package colour.view;

import juego.view.viewWindowJuego;
import jugador.model.Jugador;
import jugador.repo.RepoFileBinJugador;
import partida.model.Partida;
import partida.model.PartidaPorDefecto;
import partida.view.viewWindowCreatePartidaD;
import colour.model.Colour;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewWindowSelectColor extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JLabel lblEligeColor;
	private JPanel colorPanel;

	public viewWindowSelectColor(Jugador j, int[][] res) {
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

		// Botón Continuar
		JButton btnContinuar = new JButton("Continuar");
		contentPane.add(btnContinuar);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textNombre.getText().isEmpty()) {
					lblEligeColor.setVisible(true);
					colorPanel.setVisible(true);
					enableColorButtons(true); // Habilitar los botones de colores
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
			colorButton.setEnabled(false); // Botón deshabilitado por defecto

			textNombre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorButton.setEnabled(!textNombre.getText().isEmpty());
				}
			});

			colorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Colour c = new Colour(color);
					Partida partida = new PartidaPorDefecto(j.getNumExpediente(), textNombre.getText(), res, c);
					j.addPartida(partida);
					RepoFileBinJugador repoJugador = new RepoFileBinJugador();
					repoJugador.update(j);
					viewWindowJuego vwp = new viewWindowJuego(j);
					vwp.setVisible(true);
					dispose();
				}
			});
			colorPanel.add(colorButton);
		}
	}

	// Método para habilitar o deshabilitar los botones de colores
	private void enableColorButtons(boolean enable) {
		for (Component component : colorPanel.getComponents()) {
			if (component instanceof JButton) {
				component.setEnabled(enable);
			}
		}
	}
}
