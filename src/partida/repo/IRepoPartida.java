package partida.repo;

import java.util.List;

import partida.model.Partida;


public interface IRepoPartida {
    public void create(Partida partida);
    public List<Partida> read(int idExp);
    public List<Partida> readFile(String ruta);
    public boolean update(int idExp, int posx, Partida partida);
    public boolean remove(int idExp, int posx);
    public int buscar(int idE, int id);
    public int size();
}
