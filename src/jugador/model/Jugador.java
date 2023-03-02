package jugador.model;

import java.util.List;
import java.util.Vector;

import partida.Partida;

public class Jugador {
	private String nombre;
	private int numExpediente;
	private List<Partida> partidas;
	public Jugador(String nombre, int numExpediente) {
		this.nombre = nombre;
		this.numExpediente = numExpediente;
		partidas = new Vector<Partida>();
	}
	public void addPartida(Partida partida) {
		partidas.add(partida);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (((Jugador)obj).getNumExpediente() == this.numExpediente) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
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
