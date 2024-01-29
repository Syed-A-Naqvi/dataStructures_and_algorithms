package Traversal;

import java.util.LinkedList;



/**
 * Driver
 */
public class Driver {

    
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        tree.insert(2);
        tree.insert(4);
        tree.insert(12);
        tree.insert(25);

        tree.levelOrder();

        tree.preOrder(tree.root);
        System.out.println();
        
        tree.inOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
        System.out.println();

        System.out.println(tree.deleteNode(15));

        tree.inOrder(tree.root);
        System.out.println();
        
    }

}