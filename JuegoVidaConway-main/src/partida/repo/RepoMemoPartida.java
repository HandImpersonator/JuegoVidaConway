package partida.repo;

import java.util.List;
import java.util.Vector;

import juego.model.Juego;
import partida.model.Partida;

public class RepoMemoPartida {
	private List<Partida> partidas;

	public RepoMemoPartida() {
		this.partidas = new Vector<> ();
	}
	
	public void create(Partida Partida) {
		partidas.add(Partida);
	}
	public List<Partida> read(){
		return partidas;
	}
	public boolean remove(int posx) {
		if(posx < 0 || posx >= partidas.size()) {
			return false;
		}
		else {
			partidas.remove(posx);
			return true;
		}
	}
	public int buscar(int id) {
		for(int i = 0; i < partidas.size(); i++) {
			if(partidas.get(i).equals(new Partida(id, 0, null))) {
				return i;
			}
		}
		return -1;
	}
	public int size() {
		return partidas.size();
	}
}
