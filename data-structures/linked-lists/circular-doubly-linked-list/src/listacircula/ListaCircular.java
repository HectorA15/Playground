package listacircula;

import java.util.ArrayList;
import java.util.List;

public class ListaCircular {

    private Nodo frente;
    private Nodo ultimo;
    private int tamanio;

    public ListaCircular() {
        frente = null;
        ultimo = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public int tamanio() {
        return tamanio;
    }

    public void insertarAlFrente(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (estaVacia()) {
            nuevo.siguiente = nuevo; 
            nuevo.anterior = nuevo;
            frente = nuevo;
            ultimo = nuevo;
        } else {
                                                            // nuevo.setSiguiente(frente);
                                                             // frente.setAnterior(nuevo);          // mi modificacion
                                                                      //frente = nuevo;
                                                                  // nuevo.setAnterior(ultimo);
                                                                //  ultimo.setSiguiente(nuevo);
            frente.setSiguiente(nuevo);                           
            nuevo.setSiguiente(frente);
            frente = nuevo;
            frente.setAnterior(ultimo);
            ultimo.setSiguiente(frente);
        }
        tamanio++;
    }

    public void insertarAlUltimo(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (estaVacia()) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            frente = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
            ultimo.setSiguiente(frente);
            frente.setAnterior(ultimo);
        }
        tamanio++;
    }

    public Cancion getActual() {
        return ultimo != null ? ultimo.dato : null;
    }

    public void next() {
        if (!estaVacia()) {
            ultimo = ultimo.siguiente;
        }
    }

    public void previous() {
        if (!estaVacia()) {
            ultimo = ultimo.anterior;
        }
    }

    public void moveToIndex(int index) {
        if (index < 0 || index >= tamanio) {
            throw new IndexOutOfBoundsException();
        }
        if (estaVacia()) {
            return;
        }
        Nodo temp = frente;
        for (int i = 0; i < index; i++) {
            temp = temp.siguiente;
        }
        ultimo = temp;
    }

    public int indexOfActual() {
        if (estaVacia()) {
            return -1;
        }
        Nodo temp = frente;
        for (int i = 0; i < tamanio; i++) {
            if (temp == ultimo) {
                return i;
            }
            temp = temp.siguiente;
        }
        return -1;
    }

    public boolean eliminarActual() {
        if (estaVacia()) {
            return false;
        }
        if (tamanio == 1) {
            frente = null;
            ultimo = null;
            tamanio = 0;
            return true;
        }
        Nodo prev = ultimo.anterior;
        Nodo next = ultimo.siguiente;
        prev.siguiente = next;
        next.anterior = prev;
        if (ultimo == frente) {
            frente = next;
        }
        ultimo = next; 
        tamanio--;
        return true;
    }

    // Obtener todas las canciones en orden
    public List<Cancion> toList() {
        List<Cancion> out = new ArrayList<>();
        if (estaVacia()) {
            return out;
        }
        Nodo temp = frente;
        for (int i = 0; i < tamanio; i++) {
            out.add(temp.dato);
            temp = temp.siguiente;
        }
        return out;
    }

}
