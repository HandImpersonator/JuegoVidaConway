package partida.repo;

import java.util.List;
import java.util.Vector;

import partida.model.Partida;


public class RepoMemoPartida implements IRepoPartida {

    private List<Partida> partidas;

    public RepoMemoPartida() {
        this.partidas = new Vector<>();
    }

    @Override
    public void create(Partida partida) {
        partidas.add(partida);
    }

    @Override
    public List<Partida> read() {
        return partidas;
    }

    @Override
    public boolean update(int posx, Partida Partida) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.set(posx, Partida);
            return true;
        }
    }

    @Override
    public boolean remove(int posx) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.remove(posx);
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
