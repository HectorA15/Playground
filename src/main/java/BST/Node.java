package BST;

public class Node {

    public int peso;
    public Node siguiente0, siguiente1;
    public Node anterior;

    public Node(int peso) {
        this.peso = peso;
        this.siguiente1 = null;
        this.siguiente0 = null;
        this.anterior = null;
    }

    public void setSiguiente0(Node siguiente0) {
        this.siguiente0 = siguiente0;
    }

    public void setSiguiente1(Node siguiente1) {
        this.siguiente1 = siguiente1;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public Node getSiguiente0() {
        return siguiente0;
    }

    public Node getSiguiente1() {
        return siguiente1;
    }

    public Node getAnterior() {
        return anterior;
    }

}
