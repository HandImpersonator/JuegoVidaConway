package regla.model;

import java.io.Serializable;

/**
 * Representa una regla para el juego.
 * Cada regla tiene un nombre y un conjunto de condiciones para determinar el estado de una celda en el juego.
 * Implementa la interfaz Serializable para permitir la serialización de objetos.
 */
public class Regla implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombredereglas;
	private int nViveBot;
	private int nViveTop;
	private int nRevive;

	/**
	 * Crea una nueva instancia de Regla con los valores especificados.
	 *
	 * @param nViveBot  número mínimo de vecinos vivos para que una celda viva se mantenga viva en la siguiente generación
	 * @param nViveTop  número máximo de vecinos vivos para que una celda viva se mantenga viva en la siguiente generación
	 * @param nRevive   número de vecinos vivos requeridos para que una celda muerta se convierta en viva en la siguiente generación
	 */
	public Regla(int nViveBot, int nViveTop, int nRevive) {
		this.nViveBot = nViveBot;
		this.nViveTop = nViveTop;
		this.nRevive = nRevive;
		this.nombredereglas = "default";
	}

	/**
	 * Compara si la regla actual es igual a otro objeto especificado.
	 * Dos reglas son iguales si tienen el mismo nombre de reglas.
	 *
	 * @param obj el objeto a comparar con la regla actual
	 * @return true si las reglas son iguales, false de lo contrario
	 */
	@Override
	public boolean equals(Object obj) {
		return ((Regla) obj).getNombredereglas().equals(this.nombredereglas);
	}

	/**
	 * Devuelve una representación en forma de cadena de la regla.
	 *
	 * @return una cadena que representa la regla con sus valores de configuración
	 */
	@Override
	public String toString() {
		return "Reglas [nViveBot=" + nViveBot + ", nViveTop=" + nViveTop + ", nRevive=" + nRevive + ", nombredereglas=" + nombredereglas + "]";
	}

	/**
	 * Obtiene el nombre de las reglas.
	 *
	 * @return el nombre de las reglas
	 */
	public String getNombredereglas() {
		return nombredereglas;
	}

	/**
	 * Establece el nombre de las reglas.
	 *
	 * @param nombredereglas el nombre de las reglas a establecer
	 */
	public void setNombredereglas(String nombredereglas) {
		this.nombredereglas = nombredereglas;
	}

	/**
	 * Obtiene el número mínimo de vecinos vivos para que una celda viva se mantenga viva en la siguiente generación.
	 *
	 * @return el número mínimo de vecinos vivos para mantener una celda viva
	 */
	public int getnViveBot() {
		return nViveBot;
	}

	/**
	 * Establece el número mínimo de vecinos vivos para que una celda viva se mantenga viva en la siguiente generación.
	 *
	 * @param nViveBot el número mínimo de vecinos vivos para mantener una celda viva
	 */
	public void setnViveBot(int nViveBot) {
		this.nViveBot = nViveBot;
	}

	/**
	 * Obtiene el número máximo de vecinos vivos para que una celda viva se mantenga viva en la siguiente generación.
	 *
	 * @return el número máximo de vecinos vivos para mantener una celda viva
	 */
	public int getnViveTop() {
		return nViveTop;
	}

	/**
	 * Establece el número máximo de vecinos vivos para que una celda viva se mantenga viva en la siguiente generación.
	 *
	 * @param nViveTop el número máximo de vecinos vivos para mantener una celda viva
	 */
	public void setnViveTop(int nViveTop) {
		this.nViveTop = nViveTop;
	}

	/**
	 * Obtiene el número de vecinos vivos requeridos para que una celda muerta se convierta en viva en la siguiente generación.
	 *
	 * @return el número de vecinos vivos requeridos para que una celda muerta se convierta en viva
	 */
	public int getnRevive() {
		return nRevive;
	}

	/**
	 * Establece el número de vecinos vivos requeridos para que una celda muerta se convierta en viva en la siguiente generación.
	 *
	 * @param nRevive el número de vecinos vivos requeridos para que una celda muerta se convierta en viva
	 */
	public void setnRevive(int nRevive) {
		this.nRevive = nRevive;
	}

	/**
	 * Aplica la primera regla de la regla del juego.
	 * Determina si una celda viva se mantiene viva en la siguiente generación según la cantidad de vecinos vivos.
	 *
	 * @param liveCount la cantidad de vecinos vivos de la celda
	 * @return true si la celda viva se mantiene viva, false de lo contrario
	 */
	public boolean metodoRegla1(int liveCount) {
		return liveCount == 2 || liveCount == 3;
	}

	/**
	 * Aplica la segunda regla de la regla del juego.
	 * Determina si una celda muerta se convierte en viva en la siguiente generación según la cantidad de vecinos vivos.
	 *
	 * @param liveCount la cantidad de vecinos vivos de la celda
	 * @return true si la celda muerta se convierte en viva, false de lo contrario
	 */
	public boolean metodoRegla2(int liveCount) {
		return liveCount == 3;
	}
}
