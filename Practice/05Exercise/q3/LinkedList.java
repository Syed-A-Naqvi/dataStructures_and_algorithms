package q3;

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
    int len;

    LinkedList(){
        this.head = null;
        this.len = 0;
    }

    public void bubbleSort(){
        
        if(this.head == null){
            System.out.println("List is empty, nothing to sort.");
            return;
        }
        else if (this.len == 1){
            System.out.println("This list has a single element. A single element is trivially sorted.");
            return;
        }
        

        boolean swapped;
        
        do{

            Node currentNode = this.head;
            swapped = false;

            while (currentNode.next != null) {
                
                if(currentNode.data > currentNode.next.data){
                    
                    swapped = true;
                    
                    int temp = currentNode.data;
                    currentNode.data = currentNode.next.data;
                    currentNode.next.data = temp;
                
                }

                currentNode = currentNode.next;
            
            }

        }while(swapped == true);
        
    }

    public void insert(int data) {
        
        Node node = new Node(data);

        if (this.head == null){
            this.head = node;
            this.len++;
        }
        else{
            Node currentNode = this.head;

            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            this.len++;
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
                
                this.len++;
                
                System.out.println("New number inserted at the end of the list.");
                return;
            }

            else if (currentNode.data == number && currentNode.next != null){
                Node node = new Node(newNumber);
                
                node.next = currentNode.next;
                currentNode.next = node;
                this.len++;

                System.out.printf("Located the value %d.\nInserted %d after %d.\n", number, newNumber, number);
                return;
            }

            currentNode = currentNode.next;
        
        }

        System.out.println("The specified number could not be located, exiting method...");
        return;
    }
    
}