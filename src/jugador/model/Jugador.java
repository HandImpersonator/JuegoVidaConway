package jugador.model;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Jugador implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int numExpediente;
	//protected List<Partida> partidas;
	protected List<String>partidas;
	
	public Jugador(String nombre, int numExpediente) {
		this.nombre = nombre;
		this.numExpediente = numExpediente;
		
	}
	@Override
	public String toString() {
		// return "Jugador [nombre=" + nombre + ", numExpediente=" + numExpediente + ", partidas=" + partidas.toString() + "]";
		return "Jugador [nombre=" + nombre + ", numExpediente=" + numExpediente +"]";
	}
	@Override
	public boolean equals(Object obj) {
		if (((Jugador) (obj)).getNumExpediente() == this.numExpediente) {
			return true;
		}
		return false;
	}
	public List<String> getPartidas() {
		return partidas;
	}
	public boolean addPartida (String partida) {
		return false;
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
	
}
