import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TextFieldMatrixWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField[][] textFields;
    private String[][] values;
    private Color asteriskColor;
    private static final int TEXTFIELD_SIZE = 20;
    private JButton startButton;

    public TextFieldMatrixWindow(int rows, int cols, Color asteriskColor) {
        textFields = new JTextField[rows][cols];
        values = new String[rows][cols];
        this.asteriskColor = asteriskColor;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Text Field Matrix");

        // Create a main panel with a GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(rows, cols));

        // Create the text fields and add them to the main panel
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

        // Add the main panel to the window
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Create the "Main Menu" button
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                // Call the main menu window
                // MenuPrincipal.main(new String[0]);
                // menu.setVisible(true);
            }
        });

        // Create a panel for the buttons and add it to the window
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false); // Disable the Start button after the loop starts
                startLoop(); // Start the loop
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(mainMenuButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

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

    private void startLoop() {
        int rows = textFields.length;
        int cols = textFields[0].length;

        Timer timer = new Timer(1000, new ActionListener() {
            int iteration = 0;

            public void actionPerformed(ActionEvent e) {
                if (iteration < 1000) {
                    String[][] newValues = generateRandomValues(rows, cols);
                    updateTextFields(newValues);
                    iteration++;
                } else {
                    ((Timer) e.getSource()).stop();
                    startButton.setEnabled(true); // Enable the Start button after the loop finishes
                }
            }
        });

        timer.start();
    }

    private static String[][] generateRandomValues(int rows, int cols) {
        Random random = new Random();
        String[][] newValues = new String[rows][cols];

        // Generate random values for the array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int randomNumber = random.nextInt(2);
                newValues[i][j] = (randomNumber == 1) ? "*" : "";
            }
        }

        return newValues;
    }

    public void initializeValues(String[][] initialValues) {
        values = initialValues;

        // Display the initial values in the text fields with the corresponding colors
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                textFields[i][j].setText(values[i][j]);
                textFields[i][j].setForeground((values[i][j].equals("*")) ? asteriskColor : Color.BLACK);
            }
        }
    }

    public void updateTextFields(String[][] newValues) {
        values = newValues;

        // Update the text fields with the new values
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                textFields[i][j].setText(values[i][j]);
                textFields[i][j].setForeground((values[i][j].equals("*")) ? asteriskColor : Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        int rows = 30;
        int cols = 30;
        Color asteriskColor = Color.RED;

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextFieldMatrixWindow window = new TextFieldMatrixWindow(rows, cols, asteriskColor);
                window.initializeValues(generateRandomValues(rows, cols));
            }
        });
    }
}
