package jugador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jugador.repo.IRepoJugador;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ViewWindowDeleteJugador extends JFrame {

	private IRepoJugador jugadores;
	private JPanel contentPane;
	private final JLabel lblMsg = new JLabel("");
	private JTextField textExpediente;
	/**
	 * Create the frame.
	 */
	public ViewWindowDeleteJugador(IRepoJugador jugadores) {
		this.jugadores = jugadores;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblExpediente = new JLabel("Introduce tu expediente:");
		contentPane.add(lblExpediente);
		
		
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jugadorToDelete = jugadores.buscar(Integer.parseInt(textExpediente.getText()));
				if (jugadorToDelete == -1) {
					lblMsg.setText("No se ha encontrado este jugador");
				} else {
					jugadores.remove(jugadorToDelete);
					lblMsg.setText("Se ha eliminado correctamente");
				}
			}
		});
		
		textExpediente = new JTextField();
		contentPane.add(textExpediente);
		textExpediente.setColumns(10);
		contentPane.add(btnBorrar);
		
		
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblMsg);
	}

}
