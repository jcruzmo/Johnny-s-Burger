package burger.comedor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstadoComiendo implements Estado{
    

    @Override
    public void ejecutar(Mesa mesa) {
        System.out.println("La mesa " + mesa.getNumeroMesa() + " está degustando los platos");
        
        Random randomGenerator = new Random();
        try {
            Thread.sleep(randomGenerator.nextInt(3) * 100);
        } catch (InterruptedException ex) {
            Logger.getLogger(EstadoComiendo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
