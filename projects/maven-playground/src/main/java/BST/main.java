package bst;

public class main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(30);
        binaryTree.insert(63);
        binaryTree.insert(35);
        binaryTree.insert(74);
        binaryTree.insert(75);
        binaryTree.insert(81);
        binaryTree.insert(58);
        binaryTree.insert(78);
        System.out.println("PreOrder of the binary tree is:");
        binaryTree.PreOrder(binaryTree.root);
        System.out.println();
        binaryTree.delete(30);
    }
}

