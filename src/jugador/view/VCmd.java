package jugador.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import jugador.Jugador;

public class VCmd {
	private List<Jugador>jugadores;

	public VCmd() {
		jugadores = new Vector<Jugador>();
	}
	private int buscarJugador(int expediente) {
		for(int i = 0;i<jugadores.size();i++) {
			if(jugadores.get(i).equals(new Jugador("",expediente))) {
				return i;
			}
		}
		return -1;
	}

	public void menu() {
		boolean sigue = true;
		Scanner scanner = new Scanner(System.in);
		while (sigue) {
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
				String nombre = scanner.next();
				System.out.println("Introduce tu expediente: ");
				int expediente = scanner.nextInt();
				Jugador jugador = new Jugador(nombre,expediente);
				jugadores.add(jugador);
				break;
			case "2":
				for(int i = 0;i<jugadores.size();i++) {
					System.out.println(jugadores.get(i));
				}
				break;
			case "3":
				System.out.println("Introduce tu expediente: ");
				int expedienteToSearch = scanner.nextInt();
				int jugadorToSearch = buscarJugador(expedienteToSearch);
				if ( jugadorToSearch == -1) {
					System.out.println("No se ha encontrado este jugador");
				}
				else {
					System.out.println("Introduce tu nombre: ");
					String nombreNew = scanner.next();
					System.out.println("Introduce tu expediente: ");
					int expedienteNew = scanner.nextInt();
					jugadores.set(jugadorToSearch, new Jugador(nombreNew,expedienteNew));
				}
				break;
			case "4":
				System.out.println("Introduce tu expediente: ");
				int expedienteToDelete = scanner.nextInt();
				int jugadorToDelete = buscarJugador(expedienteToDelete);
				if ( jugadorToDelete == -1) {
					System.out.println("No se ha encontrado este jugador");
				}
				else {
					jugadores.remove(jugadorToDelete);
					System.out.println("Se ha eliminado correctamente");
				}
				break;
			case "5":
				sigue = false;
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
