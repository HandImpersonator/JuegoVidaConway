package JuegoVidaConway-main;


import java.util.ArrayList;
import java.util.List;



public class RepoFileBinRegla implements IRepoRegla{
	private List<Regla> reglas;
	private final String ruta = "data/reglascustomizadas.dat";
	
	public RepoFileBinRegla() {
		this.reglas = new ArrayList<>();	
	}
	
	public void create(Regla regla) {
		jugadores.add(regla);
		FileUtil.serializeFromListToFile(ruta,reglas);
	}
	public List<Regla> read(){
		jugadores = FileUtil.deserializeFromFileToList(ruta);
		return reglas;
	}
	public boolean update(int posx, Regla regla) {
		if(posx < 0 || posx >= reglas.size()) {
			return false;
		}
		else {
			jugadores.set(posx, regla);
			FileUtil.serializeFromListToFile(ruta,reglas);
			return true;
		}
	}
	public boolean remove(int posx) {
		if(posx < 0 || posx >= reglas.size()) {
			return false;
		} else {
			reglas.remove(posx);
			FileUtil.serializeFromListToFile(ruta,reglas);
			return true;
		}
	}
	public int buscar(String nombrederegla) {
		for(int i = 0; i < jugadores.size(); i++) {
			if(reglas.get(i).equals(new Regla("", nombrederegla))) {
				return i;
			}
		}
		return -1;
	}
	public int size() {
		return reglas.size();
	}
}
