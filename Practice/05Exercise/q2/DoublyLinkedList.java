package q2;

/**
 * Node
 */
class Node {

    Node previous;
    Node next;
    int data;

    Node(int data){
        this.previous = null;
        this.next = null;
        this.data = data;
    }
    
}

/**
 * DoublyLinkedList
 */
public class DoublyLinkedList {

    Node head;
    Node tail;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insert(int data, int pos) {

        if (this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }

        else if (pos == -1){
            Node node = new Node(data);

            node.previous = null;
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
        }

        else if (pos == 1){

            Node node = new Node(data);

            node.next = null;
            node.previous = this.tail;
            this.tail.next = node;
            this.tail = node;

        }
        
    }

    public void insert(int data) {

        if (this.head == null){
            this.head = new Node(data);
            this.tail = this.head;
        }

        else{

            Node node = new Node(data);

            node.next = null;
            node.previous = this.tail;
            this.tail.next = node;
            this.tail = node;

        }
        
    }

    public void insertAfter(int number, int newNumber) {
        
        Node currentNode = this.head;

        while(currentNode != null){

            if(currentNode.data == number && currentNode.next == null){
                Node node = new Node(newNumber);

                this.tail.next = node;
                node.previous = this.tail;
                this.tail = node;
                System.out.printf("%d inserted after the first occurence of %d.\n", newNumber, number);
                return;
                
            }
            else if (currentNode.data == number && currentNode.next != null){
                Node node = new Node(newNumber);

                node.previous = currentNode;
                node.next = currentNode.next;
                currentNode.next = node;
                node.next.previous = node;

                System.out.printf("%d inserted after the first occurence of %d.\n", newNumber, number);
                return;
            }

            currentNode = currentNode.next;

        }

        System.out.printf("%d not located in the list. %d not inserted.\n", number, newNumber);
        return;

    }
    
    public void print() {

        Node currentNode = this.head;

        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
        
    }

}