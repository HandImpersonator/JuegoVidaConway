import jugador.view.ViewWindowLoginJugador;

/**
 * Clase principal que contiene el método de inicio del programa.
 * Se encarga de crear una instancia de la ventana de inicio de sesión del jugador y mostrarla.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     * Crea una instancia de la ventana de inicio de sesión del jugador y la hace visible.
     *
     * @param args los argumentos de línea de comandos (no se utilizan en este caso)
     */
    public static void main(String[] args) {
        ViewWindowLoginJugador view = new ViewWindowLoginJugador();
        view.setVisible(true);
    }
}
