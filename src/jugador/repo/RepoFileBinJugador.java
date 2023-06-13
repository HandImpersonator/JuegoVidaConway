/**

 Implementación de la interfaz IRepoJugador que utiliza archivos binarios para almacenar los datos de los jugadores.
 */
package jugador.repo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jugador.model.Jugador;
import partida.model.Partida;

/**
 * Implementación de la interfaz IRepoJugador que utiliza archivos binarios para almacenar los datos de los jugadores.
 */
public class RepoFileBinJugador implements IRepoJugador {
	private static final String DATA_FOLDER = "data";
	private List<Partida> partidas;
	/**
	 * Guarda un jugador en un archivo binario en la carpeta "data".
	 * El archivo se nombra "jugador_" seguido del ID del jugador y la extensión ".dat".
	 *
	 * @param jugador Jugador a guardar.
	 */
	@Override
	public void create(Jugador jugador) {
		Path folderPath = Paths.get(DATA_FOLDER);
		if (!Files.exists(folderPath)) {
			try {
				Files.createDirectories(folderPath);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}

		Path filePath = folderPath.resolve("jugador_" + jugador.getNumExpediente() + ".dat");
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath.toFile()))) {
			outputStream.writeObject(jugador);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga y devuelve todos los jugadores almacenados en los archivos binarios de la carpeta "data".
	 *
	 * @return Lista de jugadores almacenados.
	 */
	@Override
	public List<Partida> read(int id) {
		Jugador jugador = readJ(id);
		if (jugador != null) {
			return jugador.getPartidas();
		}
		return null;
	}

	/**
	 * Carga y devuelve un jugador almacenado en un archivo binario de la carpeta "data".
	 *
	 * @param id El identificador del jugador a cargar.
	 * @return Jugador almacenado.
	 */
	@Override
	public Jugador readJ(int id) {
		Path filePath = getFilePath(id);
		if (Files.exists(filePath)) {
			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath.toFile()))) {
				return (Jugador) inputStream.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Actualiza los datos de un jugador en el repositorio.
	 *
	 * @param jugador El jugador a actualizar.
	 * @return true si la actualización fue exitosa, false en caso contrario.
	 */
	@Override
	public boolean update(Jugador jugador) {
		Path filePath = getFilePath(jugador.getNumExpediente());
		if (Files.exists(filePath)) {
			try {
				Jugador existingJugador = readJ(jugador.getNumExpediente());
				if (existingJugador != null) {
					Files.deleteIfExists(filePath);
					create(jugador);
					return true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Busca el índice de una partida en la lista de partidas de un jugador.
	 *
	 * @param ps  La lista de partidas del jugador.
	 * @param idP El identificador de la partida a buscar.
	 * @return El índice de la partida en la lista, o -1 si no se encontró.
	 */
	@Override
	public int buscar(List<Partida> ps, int idP) {
		for (int i = 0; i < ps.size(); i++) {
			if (ps.get(i).getIdPartida() == idP) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Obtiene el tamaño de la lista de partidas de un jugador.
	 *
	 * @param jugador El jugador.
	 * @return El tamaño de la lista de partidas.
	 */
	@Override
	public int size(Jugador jugador) {
		return jugador.getPartidas().size();
	}

	/**
	 * Elimina una partida del repositorio de un jugador.
	 *
	 * @param jugador El jugador propietario de la partida.
	 * @param idP     El identificador de la partida a eliminar.
	 */
	@Override
	public void remove(Jugador jugador, int idP) {
		List<Partida> partidas = jugador.getPartidas();

		for (int i = 0; i < partidas.size(); i++) {
			Partida partida = partidas.get(i);
			if (partida.getIdPartida() == idP) {
				partidas.remove(i);
				update(jugador);
				break;
			}
		}
	}

	/**
	 * Elimina un jugador del repositorio.
	 *
	 * @param jugador El jugador a eliminar.
	 */
	@Override
	public void removeP(Jugador jugador) {
		Path filePath = getFilePath(jugador.getNumExpediente());
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve la ruta del archivo binario asociado a un jugador.
	 *
	 * @param idExp El identificador del jugador.
	 * @return La ruta del archivo binario.
	 */
	private Path getFilePath(int idExp) {
		String fileName = "jugador_" + idExp + ".dat";
		Path folderPath = Paths.get(DATA_FOLDER);
		return folderPath.resolve(fileName);
	}

}