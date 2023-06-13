package regla.model;

import java.io.Serializable;

public class Regla implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombredereglas;
	private int nvivasrevive; 
	private int nvivasmuere ;
	private int nvivasvive ;
		
		public Regla( int nvivasrevive, int nvivasmuere, int nvivasvive) {
			this.nvivasrevive = nvivasrevive;
			this.nvivasmuere = nvivasmuere;
			this.nvivasvive = nvivasvive;
			this.nombredereglas= "default";
		}

		public Regla( int nvivasrevive, int nvivasmuere, int nvivasvive, String nombredereglas) {
			this.nvivasrevive = nvivasrevive;
			this.nvivasmuere = nvivasmuere;
			this.nvivasvive = nvivasvive;
			this.nombredereglas= nombredereglas;
		}
		@Override
	    public boolean equals(Object obj) {
	        if (((Regla)obj).getNombredereglas() == this.nombredereglas) {
	            return true;
	        }
	        return false;
	    }
	    @Override
	    public String toString() {
	        return "Reglas [nombredereglas=" + nombredereglas + ", nvivasrevive=" + nvivasrevive  + ", nvivasmuere=" + nvivasmuere +"nvivasvive ="+ nvivasvive+"]";
	    }

		public int getNvivasrevive() {
			return nvivasrevive;
		}
		public String getNombredereglas() {
			return nombredereglas;
		}

		public void setNvivasrevive(int nvivasrevive) {
			this.nvivasrevive = nvivasrevive;
		}


		public int getNvivasmuere() {
			return nvivasmuere;
		}


		public void setNvivasmuere(int nvivasmuere) {
			this.nvivasmuere = nvivasmuere;
		}


		public int getNvivasvive() {
			return nvivasvive;
		}


		public void setNvivasvive(int nvivasvive) {
			this.nvivasvive = nvivasvive;
		}
		


		public void setNombredereglas(String nombredereglas) {
			this.nombredereglas = nombredereglas;
		}


}


