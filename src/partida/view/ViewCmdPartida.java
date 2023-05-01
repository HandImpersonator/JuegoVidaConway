package partida.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;hhhhhhhhhhhhhhhhhhhhhhhh

import partida.model.Partida;
import partida.repo.IRepoPartida;
import partida.repo.RepoFileBinPartida;
import regla.model.Regla;


public class ViewCmdPartida {
    private IRepoPartida partidas;
    List<Integer> listaId = new ArrayList<Integer>();

    public ViewCmdPartida() {
        partidas = new RepoFileBinPartida();
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
                        System.out.println("Introduce número de celdas vivas iniciales: ");
                        int numCeldasVivasInicio = scanner.nextInt();
                        int idPartida = partida.model.Partida.generateRandom(listaId);
                        Regla reglas = new Regla(2, 3, 1);
                        Partida Partida = new Partida(idPartida, numCeldasVivasInicio, reglas);
                        partidas.create(Partida);
                        break;
                    case "2":
                        List<Partida> p = partidas.read();
                        for (partida.model.Partida element : p) {
                            System.out.println(element);
                        }
                        break;
                    case "3":
                        System.out.println("Introduce tu numero de partida: ");
                        int idPartidaD = scanner.nextInt();
                        int partidaToDelete = partidas.buscar(idPartidaD);
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
