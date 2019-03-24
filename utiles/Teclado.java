package gestisimal.utiles;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Permite lectura desde teclado
 * 
 * @author Francisco Javier Frías Serrano
 * @version 1.0
 */
public class Teclado {

	static Scanner entrada = new Scanner(System.in);

	/**
	 * Lee un carácter del teclado
	 * 
	 * @return carácter introducido por el usuario
	 * @throws IOException
	 */
	public static char leerCaracter() throws IOException {
		char caracter;
		try {
			caracter = leerCadena().charAt(0);
		} catch (InputMismatchException e) {
			caracter = 0;
		}
		return caracter;
	}

	/**
	 * Lee un carácter del teclado
	 * 
	 * @param mensaje mensaje mostrado al usuario
	 * @return carácter introducido por el usuario
	 * @throws IOException
	 */
	public static char leerCaracter(String mensaje) throws IOException {
		System.out.println(mensaje);
		return leerCaracter();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @param mensaje mensaje mostrado al usuario
	 * @return cadena introducida por el usuario
	 * @throws IOException
	 */
	public static String leerCadena(String mensaje) throws IOException {
		System.out.println(mensaje);
		return leerCadena();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @return cadena introducida por el usuario
	 * @throws IOException
	 */

	public static String leerCadena() throws IOException {

		String cadena;

		try {
			cadena = entrada.nextLine(); // Lee una linea de texto (hasta intro)
		} catch (InputMismatchException e) {
			cadena = "";
		}
		return cadena;
	}

	/**
	 * Lee un entero del teclado
	 * 
	 * @return entero introducido por el usuario
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static int leerEntero() throws NumberFormatException, IOException {
		int x;
		try {
			x = Integer.parseInt(leerCadena().trim()); 
		} catch (InputMismatchException e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee una entero del teclado
	 * 
	 * @param mensaje mensaje mostrado al usuario
	 * @return entero introducida por el usuario
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static int leerEntero(String mensaje) throws NumberFormatException, IOException {
		System.out.println(mensaje);
		return leerEntero();
	}

	/**
	 * Lee un decimal del teclado
	 * 
	 * @return decimal introducido por el usuario
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static double leerDecimal() throws NumberFormatException, IOException {
		double x;
		try {
			x = Double.parseDouble(leerCadena().trim()); 
		} catch (InputMismatchException e) {
			x = 0;
		}
		return x;
	}

	/**
	 * Lee una decimal del teclado
	 * 
	 * @param mensaje mensaje mostrado al usuario
	 * @return decimal introducida por el usuario
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static double leerDecimal(String mensaje) throws NumberFormatException, IOException {
		System.out.println(mensaje);
		return leerDecimal();
	}

}
