/**
 * Clase que representa una partida normal, que es un tipo específico de partida.
 * Una partida normal hereda de la clase Partida y agrega funcionalidades adicionales.
 * Esta clase implementa la interfaz Serializable para permitir su serialización.
 * El ID de la partida normal se genera utilizando un generador de números aleatorios basado en el nombre de la partida.
 *
 * @author User
 */

package partida.model;

import regla.model.Regla;

public class PartidaNormal extends Partida {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la clase PartidaNormal.
     * Crea una nueva partida normal con los parámetros especificados.
     *
     * @param idExp                   El ID del expediente.
     * @param nombrePartida           El nombre de la partida.
     * @param numCeldasVivasInicio    El número de celdas vivas al inicio de la partida.
     * @param r1                      El primer parámetro de la regla del juego.
     * @param r2                      El segundo parámetro de la regla del juego.
     * @param r3                      El tercer parámetro de la regla del juego.
     */
    public PartidaNormal(int idExp, String nombrePartida, int numCeldasVivasInicio, int r1, int r2, int r3) {
        super(idExp, setRPartida(nombrePartida), numCeldasVivasInicio, new Regla(r1, r2, r3, "Personal"));
    }

    /**
     * Devuelve una representación en forma de cadena de la partida normal.
     *
     * @return Una cadena que representa la partida normal.
     */
    @Override
    public String toString() {
        return "Partida normal: " + super.toString();
    }

    /**
     * Genera el ID de la partida normal utilizando un generador de números aleatorios basado en el nombre de la partida.
     *
     * @param n El nombre de la partida.
     * @return El ID generado para la partida normal.
     */
    public static int setRPartida(String n) {
        return new Generador(n).toInt();
    }

}
