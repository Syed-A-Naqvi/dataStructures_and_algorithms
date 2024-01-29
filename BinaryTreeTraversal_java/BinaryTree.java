package Traversal;

import java.util.LinkedList;

/**
 * Node
 */
class Node {

    Node left;
    Node right;
    int value;

    Node(int value){
        this.left = null;
        this.right = null;
        this.value = value;
    }
    
}

/**
 * BinaryTree
 */
public class BinaryTree {

    Node root;

    BinaryTree(){
        this.root = null;
    }

    //complete
    public void insert(int value){

        if (this.root == null){
            this.root = new Node(value);
            return;
        }
        else{

            Node currentNode = this.root;
            Node parentNode = currentNode;

            while(currentNode != null){

                parentNode = currentNode;

                if(value > currentNode.value){
                    currentNode = currentNode.right;
                }
                else{
                    currentNode = currentNode.left;
                }

            }

            if(value > parentNode.value){
                parentNode.right = new Node(value);
                return;
            }
            else if (value < parentNode.value){
                parentNode.left = new Node(value);
                return;            
            }

        }


    }
    
    //complete
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

    //Complete
    public void preOrder(Node root) {
        
        if (root == null){
            return;
        }

        System.out.print(root.value + " ");
        
        preOrder(root.left);
        preOrder(root.right);

    }

    //complete
    public void inOrder(Node root) {
        
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.value + " ");

        inOrder(root.right);

    }

    //Complete
    public void postOrder(Node root) {
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");

    }

    //complete
    public boolean deleteNode(int value) {
        
        Node currentNode = this.root;
        Node parentNode = this.root;

        while(currentNode.value != value){

            parentNode = currentNode;
            
            if (value < currentNode.value){
                currentNode = currentNode.left;
            }
            else{
                currentNode = currentNode.right;
            }
            if(currentNode == null){
                return false;
            }

        }

        if(currentNode == parentNode.right){
            parentNode.right = null;
        }
        else{
            parentNode.left = null;
        }

        return true;

    }

}