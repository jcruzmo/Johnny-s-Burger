/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package burger;

import burger.supervision.GrupoClientes;
import burger.supervision.MediadorCamarero;
import burger.supervision.Nota;
import burger.util.Ingrediente;
import burger.util.TipoProducto;
import java.util.ArrayList;
/**
 *
 * @author Daniel
 */
public class Burger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MediadorCamarero johnny = new MediadorCamarero();
        
        GrupoClientes grupoClientes = new GrupoClientes(johnny);   
        GrupoClientes grupoClientes2 = new GrupoClientes(johnny);  
        GrupoClientes grupoClientes3 = new GrupoClientes(johnny);   
        GrupoClientes grupoClientes4 = new GrupoClientes(johnny);  
        GrupoClientes grupoClientes5 = new GrupoClientes(johnny);   
        GrupoClientes grupoClientes6 = new GrupoClientes(johnny);  
        
        Nota nota = new Nota();
        nota.anadirProducto(TipoProducto.PATATAS_DELUXE);
        nota.anadirProducto(TipoProducto.BEBIDA_SURRENDER);
        nota.anadirProducto(TipoProducto.HAMBURGUESA_SUSPICIOUS);
        ArrayList<String> ingredientes = new ArrayList<>();
        ingredientes.add(Ingrediente.HUEVO);
        ingredientes.add(Ingrediente.BACON);
        nota.anadirProducto(TipoProducto.HAMBURGUESA_MYWAY, ingredientes);
        
        grupoClientes.asignarNota(nota);
        grupoClientes2.asignarNota(nota);
        grupoClientes3.asignarNota(nota);
        grupoClientes4.asignarNota(nota);
        grupoClientes5.asignarNota(nota);
        grupoClientes6.asignarNota(nota);
    }
}
