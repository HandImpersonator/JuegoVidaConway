package reglas;

import java.util.List;

public class RepoFileReglas {
	private List<Regla> reglas;
	
	public RepoFileReglas() {
	}
	public void create (Regla regla) {
		reglas.add(regla);
	}
	public List<Regla> read (){
		return reglas;
	}
}
