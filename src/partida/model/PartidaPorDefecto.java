/**
 * Clase que representa una partida por defecto, que es un tipo específico de partida.
 * Una partida por defecto hereda de la clase Partida y agrega funcionalidades adicionales.
 * Esta clase implementa la interfaz Serializable para permitir su serialización.
 * El ID de la partida por defecto se genera utilizando un generador de números aleatorios basado en el nombre de la partida.
 * La partida por defecto utiliza una regla predefinida con los parámetros (1, 2, 0).
 *
 * @author User
 */

package partida.model;

import regla.model.Regla;

public class PartidaPorDefecto extends Partida {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la clase PartidaPorDefecto.
     * Crea una nueva partida por defecto con los parámetros especificados.
     *
     * @param idExp                   El ID del expediente.
     * @param nombrePartida           El nombre de la partida.
     * @param numCeldasVivasInicio    El número de celdas vivas al inicio de la partida.
     */
    public PartidaPorDefecto(int idExp, String nombrePartida, int numCeldasVivasInicio) {
        super(idExp, setRPartida(nombrePartida), numCeldasVivasInicio, new Regla(1, 2, 0));
    }

    /**
     * Devuelve una representación en forma de cadena de la partida por defecto.
     *
     * @return Una cadena que representa la partida por defecto.
     */
    @Override
    public String toString() {
        return "Partida por defecto: " + super.toString();
    }

    /**
     * Genera el ID de la partida por defecto utilizando un generador de números aleatorios basado en el nombre de la partida.
     *
     * @param n El nombre de la partida.
     * @return El ID generado para la partida por defecto.
     */
    private static int setRPartida(String n) {
        return new Generador(n).toInt();
    }

}
