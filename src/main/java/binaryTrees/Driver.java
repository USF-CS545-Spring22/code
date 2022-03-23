package binaryTrees;

import java.util.HashMap;

/** Driver class for the BinarySearchTree class */
public class Driver {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(14);
        tree.insert(3);
        tree.insert(25);
        tree.insert(6);
        tree.insert(1);
        tree.printPreorder();

    }
}
