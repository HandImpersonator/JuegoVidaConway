package jugador.repositorio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import jugador.model.Jugador;

public class FileUtil {
	private final String separador = "#";
	private final String ruta = "data\\jugador.txt";
	public boolean save(List<Jugador> j) {
		FileWriter fichero = null; 
		try { 
			fichero = new FileWriter(ruta);
			for (int i=0; i < j.size(); i++) {
				fichero.write(j.get(i).getNombre());
				fichero.write(separador);
				fichero.write(""+j.get(i).getNumExpediente());
				fichero.write("\n");
			} 
			fichero.close();
			return true;
		} 
		catch (IOException ex) {
			return false;
		}
	}
	public List<Jugador> read(){
		List<Jugador> datos = new Vector<>();
		File fichero = new File(ruta);
		try { 
			Scanner s = new Scanner(fichero);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				if(linea!= "") {
					linea.split(separador);
					String [] temporal = linea.split(separador);
					datos.add(new Jugador(temporal[0],new Integer(temporal[1])));
				}
			} 
		} catch (Exception ex) { 
			System.out.println("Mensaje: " + ex.getMessage());
		}
		return datos;

	}

}
