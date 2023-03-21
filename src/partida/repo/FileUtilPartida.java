package partida.repo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import partida.model.Partida;
import regla.model.Regla;


public class FileUtilPartida {
    private final String separador = "#";
    private final String ruta = "data\\partida.txt";

    public boolean save(List<Partida> p) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(ruta);
            for (int i = 0; i < p.size(); i++) {
                fichero.write(p.get(i).getIdPartida());
                fichero.write(separador);
                fichero.write("" + p.get(i).getNumCeldasMuertas());
                fichero.write("\n");
            }
            fichero.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public List<Partida> read() {
        List<Partida> datos = new Vector<>();
        File fichero = new File(ruta);
        try {
            Scanner s = new Scanner(fichero);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                if (linea != "") {
                    linea.split(separador);
                    String[] temporal = linea.split(separador);
                    datos.add(new Partida(new Integer(temporal[0]), new Integer(temporal[1]),
                            new Regla(new Integer(temporal[2]), new Integer(temporal[3]), new Integer(temporal[4]),
                                    temporal[5])));
                }
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return datos;
    }
}
