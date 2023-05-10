package juego.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import juego.model.Juego;
import juego.model.JuegoCuadPredefinido;
import juego.model.JuegoRectPredefinido;
import juego.repositorio.IRepoJuego;
import juego.repositorio.RepoFileJuego;
import jugador.model.Jugador;

public class ViewCmdJuego {
	private IRepoJuego juegos;
	private Scanner scanner;
	public ViewCmdJuego() {
		juegos = new RepoFileJuego();
	}
	public void menu() {
		boolean salir = true;


		scanner = new Scanner(System.in);
		while (salir) {

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
				ViewCmdCreateJuego vccj = new ViewCmdCreateJuego(juegos, scanner);
				vccj.menu();
				break;
			case "2":
				List<Juego> games = juegos.read();
				for(int i = 0;i<juegos.size();i++) {
					System.out.println(games.get(i));
				}
				break;

			case "3":
				System.out.println("Introduce el nombre del juego : ");
				String juegoToSearch = scanner.next();
				int juegoPos = juegos.buscar(juegoToSearch);
				if ( juegoPos == -1) {
					System.out.println("No se ha encontrado este juego");
				}
				else {
					System.out.println("Introduce la dimension en x: ");
					int dimXNew = scanner.nextInt();
					System.out.println("Introduce la dimension en y: ");
					int dimYNew = scanner.nextInt();
					juegos.update(juegoPos, new Juego(dimXNew,dimYNew,juegos.read().get(juegoPos).getJugador(),juegos.read().get(juegoPos).getNombreJuego()));
				}
				break;


			case "4":
				System.out.println("Introduce el nombre del juego: ");
				String nombreJuegoToDelete = scanner.next();
				int juegoToDelete = juegos.buscar(nombreJuegoToDelete);
				if ( juegoToDelete == -1) {
					System.out.println("No se ha encontrado este jugador");
				}
				else {
					juegos.remove(juegoToDelete);
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
		ViewCmdJuego view = new ViewCmdJuego();
		view.menu();
	}

}
