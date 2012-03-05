package burger.comedor;

import java.util.Observable;


public class Mesa extends Observable {
	
    private Estado estadoActual = new EstadoLibre();
    private int numeroMesa;

    public Mesa(int numeroMesa){
        this.numeroMesa = numeroMesa;
    }
    
    public void comenzarAcomer() {
       estadoActual = new EstadoComiendo();
       estadoCambiado();
    }

    public void pedirCuenta() {
        estadoActual = new EstadoEsperandoCuenta();
        estadoCambiado();
    }

    public void cobrarYlimpiar() {
        estadoActual = new EstadoLibre();
        estadoCambiado();
    }

    private void estadoCambiado() {
        estadoActual.ejecutar(this);
        setChanged();
        notifyObservers();
    }

    public int getNumeroMesa(){
        return numeroMesa;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public boolean hanTerminadoDeComer() {
        return estadoActual instanceof EstadoComiendo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesa other = (Mesa) obj;
        if (this.numeroMesa != other.numeroMesa) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.numeroMesa;
        return hash;
    }

    
}
