package juego.model;

import jugador.model.Jugador;

/**
 * Representa un juego rectangular predefinido que hereda de la clase Juego.
 */
public class JuegoRectPredefinido extends Juego {

	/**
	 * Crea una nueva instancia de JuegoRectPredefinido con las dimensiones y jugador especificados.
	 *
	 * @param dimX        La dimensión X del juego.
	 * @param dimY        La dimensión Y del juego.
	 * @param jugador     El jugador asociado al juego.
	 * @param nombreJuego El nombre del juego.
	 */
	public JuegoRectPredefinido(int dimX, int dimY, Jugador jugador, String nombreJuego) {
		super(dimX, dimY, jugador, nombreJuego);
	}

	/**
	 * Establece las dimensiones del juego a 10x5.
	 */
	public void setJuego10x5() {
		setDimX(10);
		setDimY(5);
	}

	/**
	 * Establece las dimensiones del juego a 20x10.
	 */
	public void setJuego20x10() {
		setDimX(20);
		setDimY(10);
	}

	/**
	 * Establece las dimensiones del juego a 30x15.
	 */
	public void setJuego30x15() {
		setDimX(30);
		setDimY(15);
	}

}
