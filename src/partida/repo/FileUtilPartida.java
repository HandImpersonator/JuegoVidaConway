/**
 * Clase de utilidad para guardar y leer partidas desde un archivo.
 * Esta clase está marcada como obsoleta (deprecated) y se recomienda su reemplazo por implementaciones más específicas.
 * Esta clase utiliza un formato de archivo específico para guardar y leer las partidas.
 * El archivo de partida tiene una estructura de líneas separadas por un carácter especial "#".
 * Cada línea contiene los datos de una partida, en el siguiente orden:
 * ID de partida
 * Número de celdas muertas
 * Reglas de la partida (ID de regla, regla 1, regla 2, regla 3, tipo de regla)
 * El archivo de partida se encuentra en la ruta "data/partida.txt".
 * @deprecated Esta clase está marcada como obsoleta y se recomienda su reemplazo por implementaciones más específicas.
 *
 * @author User
 */

package partida.repo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import partida.model.Partida;
import regla.model.Regla;


@Deprecated
public class FileUtilPartida {
    private final String separador = "#";
    private final String ruta = "data\\partida.txt";

    /**
     * Guarda la lista de partidas en un archivo.
     *
     * @param p La lista de partidas a guardar.
     * @return true si la operación de guardado fue exitosa, false de lo contrario.
     */
    public boolean save(List<Partida> p) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(ruta);
            for (int i = 0; i < p.size(); i++) {
                fichero.write(p.get(i).getIdPartida());
                fichero.write(separador);
                fichero.write("\n");
            }
            fichero.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Lee las partidas almacenadas en el archivo y las devuelve como una lista.
     *
     * @return Una lista de partidas leídas desde el archivo.
     * @deprecated Esta operación está marcada como obsoleta y se recomienda utilizar implementaciones más específicas de repositorio de partidas.
     */
    @Deprecated
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
                    /*datos.add(new Partida(new Integer(temporal[0]), new Integer(temporal[1]), new Integer(temporal[2]),
                            new Regla(new Integer(temporal[3]), new Integer(temporal[4]), new Integer(temporal[5]),
                                    temporal[6])));*/
                }
            }
            s.close();
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return datos;
    }

}
