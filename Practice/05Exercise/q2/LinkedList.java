package q2;


/**
 * Node
 */
class Node {

    Node next;
    int data;

    Node(int data){
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

    public void insert(int data) {
        
        Node node = new Node(data);

        if (this.head == null){
            this.head = node;
        }
        else{
            Node currentNode = this.head;

            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }

    }

    public void print() {

        Node currentNode = this.head;

        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();

        
    }
 
    public void insertAfter(int number, int newNumber) {
        
        Node currentNode = this.head;

        while(currentNode != null){
            
            if(currentNode.data == number && currentNode.next == null){
                currentNode.next = new Node(newNumber);
                System.out.println("New number inserted at the end of the list.");
                return;
            }

            else if (currentNode.data == number && currentNode.next != null){
                Node node = new Node(newNumber);
                node.next = currentNode.next;
                currentNode.next = node;
                System.out.printf("Located the value %d.\nInserted %d after %d.\n", number, newNumber, number);
                return;
            }

            currentNode = currentNode.next;
        
        }

        System.out.println("The specified number could not be located, exiting method...");
        return;
    }
    
}