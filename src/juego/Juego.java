package juego;
/**
 * Dimensiones.
 * @author RCD dabf
 *
 */
public class Juego {
	private int dimX;
	private int dimY;
	/**
	 * Constructor con las dos dimensiones.
	 * @param dimX si menor que 3, entonces vale 3.
	 * @param dimY si menor que 3, entonces vale 3.
	 */
	public Juego(int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		checkDim();
	}
	/**
	 * Constructor con dimension cuadrada.
	 * @param dim si menor que 3, entonces dimX = dimY = 3.
	 */
	public Juego(int dim) {
		this.dimX = dim;
		this.dimY = dim;
		checkDim();
	}
	/**
	 * dimX o dimY si menor que 3, entonces valen 3.
	 */
	private void checkDim() {
		if (dimX<3) {
			dimX = 3;
		}
		if (dimY<3) {
			dimY = 3;
		}
	}
	public int getDimX() {
		return dimX;
	}
	public void setDimX(int dimX) {
		this.dimX = dimX;
		checkDim();
	}
	public int getDimY() {
		return dimY;
	}
	public void setDimY(int dimY) {
		this.dimY = dimY;
		checkDim();
	}
	
	
}
