package juego.model;

import jugador.model.Jugador;

/**
 * Representa un juego cuadrado predefinido que hereda de la clase Juego.
 */
public class JuegoCuadPredefinido extends Juego {

	/**
	 * Crea una nueva instancia de JuegoCuadPredefinido con las dimensiones y jugador especificados.
	 *
	 * @param dimX        La dimensión X del juego.
	 * @param dimY        La dimensión Y del juego.
	 * @param jugador     El jugador asociado al juego.
	 * @param nombreJuego El nombre del juego.
	 */
	public JuegoCuadPredefinido(int dimX, int dimY, Jugador jugador, String nombreJuego) {
		super(dimX, dimY, jugador, nombreJuego);
	}

	/**
	 * Establece las dimensiones del juego a 5x5.
	 */
	public void setJuego5() {
		setDimX(5);
		setDimY(5);
	}

	/**
	 * Establece las dimensiones del juego a 10x10.
	 */
	public void setJuego10() {
		setDimX(10);
		setDimY(10);
	}

	/**
	 * Establece las dimensiones del juego a 20x20.
	 */
	public void setJuego20() {
		setDimX(20);
		setDimY(20);
	}
}
