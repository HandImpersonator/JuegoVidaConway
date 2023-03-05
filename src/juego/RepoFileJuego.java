package juego;

import java.util.List;

import jugador.model.Jugador;

public class RepoFileJuego {
	private List<Juego> juegos;
	public void create (Juego juego) {
		juegos.add(juego);
	}
	public List<Juego> read (){
		return juegos;
	}
}
