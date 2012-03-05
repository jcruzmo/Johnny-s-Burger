package burger.supervision;

import burger.cocina.PedidoComposite;
import burger.cocina.Producto;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cocina {

    private MediadorCamarero mediador;
    
    public Cocina(MediadorCamarero mediador) {
        this.mediador = mediador;
        System.out.println("Se abre Elvis Presley’s Burger!");
    }

    public void cocinarPedido(GrupoClientes sujetoGrupoClientes, Nota nota) {
        System.out.println("Preparando pedido para mesa " + sujetoGrupoClientes.getMesa().getNumeroMesa() + "...");
        
        Random randomGenerator = new Random();
        try {
            Thread.sleep(randomGenerator.nextInt(3) * 100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PedidoComposite pedido = new PedidoComposite();
        
        for(Producto producto : nota.getProductos()){
            pedido.anadirProducto(producto);
        }
        
        mediador.llevarComida(sujetoGrupoClientes, pedido);
    }


}
