package jugador;

public class Jugador  {
	private String nombre;
	private int numExpediente;
	private Metrica metrica;
	
	public Jugador(String nombre, int numExpediente) {
		this.nombre = nombre;
		this.numExpediente = numExpediente;
		metrica = new Metrica();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getMetrica() {
		return metrica;
	}

	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}
}