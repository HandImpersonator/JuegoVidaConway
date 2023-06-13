package jugador.repo;


import jugador.model.Jugador;
import partida.model.Partida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public interface IRepoJugador {
	void create(Jugador jugador);
	List<Partida> read(int id);
	Jugador readJ(int id);
	public boolean update(Jugador jugador);
	public int buscar(List<Partida> ps, int idP);
	public int size(Jugador jugador);
	void remove(Jugador jugador, int idP);
	void removeP(Jugador jugador);
}

