package reglas.repo;

import java.util.List;

import reglas.model.Regla;

public class RepoFileReglas {
	private List<Regla> reglas;
	
	public RepoFileReglas() {
	}
	public void create (Regla regla) {
		reglas.add(regla);
	}
	public List<Regla> read(){
		return reglas;
	}
}