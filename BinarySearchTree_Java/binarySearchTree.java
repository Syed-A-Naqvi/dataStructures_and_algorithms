package BinarySearchTree;

import java.util.Stack;

/**
 * Node
 */
class Node {

    Node left;
    Node right;
    int value;

    Node (int value){

        this.left = null;
        this.right = null;
        this.value = value;

    }
        
}

/**
 * binaryTree
 */
public class binarySearchTree {

    private Node root;

    binarySearchTree(){
        this.root = null;
    }

    public Node getRoot(){
        return this.root;
    }

    //uses an iterative approach to insert a new element in the correct position of the tree
    //functional
    public void insertIterative(int value) {

        if (this.root == null){
            this.root = new Node(value);
            return;
        }
        else{
            
            Node currentNode = this.root;
            Node parent = currentNode;

            while(currentNode != null){

                parent = currentNode;

                if (value > currentNode.value){
                    currentNode = currentNode.right;
                }
                else{
                    currentNode = currentNode.left;
                }

            }

            if(value > parent.value){
                parent.right = new Node(value);
            }
            else{
                parent.left = new Node(value);
            }

        }

    }

    //uses recursion to insert a new node into the correct position in the binary tree
    //functional
    public void insertRecursive(int value) {
        this.root = rI(this.root, value);
    }
    private Node rI(Node root, int value) {

        if (root == null){
            return new Node(value);
        }
        else if (value < root.value){
            root.left = rI(root.left, value);
        }
        else if (value > root.value){
            root.right = rI(root.right, value);
        }

        return root;
    
    }

    //uses a stack to ensure a preorder printing of the binary tree
    //functional
    public void printNodes() {
        
        Stack<Node> stack = new Stack<Node>();
        Node currentNode = this.root;
        
        while(currentNode != null || !stack.isEmpty()){

            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else{
                currentNode = stack.pop();
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.right;
            }

        }
        System.out.println();

    }
    
    //Uses recursion to preorder print the binary tree
    //functional
    public void recursivePrint(Node root) {
        
        if(root == null){
            return;
        }
        else{

            recursivePrint(root.left);
            System.out.print(root.value + " ");

            recursivePrint(root.right);

        }

    }

    //Uses an iterative approach to search the binary tree for ta node corresponding to a
    //passed element
    //returns the relevent node if it contains the element being searched for
    //functional
    public Node search(int value) {

        Node currentNode = this.root;
        
        if(currentNode == null){
            return null;
        }

        while(currentNode.value != value){


            if (value < currentNode.value){
                currentNode = currentNode.left;
            }
            else if (value > currentNode.value){
                currentNode = currentNode.right;
            }
            

        }

        return currentNode;
        
    }

    //uses a recursive approach to locate and return the node containing a searched for value
    //functional
    public Node recursiveSearch(Node root, int value) {
        
        if (root == null){
            return null;
        }
        if (root.value == value){
            return root;
        }

        if(value < root.value){
            return this.recursiveSearch(root.left, value);
        }
        else{
            return this.recursiveSearch(root.right, value);
        }

    }

}