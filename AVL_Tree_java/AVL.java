package AVL_Recursive;
import java.util.LinkedList;

/**
 * AVL
 */
public class AVL {

    Node root;

    AVL(){
        this.root = null;
    }

    //recursive insertion
    //time complexity: O(logn): elimenating half the subtree every call untill end of subtree is reached
    //space complexity: O(logn): makes O(logn) function calls on the stack, each function call has constant space complexity
    public void insert(int value) {
        this.root = recursiveInsert(this.root, value);
    }
    private Node recursiveInsert(Node node, int value){

        if(node == null){
            return new Node(value);
        }
        else if(value < node.value){
            node.left = recursiveInsert(node.left, value);
        }
        else if (value > node.value){
            node.right = recursiveInsert(node.right, value);
        }
        else{
            return node;
        }

        node.height = setHeight(node);
        node = balanceNode(node);
        
        return node;

    }


    //recursive delete
    //time complexity: O(3logn) -> O(logn): will require 3 O(logn) traversals, one to find the value, then to find max of left subtree
                                          //then to delete left subtree node
    //space complexity: O(3logn) -> O(logn): makes 3 O(logn) function calls on the stack, each call uses constant space complexity
    public void delete(int value){
        this.root = recursiveDelete(this.root, value);
    }
    private Node recursiveDelete(Node node, int value){
        
        if(node == null){
            return node;
        }
        else if(value > node.value){
            node.right = recursiveDelete(node.right, value);
        }
        else if(value < node.value){
            node.left = recursiveDelete(node.left, value);
        }
        else{

            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }

            node.value = getMaxNodeVal(node.left);
            node.left = recursiveDelete(node.left, node.value);

        }

        node.height = setHeight(node);
        node = balanceNode(node);

        return node;

    }

    //utility functions
    //each of these functions has O(1) space and time complexity
    private int setHeight(Node node){
        if(node == null){
            return 0;
        }
        else{
            return getMax( getHeight(node.left), getHeight(node.right) ) + 1;
        }
    }
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        else{
            return node.height;
        }
    }
    private int getMax(int a, int b){
        if( a > b ){
            return a;
        }
        else{
            return b;
        }
    }
    private Node leftRotate(Node node){

        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        
        node.height = setHeight(node);
        newRoot.height = setHeight(newRoot);
        
        return newRoot;

    }
    private Node rightRotate(Node node){

        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        
        node.height = setHeight(node);
        newRoot.height = setHeight(newRoot);
        
        return newRoot;

    }
    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }
        else{
            return getHeight(node.left) - getHeight(node.right);
        }
    }
    private Node balanceNode(Node node){

        if( getBalanceFactor(node) > 1 ){

            if( getBalanceFactor(node.left) > 0){
                node = rightRotate(node);
            }
            else{
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }

        }
        else if ( getBalanceFactor(node) < -1){

            if( getBalanceFactor(node.right) < 0){
                node = leftRotate(node);
            }
            else{
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }

        }

        return node;


    }
    //finds the maximum value in a tree
    //O(logn) time complexity to traverse subtree, O(1) space complexity
    private int getMaxNodeVal(Node node){

        while(node.right != null){
            node = node.right;
        }
        return node.value;

    }

    //tree printing methods
    //each has an O(n) time complexity and O(n) space complexity 
    public void preOrder(Node node) {

            if(node == null){
                return;
            }
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
            
        }
    public void postOrder(Node node) {
            
            if(node == null){
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
    
        }
    public void inOrder(Node node) {
            
            if(node == null){
                return;
            }
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        
        }
    public void levelOrder() {
        
        LinkedList<Node> list = new LinkedList<>();
        Node currentNode = this.root;
        list.add(currentNode);

        while(!list.isEmpty()){

            currentNode = list.poll();
            System.out.print(currentNode.value + " ");

            if(currentNode.left != null){
                list.add(currentNode.left);
            }
            if(currentNode.right != null){
                list.add(currentNode.right);
            }
        
        }
        
        System.out.println();
        
    }

}