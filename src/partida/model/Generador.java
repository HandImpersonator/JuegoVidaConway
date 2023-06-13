/**
 * Clase que genera un número aleatorio para el ID de una partida.
 * Esta clase proporciona un método para generar un número aleatorio basado en un nombre de partida.
 * El número aleatorio generado se utiliza como ID de la partida.
 *
 * @author User
 */

package partida.model;

import java.io.Serializable;
import java.util.Random;


public class Generador implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idPartida;

    /**
     * Constructor de la clase Generador.
     * Genera un número aleatorio para el ID de la partida basado en el nombre de la partida.
     *
     * @param nombrePartida El nombre de la partida.
     */
    public Generador(String nombrePartida) {
        this.idPartida = generateRandom(nombrePartida);
    }

    /**
     * Genera un número aleatorio basado en un nombre.
     *
     * @param nombre El nombre utilizado para generar el número aleatorio.
     * @return El número aleatorio generado.
     */
    private int generateRandom(String nombre) {
        Random rand = new Random();
        int random = rand.nextInt(1000000);
        int intRandom = nombre.hashCode() + random;
        return intRandom;
    }

    /**
     * Devuelve el ID de la partida como un entero.
     *
     * @return El ID de la partida como un entero.
     */
    public int toInt() {
        return idPartida;
    }

}