package BST;

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
        if (newNode.peso < node.peso) {
            if (node.siguiente0 == null) {
                node.siguiente0 = newNode;
                newNode.anterior = node;
            } else {
                insertRec(node.siguiente0, newNode);
            }
        } else if (newNode.peso > node.peso) {
            if (node.siguiente1 == null) {
                node.siguiente1 = newNode;
                newNode.anterior = node;
            } else {
                insertRec(node.siguiente1, newNode);
            }
        }
    }

    public void PreOrder(Node node) {
        if (node != null) {
            System.out.print(node.peso + " ");
            PreOrder(node.siguiente0);
            PreOrder(node.siguiente1);
        }
    }

}
