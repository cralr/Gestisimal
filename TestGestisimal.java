package gestisimal;

import java.util.ArrayList;
import java.util.Scanner;

import gestisimal.almacen.Almacen;
import gestisimal.almacen.Articulo;
import gestisimal.almacen.exceptions.ArticuloNoExisteException;
import gestisimal.almacen.exceptions.CodigoNoValidoExceptions;

/**
 * Se comunica con el usuario (E/S de datos por consola)
 * Comprueba si existe o no el artículo en el almacén
 * Comprueba que el stock no sea negativo en el almacén
 * Comprueba que el articulo exista para borrarlo del almacén.
 * 
 * Test para comprobar la clase Gestisimal.
 * @author Rafael Miguel Cruz Álvarez
 * @author Fco Javier Frías Serrano
 * @version 1.0
 */
public class TestGestisimal {
  static  Almacen almacen = new Almacen();
  static Scanner entrada= new Scanner (System.in);

  public static void main(String[] args) throws Exception {
   
    int opcion;
   
    //almacenDePrueba();
    do {
      mostrarMenu();
      opcion=pedirOpcion();
      
      switch((opcion)) {
        case 1:
           System.out.println(almacen.toString());
          break;
        case 2:
            annadirArticulo();
          break;
        case 3:
            baja();
          break;
          
        case 4:
           modificarArticulo();
          break;
        case 5:
          entradaAlmacen();
        break;
        case 6:
          
          break;
        default:
          System.out.println("Fin del Programa");
      }
   }while(opcion!=7);
}
  /*
  private static void almacenDePrueba() {
    try {
      almacen.annadir("1", 11, 11, 11);
      almacen.annadir("2", 22, 22, 22);
      almacen.annadir("33", 11, 11, 33);
      almacen.annadir("44", 11, 11, 44);
      almacen.annadir("55", 11, 11, 55);
    } catch (Exception e) {
      System.out.println("ESTO NO DEBE APARECERRRRRRRRRRRRRRRRR");
    }
    
  }*/

  /**
   * Método añadir.
   * @throws Exception
   */

  private static void annadirArticulo() throws Exception {
   
    try { 
      System.out.println("--AÑADIR ARTÍCULO--");
      System.out.println("Introduzca la descripción del artículo:");
      String descripcion=entrada.next();
      System.out.println("Introduzca el precio de compra del artículo:");
      double precioCompra=entrada.nextDouble();
      System.out.println("Introduzca el precio de venta del artículo:");
      double precioVenta=entrada.nextDouble();
      System.out.println("Introduzca el stock del artículo:");
      int stock=entrada.nextInt();
      
      almacen.annadir(descripcion, precioCompra, precioVenta, stock);
      System.out.println("Artículo añadido.");
    } catch (Exception e) {
      System.err.println("No se ha podido dar de alta al artículo. " + e.getMessage());
    }
  }
  
  private static void baja() throws CodigoNoValidoExceptions {
      System.out.println("Introduce el códido del artículo a eliminar.");
      int codigo=entrada.nextInt();
      entrada.nextLine();
      
      if (almacen.baja(codigo))
        System.out.println("Artículo eliminado.");
      else
        System.err.println("El artículo no se ha podido eliminar. No existe un artículo con ese código en el almacen.");
      
      entrada.nextLine();    
  }
  
  private static void modificarArticulo()  {
    
      try {
        System.out.println("--MODIFICAR ARTÍCULO--");
        System.out.println("Introduce el codigo del articulo a modificar.");
        int codigo=entrada.nextInt();
        Articulo articulo = almacen.get(codigo);
        System.out.println(articulo);

            
        System.out.println("Introduzca la nueva descripción del artículo:");
        String descripcion=entrada.next();
        System.out.println("Introduzca el nuevo precio de compra del artículo:");
        double precioCompra=entrada.nextDouble();
        System.out.println("Introduzca el nuevo precio de venta del artículo:");
        double precioVenta=entrada.nextDouble();
        System.out.println("Introduzca el nuevo stock del artículo:");
        int stock=entrada.nextInt();
        
        almacen.set(articulo,descripcion, precioCompra, precioVenta, stock);
      } catch (ArticuloNoExisteException e) {
        // TODO Auto-generated catch block
        System.err.println("No se ha podido modificar el artículo."+e.getMessage());
      }
    
  }
  
  public static void entradaAlmacen() {
    try {
      System.out.println("--INCREMENTAR STOCK--");
      System.out.println("Introduce el codigo del articulo a incrementar.");
      int codigo=entrada.nextInt();
      Articulo articulo = almacen.get(codigo);
      System.out.println(articulo);

      System.out.println("Introduzca el número de artículos entregados al almacen.");
      int cantidad=entrada.nextInt();
      almacen.incrementar(codigo,cantidad);
      
    } catch (ArticuloNoExisteException e) {
      System.err.println("No se ha podido incrementar el stock del artículo."+e.getMessage());
    }
  }
  
   /**
   * Método que muestra el menú.
   */
  public static void  mostrarMenu() {
    System.out.println("----MENÚ GESTISIMAL----");
    System.out.println("1º)Listado.");
    System.out.println("2º)Alta.");
    System.out.println("3º)Baja.");
    System.out.println("4º)Modificación.");
    System.out.println("5º)Entrada de mercancía.");
    System.out.println("6º)Salida de mercancía.");
    System.out.println("7º)Salir."); 
  }
  
  /**
   * Recoge la opción valida del menú
   * 
   * @return opción 
   */
  public static int pedirOpcion() {
    int opcion;
    System.out.print("Introduzca una opción: \n");
    opcion = entrada.nextInt();
    return opcion;
  }
}