package AVL_Recursive;

/**
 * Driver
 */
public class Driver {



    public static void main(String[] args) {

        AVL tree = new AVL();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

//      tree.preOrder(tree.root);
//      System.out.println();

        tree.levelOrder();
        System.out.println();

        tree.delete(30);  

        tree.levelOrder();
        System.out.println();

//      tree.postOrder(tree.root);
//      System.out.println();
    
    }
}