package jugador.repo;

import java.util.List;

import jugador.model.Jugador;

public interface IRepoJugador {
	public void create(Jugador jugador);
	public List<Jugador> read();
	public boolean update(int posx, Jugador jugador);
	public boolean remove(int posx);
	public int buscar(int expediente);
	public int size();
}
