package juego.repositorio;

import java.util.List;
import juego.model.Juego;
import jugador.model.Jugador;
import juego.repositorio.FileUtilJuego;

public class RepoFileJuego {
	private List<Juego> juegos;
	private FileUtilJuego fichero;
	public RepoFileJuego() {
		fichero = new FileUtilJuego();
		this.juegos = fichero.read();	
	}
	public void create (Juego juego) {
		juegos.add(juego);
		fichero.save(juegos);
	}
	public List<Juego> read (){
		return juegos;
	}
	public Juego read (int pos){
		return juegos.get(pos);
	}
	public boolean update (int posx,Juego juego) {
		if(posx< 0 || posx>= juegos.size()) {
			return false;
		}
		else {
			juegos.set(posx, juego);
			return true;
		}
	}
	public boolean remove (int posx) {
		if(posx< 0 || posx>= juegos.size()) {
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
	public int size () {
		return juegos.size();
	}
}
