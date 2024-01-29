package q3;

import java.util.*;

/**
 * Driver
 */
public class Driver {

    public static ArrayList<Integer> runningSum1(ArrayList<Integer> numbers){

        ArrayList<Integer> rsum = new ArrayList<>();
        
        for (int i = 0; i < numbers.size(); i++) { //O(n)

            int sum = 0;

            for (int j = i; j > -1; j--) { //O(n-x)
                sum += numbers.get(j);
            }

            rsum.add(sum);
            
        }

        return rsum;

    }

    public static void runningSum2(ArrayList<Integer> numbers){

        
        for (int i = numbers.size()-1; i > -1; i--) { //O(n)

            int sum = 0;

            for (int j = i; j > -1; j--) { //O(n-x)
                sum += numbers.get(j);
            }

            numbers.set(i, sum);
            
        }

    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println("Original Array: " + numbers);

        runningSum2(numbers);

        System.out.println("Resultant Array: " + numbers);
        
    }

}