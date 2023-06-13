/**
 * Clase que crea nuevas partidas, lee partidas, lee ficheros de partidas, actualiza un fichero de partida y borra una partida de un fichero.
 * Esta clase proporciona métodos para realizar operaciones matemáticas simples.
 *
 * @author User
 */

package partida.repo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import common.util.FileUtil;
import partida.model.Partida;

public class RepoFileBinPartida implements IRepoPartida {
    private List<Partida> partidas;
    private Path dataDirectory;

    public RepoFileBinPartida() {
        this.partidas = new ArrayList<>();
        this.dataDirectory = Paths.get("data");
    }

    @Override
    public void create(Partida partida) {
        partidas.add(partida);
        Path filePath = getFilePath(partida.getIdExp());
        FileUtil.serializeFromListToFile(filePath.toString(), partidas);
    }

    @Override
    public List<Partida> read(int idExp) {
        Path filePath = getFilePath(idExp);
        partidas = FileUtil.deserializeFromFileToList(filePath.toString());
        return partidas;
    }

    @Override
    public boolean update(int idExp, int posx, Partida Partida) {
        Path filePath = getFilePath(idExp);
        List<Partida> parts = read(idExp);
        if ((posx < 0) || (posx >= parts.size())) {
            return false;
        } else {
            parts.set(posx, Partida);
            FileUtil.serializeFromListToFile(filePath.toString(), parts);
            return true;
        }
    }

    @Override
    public boolean remove(int idExp, int posx) {
        Path filePath = getFilePath(idExp);
        List<Partida> parts = read(idExp);
        if ((posx < 0) || (posx >= parts.size())) {
            return false;
        } else {
            parts.remove(posx);
            FileUtil.serializeFromListToFile(filePath.toString(), parts);
            return true;
        }
    }

    @Override
    public int buscar(int idExp, int id) {
        Path filePath = getFilePath(idExp);
        partidas = FileUtil.deserializeFromFileToList(filePath.toString());
        for (int i = 0; i < Objects.requireNonNull(partidas).size(); i++) {
            if (partidas.get(i).equals(new Partida(id))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return partidas.size();
    }

    private Path getFilePath(int idExp) {
        String fileName = "partida_" + String.valueOf(idExp) + ".dat";
        return dataDirectory.resolve(fileName);
    }
}
