/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger.cocina;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PedidoComposite extends Producto {

    private ArrayList<Producto> productos;
    
    public PedidoComposite() {
        super();
    }
    
    @Override
    public String toString() {
        String retorno = "Pedido: ";
        
        for (Producto producto : productos) {
            retorno += "\n" + producto + " vale " + producto.getPrecio() + "€";
        }
        
        return retorno;
    }
    
    public void anadirProducto(Producto producto){
        getPedido().add(producto);
        precio += producto.getPrecio();
    }
    
    private ArrayList<Producto> getPedido(){
        if (productos == null){
            productos  = new ArrayList<>();
        }
        return productos;
    }
}
