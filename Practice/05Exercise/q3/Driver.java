package q3;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();

        l1.insert(2);
        l1.insert(5);
        l1.insert(12);
        l1.insert(6);
        l1.insert(9);

        System.out.printf("Original unsorted list of size %d: \n", l1.len);
        l1.print();

        l1.bubbleSort();

        System.out.printf("Sorted list of size %d: \n", l1.len);
        l1.print();


        
    }

}