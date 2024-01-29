package AVL_Recursive;

/**
 * Node
 */
public class Node {

    int value;
    int height;
    Node left, right;

    Node(int value){
        this.value = value;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

}