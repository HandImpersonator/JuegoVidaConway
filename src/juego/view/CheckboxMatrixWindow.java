package juego.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CheckboxMatrixWindow extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
    private JCheckBox[][] checkboxes;
    private int[][] config_ini;
    private JButton acceptButton;
    private int[][] result;

	/**
	 * Create the frame.
	 */
	public CheckboxMatrixWindow(int filas, int columnas) {
		checkboxes = new JCheckBox[filas][columnas];
        config_ini = new int[filas][columnas];
        result = null;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Checkbox Matrix");
        setLayout(new GridLayout(filas + 1, columnas)); // +1 para agregar la fila del botón

        // Crear los checkboxes y agregarlos a la ventana
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                checkboxes[i][j] = new JCheckBox();
                add(checkboxes[i][j]);
            }
        }

        acceptButton = new JButton("Aceptar");
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result = getConfigArray();
                dispose(); // Cerrar la ventana después de pulsar el botón "Aceptar"
            }
        });
        add(acceptButton);

        pack();
        setResizable(false);
        centerWindow();
    }

    private void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int xPos = (screenWidth - windowWidth) / 2;
        int yPos = (screenHeight - windowHeight) / 2;
        setLocation(xPos, yPos);
        setVisible(true);
    }
    
    public int[][] getConfigArray() {
        for (int i = 0; i < checkboxes.length; i++) {
            for (int j = 0; j < checkboxes[0].length; j++) {
                config_ini[i][j] = checkboxes[i][j].isSelected() ? 1 : 0;
            }
        }
        return config_ini;
    }

    public int[][] getResult() {
        return result;
    }

    
 }
