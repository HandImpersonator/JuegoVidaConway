/**
 * Clase abstracta que implementa operaciones de repositorio en memoria para crear, leer, actualizar y eliminar partidas.
 * Esta clase proporciona una implementación básica utilizando una lista de partidas en memoria.
 * Esta clase está marcada como obsoleta (deprecated) y se recomienda su reemplazo por implementaciones más específicas.
 * Esta clase es abstracta y no implementa todos los métodos de la interfaz IRepoPartida.
 * @deprecated Esta clase está marcada como obsoleta y se recomienda su reemplazo por implementaciones más específicas.
 *
 * @author User
 */

package partida.repo;

import java.util.List;
import java.util.Vector;

import partida.model.Partida;


@Deprecated
public abstract class RepoMemoPartida implements IRepoPartida {

    private List<Partida> partidas;

    /**
     * Constructor de la clase RepoMemoPartida.
     * Crea una instancia de RepoMemoPartida y inicializa la lista de partidas en memoria.
     */
    public RepoMemoPartida() {
        this.partidas = new Vector<>();
    }

    /**
     * Crea una nueva partida y la agrega a la lista de partidas en memoria.
     *
     * @param partida La partida a crear y agregar.
     */
    @Override
    public void create(Partida partida) {
        partidas.add(partida);
    }

    /**
     * Lee las partidas almacenadas en la lista de partidas en memoria.
     *
     * @param idExp El ID de expediente para filtrar las partidas (no se utiliza en esta implementación).
     * @return Una lista de todas las partidas almacenadas en memoria.
     */
    @Override
    public List<Partida> read(int idExp) {
        return partidas;
    }

    /**
     * Actualiza una partida existente en la lista de partidas en memoria.
     *
     * @param idExp   El ID de expediente de la partida (no se utiliza en esta implementación).
     * @param posx    La posición de la partida en la lista de partidas.
     * @param partida La partida actualizada.
     * @return true si la actualización fue exitosa, false de lo contrario.
     */
    @Override
    public boolean update(int idExp, int posx, Partida partida) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.set(posx, partida);
            return true;
        }
    }

    /**
     * Elimina una partida de la lista de partidas en memoria.
     *
     * @param idEx  El ID de expediente de la partida (no se utiliza en esta implementación).
     * @param posx  La posición de la partida en la lista de partidas.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean remove(int idEx, int posx) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.remove(posx);
            return true;
        }
    }

    /**
     * Busca una partida en la lista de partidas en memoria basándose en su ID de expediente e ID de partida.
     *
     * @param idE El ID de expediente de la partida a buscar.
     * @param id  El ID de partida a buscar.
     * @return La posición de la partida encontrada en la lista de partidas, o -1 si no se encontró.
     */
    @Override
    public int buscar(int idE, int id) {
        for (int i = 0; i < partidas.size(); i++) {
            if (partidas.get(i).equals(new Partida(id))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Devuelve el número de partidas en el repositorio en memoria.
     *
     * @return El número de partidas en el repositorio en memoria.
     */
    @Override
    public int size() {
        return partidas.size();
    }

}
