package common.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jugador.view.ViewWindowJugador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWindow frame = new ViewWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewWindow() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnMenuJugador = new JButton("Menu Jugador");
		btnMenuJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindowJugador vistaJugador = new ViewWindowJugador();
				vistaJugador.setVisible(true);
			}
		});
		contentPane.add(btnMenuJugador);
	}

}
