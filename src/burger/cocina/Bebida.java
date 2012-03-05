/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger.cocina;

/**
 *
 * @author Daniel
 */
public class Bebida extends Producto {

    public Bebida(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }
    
    @Override
    public String toString() {
        return "Bebida " + nombre + ": hjjjhgjghjghjghjghjghj " + descripcion;
    }
    
}
