package juego;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import juego.Juego;
import jugador.repositorio.RepoFile;
import jugador.repositorio.RepoMemo;

public class ViewCmdJuego {
	private List<Juego> juegos;
	private RepoFileJuego juego;
	public ViewCmdJuego() {
		juego = new RepoFileJuego();
	}
	

public void menu() {
	boolean salir = false;

	
	Scanner scanner = new Scanner(System.in);
	while (!salir) {

	System.out.println("--------------------");
	System.out.println("1. Crear");
	System.out.println("2. Leer");
	System.out.println("3. Actualizar");
	System.out.println("4. Borrar");
	System.out.println("5. Salir");
	System.out.print("Escoge una opción: ");
	String opciones  = scanner.next();
	System.out.println("--------------------");

	switch (opciones) {


case "1":

	System.out.println("Introduce tu nombre: ");
	int dimX = scanner.nextInt();
	System.out.println("Introduce tu expediente: ");
	int dimY = scanner.nextInt();
	Juego juego = new Juego(dimX,dimY);
	juegos.add(juego);
	break;

case "2":

	for(int i = 0;i<juego.size();i++) {
		System.out.println(juego.get(i));
	}
	break;

case "3":
	System.out.println("Introduce tu expediente: ");
	int expedienteToSearch = scanner.nextInt();
	int juegoToSearch = buscarJuego(expedienteToSearch);
	if ( juegoToSearch == -1) {
		System.out.println("No se ha encontrado este jugador");
	}


	else {
		System.out.println("Introduce tu nombre: ");
		String nombreNew = scanner.next();
		System.out.println("Introduce tu expediente: ");
		int expedienteNew = scanner.nextInt();
		juego.set(juegoToSearch, new Juego(nombreNew,expedienteNew));
	}
	break;


case "4":
	System.out.println("Introduce tu expediente: ");
	int expedienteToDelete = scanner.nextInt();
	int juegoToDelete = buscarJuego(expedienteToDelete);
	if ( juegoToDelete == -1) {
		System.out.println("No se ha encontrado este jugador");
	}
	else {
		juego.remove(juegoToDelete);
		System.out.println("Se ha eliminado correctamente");
	}
	break;

case "5":
	salir = false;
	break;
default: 
	System.out.println("Opción errónea");
	break;
	
	
	


}

}

}
public static void main(String[] args) {
	VCmd view = new VCmd();
	view.menu();
}

}
