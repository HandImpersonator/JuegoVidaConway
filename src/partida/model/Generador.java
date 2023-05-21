package partida.model;

import java.io.Serializable;
import java.util.Random;


public class Generador implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idPartida;
    
    public Generador(String nombrePartida) {
        this.idPartida = generateRandom(nombrePartida);
    }
    
    private int generateRandom(String nombre) {
        Random rand = new Random();
        int random = rand.nextInt(1000000);
        int intRandom = nombre.hashCode() + random;
        return intRandom;
    }
    
    public int toInt() {
        return idPartida;
    }
}