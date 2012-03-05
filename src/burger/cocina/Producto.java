package burger.cocina;


/**
 * @author Daniel
 * @version 1.0
 * @created 05-feb-2012 20:15:38
 */
public abstract class Producto {

    protected String nombre;
    protected String descripcion;
    protected double precio = 0;

    public Producto(){

    }

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
   
    public double getPrecio() {
        return precio;
    }

    @Override
    public abstract String toString();

}