/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger.cocina;

/**
 *
 * @author Daniel
 */
public class Patatas extends Producto {

    public Patatas(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }
    
    @Override
    public String toString() {
        return "Patatas " + nombre + ": " + descripcion;
    }
    
}
