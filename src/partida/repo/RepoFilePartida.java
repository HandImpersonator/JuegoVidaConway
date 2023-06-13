/**
 * Clase que maneja operaciones de repositorio para crear, leer, actualizar y eliminar partidas.
 * Esta clase proporciona métodos para realizar operaciones en ficheros de partidas y en memoria.
 * Esta clase está marcada como obsoleta (deprecated) y se recomienda su reemplazo por la clase RepoFileBinPartida.
 * Esta clase implementa la interfaz IRepoPartida.
 * @deprecated Esta clase está marcada como obsoleta y se recomienda su reemplazo por la clase RepoFileBinPartida.
 *
 * @author User
 */

package partida.repo;

import java.util.List;

import partida.model.Partida;


@Deprecated
public class RepoFilePartida implements IRepoPartida {
    private List<Partida> partidas;
    private FileUtilPartida fichero;

    /**
     * Constructor de la clase RepoFilePartida.
     * Crea una instancia de RepoFilePartida y carga las partidas desde el fichero.
     */
    public RepoFilePartida() {
        fichero = new FileUtilPartida();
        this.partidas = fichero.read();
    }

    /**
     * Crea una nueva partida y la guarda en el repositorio.
     *
     * @param partida La partida a crear y guardar.
     */
    @Override
    public void create(Partida partida) {
        partidas.add(partida);
        fichero.save(partidas);
    }

    /**
     * Lee las partidas del repositorio asociadas a un ID de expediente.
     *
     * @param idExp El ID de expediente para filtrar las partidas.
     * @return Una lista de partidas asociadas al ID de expediente.
     */
    @Override
    public List<Partida> read(int idExp) {
        return partidas;
    }

    /**
     * Actualiza una partida existente en el repositorio.
     *
     * @param idExp   El ID de expediente de la partida.
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
     * Elimina una partida del repositorio.
     *
     * @param idExp El ID de expediente de la partida.
     * @param posx  La posición de la partida en la lista de partidas.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean remove(int idExp, int posx) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.remove(posx);
            return true;
        }
    }

    /**
     * Busca una partida en el repositorio basándose en su ID de expediente e ID de partida.
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
     * Devuelve el número de partidas en el repositorio.
     *
     * @return El número de partidas en el repositorio.
     */
    @Override
    public int size() {
        return partidas.size();
    }

}
