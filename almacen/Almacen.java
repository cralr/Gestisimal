package gestisimal.almacen;

import java.util.ArrayList;

import gestisimal.almacen.exceptions.ArticuloNoExisteException;
import gestisimal.almacen.exceptions.ArticuloYaExisteException;
import gestisimal.almacen.exceptions.CodigoNoValidoExceptions;

/**
 * Gestiona el conjunto de artículos del almacén.
 *
 *
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */
public class Almacen {
  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();

  /**
   * Añadir un articulo
   * @param codigo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws Exception
   */
  public void annadir(String descripcion, double precioCompra, double precioVenta, int stock)throws Exception {
    Articulo articulo = new Articulo(descripcion, precioCompra, precioVenta, stock);
    if (!(almacen.contains(articulo)))
      almacen.add(articulo);
    else 
      throw new ArticuloYaExisteException("El árticulo ya existe.");
      
  }
  
  /**
   * Elimina el artículo del almacén
   * 
   * @param codigo Código del artículo a eliminar
   * @return true si se ha eliminado. false en otro caso.
   */
  public boolean baja(int codigo) throws CodigoNoValidoExceptions{
    return almacen.remove(new Articulo(codigo));
  }
  
  /**
   * Modificar articulo
   * @param articulo 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   */

  public void set(Articulo articulo, String descripcion, double precioCompra, double precioVenta, int stock) {
    int indice = almacen.indexOf(articulo);
    articulo.set( descripcion,  precioCompra,  precioVenta,  stock);
    almacen.set(indice, almacen.get(indice));
  }
  
 

  
  
  @Override
  public String toString() {
    return "Artículo " + almacen + "" ;
  }

  public Articulo get(int codigo) throws ArticuloNoExisteException {
    try {
      return almacen.get(almacen.indexOf(new Articulo(codigo)));
    } catch (IndexOutOfBoundsException e) {
     throw new ArticuloNoExisteException("El código del artículo no existe en el almacén.");
    }
  }

  public void incrementar(int codigo, int cantidad) {
    Articulo articulo = almacen.get(almacen.indexOf(new Articulo(codigo)));
    articulo.incrementaStock(cantidad);
  }
}
