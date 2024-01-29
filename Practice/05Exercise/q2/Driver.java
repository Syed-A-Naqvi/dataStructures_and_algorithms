package q2;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {

        DoublyLinkedList list1 = new DoublyLinkedList();

        list1.insert(5);
        list1.insert(10, -1);
        list1.insert(8, 1);
        list1.insert(4, -1);
        list1.insert(2, 1);
        list1.insert(9, -1);
        list1.insert(7, 1);

        list1.print();
        list1.insertAfter(9, 0);
        list1.print();

        
    }

}