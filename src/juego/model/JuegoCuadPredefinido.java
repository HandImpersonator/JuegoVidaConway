package juego.model;

import jugador.model.Jugador;

public class JuegoCuadPredefinido extends Juego {

	public JuegoCuadPredefinido(int dimX, int dimY, Jugador jugador, String nombreJuego) {
		super(dimX, dimY, jugador, nombreJuego);
	}
	public void setJuego5() {
		setDimX(5);
		setDimY(5);
	}
	public void setJuego10() {
		setDimX(10);
		setDimY(10);
	}
	public void setJuego20() {
		setDimX(20);
		setDimY(20);
	}
}
