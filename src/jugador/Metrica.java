package jugador;

import java.util.List;
import java.util.Vector;

import partida.Partida;

public class Metrica {
	private List<Partida> partidas;
	private int numCeldasMuertas;
	private int numCeldasVivasInicio;
	private int numCeldasVivasFinal;
	
	public Metrica() {
		partidas = new Vector<Partida>();
		numCeldasMuertas = 0;
		numCeldasVivasInicio = 0;
		numCeldasVivasFinal = 0;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public int getNumCeldasMuertas() {
		return numCeldasMuertas;
	}

	public void setNumCeldasMuertas(int numCeldasMuertas) {
		this.numCeldasMuertas = numCeldasMuertas;
	}

	public int getNumCeldasVivasInicio() {
		return numCeldasVivasInicio;
	}

	public void setNumCeldasVivasInicio(int numCeldasVivasInicio) {
		this.numCeldasVivasInicio = numCeldasVivasInicio;
	}

	public int getNumCeldasVivasFinal() {
		return numCeldasVivasFinal;
	}

	public void setNumCeldasVivasFinal(int numCeldasVivasFinal) {
		this.numCeldasVivasFinal = numCeldasVivasFinal;
	}

	
}