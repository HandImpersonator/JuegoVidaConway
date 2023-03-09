package juego.repositorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import juego.model.Juego;
import jugador.model.Jugador;


public class FileUtilJuego {
	private final String separador = "#";
	private final String ruta = "data\\juegos.txt";
	public boolean save(List<Juego> juego) {
		FileWriter fichero = null; 
		try { 
			fichero = new FileWriter(ruta);
			for (int i=0; i < juego.size(); i++) {
				fichero.write(""+juego.get(i).getNombreJuego());
				fichero.write(separador);
				fichero.write(""+juego.get(i).getDimX());
				fichero.write(separador);
				fichero.write(""+juego.get(i).getDimY());
				fichero.write(separador);
				fichero.write(juego.get(i).getJugador().getNombre());
				fichero.write(separador);
				fichero.write(""+juego.get(i).getJugador().getNumExpediente());
				fichero.write("\n");
			} 
			fichero.close();
			return true;
		} 
		catch (IOException ex) {
			return false;
		}
	}
	public List<Juego> read(){
		List<Juego> datos = new Vector<>();
		File fichero = new File(ruta);
		try { 
			Scanner s = new Scanner(fichero);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				if(linea!= "") {
					linea.split(separador);
					String [] temporal = linea.split(separador);
					Jugador jugadortemp = new Jugador(temporal[3],new Integer(temporal[4]));
					datos.add(new Juego(new Integer(temporal[1]),new Integer(temporal[2]),jugadortemp,temporal[0]));
				}
			} 
		} catch (FileNotFoundException ex) { 
			datos = null;
		}
		return datos;

	}

}
