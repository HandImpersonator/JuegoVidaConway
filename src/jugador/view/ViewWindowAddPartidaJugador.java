package jugador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jugador.model.Jugador;
import jugador.repo.IRepoJugador;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ViewWindowAddPartidaJugador extends JFrame {

	private IRepoJugador jugadores;
	private JPanel contentPane;
	private JTextField textPartida;
	private final JLabel lblMsg = new JLabel("");
	private JTextField textExpediente;
	/**
	 * Create the frame.
	 */
	public ViewWindowAddPartidaJugador(IRepoJugador jugadores) {
		this.jugadores = jugadores;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblNota = new JLabel("Nota: Solo se podrá añadir partidas a jugadores registrados ");
		contentPane.add(lblNota);
		
		JLabel lblExpediente = new JLabel("Introduce tu expediente");
		contentPane.add(lblExpediente);
		
		textExpediente = new JTextField();
		contentPane.add(textExpediente);
		textExpediente.setColumns(10);
		
		JLabel lblNombrePartida = new JLabel("Introduce el nombre de tu partida");
		contentPane.add(lblNombrePartida);
		
		textPartida = new JTextField();
		contentPane.add(textPartida);
		textPartida.setColumns(10);
		
		JButton btnAnadirPartida = new JButton("Añadir Partida");
		btnAnadirPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = jugadores.buscar(Integer.parseInt(textExpediente.getText()));
				if (j == -1) {
					lblMsg.setText("No se ha encontrado este jugador");
				} else {
					Jugador jugTemp = jugadores.read().get(j);
					//boolean b = jugTemp.addPartida(new Partida(0,0,new Regla(0,0,0)));
					boolean b = jugTemp.addPartida(textPartida.getText());
					jugadores.update(j,jugTemp);
					if (b) 
						lblMsg.setText("Partida agregada correctamente");
					else 
						lblMsg.setText("No se ha agregado la partida"); 
//					String res=(b)?"Partida agregada correctamente":"No se ha agregado la partida";
//					System.out.println(res);
				}
			}
		});
		contentPane.add(btnAnadirPartida);
		
		lblMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblMsg);
	}

}
