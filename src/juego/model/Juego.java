package juego.model;

import jugador.model.Jugador;

/**
 * Representa un juego con dimensiones y un jugador asociado.
 */
public class Juego {
	private int dimX;
	private int dimY;
	private final Jugador jugador;
	private String nombreJuego;

	/**
	 * Crea una nueva instancia de Juego con las dimensiones especificadas.
	 * Si las dimensiones son menores que 3, se establecen como 3.
	 *
	 * @param dimX        La dimensión X del juego.
	 * @param dimY        La dimensión Y del juego.
	 * @param jugador     El jugador asociado al juego.
	 * @param nombreJuego El nombre del juego.
	 */
	public Juego(int dimX, int dimY, Jugador jugador, String nombreJuego) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.jugador = jugador;
		this.nombreJuego = nombreJuego;
		checkDim();
	}

	/**
	 * Crea una nueva instancia de Juego con una dimensión cuadrada.
	 * Si la dimensión es menor que 3, se establece como 3.
	 *
	 * @param dim         La dimensión del juego.
	 * @param jugador     El jugador asociado al juego.
	 * @param nombreJuego El nombre del juego.
	 */
	public Juego(int dim, Jugador jugador, String nombreJuego) {
		this(dim, dim, jugador, nombreJuego);
	}

	/**
	 * Crea una nueva instancia de Juego sin dimensiones.
	 *
	 * @param jugador     El jugador asociado al juego.
	 * @param nombreJuego El nombre del juego.
	 */
	public Juego(Jugador jugador, String nombreJuego) {
		this.jugador = jugador;
		this.nombreJuego = nombreJuego;
	}

	/**
	 * Comprueba y ajusta las dimensiones del juego.
	 * Si las dimensiones son menores que 3, se establecen como 3.
	 */
	private void checkDim() {
		if (dimX < 3) {
			dimX = 3;
		}
		if (dimY < 3) {
			dimY = 3;
		}
	}

	@Override
	public boolean equals(Object obj) {
		return this.nombreJuego.equals(((Juego) obj).getNombreJuego());
	}

	@Override
	public String toString() {
		return "Juego [dimX=" + dimX + ", dimY=" + dimY + ", jugador=" + jugador + ", nombreJuego=" + nombreJuego + "]";
	}

	/**
	 * Obtiene la dimensión X del juego.
	 *
	 * @return La dimensión X.
	 */
	public int getDimX() {
		return dimX;
	}

	/**
	 * Establece la dimensión X del juego.
	 * Si la dimensión es menor que 3, se establece como 3.
	 *
	 * @param dimX La nueva dimensión X.
	 */
	public void setDimX(int dimX) {
		this.dimX = dimX;
		checkDim();
	}

	/**
	 * Obtiene la dimensión Y del juego.
	 *
	 * @return La dimensión Y.
	 */
	public int getDimY() {
		return dimY;
	}

	/**
	 * Establece la dimensión Y del juego.
	 * Si la dimensión es menor que 3, se establece como 3.
	 *
	 * @param dimY La nueva dimensión Y.
	 */
	public void setDimY(int dimY) {
		this.dimY = dimY;
		checkDim();
	}

	/**
	 * Obtiene el jugador asociado al juego.
	 *
	 * @return El jugador asociado.
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * Obtiene el nombre del juego.
	 *
	 * @return El nombre del juego.
	 */
	public String getNombreJuego() {
		return nombreJuego;
	}

	/**
	 * Establece el nombre del juego.
	 *
	 * @param nombreJuego El nuevo nombre del juego.
	 */
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}
}
