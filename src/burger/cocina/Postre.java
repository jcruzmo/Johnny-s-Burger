/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger.cocina;

/**
 *
 * @author Daniel
 */
public class Postre extends Producto{

    public Postre(String nombre, String descripcion, double precio) {
        super(nombre, descripcion, precio);
    }
    
    @Override
    public String toString() {
        return "Postre " + nombre + ": " + descripcion;
    }
    
}
