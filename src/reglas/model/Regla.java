package reglas.model;

public class Regla {
	private int CeldasVivasAlrededor; // declara las celdas vivas necesarias para revivir a otra muerta.
	private int CeldasMuertasAlrededor; // declara las celdas vivas necesarias para matar a una  viva.
	
	public Regla(int CeldasVivasAlrededor, int CeldasMuertasAlrededor) {
		this.CeldasVivasAlrededor = CeldasVivasAlrededor;
		this.CeldasMuertasAlrededor = CeldasMuertasAlrededor;
	}
	public int getCeldasVivasAlrededor() {
		return CeldasVivasAlrededor;
	}
	public void setCeldasVivasAlrededor(int celdasVivasAlrededor) {
		CeldasVivasAlrededor = celdasVivasAlrededor;
	}
	public int getCeldasMuertasAlrededor() {
		return CeldasMuertasAlrededor;
	}
	public void setCeldasMuertasAlrededor(int celdasMuertasAlrededor) {
		CeldasMuertasAlrededor = celdasMuertasAlrededor;
	}
}