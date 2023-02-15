package juego;

public class Juego  {
	private int dimX;
	private int dimY;
	
	public Juego(int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		checkDim();
	}
	
	public Juego(int dim) {
		this.dimX = dim;
		this.dimY = dim;
		checkDim();
	}
	
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