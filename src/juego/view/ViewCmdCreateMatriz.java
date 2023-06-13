package juego.view;

import java.util.Scanner;

import common.util.CmdUtil;
import jugador.model.Jugador;

public class ViewCmdCreateMatriz {
	private Scanner scanner;

	public ViewCmdCreateMatriz(Scanner scanner) {
		this.scanner = scanner;
	}

	public int[][] menu() {
		System.out.println("Introduce tu nombre: ");
		String nombre = scanner.next();
		System.out.println("Introduce tu expediente: ");
		int expediente = scanner.nextInt();
		Jugador jugador = new Jugador(expediente);
		System.out.println("Introduce eln nombre de tu juego: ");
		String nombreJuego = scanner.next();
		System.out.println("Introduce la altura de la matriz: ");
		int y = scanner.nextInt();
		System.out.println("Introduce la matriz");
		scanner.nextLine();
		CmdUtil util = new CmdUtil(scanner);
		try {
			int[] lineaArrayInt = util.meterLinea();
			int[][] array = new int[y][lineaArrayInt.length];
			array[0] = lineaArrayInt;
			int i = 1;
			while (i < y) {
				array[i] = util.meterLinea();
				i++;
			}
			return array;
		} catch (Exception e) {
			System.out.println("Error en los caracteres");
			return null;
		}

	}

}
