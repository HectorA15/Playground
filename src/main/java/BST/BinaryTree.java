
package bst;


public class BinaryTree {

    Node root = null;
    Node currentNode = null;

    public BinaryTree() {
        this.root = null;
        this.currentNode = null;
    }

    public void insert(int peso) {
        Node newNode = new Node(peso);
        if (root == null) {
            root = newNode;
            currentNode = newNode;
        } else {
            insertRec(currentNode, newNode);
        }
    }

    public void insertRec(Node node, Node newNode) {
        if (newNode.weight < node.weight) {
            if (node.left == null) {
                node.left = newNode;
                newNode.previous = node;
            } else {
                insertRec(node.left, newNode);
            }
        } else if (newNode.weight > node.weight) {
            if (node.right == null) {
                node.right = newNode;
                newNode.previous = node;
            } else {
                insertRec(node.right, newNode);
            }
        }
    }

    public void delete(int peso) {
        Node nodeToSearch = new Node(peso);
        Node currentNode = root;

        //buscamos el nodo
        while (currentNode != nodeToSearch) {
            if (currentNode.weight < nodeToSearch.weight) {
                if (currentNode.left == null) {
                    currentNode.left = nodeToSearch;
                    nodeToSearch.previous = currentNode;
                } else {
                    System.out.println("Node not found");
                    break;
                }
            } else if (nodeToSearch.weight > currentNode.weight) {
                if (currentNode.right == null) {
                    currentNode.right = nodeToSearch;
                    nodeToSearch.previous = currentNode;
                } else {
                    System.out.println("Node not found");
                    break;
                }
            }
        }

        //aqui decidimos como vamos a eliminar el nodo
        //caso 1: el padre tiene ambos hijos y el que va ocupara su lugar tambien tiene dos hijos
        Node parent = currentNode.previous;
        if(currentNode.left == null && currentNode.right == null){
            
            if(currentNode.weight > parent.weight){
                parent.right = null;
            }else if(currentNode.weight < parent.weight){
                parent.left = null;
            }
            
            
        }else if(currentNode.right == null){
            
        }else if(currentNode.left == null){
            
        }
        //caso 2: el padre tiene dos hijos, pero el hijo derecho no tiene hijo izquierdo
        
    }

    public void PreOrder(Node node) {
        if (node != null) {
            System.out.print(node.weight + " ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }
}
