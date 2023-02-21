package juego;

/**
 * Dimensiones del juego.
 * @author user
 *
 */
public class Juego  {
	private int dimX;
	private int dimY;
	
	/**
	 * Constructor con las dimensiones X e Y de un juego.
	 * @param dimX si menor que 3, entonces vale 3.
	 * @param dimY si menor que 3, entonces vale 3.
	 *
	 */
	public Juego(int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		checkDim();
	}
	
	/**
	 * Constructor con las dimension cuadrada.
	 * @param dim si menor que 3, entonces dimX = dimY = 3.
	 *
	 */
	public Juego(int dim) {
		this.dimX = dim;
		this.dimY = dim;
		checkDim();
	}
	
	/**
	 * Constructor con las dimension cuadrada.
	 * si dimX o dimY menor que 3, entonces valen 3.
	 *
	 */
	private void checkDim() {
		if (dimX < 3) {
			dimX = 3;		
		}
		if (dimY < 3) {
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