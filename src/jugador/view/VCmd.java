package jugador.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import jugador.Jugador;

public class VCmd {
	private List<Jugador> jugadores;

	public VCmd() {
		jugadores = new Vector<Jugador>();
	}
	
	private int buscarJugador(int expediente) {
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getNumExpediente() == expediente) {
				return i;
			}
		}
		return 0;
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
				System.out.println("Introduce tu numero de expediente: ");
				int numExpediente = scanner.nextInt();
				/*
				 * En varias lineas.
				 * Jugador jugador = new Jugador(nombre, expediente);
				 * jugadores.add(jugador);
				 */
				// En una linea.
				jugadores.add(new Jugador(nombre, numExpediente));
				break;
			case "2":
				for (int i = 0; i < jugadores.size(); i++) {
					System.out.println(jugadores.get(i));
				}
				break;
			case "3":
				// set
				System.out.println("Introduce tu numero de expediente: ");
				int expedienteToEdit = scanner.nextInt();
				int posJugadorEdit = buscarJugador(expedienteToEdit);
				if (posJugadorEdit != 0) {
					System.out.println("Introduce tu nuevo nombre: ");
					String newNombre = scanner.next();
					System.out.println("Introduce tu nuevo numero de expediente: ");
					int newNumExpediente = scanner.nextInt();
					jugadores.get(posJugadorEdit).setNombre(newNombre);
					jugadores.get(posJugadorEdit).setNumExpediente(newNumExpediente);
				} else if (posJugadorEdit == 0) {
					System.out.println("Numero de expediente no encontrado, no se puede editar.");
				}
				break;
			case "4":
				System.out.println("Introduce tu numero de expediente: ");
				int expedienteToDelete = scanner.nextInt();
				int posJugadorDelete = buscarJugador(expedienteToDelete);
				if (posJugadorDelete != 0) {
					jugadores.remove(posJugadorDelete);
				} else if (posJugadorDelete == 0) {
					System.out.println("Numero de expediente no encontrado, no se puede borrar.");
				}
				break;
			case "5":
				break;
			default: 
				System.out.println("Opción errónea");
				break;
			}
		}
	}
}