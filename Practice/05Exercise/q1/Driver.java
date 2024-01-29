package q1;


/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {
        
        LinkedList list1 = new LinkedList();

        list1.insert(10);
        list1.insert(4);
        list1.insert(72);
        list1.insert(18);
        list1.insert(2);
        list1.insert(38);
        list1.insert(6);
        
        System.out.println("Original list...");
        list1.print();

        System.out.println("Printing even numbers from the list...");
        list1.printEven();

    }

}