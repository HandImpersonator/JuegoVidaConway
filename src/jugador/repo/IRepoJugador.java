/**

 Esta interfaz define los métodos para interactuar con un repositorio de jugadores.
 */
package jugador.repo;


import jugador.model.Jugador;
import partida.model.Partida;

import java.util.List;

public interface IRepoJugador {
	/**
	 * Crea un nuevo jugador en el repositorio.
	 *
	 * @param jugador El jugador a crear.
	 */
	void create(Jugador jugador);

	/**
	 * Lee la lista de partidas asociadas a un jugador.
	 *
	 * @param id El identificador del jugador.
	 * @return La lista de partidas del jugador.
	 */
	List<Partida> read(int id);

	/**
	 * Lee un jugador del repositorio.
	 *
	 * @param id El identificador del jugador.
	 * @return El jugador encontrado, o null si no existe.
	 */
	Jugador readJ(int id);

	/**
	 * Actualiza los datos de un jugador en el repositorio.
	 *
	 * @param jugador El jugador a actualizar.
	 * @return true si la actualización fue exitosa, false en caso contrario.
	 */
	boolean update(Jugador jugador);

	/**
	 * Busca el índice de una partida en la lista de partidas de un jugador.
	 *
	 * @param ps   La lista de partidas del jugador.
	 * @param idP  El identificador de la partida a buscar.
	 * @return El índice de la partida en la lista, o -1 si no se encontró.
	 */
	int buscar(List<Partida> ps, int idP);

	/**
	 * Obtiene el tamaño de la lista de partidas de un jugador.
	 *
	 * @param jugador El jugador.
	 * @return El tamaño de la lista de partidas.
	 */
	int size(Jugador jugador);

	/**
	 * Elimina una partida del repositorio de un jugador.
	 *
	 * @param jugador El jugador propietario de la partida.
	 * @param idP     El identificador de la partida a eliminar.
	 */
	void remove(Jugador jugador, int idP);

	/**
	 * Elimina un jugador del repositorio.
	 *
	 * @param jugador El jugador a eliminar.
	 */
	void removeP(Jugador jugador);

}

