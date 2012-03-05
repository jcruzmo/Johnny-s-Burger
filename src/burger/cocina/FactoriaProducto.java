package burger.cocina;

import burger.util.TipoProducto;


/**
 * @author Daniel
 * @version 1.0
 * @created 05-feb-2012 20:15:31
 */
public class FactoriaProducto {

   public static  Producto getProducto(TipoProducto tipoProducto){
       Producto producto = null;
        
        switch(tipoProducto){
            case HAMBURGUESA_SUSPICIOUS:
                producto = new HamburguesaBase("Suspicious Mind","Increíble hamburguesa de ¼ de libra",5.5);
                producto = new Ingrediente(producto, "cebolla a la plancha", 0);
                producto = new Ingrediente(producto, "bacon", 0);
                producto = new Ingrediente(producto, "queso", 0);
                break;
            case HAMBURGUESA_MYWAY:
                producto = new HamburguesaBase("My Way","Increíble hamburguesa de ¼ de libra con ",4);
                producto = new Ingrediente(producto, "lechuga", 0);
                producto = new Ingrediente(producto, "tomate", 0);
                break;
            case PATATAS_CLASSICS:
                producto = new Patatas("Classics","Las patatas clásicas de corte fino",2);
                break;
            case PATATAS_DELUXE:
                producto = new Patatas("Deluxe","Patatas de corte grueso con salsa especial",3);
                break;
            case POSTRE_NEW_YORK_CHEESE_CAKE:
                producto = new Postre("New York Cheese Cake","Tarta de queso", 4.95);
                break;
            case POSTRE_MANHATTAN_APPLE:
                producto = new Postre("Manhattan Apple","Tarta de manzana", 4.5);
                break;
            case BEBIDA_ELVIS_COLA:
                producto = new Bebida("Elvis Cola","",4.5);
                break;
            case BEBIDA_SURRENDER:
                producto = new Bebida("Surrender","Zumo de frutas", 2);
                break;
        }
        
        return producto;
   }
            

}