package jugador.model;

import java.util.List;
import java.util.Vector;

import partida.model.Partida;

public class JugadorRegistrado extends Jugador {
	public JugadorRegistrado(String nombre, int numExpediente) {
		super(nombre, numExpediente);
		partidas = new Vector<Partida> ();
	}

	@Override
	public String toString() {
		return "JugadorRegistrado" + super.toString()+", partidas="+partidas;
	}
	public boolean addPartida (Partida partida) {
		partidas.add(partida);
		return true;
	}

}
