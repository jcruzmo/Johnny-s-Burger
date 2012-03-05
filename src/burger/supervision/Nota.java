/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger.supervision;

import burger.cocina.FactoriaProducto;
import burger.cocina.Producto;
import burger.util.TipoProducto;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Nota {
    private ArrayList<Producto> productos;
    
    public void anadirProducto(TipoProducto tipoProducto){
        Producto producto = FactoriaProducto.getProducto(tipoProducto);
        getProductos().add(producto);
    }
    
    public void anadirProducto(TipoProducto tipoProducto, ArrayList<String> ingredientes) {
        Producto producto = FactoriaProducto.getProducto(tipoProducto);
        for (String ingrediente : ingredientes) {
            producto = new burger.cocina.Ingrediente(producto, ingrediente, 0.5);
        }
        
        getProductos().add(producto);
    }
    
    public ArrayList<Producto> getProductos(){
        if(productos == null){
            productos = new ArrayList<>();
        }
        return productos;
    }
    
}
