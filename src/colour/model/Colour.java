package colour.model;

import java.io.Serializable;

/**
 * Clase que representa un color.
 */
public class Colour implements Serializable {
	private static final long serialVersionUID = 1L;
	private java.awt.Color idColor;

	/**
	 * Constructor de la clase Colour.
	 *
	 * @param color El color a asignar.
	 */
	public Colour(java.awt.Color color) {
		this.idColor = color;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Colour) obj).getidColor() == this.idColor;
	}

	@Override
	public String toString() {
		return "Color [idColor=" + idColor + "]";
	}

	/**
	 * Obtiene el color asociado.
	 *
	 * @return El color asociado.
	 */
	public java.awt.Color getidColor() {
		return idColor;
	}

	/**
	 * Establece el color asociado.
	 *
	 * @param idColor El color a establecer.
	 */
	public void setidColor(java.awt.Color idColor) {
		this.idColor = idColor;
	}
}
