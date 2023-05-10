package juego.view;

import java.util.Arrays;
import java.util.Scanner;

import juego.model.Juego;
import juego.model.JuegoCuadPredefinido;
import juego.model.JuegoRectPredefinido;
import juego.repositorio.IRepoJuego;
import jugador.model.Jugador;

public class ViewCmdCreateJuego {
	private IRepoJuego juegos;
	private Scanner scanner;
	private String nombre;
	private int expediente;
	private String nombreJuego;
	public ViewCmdCreateJuego(IRepoJuego juegos, Scanner scanner) {
		this.juegos = juegos;
		this.scanner = scanner;
	}
	public void menu() {
		System.out.println("¿Quieres un juego predefinido o crear el tuyo propio?");
		System.out.println("1. Predefinido 2. Propio 3.Crear Matriz"); 
		int respuesta = scanner.nextInt();
		switch(respuesta) {

		case 1:
			System.out.println("1. Cuadrado  2. Rectangular");
			int respuestaForma = scanner.nextInt();
			if (respuestaForma == 1) {
				credencialesComunes();
				JuegoCuadPredefinido juegocuad = new JuegoCuadPredefinido(0,0,new Jugador(nombre,expediente),nombreJuego);
				System.out.println("1. 5x5  2. 10x10  3. 20x20");
				int respuestaCuad = scanner.nextInt();
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
			else if(respuestaForma ==2) {
				credencialesComunes();
				JuegoRectPredefinido juegorect = new JuegoRectPredefinido(0,0,new Jugador(nombre,expediente),nombreJuego);
				System.out.println("1. 10x5  2. 20x10  3. 30x15");
				int respuestaRect = scanner.nextInt();
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
			credencialesComunes();
			System.out.println("Introduce la dimensión del eje x que quieras: ");
			int dimX = scanner.nextInt();
			System.out.println("Introduce la dimensión del eje y que quieras: ");
			int dimY = scanner.nextInt();
			Juego juego = new Juego(dimX,dimY,new Jugador(nombre,expediente),nombreJuego);
			juegos.create(juego);
			break;
		case 3:
			credencialesComunes();
			ViewCmdCreateMatriz vccm = new ViewCmdCreateMatriz(juegos, scanner);
			juegos.create(new Juego(new Jugador(nombre, expediente), nombreJuego, vccm.menu()));
			break;
		}
		
	}
	
	private void credencialesComunes() {
		System.out.println("Introduce tu nombre: ");
		nombre = scanner.next();
		System.out.println("Introduce tu expediente: ");
		expediente = scanner.nextInt();
		System.out.println("Introduce eln nombre de tu juego: ");
		nombreJuego = scanner.next();
	}
	
	
}
