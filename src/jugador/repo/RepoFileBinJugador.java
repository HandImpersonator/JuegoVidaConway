package jugador.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import common.util.FileUtil;
import jugador.model.Jugador;

public class RepoFileBinJugador implements IRepoJugador {
	private List<Jugador> jugadores;
	private final String ruta = "data/jugador.dat";
	
	public RepoFileBinJugador() {
		List<Jugador> lTemp=FileUtil.deserializeFromFileToList(ruta);
		if (lTemp==null)
			this.jugadores = new ArrayList<>();	
		else
			jugadores=lTemp;
	}
	
	public void create(Jugador jugador) {
		jugadores.add(jugador);
		FileUtil.serializeFromListToFile(ruta,jugadores);
	}
	public List<Jugador> read(){
		List<Jugador> lTemp=FileUtil.deserializeFromFileToList(ruta);
		jugadores = (lTemp!=null)?FileUtil.deserializeFromFileToList(ruta):new ArrayList<>();
		return jugadores;
	}
	public boolean update(int posx, Jugador jugador) {
		if(posx < 0 || posx >= jugadores.size()) {
			return false;
		}
		else {
			jugadores.set(posx, jugador);
			FileUtil.serializeFromListToFile(ruta,jugadores);
			return true;
		}
	}
	public boolean remove(int posx) {
		if(posx < 0 || posx >= jugadores.size()) {
			return false;
		} else {
			jugadores.remove(posx);
			FileUtil.serializeFromListToFile(ruta,jugadores);
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