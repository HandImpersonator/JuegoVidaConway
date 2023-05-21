package partida.model;

import regla.model.Regla;

public class PartidaPorDefecto extends Partida {
    private static final long serialVersionUID = 1L;

    public PartidaPorDefecto(int idExp, String nombrePartida, int numCeldasVivasInicio) {
        super(idExp, setRPartida(nombrePartida), numCeldasVivasInicio, new Regla(1, 2, 3));
    }

    @Override
    public String toString() {
        return "Partida por defecto: " + super.toString();
    }
    
    private static int setRPartida(String n) {
        return new Generador(n).toInt();
    }
}
