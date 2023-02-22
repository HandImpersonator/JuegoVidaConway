package partida;

import juego.Juego;

public class Partida {
	private int numCeldasMuertas;
	private int numCeldasVivasInicio;
	private int numCeldasVivasFinal;
	private int ronda;
	private Juego juego;
	public Partida(int numCeldasVivasInicio,Juego juego) {
		this.numCeldasVivasInicio = numCeldasVivasInicio;
		this.juego = juego;
		numCeldasVivasFinal = numCeldasVivasInicio;
		numCeldasMuertas = 0;
		ronda = 0;
	}
	public void nextRonda() {
		ronda++;//Aquí hay que aplicar las reglas del juego.
	}
	public int getNumCeldasMuertas() {
		return numCeldasMuertas;
	}
	public int getNumCeldasVivasInicio() {
		return numCeldasVivasInicio;
	}
	public int getNumCeldasVivasFinal() {
		return numCeldasVivasFinal;
	}
	public int getRonda() {
		return ronda;
	}
	public Juego getJuego() {
		return juego;
	}
}
