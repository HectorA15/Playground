
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
        Node parent = null;
        Node node = root;

        //search the node
        while (node != null && node.weight != weight) {
            parent = node;
            if(node.weight < weight){node = node.left;}
            else{node = node.right;}
        }


        //case 1: parent have 2 childs
        
        //case 2: parent only have 1 child
        
        //case 3: parent does not have childs
    }

    public void PreOrder(Node node) {
        if (node != null) {
            System.out.print(node.weight + " ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }
}


