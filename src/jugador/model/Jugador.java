/**

 Esta clase representa a un jugador en el juego.
 Contiene información sobre el número de expediente del jugador y las partidas en las que ha participado.
 Implementa la interfaz Serializable para permitir la serialización de objetos.
 */
package jugador.model;

import partida.model.Partida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numExpediente;
	private List<Partida> partidas;

	/**
	 * Crea una instancia de la clase Jugador con el número de expediente especificado.
	 *
	 * @param numExpediente El número de expediente del jugador.
	 */
	public Jugador(int numExpediente) {
		this.numExpediente = numExpediente;
		this.partidas = new ArrayList<>();
	}

	/**
	 * Devuelve una representación en cadena del objeto Jugador.
	 *
	 * @return Una cadena que representa al jugador, incluyendo su número de expediente.
	 */
	@Override
	public String toString() {
		return "Jugador [numExpediente=" + numExpediente + "]";
	}

	/**
	 * Compara el objeto Jugador actual con otro objeto para determinar si son iguales.
	 * Dos jugadores se consideran iguales si tienen el mismo número de expediente.
	 *
	 * @param obj El objeto a comparar con el jugador actual.
	 * @return true si los objetos son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jugador) {
			Jugador other = (Jugador) obj;
			return this.numExpediente == other.numExpediente;
		}
		return false;
	}

	/**
	 * Agrega una partida a la lista de partidas del jugador.
	 *
	 * @param partida La partida a agregar.
	 */
	public void addPartida(Partida partida) {
		partidas.add(partida);
	}

	/**
	 * Obtiene el número de expediente del jugador.
	 *
	 * @return El número de expediente del jugador.
	 */
	public int getNumExpediente() {
		return numExpediente;
	}

	/**
	 * Establece el número de expediente del jugador.
	 *
	 * @param numExpediente El nuevo número de expediente del jugador.
	 */
	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	/**
	 * Establece la lista de partidas del jugador.
	 *
	 * @param partidas La nueva lista de partidas del jugador.
	 */
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	/**
	 * Obtiene la lista de partidas del jugador.
	 *
	 * @return La lista de partidas del jugador.
	 */
	public List<Partida> getPartidas() {
		return partidas;
	}

}
