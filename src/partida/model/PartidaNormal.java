package partida.model;

import regla.model.Regla;

public class PartidaNormal extends Partida {
    private static final long serialVersionUID = 1L;
    
    public PartidaNormal(int idExp, String nombrePartida, int numCeldasVivasInicio, int r1, int r2, int r3) {
        super(idExp, setRPartida(nombrePartida), numCeldasVivasInicio, new Regla(r1, r2, r3, "Personal"));
    }

    @Override
    public String toString() {
        return "Partida normal: " + super.toString();
    }
    
    public static int setRPartida(String n) {
        return new Generador(n).toInt();
    }
}
