package partida.view;

import java.util.List;
import java.util.Scanner;

import jugador.model.Jugador;
import partida.model.Partida;
import partida.model.PartidaNormal;
import partida.model.PartidaPorDefecto;
import partida.repo.IRepoPartida;
import partida.repo.RepoFileBinPartida;


public class ViewCmdPartida {
    private IRepoPartida partidas;
    private Jugador jugadorUser = new Jugador("User", 69328543);

    public ViewCmdPartida() {
        partidas = new RepoFileBinPartida();
    }

    public void menu() {
        boolean sigue = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (sigue) {
                System.out.println("\nHola Jugador " + jugadorUser.getNombre() + ":");
                System.out.println("--------------------");
                System.out.println("1. Crear");
                System.out.println("2. Leer");
                System.out.println("3. Borrar");
                System.out.println("4. Salir");
                System.out.print("Escoge una opción: ");
                String opciones = scanner.next();
                switch (opciones) {
                    case "1":
                        System.out.println("--------------------");
                        System.out.println("1. Partida con reglas por defecto.");
                        System.out.println("2. Partida normal.");
                        System.out.print("Escoge una opción: ");
                        int opcion = scanner.nextInt();
                        System.out.println("--------------------");
                        if (opcion == 1) {
                            System.out.println("--------------------");
                            System.out.println("Introduce nombre de partida: ");
                            String nombre = scanner.next();
                            System.out.println("Introduce número de celdas vivas iniciales: ");
                            int numCeldasVivasInicio = scanner.nextInt();
                            Partida Partida = new PartidaPorDefecto(jugadorUser.getNumExpediente(), nombre, numCeldasVivasInicio);
                            partidas.create(Partida);
                        } else if (opcion == 2) {
                            System.out.println("--------------------");
                            System.out.println("Introduce nombre de partida: ");
                            String nombre = scanner.next();
                            System.out.println("Introduce número de celdas vivas iniciales: ");
                            int numCeldasVivasInicio = scanner.nextInt();
                            System.out.println("Introduce número de la regla 1: ");
                            int regla1 = scanner.nextInt();
                            System.out.println("Introduce número de la regla 2: ");
                            int regla2 = scanner.nextInt();
                            System.out.println("Introduce número de la regla 3: ");
                            int regla3 = scanner.nextInt();
                            Partida Partida = new PartidaNormal(jugadorUser.getNumExpediente(), nombre, numCeldasVivasInicio, regla1, regla2, regla3);
                            partidas.create(Partida);
                        }
                        break;
                    case "2":
                        List<Partida> p = partidas.read(jugadorUser.getNumExpediente());
                        try {
                            for (Partida element : p) {
                                System.out.println(element);
                            }
                        } catch (Exception e) {
                            System.out.println("No existen partidas para mostrar.\n");
                        }
                        break;
                    case "3":
                        System.out.println("Introduce tu numero de partida: ");
                        int idPartidaD = scanner.nextInt();
                        int partidaToDelete = partidas.buscar(jugadorUser.getNumExpediente(), idPartidaD);
                        if (partidaToDelete == -1) {
                            System.out.println("No se ha encontrado esta partida");
                        } else {
                            partidas.remove(jugadorUser.getNumExpediente(), partidaToDelete);
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
