package burger.comedor;

public class EstadoLibre implements Estado{

    @Override
    public void ejecutar(Mesa mesa) {
        System.out.println("La mesa " + mesa.getNumeroMesa() + " está libre");
    }

}
