package gestisimal.utiles;

import java.io.IOException;

/**
 * <p>
 * Clase utilizada para la gestión de un menu. Se dedica a:
 * </p>
 * <ul>
 * <li>Mostrar las opciones del menu
 * <li>Recoger y devolver las opciones de un menu
 * </ul>
 * 
 * @author Francisco Javier Frías Serrano
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */
public class Menu {
	String titulo = null;
	String opciones[] = null;
	int numOpciones = 0;

	/**
	 * 
	 * @param titulo   título del menu
	 * @param opciones opciones del menu
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * Gestiona el menu. Consiste en mostrar las opcines y recoger la opcion
	 * seleccionada por el usuario
	 * 
	 * @return opcion valida del menu
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public int gestionar() throws NumberFormatException, IOException {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del menu
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("***" + titulo+"***");
		for (String elemento : opciones) {
			System.out.println("(" + (i++) + ") " + elemento);
		}
		System.out.print("Introduzca una opción: ");
	}

	/**
	 * Recoge la opcion valida del menu
	 * 
	 * @return opcion valida
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	private int recogerOpcion() throws NumberFormatException, IOException {
		int opcion;
  		do {
  			opcion = Teclado.leerEntero();
  		} while (opcion < 1 || opcion > numOpciones);
  		return opcion;
  	}
}

