/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger.cocina;


/**
 *
 * @author Daniel
 */
public abstract class IngredientesDecorator extends Producto{
    Producto producto;

    public IngredientesDecorator() {
    }
    
    public IngredientesDecorator(Producto producto,String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
        this.producto = producto;
    }
    
    @Override
    public double getPrecio() {
        return producto.getPrecio();
    }

    @Override
    public String toString() {
        return producto.toString();
    }
    
}
