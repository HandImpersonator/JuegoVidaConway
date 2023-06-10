package juego.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.model.JuegoRectPredefinido;
import juego.repositorio.IRepoJuego;
import jugador.model.Jugador;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewWindowCreateJuegoPredeterminadoRectangular extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textExp;
	private JTextField textNombreJuego;
	private IRepoJuego juegos;

	
	public ViewWindowCreateJuegoPredeterminadoRectangular(IRepoJuego juegos) {
		this.juegos = juegos; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 3, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre);
		
		JLabel lblVacio_1 = new JLabel("");
		contentPane.add(lblVacio_1);
		
		textNombre = new JTextField();
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblExpediente = new JLabel("Expediente ");
		contentPane.add(lblExpediente);
		
		JLabel lblVacio_2 = new JLabel("");
		contentPane.add(lblVacio_2);
		
		textExp = new JTextField();
		contentPane.add(textExp);
		textExp.setColumns(10);
		
		JLabel lblNombreJuego = new JLabel("Nombre del juego");
		contentPane.add(lblNombreJuego);
		
		JLabel lblVacio_3 = new JLabel("");
		contentPane.add(lblVacio_3);
		
		textNombreJuego = new JTextField();
		contentPane.add(textNombreJuego);
		textNombreJuego.setColumns(10);
		
		JButton btn10x5 = new JButton("10x5");
		btn10x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegoRectPredefinido jrp = new JuegoRectPredefinido(0,0,new Jugador(textNombre.getText(), Integer.parseInt(textExp.getText())),textNombreJuego.getText());
				jrp.setJuego10x5();
				juegos.create(jrp);
			}
		});
		contentPane.add(btn10x5);
		
		JButton btn20x10 = new JButton("20x10");
		btn20x10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegoRectPredefinido jrp = new JuegoRectPredefinido(0,0,new Jugador(textNombre.getText(), Integer.parseInt(textExp.getText())),textNombreJuego.getText());
				jrp.setJuego20x10();
				juegos.create(jrp);
			}
		});
		contentPane.add(btn20x10);
		
		JButton btn30x15 = new JButton("30x15");
		btn30x15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegoRectPredefinido jrp = new JuegoRectPredefinido(0,0,new Jugador(textNombre.getText(), Integer.parseInt(textExp.getText())),textNombreJuego.getText());
				jrp.setJuego30x15();
				juegos.create(jrp);
			}
		});
		contentPane.add(btn30x15);
	}

}
