package partida;

import juego.Juego;

public class Partida  {
	private int numCeldasMuertas;
	private int numCeldasVivasInicio;
	private int numCeldasVivasFinal;
	private int ronda;
	private Juego juego;
	
	public Partida(int numCeldasVivasInicio, Juego juego) {
		numCeldasMuertas = 0;
		this.numCeldasVivasInicio = numCeldasVivasInicio;
		numCeldasVivasFinal = numCeldasVivasInicio;
		ronda = 0;
		this.juego = juego;
	}

	public void nextRonda() {
		ronda++; // Aqui hay que aplicar las reglas del juego.
	}
	
	public int getNumCeldasVivasInicio() {
		return numCeldasVivasInicio;
	}
	public int getNumCeldasMuertas() {
		return numCeldasMuertas;
	}
	public int getNumCeldasVivasFinal() {
		return numCeldasVivasFinal;
	}
	public int getRonda() {
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	public Juego getJuego() {
		return juego;
	}
}