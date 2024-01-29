package Maximum_Product;

import java.util.*;

/**
 * Driver
 */
public class Driver {

    public static void max_product(int[] numbers) {

        //Arrays.sort(numbers);
        //System.out.println(Arrays.toString(numbers));

        //Arrays.sort(numbers,Collections.reverseOrder());
        //System.out.println(Arrays.toString(numbers));
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); 
        
        for (int number : numbers) {
            
            System.out.println(number);
            queue.add(number);
            System.out.println(queue);            

        }
        
        //while(!queue.isEmpty()){
        //    System.out.println(queue.poll());
        //}
        
        //int result = queue.poll() * queue.poll();
        //return result;

    }

    public static void main(String[] args) {

        int[] numbers = new int[] {5,2,1,8,10};

        max_product(numbers);
        
    }

}