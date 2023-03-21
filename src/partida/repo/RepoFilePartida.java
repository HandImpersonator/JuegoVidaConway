package partida.repo;

import java.util.List;

import partida.model.Partida;


@Deprecated
public class RepoFilePartida implements IRepoPartida {
    private List<Partida> partidas;
    private FileUtilPartida fichero;

    public RepoFilePartida() {
        fichero = new FileUtilPartida();
        this.partidas = fichero.read();
    }

    @Override
    public void create(Partida Partida) {
        partidas.add(Partida);
        fichero.save(partidas);
    }

    @Override
    public List<Partida> read() {
        return partidas;
    }

    @Override
    public boolean update(int posx, Partida partida) {
        if ((posx < 0) || (posx >= partidas.size())) {
            return false;
        } else {
            partidas.set(posx, partida);
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
            if (partidas.get(i).equals(new Partida(id, 0, null))) {
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
