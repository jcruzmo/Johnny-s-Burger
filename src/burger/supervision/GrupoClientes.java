package burger.supervision;

import burger.cocina.Producto;
import burger.comedor.Mesa;
import java.util.Observable;
import java.util.Observer;


public class GrupoClientes extends Thread implements Observer{

    private MediadorCamarero mediador;
    private Mesa mesa;
    private Producto pedido;
    private Nota nota;

    public GrupoClientes(MediadorCamarero mediador) {
        this.mediador = mediador;
        mediador.addSujetoGrupoClientes(this);
        System.out.println("Clientes esperando en la cola..");
    }

    public void asignarNota(Nota nota) {
        this.nota = nota;
        start();
    }
    
    @Override
    public void run() {
        mediador.tomarNota(this, nota);
    }
    
    public void degustar(Producto producto) {
        System.out.println("Mesa " + mesa.getNumeroMesa() + " " + producto.toString());
        pedido = producto;
        mesa.comenzarAcomer();
    }
    
    void pagar() {
        System.out.println("La cuenta son: " + pedido.getPrecio() + "€");
        mesa.cobrarYlimpiar();
        mediador.limpiarMesa(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        Mesa mesaObservada = (Mesa)observable;

        if (mesaObservada.hanTerminadoDeComer()){
            mesa.pedirCuenta();
            mediador.prepararCuenta(this);
        }
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
}
