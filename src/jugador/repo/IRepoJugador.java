package jugador.repo;


import jugador.model.Jugador;
import partida.model.Partida;

import java.util.List;

public interface IRepoJugador {
	void create(Jugador jugador);
	List<Partida> read(int id);
	Jugador readJ(int id);
	void remove(int id);
}

