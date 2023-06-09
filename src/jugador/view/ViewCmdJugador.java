package jugador.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import jugador.model.Jugador;
import jugador.model.JugadorNoRegistrado;
import jugador.model.JugadorRegistrado;
import jugador.repo.FileUtilJugador;
import jugador.repo.IRepoJugador;
import jugador.repo.RepoFileBinJugador;
import jugador.repo.RepoFileJugador;
import jugador.repo.RepoMemoJugador;

public class ViewCmdJugador {
	private IRepoJugador jugadores;
	private Scanner scanner;
	public ViewCmdJugador() {
		jugadores = new RepoFileBinJugador();
	}

	public void menu() {
		boolean sigue = true;
		scanner = new Scanner(System.in);
		while (sigue) {
			System.out.println("--------------------");
			System.out.println("1. Crear");
			System.out.println("2. Leer");
			System.out.println("3. Actualizar");
			System.out.println("4. Borrar");
			System.out.println("5. Añadir partida");
			System.out.println("6. Salir");
			System.out.print("Escoge una opción: ");
			String opciones = scanner.next();
			System.out.println("--------------------");

			switch (opciones) {

			case "1":
				menuCrear();
				break;
			case "2":
				List<Jugador> j = jugadores.read();
				for (int i = 0; i < j.size(); i++) {
					System.out.println(j.get(i));
				}
				break;
			case "3":
				System.out.println("Introduce tu expediente: ");
				int expedienteToSearch = scanner.nextInt();
				int jugadorToSearch = jugadores.buscar(expedienteToSearch);
				if (jugadorToSearch == -1) {
					System.out.println("No se ha encontrado este jugador");
				} else {
					System.out.println("Introduce tu nombre: ");
					String nombreNew = scanner.next();
					System.out.println("Introduce tu expediente: ");
					int expedienteNew = scanner.nextInt();
					Jugador jugTemp = jugadores.read().get(jugadorToSearch);
					jugTemp.setNombre(nombreNew);
					jugTemp.setNumExpediente(expedienteNew);
					jugadores.update(jugadorToSearch,jugTemp);
				}
				break;
			case "4":
				System.out.println("Introduce tu expediente: ");
				int expedienteToDelete = scanner.nextInt();
				int jugadorToDelete = jugadores.buscar(expedienteToDelete);
				if (jugadorToDelete == -1) {
					System.out.println("No se ha encontrado este jugador");
				} else {
					jugadores.remove(jugadorToDelete);
					System.out.println("Se ha eliminado correctamente");
				}
				break;
			case "5":
				menuPartida();
				break;
			case "6":
				sigue = false;
				break;
			default: 
				System.out.println("Opción errónea");
				break;
			}
		}
	}
	public void menuCrear(){
		System.out.println("1: Registrado, Otro: No registrado");
		String registrado = scanner.next();
		System.out.println("Introduce tu nombre: ");
		String nombre = scanner.next();
		System.out.println("Introduce tu expediente: ");
		int expediente = scanner.nextInt();
		Jugador jugador;
		if (registrado.equals("1")) {
			jugador = new JugadorRegistrado(nombre,expediente);
		}
		else {
			jugador = new JugadorNoRegistrado(nombre,expediente);
		}
		jugadores.create(jugador);
	}
	public void menuPartida() {
		System.out.println("Introduce tu expediente: ");
		int exp = scanner.nextInt();
		int j = jugadores.buscar(exp);
		if (j == -1) {
			System.out.println("No se ha encontrado este jugador");
		} else {
			Jugador jugTemp = jugadores.read().get(j);
			boolean b = jugTemp.addPartida("Partida");
			jugadores.update(j,jugTemp);
//			if (b) 
//				System.out.println("Partida agregada correctamente");
//			else 
//				System.out.println("No se ha agregado la partida"); 
			String res=(b)?"Partida agregada correctamente":"No se ha agregado la partida";
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		ViewCmdJugador view = new ViewCmdJugador();
		view.menu();
	}
}