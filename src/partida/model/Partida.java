/**

 Clase que representa una partida.
 Una partida contiene información sobre el ID del expediente, el ID de la partida, el número de celdas vivas al inicio,
 el número de celdas vivas al final, el número de celdas muertas, la ronda actual y las reglas del juego.
 Esta clase proporciona métodos para acceder y modificar los atributos de la partida, así como métodos para avanzar a la siguiente ronda
 y obtener una representación en forma de cadena de la partida.
 La igualdad entre dos partidas se basa en el ID de la partida.
 Esta clase implementa la interfaz Serializable para permitir su serialización.
 */

package partida.model;

import colour.model.Colour;
import regla.model.Regla;

import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;


public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idExp;
    private int idPartida;
    private int[][] p;
    private Colour colour;
    private Regla regla;

    /**
     * Constructor de la clase Partida.
     *
     * @param idExp    El ID del expediente.
     * @param idPartida    El ID de la partida.
     * @param partida    El número de celdas vivas al inicio de la partida.
     * @param colour    El color asociado a la partida.
     * @param regla    Las reglas del juego de la partida.
     */
    public Partida(int idExp, int idPartida, int[][] partida, Colour colour, Regla regla) {
        this.idExp = idExp;
        this.idPartida = idPartida;
        this.p = partida;
        this.colour = colour;
        this.regla = regla;
    }

    /**
     * Constructor de la clase Partida.
     *
     * @param idPartida    El ID de la partida.
     */
    public Partida(int idPartida) {
        this.idPartida = idPartida;
    }

    /**
     * Devuelve una representación en forma de cadena de la partida.
     *
     * @return Una cadena que representa la partida.
     */
    @Override
    public String toString() {
        return "Partida [ID Expediente = " + idExp + ", ID Partida=" + idPartida + ", configuración = " + Arrays.deepToString(p) + ", color = " + colour + "]";
    }

    /**
     * Compara la partida actual con otro objeto para determinar si son iguales.
     * Dos partidas son iguales si tienen el mismo ID de partida.
     *
     * @param obj    El objeto a comparar con la partida actual.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        return ((Partida) (obj)).idPartida == this.idPartida;
    }

    /**
     * Devuelve el ID del expediente.
     *
     * @return El ID del expediente.
     */
    public int getIdExp() {
        return idExp;
    }

    /**
     * Devuelve el ID de la partida.
     *
     * @return El ID de la partida.
     */
    public int getIdPartida() {
        return idPartida;
    }

    /**
     * Devuelve la configuración actual de la partida.
     *
     * @return La configuración actual de la partida.
     */
    public int[][] getPartida() {
        return p;
    }

    /**
     * Devuelve el color asociado a la partida.
     *
     * @return El color asociado a la partida.
     */
    public Color getIdColor() {
        return colour.getidColor();
    }

    /**
     * Establece el ID de la partida.
     *
     * @param idPartida    El nuevo ID de la partida.
     */
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    /**
     * Procesa las celdas de la partida según las reglas del juego.
     * Actualiza el estado de las celdas a partir de la configuración actual.
     *
     * @param p    La partida actual.
     * @param cells    Las celdas de la partida.
     */
    public void processCells(Partida p, int[][] cells) {
        int rows = cells.length;
        int columns = cells[0].length;
        int[][] newCells = new int[rows][columns];
        Regla mRegla1 = p.regla;
        Regla mRegla2 = p.regla;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int liveCount = countLiveCells(cells, i, j);
                if (cells[i][j] == 1) {
                    boolean regla1 = mRegla1.metodoRegla1(liveCount);
                    if (!regla1) {
                        newCells[i][j] = 0;
                    } else {
                        newCells[i][j] = 1; // Mantener la celda viva
                    }
                } else {
                    boolean regla2 = mRegla2.metodoRegla2(liveCount);
                    if (regla2) {
                        newCells[i][j] = 1;
                    } else {
                        newCells[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            System.arraycopy(newCells[i], 0, cells[i], 0, columns);
        }
    }

    /**
     * Cuenta el número de celdas vivas vecinas a una celda dada.
     *
     * @param cells    Las celdas de la partida.
     * @param row    Fila de la celda.
     * @param col    Columna de la celda.
     * @return El número de celdas vivas vecinas a la celda dada.
     */
    public int countLiveCells(int[][] cells, int row, int col) {
        int liveCount = 0;
        int rows = cells.length;
        int columns = cells[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < columns && !(i == row && j == col)) {
                    if (cells[i][j] == 1) {
                        liveCount++;
                    }
                }
            }
        }

        return liveCount;
    }

}
