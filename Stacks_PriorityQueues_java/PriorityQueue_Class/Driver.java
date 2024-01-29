package PriorityQueue_Class;

import java.util.*;

/**
 * Driver
 */
public class Driver {

    public static void pushElements(PriorityQueue<Integer> queue) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the queue: ");
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {

            System.out.print("Element to push: ");
            queue.add(scanner.nextInt());

        }
        scanner.close();

    }

    public static void print(PriorityQueue<Integer> queue) {

        System.out.println(queue);

        //while(!queue.isEmpty()) {

            //System.out.println(queue.element());
            //queue.poll();

        //}
        
    }

    public static void main(String[] args) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        pushElements(queue);
        print(queue);

    }

}