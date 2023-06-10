package juego.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.model.JuegoCuadPredefinido;
import juego.repositorio.IRepoJuego;
import jugador.model.Jugador;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewWindowCreateJuegoPredeterminadoCuadrado extends JFrame {

	private JPanel contentPane;
	private JTextField textExp;
	private JTextField textNombre;
	private JTextField textNombreJuego;
	private IRepoJuego juegos;
	
	public ViewWindowCreateJuegoPredeterminadoCuadrado(IRepoJuego juegos) {
		this.juegos = juegos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 3, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre ");
		contentPane.add(lblNombre);
		
		JLabel lblVacio_1 = new JLabel("");
		contentPane.add(lblVacio_1);
		
		textNombre = new JTextField();
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblExpediente = new JLabel("Expediente");
		contentPane.add(lblExpediente);
		
		JLabel lblVacio_2 = new JLabel("");
		contentPane.add(lblVacio_2);
		
		JButton btn5x5 = new JButton("5x5");
		btn5x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegoCuadPredefinido jcp = new JuegoCuadPredefinido(0,0,new Jugador(textNombre.getText(), Integer.parseInt(textExp.getText())),textNombreJuego.getText());
				jcp.setJuego5();
				juegos.create(jcp);
			}
		});
		
		textExp = new JTextField();
		contentPane.add(textExp);
		textExp.setColumns(10);
		
		JLabel lblNombreJuego = new JLabel("Nombre de Juego");
		contentPane.add(lblNombreJuego);
		
		JLabel lblVacio_3 = new JLabel("");
		contentPane.add(lblVacio_3);
		
		textNombreJuego = new JTextField();
		contentPane.add(textNombreJuego);
		textNombreJuego.setColumns(10);
		contentPane.add(btn5x5);
		
		JButton btn10x10 = new JButton("10x10");
		btn10x10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegoCuadPredefinido jcp = new JuegoCuadPredefinido(0,0,new Jugador(textNombre.getText(), Integer.parseInt(textExp.getText())),textNombreJuego.getText());
				jcp.setJuego10();
				juegos.create(jcp);
			}
		});
		contentPane.add(btn10x10);
		
		JButton btn20x20 = new JButton("20x20");
		btn20x20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegoCuadPredefinido jcp = new JuegoCuadPredefinido(0,0,new Jugador(textNombre.getText(), Integer.parseInt(textExp.getText())),textNombreJuego.getText());
				jcp.setJuego20();
				juegos.create(jcp);
			}
		});
		contentPane.add(btn20x20);
	}

}
