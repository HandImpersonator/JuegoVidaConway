package partida.repo;

import java.util.List;
import java.util.Vector;

import partida.model.Partida;

public class RepoFilePartida {
	private List<Partida> partidas;

	public void create(Partida partida) {
		partidas.add(partida);
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
