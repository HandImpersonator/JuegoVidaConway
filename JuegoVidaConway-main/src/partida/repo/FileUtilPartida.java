package partida.repo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import partida.model.Partida;

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
				fichero.write(p.get(i).getNumCeldasVivasInicio());
				fichero.write(separador);
				fichero.write(p.get(i).getNumCeldasVivasFinal());
				fichero.write(separador);
				fichero.write(p.get(i).getNumCeldasMuertas());
				fichero.write(separador);
				fichero.write(p.get(i).getRonda());
				fichero.write(separador);
				fichero.write("\n");
			}
			fichero.close();
			return true;
		} 
		catch (IOException ex) {
			return false;
		}
	}
}
