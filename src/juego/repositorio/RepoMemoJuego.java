package juego.repositorio;

import java.util.List;
import java.util.Vector;

import juego.model.Juego;
import jugador.model.Jugador;

public class RepoMemoJuego implements IRepoJuego{

	private List<Juego> juegos;

	public RepoMemoJuego() {
		this.juegos = new Vector<> ();
	}
	
	public void create(Juego juego) {
		juegos.add(juego);
	}
	public List<Juego> read(){
		return juegos;
	}
	public boolean update(int posx, Juego juego) {
		if(posx < 0 || posx >= juegos.size()) {
			return false;
		}
		else {
			juegos.set(posx, juego);
			return true;
		}
	}
	public boolean remove(int posx) {
		if(posx < 0 || posx >= juegos.size()) {
			return false;
		}
		else {
			juegos.remove(posx);
			return true;
		}
	}
	public int buscar(String nombreJuego) {
		for(int i = 0;i<juegos.size();i++) {
			if(juegos.get(i).equals(new Juego(0,new Jugador("",0),nombreJuego))) {
				return i;
			}
		}
		return -1;
	}
	public int size() {
		return juegos.size();
	}
}