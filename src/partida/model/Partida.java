package partida.model;

import regla.model.Regla;
import partida.repo.IRepoPartida;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;


public class Partida {
    private int idPartida;
    private int numCeldasMuertas;
    private int numCeldasVivasInicio;
    private int numCeldasVivasFinal;
    private int ronda;
    private Regla reglas; // Contiene las reglas de la partida.
    private List<Integer> listaIdPartida = new ArrayList();

    public Partida(int idPartida, int numCeldasVivasInicio, Regla reglas) {
        this.idPartida = idPartida;
        this.numCeldasVivasInicio = numCeldasVivasInicio;
        this.reglas = reglas;
        numCeldasMuertas = 0;
        numCeldasVivasFinal = numCeldasVivasInicio;
        ronda = 0;
    }

    public Partida(int numCeldasVivasInicio, Regla reglas) {
        idPartida = generateRandom();
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
        return "Partida [ID Partida=" + idPartida + ", numCeldasVivasInicio=" + numCeldasVivasInicio
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
    
    public int generateRandom() {
        Random rand = new Random();
        int max = 90000;
        int intRandom = 0;
        while (intRandom < 10000) {
            intRandom = rand.nextInt(max);
            if (!checkInt(intRandom)) {
                listaIdPartida.add(intRandom);
            }
        }
        return intRandom;
    }
    
    public boolean checkInt(int rand) {
        return listaIdPartida.contains(rand);
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
