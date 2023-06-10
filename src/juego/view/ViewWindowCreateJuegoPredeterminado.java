package juego.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.repositorio.IRepoJuego;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewWindowCreateJuegoPredeterminado extends JFrame {

	private JPanel contentPane;
	private IRepoJuego juegos;

	/**
	 * Create the frame.
	 */
	public ViewWindowCreateJuegoPredeterminado(IRepoJuego juegos) {
		this.juegos = juegos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblInfo = new JLabel("¿Cuadrado o rectangular?");
		contentPane.add(lblInfo);
		
		JButton btnCuadrado = new JButton("Cuadrado");
		btnCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowCreateJuegoPredeterminadoCuadrado vwcjpc = new ViewWindowCreateJuegoPredeterminadoCuadrado(juegos);
				vwcjpc.setVisible(true);
			}
		});
		contentPane.add(btnCuadrado);
		
		JButton btnRectangular = new JButton("Rectangular");
		btnRectangular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowCreateJuegoPredeterminadoRectangular vwcjpr = new ViewWindowCreateJuegoPredeterminadoRectangular(juegos);
				vwcjpr.setVisible(true);
			}
		});
		contentPane.add(btnRectangular);
	}

}
