
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package gestionalmacen01.modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ModeloHashMap implements ModeloAbs
{
    private HashMap <Integer,Producto> mapa;
    
    public ModeloHashMap()
    {
       mapa=new HashMap  <Integer,Producto>();
    }

	@Override
	public boolean insertarProducto(Producto p) {
		assert (p !=null );
		return mapa.put(p.codigo, p)==null;
	}

	@Override
	public boolean borrarProducto(int codigo) {
		// TODO Auto-generated method stub
		return mapa.remove(codigo)!=null;
	}

	@Override
	public boolean modificarProducto(Producto nuevo) {
		// TODO Auto-generated method stub
		assert (nuevo !=null);
		if(mapa.containsKey(nuevo.codigo)) {
			mapa.put(nuevo.codigo, nuevo);
			return true;
		}
		return false;
	}

	@Override
	public Producto buscarProducto(int codigo) {
		
		return mapa.get(codigo);
	}

	@Override
	public void imprimirProductosTodos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> obtenerProductos() {
		//List<Producto> obtenProductos = new ArrayList<Producto>();
		//for (Producto producto : mapa.values()) {
			//obtenProductos.add(producto);
		//}
		return new ArrayList<>(mapa.values());
	}

	@Override
	public List<Producto> obtenerProductosStockMin() {
		// TODO Auto-generated method stub
		List<Producto> stockMin = new ArrayList<>();
		for (Producto p :mapa.values()) {
			if (p.getStock()<=p.getStock_min()) {
				stockMin.add(p);
			}
		}
		return stockMin;
	}

   // COMPLETAR
    
    
    
}
