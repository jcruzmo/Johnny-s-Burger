package burger.supervision;

import burger.cocina.Producto;
import burger.comedor.Mesa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MediadorCamarero{
    
    private static final Logger LOG = Logger.getLogger(MediadorCamarero.class.getName());

    private Semaphore semaforoMesas;
    private Cocina sujetoCocina;
    private ArrayList<GrupoClientes> colaDeClientes;
    private HashMap<Mesa, Boolean> mesasLibres;
    
    public MediadorCamarero(){
        sujetoCocina = new Cocina(this);
        semaforoMesas = new Semaphore(4);
        
        mesasLibres = new HashMap<>();
        mesasLibres.put(new Mesa(1), Boolean.TRUE);
        mesasLibres.put(new Mesa(2), Boolean.TRUE);
        mesasLibres.put(new Mesa(3), Boolean.TRUE);
        mesasLibres.put(new Mesa(4), Boolean.TRUE);
    }

    public void llevarComida(GrupoClientes sujetoGrupoClientes, Producto producto) {
        sujetoGrupoClientes.degustar(producto);
    }

    public void tomarNota(GrupoClientes sujetoGrupoClientes, Nota nota) {
        
        try {
            semaforoMesas.acquire();
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Jhonny da paso a los clientes");
        
        Mesa mesaLibre = getMesaLibre();
        sujetoGrupoClientes.setMesa(mesaLibre);
        ocuparMesa(sujetoGrupoClientes,mesaLibre);

        System.out.println("Clientes sentandose en mesa " + mesaLibre.getNumeroMesa());
        System.out.println("Atendiendo a mesa " + mesaLibre.getNumeroMesa());
        sujetoCocina.cocinarPedido(sujetoGrupoClientes, nota);
        
    }

    public void prepararCuenta(GrupoClientes sujetoGrupoClientes) {
        System.out.println("Calculando la cuenta...");
        
        sujetoGrupoClientes.pagar();
    }
   
    public synchronized ArrayList<GrupoClientes> getColaDeClientes() {
        if(colaDeClientes == null){
            colaDeClientes = new ArrayList<>();
        }
        return colaDeClientes;
    }

    public void setColaClientes(ArrayList<GrupoClientes> listaGrupoClientes) {
        this.colaDeClientes = listaGrupoClientes;
    }

    public synchronized void addSujetoGrupoClientes(GrupoClientes sujetoGrupoClientes) {
        getColaDeClientes().add(sujetoGrupoClientes);
    }

    public synchronized void limpiarMesa(GrupoClientes sujetoGrupoClientes) {
        getColaDeClientes().remove(sujetoGrupoClientes);
        mesasLibres.put(sujetoGrupoClientes.getMesa(), Boolean.TRUE);
        semaforoMesas.release();
    }

    private synchronized Mesa getMesaLibre() {
        Mesa mesaLibre = null;
        
        for (Mesa mesa : mesasLibres.keySet()) {
            if (mesasLibres.get(mesa)){
                mesaLibre = mesa;
                break;
            }
        }
        
        return mesaLibre;
    }

    private synchronized void ocuparMesa(GrupoClientes sujetoGrupoClientes,Mesa mesaLibre) {
        mesasLibres.put(mesaLibre, Boolean.FALSE);
        mesaLibre.addObserver(sujetoGrupoClientes);
    }
   
    
}
