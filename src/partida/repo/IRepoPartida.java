package partida.repo;

import java.util.List;

import partida.model.Partida;


public interface IRepoPartida {
    public void create(Partida partida);

    public List<Partida> read();

    public boolean update(int posx, Partida partida);

    public boolean remove(int posx);

    public int buscar(int id);

    public int size();
}
