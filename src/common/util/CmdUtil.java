package common.util;

import java.util.Arrays;
import java.util.Scanner;

public class CmdUtil {
	private final Scanner scanner;
	public CmdUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public int[] meterLinea() throws Exception{
		String linea = scanner.nextLine();
		String[] lineaArray = linea.split(" ");
		return  Arrays.stream(lineaArray).mapToInt(Integer::parseInt).toArray();
	}
	
	public String imprimirArray(int[][] array) {
		String resultado = "";
		for(int i = 0; i < array.length; i++) {
			resultado += Arrays.toString(array[i]) + "\n";
		}
		return resultado;
	}
	
}
