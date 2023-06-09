package jugador.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jugador.model.Jugador;
import jugador.model.JugadorRegistrado;
import jugador.repo.IRepoJugador;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class ViewWindowUpdateJugador extends JFrame {
	private IRepoJugador jugadores;
	private JPanel contentPane;
	private JTextField textActualizarExp;
	private JTextField textNombre; 
	private JTextField textExpediente;
	private final JLabel lblMsg = new JLabel("");
	/**
	 * Create the frame.
	 */
	public ViewWindowUpdateJugador(IRepoJugador jugadores) {
		this.jugadores = jugadores;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblActExp = new JLabel("Introduce tu expediente");
		contentPane.add(lblActExp);
		
		textActualizarExp = new JTextField();
		contentPane.add(textActualizarExp);
		textActualizarExp.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblExpediente = new JLabel("Expediente");
		contentPane.add(lblExpediente);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jugadorToSearch = jugadores.buscar(Integer.parseInt(textActualizarExp.getText()));
				if (jugadorToSearch == -1) {
					lblMsg.setText("No se ha encontrado este jugador");
				} else {
					Jugador jugTemp = jugadores.read().get(jugadorToSearch);
					jugTemp.setNombre(textNombre.getText());
					jugTemp.setNumExpediente(Integer.parseInt(textExpediente.getText()));
					jugadores.update(jugadorToSearch,jugTemp);
					lblMsg.setText("Se ha actualizado correctamente");
				}
			}
		});
		
		textExpediente = new JTextField();
		contentPane.add(textExpediente);
		textExpediente.setColumns(10);
		contentPane.add(btnActualizar);
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblMsg);
	}

}
