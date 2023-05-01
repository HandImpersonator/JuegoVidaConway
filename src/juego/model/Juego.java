package juego.model;

import jugador.model.Jugador;

/**
 * Dimensiones.
 * @author RCD dabf
 *
 */
//hh
public class Juego {
	private int dimX;
	private int dimY;
	private Jugador jugador;
	private String nombreJuego;
	/**
	 * Constructor con las dos dimensiones.
	 * @param dimX si menor que 3, entonces vale 3.
	 * @param dimY si menor que 3, entonces vale 3.
	 */
	public Juego(int dimX, int dimY,Jugador jugador,String nombreJuego) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.jugador = jugador;
		this.nombreJuego = nombreJuego;
		checkDim();
	}
	/**
	 * Constructor con dimension cuadrada.
	 * @param dim si menor que 3, entonces dimX = dimY = 3.
	 */
	public Juego(int dim,Jugador jugador,String nombreJuego) {
		this(dim,dim,jugador,nombreJuego);
	}
	public Juego(Jugador jugador, String nombreJuego) {
		this.jugador = jugador;
		this.nombreJuego = nombreJuego;
	}
	/**
	 * dimX o dimY si menor que 3, entonces valen 3.
	 */
	private void checkDim() {
		if (dimX<3) {
			dimX = 3;
		}
		if (dimY<3) {
			dimY = 3;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this.nombreJuego.equals(((Juego)obj).getNombreJuego())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Juego [dimX=" + dimX + ", dimY=" + dimY + ", jugador=" + jugador + ", nombreJuego=" + nombreJuego + "]";
	}
	public int getDimX() {
		return dimX;
	}
	public void setDimX(int dimX) {
		this.dimX = dimX;
		checkDim();
	}
	public int getDimY() {
		return dimY;
	}
	public void setDimY(int dimY) {
		this.dimY = dimY;
		checkDim();
	}
	public Jugador getJugador() {
		return jugador;
	}
	public String getNombreJuego() {
		return nombreJuego;
	}
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}





}
