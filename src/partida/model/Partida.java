/**
 * Clase que representa una partida.
 * Una partida contiene información sobre el ID del expediente, el ID de la partida, el número de celdas vivas al inicio,
 * el número de celdas vivas al final, el número de celdas muertas, la ronda actual y las reglas del juego.
 * Esta clase proporciona métodos para acceder y modificar los atributos de la partida, así como métodos para avanzar a la siguiente ronda
 * y obtener una representación en forma de cadena de la partida.
 * La igualdad entre dos partidas se basa en el ID de la partida.
 * Esta clase implementa la interfaz Serializable para permitir su serialización.
 *
 * @author User
 */

package partida.model;

import colour.model.Colour;

import java.io.Serializable;
import java.util.Arrays;


public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idExp;
    private int idPartida;
    private int[][] p;
    private Colour colour;

    /**
     * Constructor de la clase Partida.
     *
     * @param idExp                 El ID del expediente.
     * @param idPartida             El ID de la partida.
     * @param partida  El número de celdas vivas al inicio de la partida.
     */
    public Partida(int idExp, int idPartida, int[][] partida, Colour colour) {
        this.idExp = idExp;
        this.idPartida = idPartida;
        this.p = partida;
        this.colour = colour;
    }

    /**
     * Constructor de la clase Partida.
     *
     * @param idPartida  El ID de la partida.
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
     * @param obj  El objeto a comparar con la partida actual.
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
     * Establece el ID de la partida.
     *
     * @param idPartida El nuevo ID de la partida.
     */
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

}
