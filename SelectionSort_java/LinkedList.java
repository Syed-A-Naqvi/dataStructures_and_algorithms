package SelectionSort;


/**
 * Node
 */
class Node {

    Node next;
    int data;

    Node (int data){
        this.data = data;
        this.next = null;
    }
    
}
/**
 * LinkedList
 */
public class LinkedList {

    Node head;

    LinkedList(){
        this.head = null;
    }

    public void insertElement(int data) {

        if(this.head == null){
            this.head = new Node(data);
        }
        else {
            
            Node currentNode = this.head;
            while (currentNode.next != null) {

                currentNode = currentNode.next;    
            
            }

            currentNode.next = new Node(data);
            
        }
        
    }

    public void printLinkedList() {

        if (this.head == null) {

            System.out.println("The list is empty.");
            
        }
        else{
            Node currentNode = this.head;

            System.out.print("[");
            while(currentNode != null){
                System.out.print(" " + currentNode.data);
                currentNode = currentNode.next;
            }
            System.out.println("]");
        }
        
    }

    
}