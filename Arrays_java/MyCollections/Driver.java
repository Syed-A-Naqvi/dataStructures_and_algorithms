package MyCollections;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Driver
 */
public class Driver {

    public static void display(int[][] numbers) {
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers[j].length; i++) {
                System.out.println(numbers[j][i]);
            }
        }
    }

    public static void display_for_each(int[][] numbers) {

        for (int[] i : numbers) {
            System.out.println(Arrays.toString(i));
        }
        
    }

    public static void display_list(ArrayList<String> list ) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
    }

    public static void main(String[] args) {
    
        /*int[][] numbers = new int[][]{
            {1,2,3},
            {4,5,6}
        };*/

        //display(numbers);

        //display_for_each(numbers);

        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Peach");
        fruits.add("Grapes");
        fruits.add("Oranges");

        System.out.println(fruits);

        fruits.remove("Apple");

        System.out.println(fruits);

        System.out.println(fruits.contains("Peach"));

        fruits.set(0, "Pine Apple");

        System.out.println(fruits);

        display_list(fruits);

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(6);
        numbers.add(0);
        numbers.add(8);
        numbers.add(12);

        Collections.sort(numbers);
        System.out.println(numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers);

    }


}