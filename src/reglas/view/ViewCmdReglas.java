package reglas.view;

import java.util.List;
import java.util.Scanner;
import jugador.model.Jugador;
import jugador.repo.RepoFileJugador;
import reglas.model.Regla;
import reglas.repo.RepoFileReglas;

public class ViewCmdReglas {
	private  RepoFileReglas reglas;
	public ViewCmdReglas() {
		reglas = new RepoFileReglas();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Quieres cambiar las reglas?");
		System.out.println("Introduce un 1 si es que sí o un 2 si es que no");
		int numero = scanner.nextInt();
		switch (numero) {
			case 1:
				System.out.println("¿Que quieres hacer?");
				System.out.println("1. Crear nuevas reglas");
				System.out.println("2. Leer las reglas");
				System.out.println("3. Actualizar las reglas");
				System.out.println("4. Eliminar las reglas");
				int regla = scanner.nextInt();
				switch(regla) {
					case 1:
						System.out.println("¿Cuantas celdas vivas son necesarias para revivir a una muerta?");
						int celdasVivasAlrededor = scanner.nextInt();
						System.out.println("¿Cuantas celdas muertas son necesarias para matar a una viva?");
						int celdasMuertasAlrededor = scanner.nextInt();
						Regla regla1 = new Regla(celdasVivasAlrededor, celdasMuertasAlrededor);
						reglas.create(regla1);
						break;
					case 2:
						List<Regla> r = reglas.read();
						for(int i = 0; i < r.size(); i++) {
							System.out.println(r.get(i));
						}
						break;
					case 3: 
						break;
					case 4:
						break;
				}
				break;
			case 2: 
				System.out.println("Las reglas del juego son las siguientes:");
				System.out.println("Si una célula está viva y tiene dos o tres vecinas vivas, sobrevive");
				System.out.println("Si una célula está muerta y tiene tres vecinas vivas, nace");
				System.out.println("Si una célula está viva y tiene más de tres vecinas muertas, muere");
				break;
		}
	}
}