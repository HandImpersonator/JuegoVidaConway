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
	public ViewCmdJuego() {
		juegos = new RepoFileJuego();
	}
	public void menu() {
		boolean salir = true;


		Scanner scanner = new Scanner(System.in);
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
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("¿Quieres un juego predefinido o crear el tuyo propio?");
				System.out.println("1. Predefinido 2. Propio"); 
				int respuesta = scanner2.nextInt();
				switch(respuesta) {

				case 1:
					System.out.println("1. Cuadrado  2. Rectangular");
					int respuesta2 = scanner2.nextInt();
					if (respuesta2 == 1) {
						System.out.println("Introduce tu nombre: ");
						String nombre = scanner.next();
						System.out.println("Introduce tu expediente: ");
						int expediente = scanner.nextInt();
						System.out.println("Introduce eln nombre de tu juego: ");
						String nombreJuego = scanner.next();
						JuegoCuadPredefinido juegocuad = new JuegoCuadPredefinido(0,0,new Jugador(nombre,expediente),nombreJuego);
						System.out.println("1. 5x5  2. 10x10  3. 20x20");
						int respuestaCuad = scanner2.nextInt();
						switch(respuestaCuad) {
						case 1:
							juegocuad.setJuego5();
							juegos.create(juegocuad);
							break;
						case 2:
							juegocuad.setJuego10();
							juegos.create(juegocuad);
							break;
						case 3:
							juegocuad.setJuego20();
							juegos.create(juegocuad);
							break;
						}
					}
					else if(respuesta2 ==2) {
						System.out.println("Introduce tu nombre: ");
						String nombre = scanner.next();
						System.out.println("Introduce tu expediente: ");
						int expediente = scanner.nextInt();
						System.out.println("Introduce eln nombre de tu juego: ");
						String nombreJuego = scanner.next();
						JuegoRectPredefinido juegorect = new JuegoRectPredefinido(0,0,new Jugador(nombre,expediente),nombreJuego);
						System.out.println("1. 10x5  2. 20x10  3. 30x15");
						int respuestaRect = scanner2.nextInt();
						switch(respuestaRect) {
						case 1:
							juegorect.setJuego10x5();
							juegos.create(juegorect);
							break;
						case 2:
							juegorect.setJuego20x10();
							juegos.create(juegorect);
							break;
						case 3:
							juegorect.setJuego30x15();
							juegos.create(juegorect);
							break;
						}
					}
					else {
						System.out.println("Respuesta erronea");
					}
					break;
					default:
						System.out.println("Respuesta erronea");
				case 2:
					System.out.println("Introduce tu nombre: ");
					String nombre = scanner.next();
					System.out.println("Introduce tu expediente: ");
					int expediente = scanner.nextInt();
					System.out.println("Introduce eln nombre de tu juego: ");
					String nombreJuego = scanner.next();
					System.out.println("Introduce la dimensión del eje x que quieras: ");
					int dimX = scanner.nextInt();
					System.out.println("Introduce la dimensión del eje y que quieras: ");
					int dimY = scanner.nextInt();
					Juego juego = new Juego(dimX,dimY,new Jugador(nombre,expediente),nombreJuego);
					juegos.create(juego);
					break;
				}
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
				System.out.println("Introduce el nombre del : ");
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
