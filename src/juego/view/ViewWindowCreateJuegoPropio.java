package juego.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.model.Juego;
import juego.repositorio.IRepoJuego;
import jugador.model.Jugador;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewWindowCreateJuegoPropio extends JFrame {

	private JPanel contentPane;
	private JTextField textDimX;
	private JTextField textNombre;
	private JTextField textNombreJuego;
	private JTextField textExp;
	private JTextField textDimY;
	private IRepoJuego juegos;
	/**
	 * Create the frame.
	 */
	public ViewWindowCreateJuegoPropio(IRepoJuego juegos) {
		this.juegos = juegos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblExp = new JLabel("Expediente");
		contentPane.add(lblExp);
		
		textExp = new JTextField();
		contentPane.add(textExp);
		textExp.setColumns(10);
		
		JLabel lblNombreJuego = new JLabel("Nombre del Juego");
		contentPane.add(lblNombreJuego);
		
		textNombreJuego = new JTextField();
		contentPane.add(textNombreJuego);
		textNombreJuego.setColumns(10);
		
		JLabel lblDimX = new JLabel("Dimensión X");
		contentPane.add(lblDimX);
		
		textDimX = new JTextField();
		contentPane.add(textDimX);
		textDimX.setColumns(10);
		
		JLabel lblDimY = new JLabel("Dimensión Y");
		contentPane.add(lblDimY);
		
		textDimY = new JTextField();
		contentPane.add(textDimY);
		textDimY.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego jp = new Juego(Integer.parseInt(textDimX.getText()), Integer.parseInt(textDimY.getText()), new Jugador(textNombre.getText(), Integer.parseInt(textExp.getText())), textNombreJuego.getText());
				juegos.create(jp);
			}
		});
		contentPane.add(btnCrear);
	}

}
