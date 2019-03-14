package gestisimal.almacen;

import gestisimal.almacen.exceptions.CantidadNegativaExceptions;
import gestisimal.almacen.exceptions.CodigoNoValidoExceptions;
import gestisimal.almacen.exceptions.StockNegativoExceptions;
import gestisimal.almacen.exceptions.StockNegativoExceptions;

/**
 * <p>
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el
 * control de los artículos de un almacén. De cada artículo se debe saber el
 * código, la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades). El menú del programa debe tener, al menos, las
 * siguientes opciones:
 * </p>
 * <ul>
 * <li>1. Listado</li>
 * <li>2. Alta</li>
 * <li>3. Baja</li>
 * <li>4. Modificación</li>
 * <li>5. Entrada de mercancía</li>
 * <li>6. Salida de mercancía</li>
 * <li>7. Salir</li>
 * </ul>
 * <p>
 * La entrada y salida de mercancía supone respectivamente el incremento y
 * decremento de stock de un determinado artículo. Hay que controlar que no se
 * pueda sacar más mercancía de la que hay en el almacén.
 * </p>
 *
 * @author Fco Javier Frías Serrano
 * @author Rafa Cruz
 * @version 1.0
 */
public class Articulo {

  /**
   * Generará códigos para los artículos
   */
  private static int contador=0;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int stock;
  /**
   * Identifica al artículo. Será único
   */
  private int codigo;
  
   Articulo (String descripcion, double precioCompra, double precioVenta, int stock) throws StockNegativoExceptions {
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
    setCodigo();
  }
  
   Articulo(int codigoArticulo) {
    setCodigo(codigoArticulo);
   }
  
  
  private void setCodigo() {
    this.codigo=Articulo.contador++;
  }
  
  private void setCodigo(int codigo) {
    this.codigo = codigo;
  }
  
  public int getCodigo() {
    return codigo;
  }
  /**
   * @return the descripcion
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * @param descripcion the descripcion to set
   */
   void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * @return the precioCompra
   */
  public double getPrecioCompra() {
    return precioCompra;
  }

  /**
   * @param precioCompra the precioCompra to set
   */
   void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  /**
   * @return the precioVenta
   */
  public double getPrecioVenta() {
    return precioVenta;
  }

  /**
   * @param precioVenta the precioVenta to set
   */
   void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  /**
   * @return the stock
   */
  public int getStock() {
    return stock;
  }

  /**
   * @param stock the stock to set
   * @throws StockNegativoExceptions 
   */
   void setStock(int stock) throws StockNegativoExceptions {
    if(stock >=0) {
      this.stock = stock;
    }else
      throw new StockNegativoExceptions("El stock no puede ser negativo.");   
  }  
  
  /**
   * Método para aumentar el stock
   * @param cantidad
   * @throws StockNegativoExceptions 
   * @throws CantidadNegativaExceptions 
  */
  public void incrementaStock(int cantidad) throws StockNegativoExceptions, CantidadNegativaExceptions{
    if(cantidad>0)
      setStock(getStock()+cantidad);
    else
    throw new CantidadNegativaExceptions("No se puede añadir una cantidad de stock negativo.");
  }
  
  /**
   * Método para aumentar el stock
   * @param cantidad
   * @throws CantidadNegativaExceptions 
   * @throws StockNegativoExceptions 
  */
  public void decrementaStock(int cantidad) throws CantidadNegativaExceptions, StockNegativoExceptions{
    if(cantidad>0)
      setStock(getStock()-cantidad);
    else
      throw new CantidadNegativaExceptions("No se puede añadir una cantidad de stock negativo.");
   }
  
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "\nCodigo: " + getCodigo() + 
        "\nDescripcion: " + getDescripcion() + 
        "\nPrecioCompra: " + getPrecioCompra()+
        "\nPrecioVenta: " + getPrecioVenta() + 
        "\nStock: " + getStock() +
        "\n'''''''''''''''''''''''''''''''''''''''";
  }

  /**
   * Método set usado en Almacen para realizar la modificación.
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws StockNegativoExceptions 
   */
  public void set(String descripcion, double precioCompra, double precioVenta, int stock) throws StockNegativoExceptions {
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
  }



}