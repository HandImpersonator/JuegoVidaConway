package colour.model;

import java.io.Serializable;

public class Colour implements Serializable {
	private static final long serialVersionUID = 1L;
	private java.awt.Color idColor;
	public Colour(java.awt.Color color) {
		this.idColor = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (((Colour)obj).getidColor() == this.idColor) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Color [idColor=" + idColor + "]";
	}
	public java.awt.Color getidColor() {
		return idColor;
	}
	public void setidColor(java.awt.Color idColor) {
		this.idColor= idColor;
	}
}
