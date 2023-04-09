package juego.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import common.util.FileUtil;
import juego.model.Juego;
import jugador.model.Jugador;

public class RepoFileBinJuego implements IRepoJuego {
	private List<Juego> juegos;
	private final String ruta = "data/juego.dat";
	
	public RepoFileBinJuego() {
		List<Juego> temp = FileUtil.deserializeFromFileToList(ruta);
		if(temp == null) {
			juegos = new Vector<>();
		}
		else {
			this.juegos = temp;
		}
	}
	
	public void create(Juego juego) {
		juegos.add(juego);
		FileUtil.serializeFromListToFile(ruta,juegos);
	}
	public List<Juego> read(){
		juegos = FileUtil.deserializeFromFileToList(ruta);
		return juegos;
	}
	public boolean update(int posx, Juego juego) {
		if(posx < 0 || posx >= juegos.size()) {
			return false;
		}
		else {
			juegos.set(posx, juego);
			FileUtil.serializeFromListToFile(ruta,juegos);
			return true;
		}
	}
	public boolean remove(int posx) {
		if(posx < 0 || posx >= juegos.size()) {
			return false;
		} else {
			juegos.remove(posx);
			FileUtil.serializeFromListToFile(ruta,juegos);
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