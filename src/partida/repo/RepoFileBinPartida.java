package partida.repo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import common.util.FileUtil;
import partida.model.Partida;


public class RepoFileBinPartida implements IRepoPartida {
    private List<Partida> partidas;

    public RepoFileBinPartida() {
        this.partidas = new ArrayList<>();
    }

    @Override
    public void create(Partida partida) {
        partidas.add(partida);
        String ruta = "data/partida_" + String.valueOf(partida.getIdExp()) + ".dat";
        FileUtil.serializeFromListToFile(ruta, partidas);
    }

    @Override
    public List<Partida> read(int idExp) {
        File[] fileLista = (new File("data/").listFiles());
        for (File element : fileLista) {
            if (!element.isDirectory()) {
                String nameFile = element.getName();
                String compareFile = "partida_" + String.valueOf(idExp) + ".dat";
                if (nameFile.equals(compareFile)) {
                    String ruta = "data/" + nameFile;
                    partidas = FileUtil.deserializeFromFileToList(ruta);
                    return partidas;
                }
            }
        }
        return partidas;
    }
    
    public List<Partida> readFile(String ruta) {
        partidas = FileUtil.deserializeFromFileToList(ruta);
        return partidas;
    }

    @Override
    public boolean update(int idExp, int posx, Partida Partida) {
        String ruta = "data/partida_" + String.valueOf(idExp) + ".dat";
        List<Partida> parts = readFile(ruta);
        if ((posx < 0) || (posx >= parts.size())) {
            return false;
        } else {
            parts.set(posx, Partida);
            FileUtil.serializeFromListToFile(ruta, parts);
            return true;
        }
    }

    @Override
    public boolean remove(int idExp, int posx) {
        String ruta = "data/partida_" + String.valueOf(idExp) + ".dat";
        List<Partida> parts = readFile(ruta);
        if ((posx < 0) || (posx >= parts.size())) {
            return false;
        } else {
            parts.remove(posx);
            FileUtil.serializeFromListToFile(ruta, parts);
            return true;
        }
    }

    @Override
    public int buscar(int idExp, int id) {
        File[] fileLista = (new File("data/").listFiles());
        for (File element : fileLista) {
            if (!element.isDirectory()) {
                String nameFile = element.getName();
                String compareFile = "partida_" + String.valueOf(idExp) + ".dat";
                if (nameFile.equals(compareFile)) {
                    String ruta = "data/" + nameFile;
                }
            }
        }
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
