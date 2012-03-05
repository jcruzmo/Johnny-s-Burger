/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger.cocina;

/**
 *
 * @author Daniel
 */
public class Ingrediente extends IngredientesDecorator {

    public Ingrediente(Producto producto,String nombre, double precio) {
        super(producto,nombre, "", precio);
    }
    
    @Override
    public double getPrecio() {
        return super.getPrecio() + precio;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + nombre;
    }
    
}
