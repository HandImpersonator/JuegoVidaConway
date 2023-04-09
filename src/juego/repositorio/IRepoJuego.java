package juego.repositorio;

import java.util.List;

import juego.model.Juego;
import jugador.model.Jugador;

public interface IRepoJuego {
	public void create(Juego juego);
	public List<Juego> read();
	public boolean update(int posx, Juego juego);
	public boolean remove(int posx);
	public int buscar(String nombreJuego);
	public int size();
}
