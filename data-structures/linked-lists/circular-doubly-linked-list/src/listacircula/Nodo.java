package listacircula;

public class Nodo {

    public Cancion dato;
    public Nodo siguiente;
    public Nodo anterior;

    public Nodo(Cancion dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
    
    
}
