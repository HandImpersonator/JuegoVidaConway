package juego.model;

import jugador.model.Jugador;

public class JuegoRectPredefinido extends Juego {

	public JuegoRectPredefinido(int dimX, int dimY, Jugador jugador, String nombreJuego) {
		super(dimX, dimY, jugador, nombreJuego);
	}
	public void setJuego10x5() {
		setDimX(10);
		setDimY(5);
	}
	public void setJuego20x10() {
		setDimX(20);
		setDimY(10);
	}
	public void setJuego30x15() {
		setDimX(30);
		setDimY(15);
	}

}
