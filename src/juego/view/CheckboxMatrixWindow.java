package juego.view;

import colour.view.ViewWindowSelectColor;
import jugador.model.Jugador;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana que muestra una matriz de casillas de verificación.
 * Permite al jugador seleccionar una configuración y pasar a la ventana de selección de color.
 */
public class CheckboxMatrixWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JCheckBox[][] checkboxes;
    private final int[][] config_ini;
    private final JButton acceptButton;
    private int[][] result;

    /**
     * Crea una nueva instancia de CheckboxMatrixWindow.
     *
     * @param jugador El jugador asociado a la ventana.
     * @param rows    El número de filas de la matriz.
     * @param cols    El número de columnas de la matriz.
     */
    public CheckboxMatrixWindow(Jugador jugador, int rows, int cols) {
        checkboxes = new JCheckBox[rows][cols];
        config_ini = new int[rows][cols];
        result = null;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Checkbox Matrix");

        JPanel checkboxPanel = new JPanel(new GridLayout(rows, cols, 0, 0));
        checkboxPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                checkboxes[i][j] = new JCheckBox();
                checkboxes[i][j].setMargin(new Insets(0, 0, 0, 0));
                checkboxes[i][j].setBorderPaintedFlat(true);
                checkboxPanel.add(checkboxes[i][j]);
            }
        }

        acceptButton = new JButton("Aceptar");
        acceptButton.addActionListener(e -> {
            result = getConfigArray();
            ViewWindowSelectColor vwsc = new ViewWindowSelectColor(jugador, result);
            vwsc.setVisible(true);
            dispose();
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(checkboxPanel, BorderLayout.CENTER);
        mainPanel.add(acceptButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setResizable(false);
        centerWindow();
    }

    /**
     * Centra la ventana en la pantalla.
     */
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

    /**
     * Obtiene la configuración de la matriz de casillas de verificación.
     *
     * @return Una matriz que representa la configuración seleccionada.
     */
    public int[][] getConfigArray() {
        for (int i = 0; i < checkboxes.length; i++) {
            for (int j = 0; j < checkboxes[0].length; j++) {
                config_ini[i][j] = checkboxes[i][j].isSelected() ? 1 : 0;
            }
        }
        return config_ini;
    }

    /**
     * Obtiene el resultado de la configuración seleccionada.
     *
     * @return La matriz de configuración seleccionada.
     */
    public int[][] getResult() {
        return result;
    }

}
