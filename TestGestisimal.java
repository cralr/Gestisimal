package gestisimal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import gestisimal.almacen.Almacen;
import gestisimal.almacen.Articulo;
import gestisimal.almacen.exceptions.ArticuloNoExisteException;
import gestisimal.almacen.exceptions.CantidadNegativaException;
import gestisimal.almacen.exceptions.CodigoNoValidoException;
import gestisimal.almacen.exceptions.StockNegativoException;
import gestisimal.utiles.Menu;
import gestisimal.utiles.Teclado;
import gestisimal.almacen.exceptions.PrecioCompraNegativoException;
import gestisimal.almacen.exceptions.PrecioVentaNegativoException;

/**
 * Se comunica con el usuario (E/S de datos por consola) Comprueba si existe o
 * no el artículo en el almacén Comprueba que el stock no sea negativo en el
 * almacén Comprueba que el articulo exista para borrarlo del almacén.
 * 
 * Test para comprobar la clase Gestisimal.
 * 
 * @author Rafael Miguel Cruz Álvarez
 * @author Fco Javier Frías Serrano
 * @version 1.0
 */

public class TestGestisimal {
  static Almacen almacen = new Almacen();
  static Scanner entrada = new Scanner(System.in);
  private static Menu menu = new Menu("----MENÚ GESTISIMAL----", new String[] {"Listado", "Alta", "Baja",
      "Modificación", "Entada de mercancía","Salida de mercancía", "Salir" });

  public static void main(String[] args) throws Exception {

    int opcion;

    //almacenDePrueba();
    do {
      switch ((menu.gestionar())) {
      case 1:
        System.out.println(almacen.toString());
        break;
      case 2:
        annadir();
        break;
      case 3:
        baja();
        break;
      case 4:
        modificar();
        break;
      case 5:
        entradaAlmacen();
        break;
      case 6:
        salidaAlmacen();
        break;
       default:
         System.out.println("Adios");
         return;
      }
    } while (true);
  }

 
//  private static void almacenDePrueba() {
//    try {
//      almacen.annadir("1", 11, 11, 11);
//      almacen.annadir("1", 22, 22, 22);
//      almacen.annadir("33", 11, 11, 33);
//      almacen.annadir("44", 11, 11, 44);
//      almacen.annadir("55", 11, 11, 55);
//    } catch (Exception e) {
//      System.out.println("ESTO NO DEBE APARECERRRRRRRRRRRRRRRRR");
//    }
//  }
 

  /**
   * Método añadir en el que se le pedirá al usuario los datos del artículo.
   * 
   * @throws Exception
   */

  private static void annadir() throws Exception {

    try {
      System.out.println("--AÑADIR ARTÍCULO--");
      String descripcion=Teclado.leerCadena("Introduzca la descripción del artículo:");
      double precioCompra=Teclado.leerDecimal("Introduzca el precio de compra del artículo:");
      double precioVenta=Teclado.leerDecimal("Introduzca el precio de venta del artículo:");
      int stock=Teclado.leerEntero("Introduzca el stock del artículo:");

      almacen.annadir(descripcion, precioCompra, precioVenta, stock); // Con almacen.annadir usamos el metodo creado en
                                                                      // Almacen.
      System.out.println("Artículo añadido.");
    } catch (Exception e) {
      System.err.println("No se ha podido dar de alta al artículo. " + e.getMessage());// Si hay un error salta la
                                                                                       // excepción.
      entrada.nextLine();
    }
  }

  /**
   * Método para dar de baja un artículo de la lista.
   * 
   * @throws CodigoNoValidoException
   * @throws IOException 
   * @throws NumberFormatException 
   */
  private static void baja() throws CodigoNoValidoException, NumberFormatException, IOException {
    int codigo= Teclado.leerEntero("Introduce el códido del artículo a eliminar.");

    if (almacen.baja(codigo))
      System.out.println("Artículo eliminado.");
    else
      System.err.println("El artículo no se ha podido eliminar. No existe un artículo con ese código en el almacen.");
  }

  /**
   * Método para modificar los atributos de un artículo.
   * 
   * @throws StockNegativoException
   * @throws PrecioCompraNegativoException
   * @throws PrecioVentaNegativoException
   * @throws IOException 
   * @throws NumberFormatException 
   */
  private static void modificar()
      throws StockNegativoException, PrecioCompraNegativoException, PrecioVentaNegativoException, NumberFormatException, IOException {

    try {
      System.out.println("--MODIFICAR ARTÍCULO--");
      int codigo= Teclado.leerEntero("Introduce el códido del artículo a eliminar.");
      Articulo articulo = almacen.get(codigo);
      System.out.println(articulo);

      String descripcion=Teclado.leerCadena("Introduzca la descripción del artículo:");
      double precioCompra=Teclado.leerDecimal("Introduzca el precio de compra del artículo:");
      double precioVenta=Teclado.leerDecimal("Introduzca el precio de venta del artículo:");
      int stock=Teclado.leerEntero("Introduzca el stock del artículo:");


      almacen.set(articulo, descripcion, precioCompra, precioVenta, stock);
    } catch (ArticuloNoExisteException e) {
      System.err.println("No se ha podido modificar el artículo." + e.getMessage());
    }

  }

  /**
   * Método para aumentar el stock de un artículo.
   * 
   * @throws StockNegativoException
   * @throws CantidadNegativaException
   */
  private static void entradaAlmacen() {
    try {
      System.out.println("--INCREMENTAR STOCK--");
      int codigo= Teclado.leerEntero("Introduce el códido del artículo a eliminar.");
      Articulo articulo = almacen.get(codigo);
      System.out.println(articulo);

      int cantidad = Teclado.leerEntero("Introduzca el número de artículos a aumentar del stock del almacen.");
      almacen.incrementar(codigo, cantidad);
    } catch (Exception e) {
      System.err.println("No se ha podido decrementar el stock del artículo." + e.getMessage()+"\n");
    }
  }

  /**
   * Método para disminuir el stock de un artículo, este no puede ser negativo.
   * 
   * @throws StockNegativoException
   * @throws CantidadNegativaException
   */
  private static void salidaAlmacen() {
    try {
      System.out.println("--DECREMENTAR STOCK--");
      int codigo= Teclado.leerEntero("Introduce el códido del artículo a eliminar.");
      Articulo articulo = almacen.get(codigo);
      System.out.println(articulo);

      int cantidad = Teclado.leerEntero("Introduzca el número de artículos a eliminar del stock del almacen.");
      almacen.decrementar(codigo, cantidad);
    } catch (Exception e) {
      System.err.println("No se ha podido decrementar el stock del artículo." + e.getMessage()+"\n");
    }
  }
}