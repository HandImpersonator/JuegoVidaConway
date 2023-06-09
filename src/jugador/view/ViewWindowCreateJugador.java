package jugador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jugador.model.Jugador;
import jugador.model.JugadorNoRegistrado;
import jugador.model.JugadorRegistrado;
import jugador.repo.IRepoJugador;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewWindowCreateJugador extends JFrame {
	private IRepoJugador jugadores;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textExpediente;

	/**
	 * Create the frame.
	 */
	public ViewWindowCreateJugador(IRepoJugador jugadores) {
		this.jugadores = jugadores;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 1, 1));
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblExpediente = new JLabel("Expediente");
		contentPane.add(lblExpediente);
		
		JButton btnCrear = new JButton("Crear Registrado");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador jugador = new JugadorRegistrado(textNombre.getText(),Integer.parseInt(textExpediente.getText()));
				jugadores.create(jugador);
			}
		});
		
		textExpediente = new JTextField();
		contentPane.add(textExpediente);
		textExpediente.setColumns(10);
		contentPane.add(btnCrear);
		
		JButton btnCrearNoRegistrado = new JButton("Crear No Registrado");
		btnCrearNoRegistrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador jugador = new JugadorNoRegistrado(textNombre.getText(),Integer.parseInt(textExpediente.getText()));
				jugadores.create(jugador);
			}
		});
		contentPane.add(btnCrearNoRegistrado);
	}

}
