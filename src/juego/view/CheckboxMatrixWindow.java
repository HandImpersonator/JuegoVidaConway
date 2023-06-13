package juego.view;

import colour.view.viewWindowSelectColor;
import jugador.model.Jugador;

import javax.swing.*;
import java.awt.*;

public class CheckboxMatrixWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JCheckBox[][] checkboxes;
    private int[][] config_ini;
    private JButton acceptButton;
    private int[][] result;

    public CheckboxMatrixWindow(Jugador jugador, int rows, int cols) {
        checkboxes = new JCheckBox[rows][cols];
        config_ini = new int[rows][cols];
        result = null;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Checkbox Matrix");

        JPanel checkboxPanel = new JPanel(new GridLayout(rows, cols, 0, 0));
        checkboxPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agregar un margen al panel de checkboxes

        // Crear los checkboxes y agregarlos al panel
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                checkboxes[i][j] = new JCheckBox();
                checkboxes[i][j].setMargin(new Insets(0, 0, 0, 0)); // Reducir el espacio interno del checkbox
                checkboxes[i][j].setBorderPaintedFlat(true); // Eliminar el borde alrededor del checkbox
                checkboxPanel.add(checkboxes[i][j]);
            }
        }

        acceptButton = new JButton("Aceptar");
        acceptButton.addActionListener(e -> {
            result = getConfigArray();
            viewWindowSelectColor vwsc = new viewWindowSelectColor(jugador, result);
            vwsc.setVisible(true);
            dispose(); // Cerrar la ventana después de pulsar el botón "Aceptar"
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(checkboxPanel, BorderLayout.CENTER);
        mainPanel.add(acceptButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
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
