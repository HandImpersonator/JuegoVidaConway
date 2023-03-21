import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

	
public class FileUtilRegla {


	
	    private final String separador = "#";
	    private final String ruta = "data/reglascustomizadas.txt";
	    public boolean save(List<Regla> j) {
	        FileWriter fichero = null; 
	        try { 
	            fichero = new FileWriter(ruta);
	            for (int i=0; i < j.size(); i++) {
	                fichero.write(j.get(i).getNvivasmuere());
	                fichero.write(separador);
	                fichero.write(j.get(i).getNvivasvive());
	                fichero.write(separador);
	                fichero.write(j.get(i).getNvivasrevive());
	                fichero.write("\n");
	            } 
	            fichero.close();
	            return true;
	        } 
	        catch (IOException ex) {
	            return false;
	        }
	    }
	    public List<Regla> read(){
	        List<Regla> datos = new Vector<>();
	        File fichero = new File(ruta);
	        try { 
	            Scanner s = new Scanner(fichero);
	            while (s.hasNextLine()) {
	                String linea = s.nextLine();
	                if(linea!= "") {
	                    linea.split(separador);
	                    String [] temporal = linea.split(separador);
	                    datos.add(new Regla(new Integer(temporal[0]),new Integer( temporal[1]),new Integer(temporal[2]),temporal[3]));
	                }
	            } 
	        } catch (Exception ex) { 
	            System.out.println("Mensaje: " + ex.getMessage());
	        }
	        return datos;

	    }

	}

