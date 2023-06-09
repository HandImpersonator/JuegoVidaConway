package jugador.model;

import java.util.List;
import java.util.Vector;


public class JugadorRegistrado extends Jugador {
	public JugadorRegistrado(String nombre, int numExpediente) {
		super(nombre, numExpediente);
		partidas = new Vector<String> ();
	}

	@Override
	public String toString() {
		return "JugadorRegistrado" + super.toString()+", partidas="+partidas;
	}
	public boolean addPartida (String partida) {
		partidas.add(partida);
		return true;
	}

}
