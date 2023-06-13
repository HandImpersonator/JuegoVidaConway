package juego.view;

import jugador.model.Jugador;
import partida.model.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana que muestra una matriz de campos de texto.
 * Permite al jugador interactuar con la matriz y controlar el inicio y detención de un bucle de actualización.
 */
public class TextFieldMatrixWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private boolean running = false;
    private final JTextField[][] textFields;
    private int[][] values;
    private final Color asteriskColor;
    private static final int TEXTFIELD_SIZE = 20;
    private final JButton startButton;
    private int updateCount;

    /**
     * Crea una nueva instancia de TextFieldMatrixWindow.
     *
     * @param jugador       El jugador asociado a la ventana.
     * @param partida       La partida asociada a la ventana.
     * @param rows          El número de filas de la matriz.
     * @param cols          El número de columnas de la matriz.
     * @param asteriskColor El color de los asteriscos en los campos de texto.
     */
    public TextFieldMatrixWindow(Jugador jugador, final Partida partida, int rows, int cols, Color asteriskColor) {
        textFields = new JTextField[rows][cols];
        values = new int[rows][cols];
        this.asteriskColor = asteriskColor;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Text Field Matrix");

        JPanel mainPanel = new JPanel(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JTextField textField = new JTextField();
                textField.setEditable(false);
                textField.setHorizontalAlignment(JTextField.CENTER);
                textField.setPreferredSize(new Dimension(TEXTFIELD_SIZE, TEXTFIELD_SIZE));

                textFields[i][j] = textField;

                mainPanel.add(textField);
            }
        }

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        JButton mainMenuButton = new JButton("Menu principal");
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = false;
                dispose();
                ViewWindowJuego viewJuego = new ViewWindowJuego(jugador);
                viewJuego.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = true;
                startButton.setEnabled(false);
                startLoop(jugador, partida);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(mainMenuButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

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
     * Inicia el bucle de actualización de la matriz de campos de texto.
     *
     * @param j       El jugador asociado a la ventana.
     * @param partida La partida asociada a la ventana.
     */
    private void startLoop(Jugador j, final Partida partida) {
        int rows = textFields.length;
        int cols = textFields[0].length;
        Timer timer = new Timer(80, null);

        ActionListener actionListener = new ActionListener() {
            int currentRow = 0;
            int currentCol = 0;

            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    ((Timer) e.getSource()).stop();
                    startButton.setEnabled(true);
                    return;
                }

                if (currentRow < rows && currentCol < cols) {
                    updateTextField(values, currentRow, currentCol, partida);
                    currentCol++;
                    if (currentCol >= cols) {
                        currentRow++;
                        currentCol = 0;
                    }
                } else {
                    partida.processCells(partida, values);
                    updateTextFields(partida.getPartida());
                    if (areAllZero(values)) {
                        ((Timer) e.getSource()).stop();
                        running = false;
                        dispose();
                        ViewEndGame veg = new ViewEndGame(j);
                        veg.setVisible(true);
                    } else if (updateCount >= 100) {
                        ((Timer) e.getSource()).stop();
                        running = false;
                        dispose();
                        ViewStableGame viewStableGame = new ViewStableGame(j);
                        viewStableGame.setVisible(true);
                    }
                    updateCount++;
                }
            }
        };

        timer.addActionListener(actionListener);
        timer.start();
    }

    /**
     * Verifica si todos los valores de una matriz son cero.
     *
     * @param array La matriz a verificar.
     * @return true si todos los valores son cero, false en caso contrario.
     */
    private boolean areAllZero(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                if (value != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Inicializa los valores de la matriz de campos de texto.
     *
     * @param initialValues Los valores iniciales de la matriz.
     */
    public void initializeValues(int[][] initialValues) {
        values = initialValues;

        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                String text = (values[i][j] == 1) ? "*" : "";
                textFields[i][j].setText(text);
                textFields[i][j].setForeground((values[i][j] == 1) ? asteriskColor : Color.BLACK);
            }
        }
    }

    /**
     * Actualiza un campo de texto en la matriz y procesa las celdas de la partida.
     *
     * @param newValues Los nuevos valores de la matriz.
     * @param row       El índice de la fila del campo de texto.
     * @param col       El índice de la columna del campo de texto.
     * @param partida   La partida asociada a la ventana.
     */
    private void updateTextField(int[][] newValues, int row, int col, Partida partida) {
        int value = newValues[row][col];

        if (!running) {
            return;
        }

        String text = (value == 1) ? "*" : " ";
        textFields[row][col].setText(text);
        textFields[row][col].setForeground((value == 1) ? asteriskColor : Color.BLACK);

        partida.processCells(partida, values);
    }

    /**
     * Actualiza todos los campos de texto en la matriz con nuevos valores y actualiza la matriz de valores.
     *
     * @param newValues Los nuevos valores de la matriz.
     */
    private void updateTextFields(int[][] newValues) {
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                String text = (newValues[i][j] == 1) ? "*" : "";
                textFields[i][j].setText(text);
                textFields[i][j].setForeground((newValues[i][j] == 1) ? asteriskColor : Color.BLACK);
                values[i][j] = newValues[i][j];
            }
        }
    }
}
