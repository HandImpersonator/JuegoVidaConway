/**
 * Clase de vista para la partida.
 * Esta clase proporciona métodos para mostrar el menú principal de la partida y establecer la vista de la partida.
 * También contiene el punto de entrada del programa.
 * El repositorio de partidas utilizado es RepoFileBinPartida.
 * El jugador por defecto es "User" con un número de expediente de 69328543.
 *
 * @author User
 */

package partida.view;

import jugador.model.Jugador;
import partida.repo.RepoFileBinPartida;

import javax.swing.*;

public class ViewCmdPartida {
    private final RepoFileBinPartida partidas;
    private final Jugador jugadorUser = new Jugador("User", 69328543);
    private ViewWindowPartida viewWindowPartida;

    /**
     * Crea una instancia de ViewCmdPartida y inicializa el repositorio de partidas.
     */
    public ViewCmdPartida() {
        partidas = new RepoFileBinPartida();
    }

    /**
     * Establece la vista de la partida.
     *
     * @param viewWindowPartida La vista de la partida
     */
    public void setViewWindowPartida(ViewWindowPartida viewWindowPartida) {
        this.viewWindowPartida = viewWindowPartida;
    }

    /**
     * Muestra el menú principal de la partida.
     */
    public void menu() {
        String wel = "\nHola Jugador " + jugadorUser.getNombre() + ":";
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                viewWindowPartida = new ViewWindowPartida(wel, jugadorUser.getNumExpediente(), partidas);
                viewWindowPartida.setVisible(true);
            }
        });
    }

    /**
     * Punto de entrada del programa.
     *
     * @param args Los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        ViewCmdPartida view = new ViewCmdPartida();

        ViewWindowPartida window = new ViewWindowPartida("", 0, null);

        view.setViewWindowPartida(window);
        view.menu();
    }
}
