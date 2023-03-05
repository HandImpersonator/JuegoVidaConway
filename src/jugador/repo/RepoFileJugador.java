package jugador.repo;

import java.util.List;
import java.util.Vector;

import jugador.model.Jugador;

public class RepoFileJugador {
	private List<Jugador> jugadores;
	private FileUtilJugador fichero;
	
	public RepoFileJugador() {
		fichero = new FileUtilJugador();
		this.jugadores = fichero.read();	
	}
	
	public void create(Jugador jugador) {
		jugadores.add(jugador);
		fichero.save(jugadores);
	}
	public List<Jugador> read(){
		return jugadores;
	}
	public boolean update(int posx, Jugador jugador) {
		if(posx < 0 || posx >= jugadores.size()) {
			return false;
		}
		else {
			jugadores.set(posx, jugador);
			return true;
		}
	}
	public boolean remove(int posx) {
		if(posx < 0 || posx >= jugadores.size()) {
			return false;
		} else {
			jugadores.remove(posx);
			return true;
		}
	}
	public int buscar(int expediente) {
		for(int i = 0; i < jugadores.size(); i++) {
			if(jugadores.get(i).equals(new Jugador("", expediente))) {
				return i;
			}
		}
		return -1;
	}
	public int size() {
		return jugadores.size();
	}
}