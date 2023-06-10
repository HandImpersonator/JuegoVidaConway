package juego.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.repositorio.IRepoJuego;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ViewWindowCreateJuego extends JFrame {

	private JPanel contentPane;
	private IRepoJuego juegos;
	/**
	 * Create the frame.
	 */
	public ViewWindowCreateJuego(IRepoJuego juegos) {
		this.juegos = juegos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnPredeterminado = new JButton("Predeterminado");
		btnPredeterminado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowCreateJuegoPredeterminado vcjp = new ViewWindowCreateJuegoPredeterminado(juegos);
				vcjp.setVisible(true);
			}
		});
		
		JLabel lblTipoDeJuego = new JLabel("¿Que tipo de juego quieres?");
		contentPane.add(lblTipoDeJuego);
		contentPane.add(btnPredeterminado);
		
		JButton btnPropio = new JButton("Propio");
		btnPropio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowCreateJuegoPropio vwcjpro = new ViewWindowCreateJuegoPropio(juegos);
				vwcjpro.setVisible(true);
			}
		});
		contentPane.add(btnPropio);
		
		JButton btnMatriz = new JButton("Crear Matriz");
		btnMatriz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ViewWindowCreateMatrizDimensiones vwcmd = new  ViewWindowCreateMatrizDimensiones(juegos);
				 vwcmd.setVisible(true);
			}
		});
		contentPane.add(btnMatriz);
	}

}
