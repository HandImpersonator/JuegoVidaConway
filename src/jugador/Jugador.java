package jugador;

import java.util.List;
import java.util.Vector;

import partida.Partida;

public class Jugador  {
	private String nombre;
	private int numExpediente;
	private List<Partida> partidas;
	
	/**
	 * Constructor con los datos de un jugador.
	 * @param nombre nombre del jugador.
	 * @param numExpediente identificador del jugador en nuestro juego.
	 *
	 */
	public Jugador(String nombre, int numExpediente) {
		this.nombre = nombre;
		this.numExpediente = numExpediente;
		partidas = new Vector<Partida>();
	}
	
	/**
	 * Funcion añadir partida nueva al jugador.
	 * @param partida
	 *
	 */
	public void addPartida (Partida partida) {
		partidas.add(partida);
	}

	@Override
	public String toString() {
		// return "Jugador [nombre=" + nombre + ", numExpediente=" + numExpediente + ", partidas=" + partidas.toString() + "]";
		return "Jugador [nombre=" + nombre + ", numExpediente=" + numExpediente + ", partidas=" + partidas + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumExpediente() {
		return numExpediente;
	}
	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}
	public List<Partida> getPartidas() {
		return partidas;
	}
}