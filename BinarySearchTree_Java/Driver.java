package BinarySearchTree;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {

        binarySearchTree tree = new binarySearchTree();

        tree.insertRecursive(20);
        tree.insertRecursive(11);
        tree.insertRecursive(9);
        tree.insertRecursive(4);
        tree.insertRecursive(17);
        tree.insertRecursive(5);
        tree.insertRecursive(1);
        tree.insertRecursive(2);
        tree.insertRecursive(7);
        
        tree.printNodes();
        tree.recursivePrint(tree.getRoot());
        System.out.println();

        System.out.println(tree.search(17).value);
        System.out.println(tree.recursiveSearch(tree.getRoot(),17).value);

        
    }

}