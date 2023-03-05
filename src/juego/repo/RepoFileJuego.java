package juego.repo;

import java.util.List;

import juego.model.Juego;

public class RepoFileJuego {
	private List<Juego> juegos;
	
	public void create(Juego juego) {
		juegos.add(juego);
	}
	public List<Juego> read(){
		return juegos;
	}
}