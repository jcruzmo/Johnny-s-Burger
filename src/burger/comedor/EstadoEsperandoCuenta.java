package burger.comedor;

public class EstadoEsperandoCuenta implements Estado{

    @Override
    public void ejecutar(Mesa mesa) {
        System.out.println("La mesa " + mesa.getNumeroMesa() + " está esperando la cuenta");
    }

}
