package juego.view;

import java.util.Arrays;
import java.util.Scanner;

import common.util.CmdUtil;
import juego.model.JuegoCuadPredefinido;
import juego.repositorio.IRepoJuego;
import jugador.model.Jugador;

public class ViewCmdCreateMatriz {
	private IRepoJuego juegos;
	private Scanner scanner;

	public ViewCmdCreateMatriz(IRepoJuego juegos, Scanner scanner) {
		this.juegos = juegos;
		this.scanner = scanner;
	}

	public int[][] menu() {
		System.out.println("Introduce tu nombre: ");
		String nombre = scanner.next();
		System.out.println("Introduce tu expediente: ");
		int expediente = scanner.nextInt();
		Jugador jugador = new Jugador(nombre, expediente);
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
