/**
 * Interfaz para el repositorio de partidas.
 * Esta interfaz define los métodos necesarios para crear, leer, actualizar y eliminar partidas,
 * así como realizar otras operaciones relacionadas.
 *
 * @author User
 */

package partida.repo;

import java.util.List;

import partida.model.Partida;


public interface IRepoPartida {
    /**
     * Crea una nueva partida.
     *
     * @param partida La partida a crear.
     */
    void create(Partida partida);

    /**
     * Lee las partidas asociadas a un ID de expediente.
     *
     * @param idExp El ID de expediente para el cual se desean obtener las partidas.
     * @return Una lista de partidas asociadas al ID de expediente.
     */
    List<Partida> read(int idExp);

    /**
     * Actualiza una partida existente.
     *
     * @param idExp El ID de expediente al que pertenece la partida.
     * @param posx La posición de la partida en la lista de partidas.
     * @param partida La partida actualizada.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    boolean update(int idExp, int posx, Partida partida);

    /**
     * Elimina una partida existente.
     *
     * @param idExp El ID de expediente al que pertenece la partida.
     * @param posx La posición de la partida en la lista de partidas.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    boolean remove(int idExp, int posx);

    /**
     * Busca una partida por su ID de expediente y su ID de partida.
     *
     * @param idE El ID de expediente de la partida a buscar.
     * @param id El ID de partida a buscar.
     * @return La posición de la partida en la lista de partidas, o -1 si no se encontró la partida.
     */
    int buscar(int idE, int id);

    /**
     * Obtiene el número total de partidas almacenadas.
     *
     * @return El número total de partidas almacenadas.
     */
    int size();

}
