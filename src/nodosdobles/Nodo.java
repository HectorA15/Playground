package nodosdobles;


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

    public Cancion getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    @Override
    public String toString() {    //     return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + ", anterior=" + anterior + '}';
      if (this.dato != null) {
        return this.dato.toString();
    }
    return "Nodo vacío";
    }
}
