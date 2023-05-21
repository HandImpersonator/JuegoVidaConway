package partida.model;

import java.io.Serializable;

import regla.model.Regla;


public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idExp;
    private int idPartida;
    private int numCeldasMuertas;
    private int numCeldasVivasInicio;
    private int numCeldasVivasFinal;
    private int ronda;
    private Regla reglas; // Contiene las reglas de la partida.

    public Partida(int idExp, int idPartida, int numCeldasVivasInicio, Regla reglas) {
        this.idExp = idExp;
        this.idPartida = idPartida;
        this.numCeldasVivasInicio = numCeldasVivasInicio;
        this.reglas = reglas;
        numCeldasMuertas = 0;
        numCeldasVivasFinal = numCeldasVivasInicio;
        ronda = 0;
    }

    public Partida(int idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public String toString() {
        return "Partida [ID Expediente = " + idExp + ", ID Partida=" + idPartida + ", numCeldasVivasInicio=" + numCeldasVivasInicio
                + ", numCeldasVivasFinal=" + numCeldasVivasFinal + ", numCeldasMuertas=" + numCeldasMuertas
                + ", reglas=" + reglas + ", rondas=" + ronda + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (((Partida) (obj)).idPartida == this.idPartida) {
            return true;
        }
        return false;
    }

    public int getIdExp() {
        return idExp;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getNumCeldasVivasInicio() {
        return numCeldasVivasInicio;
    }

    public int getNumCeldasMuertas() {
        return numCeldasMuertas;
    }

    public int getNumCeldasVivasFinal() {
        return numCeldasVivasFinal;
    }

    public int getRonda() {
        return ronda;
    }

    public void nextRonda() {
        ronda++; // Aqui hay que aplicar las reglas del juego.
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public Regla getReglas() {
        return reglas;
    }
}
