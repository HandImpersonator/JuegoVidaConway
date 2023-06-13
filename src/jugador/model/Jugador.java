package jugador.model;

import partida.model.Partida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numExpediente;
	private List<Partida> partidas;

	public Jugador(int numExpediente) {
		this.numExpediente = numExpediente;
		this.partidas = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Jugador [numExpediente=" + numExpediente + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jugador) {
			Jugador other = (Jugador) obj;
			return this.numExpediente == other.numExpediente;
		}
		return false;
	}

	public void addPartida(Partida partida) {
		partidas.add(partida);
	}

	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	public List<Partida> getPartidas() {
		return partidas;
	}
}
