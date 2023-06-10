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

public class ViewWindowCreateMatrizDimensiones extends JFrame {

	private JPanel contentPane;
	private JTextField textDimensionX;
	private JTextField textDimensionY;
	private JButton btnContinuar;
	private JLabel lblNombreJuego;
	private JLabel lblExp;
	private JLabel lblNombre;
	private JTextField textExpediente;
	private JTextField textNombre;
	private JTextField textNombreJuego;
	private IRepoJuego juegos;
	/**
	 * Create the frame.
	 */
	public ViewWindowCreateMatrizDimensiones(IRepoJuego juegos) {
		this.juegos = juegos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Dimensión X");
		contentPane.add(lblNewLabel_1);
		
		textDimensionX = new JTextField();
		contentPane.add(textDimensionX);
		textDimensionX.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dimensión Y ");
		contentPane.add(lblNewLabel);
		
		textDimensionY = new JTextField();
		contentPane.add(textDimensionY);
		textDimensionY.setColumns(10);
		
		btnContinuar = new JButton("Siguiente ");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckboxMatrixWindow cmw = new CheckboxMatrixWindow(Integer.parseInt(textDimensionX.getText()), Integer.parseInt(textDimensionY.getText()));
				cmw.setVisible(true);
				Juego juego =  new Juego(new Jugador(textNombre.getText(), Integer.parseInt(textExpediente.getText())), textNombreJuego.getText(), cmw.getResult());
				juegos.create(juego);
			}
		});
		
		lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblExp = new JLabel("Expediente");
		contentPane.add(lblExp);
		
		textExpediente = new JTextField();
		contentPane.add(textExpediente);
		textExpediente.setColumns(10);
		
		lblNombreJuego = new JLabel("Nombre de Juego");
		contentPane.add(lblNombreJuego);
		
		textNombreJuego = new JTextField();
		contentPane.add(textNombreJuego);
		textNombreJuego.setColumns(10);
		contentPane.add(btnContinuar);
	}

}
