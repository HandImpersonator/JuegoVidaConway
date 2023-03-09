

import java.util.List;
import java.util.Vector;


public class RepoFileRegla {



	private List<Regla>reglas;
	private FileUtilRegla fichero ;
	public RepoFileRegla() {
		fichero = new FileUtilRegla();
		this.reglas = new Vector();
		
	}

	public void create (Regla regla) {
		reglas.add(regla);
		fichero.save(reglas);
	}
	public List<Regla> read (){
		return fichero.read();
	}
	public Regla read(int pos) {
		return reglas.get(pos);
	}
	public boolean update (int posx,Regla regla) {
		if(posx< 0 || posx>= reglas.size()) {
			return false;
		}
		else {
			reglas.set(posx, regla);
			fichero.save(reglas);
			return true;
			
		}
	}
	public boolean remove (int posx) {
		if(posx< 0 || posx>= reglas.size()) {
			return false;
		}
		else {
			reglas.remove(posx);
			fichero.save(reglas);
			return true;
		}
	}
	public int buscar(String nombrederegla) {
		for(int i = 0;i<reglas.size();i++) {
			if(reglas.get(i).equals(new Regla(0,0,0,nombrederegla))) {
				return i;
			}
		}
		return -1;
	}
	public int size () {
		return reglas.size();
	}
}

