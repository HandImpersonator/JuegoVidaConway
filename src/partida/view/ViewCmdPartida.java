package partida.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import juego.model.Juego;
import reglas.model.Regla;
import partida.model.Partida;
import partida.repo.FileUtilPartida;
import partida.repo.RepoFilePartida;
import partida.repo.RepoMemoPartida;

public class ViewCmdPartida {
	private RepoMemoPartida partidas;
	//private RepoFilePartida partidas;
	
	public ViewCmdPartida() {
		partidas = new RepoMemoPartida();
		//partidas = new RepoFilePartida();
	}
	
	public void menu() {
		boolean sigue = true;
		try (Scanner scanner = new Scanner(System.in)) {
			while (sigue) {
				System.out.println("--------------------");
				System.out.println("1. Crear");
				System.out.println("2. Leer");
				System.out.println("3. Borrar");
				System.out.println("4. Salir");
				System.out.print("Escoge una opción: ");
				String opciones = scanner.next();
				System.out.println("--------------------");

				switch (opciones) {

				case "1":
					System.out.println("Introduce tu expediente: ");
					int idPartida = scanner.nextInt();
					System.out.println("Introduce número de celdas vivas iniciales: ");
					int numCeldasVivasInicio = scanner.nextInt();
					Juego juego = new Juego(5);
					Regla reglas = new Regla(2, 3);
					Partida Partida = new Partida(idPartida, numCeldasVivasInicio, juego, reglas);
					partidas.create(Partida);
					break;
				case "2":
					List<Partida> j = partidas.read();
					for (int i = 0; i < j.size(); i++) {
						System.out.println(j.get(i));
					}
					break;
				case "3":
					System.out.println("Introduce tu numero de partida: ");
					int expedienteToDelete = scanner.nextInt();
					int partidaToDelete = partidas.buscar(expedienteToDelete);
					if (partidaToDelete == -1) {
						System.out.println("No se ha encontrado esta partida");
					} else {
						partidas.remove(partidaToDelete);
						System.out.println("Se ha eliminado correctamente la partida.");
					}
					break;
				case "4":
					sigue = false;
					break;
				default: 
					System.out.println("Opción errónea");
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ViewCmdPartida view = new ViewCmdPartida();
		view.menu();
	}
}
