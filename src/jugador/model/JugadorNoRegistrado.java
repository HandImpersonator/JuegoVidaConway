package jugador.model;

public class JugadorNoRegistrado extends Jugador {

	public JugadorNoRegistrado(String nombre, int numExpediente) {
		super(nombre, numExpediente);
	}
	public String toString() {
		return "JugadorNoRegistrado" + super.toString();
	}

}
