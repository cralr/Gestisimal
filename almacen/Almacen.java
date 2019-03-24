package gestisimal.almacen;

import java.util.ArrayList;

import gestisimal.almacen.exceptions.ArticuloNoExisteException;
import gestisimal.almacen.exceptions.ArticuloYaExisteException;
import gestisimal.almacen.exceptions.CantidadNegativaException;
import gestisimal.almacen.exceptions.CodigoNoValidoException;
import gestisimal.almacen.exceptions.StockNegativoException;
import gestisimal.almacen.exceptions.PrecioCompraNegativoException;
import gestisimal.almacen.exceptions.PrecioVentaNegativoException;

/**
 * Gestiona el conjunto de artículos del almacén.
 *
 *
 * @author Rafael Miguel Cruz Álvarez
 * @author Fco Javier Frías Serrano
 * @version 1.0
 */
public class Almacen {
  private ArrayList<Articulo> arraylist = new ArrayList<Articulo>();

  /**
   * Añadir un articulo
   * 
   * @param codigo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws Exception
   */
  public void annadir(String descripcion, double precioCompra, double precioVenta, int stock) throws Exception {
    Articulo articulo = new Articulo(descripcion, precioCompra, precioVenta, stock);
    if (!(arraylist.contains(articulo)))
      arraylist.add(articulo);
    else
      throw new ArticuloYaExisteException("El árticulo ya existe.");

  }

  /**
   * Elimina el artículo del almacén
   * 
   * @param codigo
   *          Código del artículo a eliminar
   * @return true si se ha eliminado. false en otro caso.
   */
  public boolean baja(int codigo) throws CodigoNoValidoException {
    return arraylist.remove(new Articulo(codigo)); // Si el código que introducimos en el test es igual al código del
                                                 // artículo que hay en la lista se realiza el borrado.
  }

  /**
   * Modificar articulo
   * 
   * @param articulo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws StockNegativoException
   * @throws PrecioVentaNegativoException
   * @throws PrecioCompraNegativoException
   */

  public void set(Articulo articulo, String descripcion, double precioCompra, double precioVenta, int stock)
      throws StockNegativoException, PrecioCompraNegativoException, PrecioVentaNegativoException {
    int indice = arraylist.indexOf(articulo);
    articulo.set(descripcion, precioCompra, precioVenta, stock);
    arraylist.set(indice, arraylist.get(indice));
  }

  /**
   * Método toString
   */
  @Override
  public String toString() {
    return "Artículo " + arraylist + "";
  }

  /**
   * Método get para obtener el codigo del artículo.
   * 
   * @param codigo
   * @return
   * @throws ArticuloNoExisteException
   */
  public Articulo get(int codigo) throws ArticuloNoExisteException {
    try {
      return arraylist.get(arraylist.indexOf(new Articulo(codigo))); // Con get lo que se hace es extraer el código del
                                                                 // artículo.
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloNoExisteException("El código del artículo no existe en el almacén.");// Si el código no lo
                                                                                             // devuelve el indexOf es
                                                                                             // que no existe y salta la
                                                                                             // excepción.
    }
  }

  /**
   * Método incrementar, que aumenta las unidades de stock de un artículo.
   * 
   * @param codigo
   * @param cantidad
   * @throws CantidadNegativaException
   * @throws StockNegativoException
   */
  public void incrementar(int codigo, int cantidad) throws StockNegativoException, CantidadNegativaException {
    Articulo articulo = arraylist.get(arraylist.indexOf(new Articulo(codigo))); 
    articulo.incrementaStock(cantidad);
  }

  /**
   * Método decrementar, que disminuye las unidades de stock de un artículo.
   * 
   * @param codigo
   * @param cantidad
   * @throws CantidadNegativaException
   * @throws StockNegativoException
   */
  public void decrementar(int codigo, int cantidad) throws StockNegativoException, CantidadNegativaException {
    Articulo articulo = arraylist.get(arraylist.indexOf(new Articulo(codigo)));
    articulo.decrementaStock(cantidad);
    
  }
}
