/** Implementa la parte de Modelo de Datos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package gestionalmacen01.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModeloArrayList implements ModeloAbs
{
    protected ArrayList <Producto> lista;
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
    }

    public boolean insertarProducto ( Producto p){
      assert ( p != null ); // No permito productos nulos  
      return lista.add(p);     
    }
 
    public boolean borrarProducto(int codigo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).codigo == codigo) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }
    
    
    public Producto buscarProducto ( int codigo) {
    	for (Producto producto : lista) {
			if (producto.codigo==codigo) {
				return producto;
			}
		}
    	return null;
    }
   
    // Funciona pero no es una solución independiente del la mécanismo de salida.
    // El acceso a datos debe ser independiente de la visualización de los mismos.
    
    
    
    // Solo chequea si el producto ya existia en el almacen.
    // No tiene que hacer nada pues se ha cambiado la referencia
    public boolean modificarProducto(Producto nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).codigo == nuevo.codigo) {
                lista.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    // Devuelvo una lista con los productos con stock mínimo
    // Será el programa principal quien se encargue de mostrarlos
	public List<Producto> obtenerProductosStockMin() {
		var stockmin = new ArrayList<Producto>();
		for (int i = 0; i < lista.size(); i++) {
			Producto p = lista.get(i);
			if (p.stock <= p.stock_min) {
				stockmin.add(p);
			}
		}
		return stockmin;
	}

	

	 // LISTAR TODOS (IMPORTANTE: COPIA, NO LISTA ORIGINAL)
    public List<Producto> obtenerProductos() {
        return new ArrayList<>(lista);
    }

	@Override
	public void imprimirProductosTodos() {
		// TODO Auto-generated method stub
		
	}
}    
