package q1;


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
 * Singly
 */
public class LinkedList {

    Node head;

    LinkedList(){
        this.head = null;
    }

    public void insert(int data) {

        Node node = new Node(data);
        Node currentNode = head;

        if (head == null){
            head = node;
        }
        else{
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
        
    }

    public void print() {

        Node currentNode = head;

        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
        
    }

    public void printEven() {

        Node currentNode = head;

        while(currentNode != null){

            if(currentNode.data%2 == 0){
                System.out.print(currentNode.data + " ");
            }

            currentNode = currentNode.next;

        }
        System.out.println();

        
    }

    
}