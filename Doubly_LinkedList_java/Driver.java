package Doubly_LinkedList;

public class Driver {
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();

        list.printList(1);
        
        list.appendElement(2);
        list.printList(1);
        
        list.prependElement(4);
        list.printList(1);
        
        list.appendElement(6);
        list.printList(1);
        
        list.prependElement(8);
        list.printList(1);
        
        list.appendElement(10);
        list.printList(1);
        
        list.prependElement(2);
        list.printList(1);
        
        list.appendElement(2);
        list.printList(1);
        
        list.prependElement(2);
        list.printList(1);
        
        list.appendElement(2);
        list.printList(1);

        list.printList(-1);

        list.deleteElement(2);
        list.printList(1);
    }
}