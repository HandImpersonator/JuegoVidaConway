package JuegoVidaConway-main;

import java.util.List;



public class IRepoRegla {
	public void create(Regla regla );
	public List<Regla> read();
	public boolean update(int posx, Regla regla );
	public boolean remove(int posx);
	public int buscar(String nombrederegla);
	public int size();
}
