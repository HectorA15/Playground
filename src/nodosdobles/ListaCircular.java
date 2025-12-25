package nodosdobles;

public class ListaCircular {

    private Nodo frente;
    private Nodo ultimo;

    public ListaCircular() {
        frente = null;
        ultimo = null;
    }

    public boolean isVacia() {
        if (ultimo == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public int cuentaNodos() {
        if (isVacia()) {
            return 0;
        } else {
            int cuenta = 1;
            Nodo q = frente;

            while (q != ultimo) {
                cuenta++;
                q = q.getSiguiente();
            }
            return cuenta;
        }
    }
    
    public void insertarIndice(int indice, Cancion cancion) {
        if (isVacia()) {
            insertarVacia(cancion);

        } else if (indice == 0) {
            insertarAlFrente(cancion);

        } else if (indice == this.cuentaNodos()) {
            insertarAlFinal(cancion);
        } else {
            Nodo nuevo = new Nodo(cancion);
            Nodo q = frente;
            int i = 0;

            do {
                q = q.getSiguiente();
                i++;
            } while (i != indice);

            Nodo p = q.getAnterior();
            p.setSiguiente(nuevo);
            nuevo.setAnterior(p);
            nuevo.setSiguiente(q);
            q.setAnterior(nuevo);
        }
    }
    
    public void insertarVacia(Cancion c) {
        if (isVacia()) {
            Nodo nuevo = new Nodo(c);

            frente = nuevo;
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
        } else {
            System.out.println("No esta vacia...");
        }
        
    }
    
    public void insertarAlFrente(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (isVacia()) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            frente = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSiguiente(frente);
            frente.setAnterior(nuevo);          // mi modificacion
            frente = nuevo;
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);

        }
    }
    
    public void insertarAlFinal(Cancion cancion) {
        Nodo nuevo = new Nodo(cancion);
        if (isVacia()) {
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
    }
    
    public void eliminarUnico() {
        frente = null;
        ultimo = null;
    }
    
    public void eliminarFrente() {
        if (isVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            if (frente == ultimo) {
                eliminarUnico();
            } else {
                frente = frente.getSiguiente();
                frente.setAnterior(ultimo);
                ultimo.setSiguiente(frente);

            }
        }
    }
    
    public void vaciarLista() {
        /*while (!isVacia()) {
            eliminarFrente();
        }*/
        
        
        frente = null;
        ultimo = null;
    }
    
    public void eliminarUltimo() {
        if (isVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            if (frente == ultimo) {
                eliminarUnico();
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(frente);
                frente.setAnterior(ultimo);
            }
        }
    }
    
    public void eliminarIndice(int indice) {
        if (isVacia()) {
            System.out.println("Lista vacia");
        } else {
            int imax = cuentaNodos() - 1;
            if (indice < 0 || indice > imax) {
                System.out.println("Indice fuera de rango");
            } else {
                if (indice == 0) {
                    eliminarFrente();
                } else {
                    if (indice == imax) {
                        eliminarUltimo();
                    } else {
                        Nodo q = frente;

                        for (int i = 0; i < indice; i++) {
                            q = q.getSiguiente();
                        }
                        Nodo Anterior = q.getAnterior();
                        Nodo Siguiente = q.getSiguiente();

                        Anterior.setSiguiente(Siguiente);
                        Siguiente.setAnterior(Anterior);
                    }
                }
            }
        }
    }
    
    public Cancion getActual() {
        return ultimo != null ? ultimo.dato : null;
    }

    public void next() {
        if (!isVacia()) {
            ultimo = ultimo.siguiente;
        }
    }

    public void previous() {
        if (!isVacia()) {
            ultimo = ultimo.anterior;
        }
    }
    
    public boolean eliminarActual() {
        if (isVacia()) {
            return false;
        }
        if (cuentaNodos() == 1) {
            frente = null;
            ultimo = null;
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
        return true;
    }
    
    public void imprimirLista() {

        Nodo nueva = frente;
        if (frente != null) {
            do {
                System.out.println(nueva.dato);
                nueva = nueva.siguiente;
            } while (nueva != frente);
        }

    }
    
    public Nodo getFrente() {
        return this.frente;
    }
    
    public Nodo getUltimo() {
        return this.ultimo;
    }
    
}
