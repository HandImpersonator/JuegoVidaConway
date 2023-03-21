package partida.repo;

import java.util.ArrayList;
import java.util.List;

import common.util.FileUtil;
import partida.model.Partida;


public class RepoFileBinPartida implements IRepoPartida {
    private List<Partida> partidas;
    private final String ruta = "data/partida.dat";

    public RepoFileBinPartida() {
        this.partidas = new ArrayList<>();
    }

    @Override
    public void create(Partida partida) {
        partidas.add(partida);
        FileUtil.serializeFromListToFile(ruta, partidas);
    }

    @Override
    public List<Partida> read() {
        partidas = FileUtil.deserializeFromFileToList(ruta);
        return partidas;
    }

    @Override
    public boolean update(int posx, Partida Partida) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.set(posx, Partida);
            FileUtil.serializeFromListToFile(ruta, partidas);
            return true;
        }
    }

    @Override
    public boolean remove(int posx) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.remove(posx);
            FileUtil.serializeFromListToFile(ruta, partidas);
            return true;
        }
    }

    @Override
    public int buscar(int id) {
        for (int i = 0; i < partidas.size(); i++) {
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
}
