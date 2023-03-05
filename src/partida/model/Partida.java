package partida.model;

import juego.model.Juego;
import jugador.model.Jugador;
import reglas.model.Regla;

public class Partida {
	private int idPartida;
	private int numCeldasMuertas;
	private int numCeldasVivasInicio;
	private int numCeldasVivasFinal;
	private int ronda;
	private Juego juego; // Contiene la dimension de la partida.
	private Regla reglas; // Contiene las reglas de la partida.

	public Partida(int idPartida, int numCeldasVivasInicio, Juego juego, Regla reglas) {
		this.idPartida = idPartida;
		this.numCeldasVivasInicio = numCeldasVivasInicio;
		this.juego = juego;
		this.reglas = reglas;
		numCeldasMuertas = 0;
		numCeldasVivasFinal = numCeldasVivasInicio;
		ronda = 0;
	}
	
	@Override
	public String toString() {
		return "Partida [numExpediente=" + idPartida + ", numCeldasVivasInicio=" + numCeldasVivasInicio + ", numCeldasVivasFinal=" + numCeldasVivasFinal + ", numCeldasMuertas=" + numCeldasMuertas + ", dimensiones=" + juego + ", reglas=" + reglas + ", rondas=" + ronda + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (((Partida) (obj)).idPartida == this.idPartida) {
			return true;
		}
		return false;
	}
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setExpedienteJugador(int expedienteJugador) {
		this.idPartida = expedienteJugador;
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
	public Regla getReglas() {
		return reglas;
	}
}
