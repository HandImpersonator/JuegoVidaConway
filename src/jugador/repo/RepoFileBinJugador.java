package jugador.repo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import common.util.FileUtil;
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
	 * Borra un jugador y su archivo asociado en la carpeta "data".
	 * El archivo se nombra "jugador_" seguido del ID del jugador y la extensión ".dat".
	 *
	 * @param id ID del jugador a borrar.
	 */
	@Override
	public void remove(int id) {
		Path filePath = getFilePath(id);
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Path getFilePath(int idExp) {
		String fileName = "jugador_" + String.valueOf(idExp) + ".dat";
		Path folderPath = Paths.get(DATA_FOLDER);
		return folderPath.resolve(fileName);
	}
}
