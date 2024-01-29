package Doubly_LinkedList;

/**
 * Node
 */
class Node {

    int data;
    Node next;
    Node previous;

    Node(int data){

        this.data = data;
        this.next = null;
        this.previous = null;
    
    }

}

/**
 * LinkedList
 */
public class LinkedList {

    Node head, tail;

    LinkedList(){
        this.head = null;
        this.tail = null;
    }

    //returns true if an element was succesfully appended to the list
    public boolean appendElement(int data) {

        //new node to be added
        Node node = new Node(data);

        //sets both tail and head to point to the new node in the case that the list is empty 
        if (this.head == null){
        
            this.head = node;
            this.tail = node;
            System.out.println(node.data + " appended to list.");
            return true;
        
        }
        //if the list is not empty, this.tail is used to have the last node's next pointer point to the new node
        //the new node's previous pointer is set to the current tail
        //and then this.tail is set equal to this.tail.next so that it points to the new last node
        //by default all new node's next and previous pointers point to null
        else if (this.head != null){
            
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
            System.out.println(node.data + " appended to list.");
            return true;

        }
        else{
        
            System.out.println("Nothing appended to list.");
            return false;
        
        }

    }

    //returns true if an element was successfully prepended to the list
    public boolean prependElement(int data) {

        //this is the new node that needs to be prepended to the list
        Node node = new Node(data);

        //sets both tail and head to point to the new node in the case that the list is empty 
        if (this.head == null){
        
            this.head = node;
            this.tail = node;
            System.out.println(node.data + " prepended to list.");
            return true;
        
        }
        //old head.previous points to the new node
        //new node.next points to the old head
        //old head points to new node becoming the new head
        else if (this.head != null){

            node.next = this.head;
            this.head.previous = node;
            this.head = node;
            System.out.println(node.data + " prepended to list.");
            return true;

        }
        else{
            return false;
        }
        
    }

    //prints the list forwards if 1 is passed as a parameter
    //prints the list backwards if -1 is passed as a parameter
    public void printList(int direction) {

        if(this.head == null){
            System.out.println("The list is empty, nothing to print");
            return;
        }

        if(direction == 1){
            
            Node currentNode = this.head;

            System.out.print("Printing forwards: [ ");
            while(currentNode != null){
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println("]");

        }
        else if (direction == -1){

            Node currentNode = this.tail;

            System.out.print("Printing reversed: [ ");
            while(currentNode != null){
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.previous;
            }
            System.out.println("]");

        }
        else{
            System.out.println("\nPlease specify a valid direction for printing.");
            System.out.println("(1 = forward printing, -1 = reverse printing)");
        }
        
    }

    //delete all instances of the specified element from the list
    public void deleteElement(int number) {

        Node currentNode = this.head;

        //in this case the list is empty and the method exits
        if(currentNode == null){
            System.out.println("The list is empty, nothing to delete");
            return;
        }

        while (currentNode != null){
 
            //in this case the list contains a single node that needs to be removed
            //currentNode, head and tail are all set to null
            if(currentNode.data == number && currentNode == this.head && currentNode == this.tail){
                
                this.head = currentNode = this.tail = null;
            
            }
            //in this case the first element of the list needs to be removed
            //currentNode and head are all set to the next node and currentNode.previous is set to null 
            else if (currentNode.data == number && currentNode == this.head){

                this.head = currentNode = this.head.next;
                this.head.previous = null;

            }
            //in this case the last element of the list needs to be removed
            //currentNode and tail are set equal to the previous node and then currentNode.next is set to null
            else if (currentNode.data == number && currentNode == this.tail){
                
                currentNode = this.tail = this.tail.previous;
                this.tail.next = null;
            
            }
            //in this case some intermediate node needs to be removed
            //the previous node's next pointer is set to the current node's next pointer
            //and the next node's previous pointer is set to the current node's previous pointer
            //the current node is no longer being referenced by anything except currentNode which is then set equal to the next node
            else if (currentNode.data == number){
            
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
                currentNode = currentNode.next;
            
            }
            //if the current node does not need to be removed currentNode is set equal to currentNode.next
            else {

                currentNode = currentNode.next;
            
            }

        }
        
        System.out.println("Removed all instances of " + number + " from the list.");
        
    }

    
}