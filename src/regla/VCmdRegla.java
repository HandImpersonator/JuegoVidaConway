import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
//package regla.Reglas;

public class VCmdRegla {
	private RepoFileRegla repoReglas;
	public VCmdRegla() {
		repoReglas = new RepoFileRegla();
	}



	public void menuReglas() {
		System.out.println("¿Quieres cambiar las reglas del juego? Si (false), No (true) ");

		//read predeterminadas 


		Scanner scanner = new Scanner(System.in);
		boolean sigue = scanner.nextBoolean(); ;


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


				System.out.println("Ponle un nombre a tu configuración de reglas ");
				String nombredereglas  = scanner.next();
				System.out.println("¿Con cuantas celdas vivas alredeor permanece viva una celda? ");
				int nvivasvive = scanner.nextInt();
				System.out.println("¿A partir de cunatas celdas vivas alredeor muere una celda viva? ");
				int nvivasmuere = scanner.nextInt();
				System.out.println("¿Con cuantas celdas vivas se revive una celda muerta ? ");
				int nvivasrevive = scanner.nextInt();

				Regla regla = new Regla( nvivasrevive, nvivasmuere , nvivasvive,nombredereglas);
				repoReglas.create(regla);

				break;

			case "2":
				List<Regla> temp = repoReglas.read();
				temp.forEach(System.out::println);
				//				for(int i = 0;i<temp.size();i++) {
				//					System.out.println(temp.get(i));
				//				}
				break;

			case "3":
				System.out.println("Introduce el conjunto de reglas a modificar  ");
				//	int nvivasreviveToSearch = scanner.nextInt();
				//  int nvivasmuereToSearch = scanner.nextInt();
				//  int nvivasviveToSearch = scanner.nextInt();
				String reglasToSearch =scanner.next();
				int reglaPos = repoReglas.buscar(reglasToSearch);
				if ( reglaPos == -1) {
					System.out.println("No se ha encontrado este jugador");
				}
				else {
					System.out.println("Introduce tu nuevo nombre de reglas: ");
					String nombredereglasNew = scanner.next();
					System.out.println("Introduce tu nuevo número de celdas vivas : ");
					int nvivasNew = scanner.nextInt();
					System.out.println("Introduce tu nuevo número de celdas muertas : ");
					int nvivasmuereNew = scanner.nextInt();
					System.out.println("Introduce tu nuevo número de celdas reviven : ");
					int nvivasviveNew = scanner.nextInt();
					repoReglas.update(reglaPos, new Regla(nvivasNew,nvivasmuereNew,nvivasviveNew,nombredereglasNew ));


				}
				break;
			case "4":
				System.out.println("Introduce nombre de reglas ");
				String nombredereglasToDelete = scanner.next();
				int reglaToDelete = repoReglas.buscar(nombredereglasToDelete);
				if ( reglaToDelete ==-1) {
					System.out.println("No se ha encontrado ese nombre de reglas");
				}	
				else {
					repoReglas.remove(reglaToDelete);
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
		VCmdRegla view = new VCmdRegla();
		view.menuReglas();
	}
}
