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

import java.io.Serializable;

import regla.model.Regla;


public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idExp;
    private int idPartida;
    private int numCeldasMuertas;
    private int numCeldasVivasInicio;
    private int numCeldasVivasFinal;
    private int ronda;
    private Regla reglas;

    /**
     * Constructor de la clase Partida.
     *
     * @param idExp                 El ID del expediente.
     * @param idPartida             El ID de la partida.
     * @param numCeldasVivasInicio  El número de celdas vivas al inicio de la partida.
     * @param reglas                Las reglas del juego.
     */
    public Partida(int idExp, int idPartida, int numCeldasVivasInicio, Regla reglas) {
        this.idExp = idExp;
        this.idPartida = idPartida;
        this.numCeldasVivasInicio = numCeldasVivasInicio;
        this.reglas = reglas;
        numCeldasMuertas = 0;
        numCeldasVivasFinal = numCeldasVivasInicio;
        ronda = 0;
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
        return "Partida [ID Expediente = " + idExp + ", ID Partida=" + idPartida + ", numCeldasVivasInicio=" + numCeldasVivasInicio
                + ", numCeldasVivasFinal=" + numCeldasVivasFinal + ", numCeldasMuertas=" + numCeldasMuertas
                + ", reglas=" + reglas + ", rondas=" + ronda + "]";
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

    /**
     * Devuelve el número de celdas vivas al inicio de la partida.
     *
     * @return El número de celdas vivas al inicio de la partida.
     */
    public int getNumCeldasVivasInicio() {
        return numCeldasVivasInicio;
    }

    /**
     * Devuelve el número de celdas muertas.
     *
     * @return El número de celdas muertas.
     */
    public int getNumCeldasMuertas() {
        return numCeldasMuertas;
    }

    /**
     * Devuelve el número de celdas vivas al final de la partida.
     *
     * @return El número de celdas vivas al final de la partida.
     */
    public int getNumCeldasVivasFinal() {
        return numCeldasVivasFinal;
    }

    /**
     * Devuelve el número de la ronda actual.
     *
     * @return El número de la ronda actual.
     */
    public int getRonda() {
        return ronda;
    }

    /**
     * Avanza a la siguiente ronda de la partida.
     * Incrementa el número de ronda en 1.
     * (Aquí se deben aplicar las reglas del juego).
     */
    public void nextRonda() {
        ronda++;
    }

    /**
     * Establece el número de la ronda actual.
     *
     * @param ronda El nuevo número de la ronda actual.
     */
    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    /**
     * Devuelve las reglas del juego.
     *
     * @return Las reglas del juego.
     */
    public Regla getReglas() {
        return reglas;
    }

}
