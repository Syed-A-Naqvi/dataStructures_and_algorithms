package Array_List_Integer;

import java.util.*;

/**
 * Driver
 */
public class Driver {
        
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(2);
        numbers.add(10);
        numbers.add(12);
        numbers.add(7);
        numbers.add(9);

        //Collections.sort(numbers, Comparator.reverseOrder());
        Collections.sort(numbers);
        System.out.println(numbers);

    }

}
