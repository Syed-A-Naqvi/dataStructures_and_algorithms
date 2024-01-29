package LinkedList;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertElement(2);
        list.insertElement(2);
        list.insertElement(2);
        list.insertElement(2);
        list.insertElement(2);
        list.insertElement(2);
        list.insertElement(2);
        list.insertElement(2);

        list.print();
        
        //list.delete(2);

        list.print();

        list.removeDuplicates();

        

       
    }
    
}