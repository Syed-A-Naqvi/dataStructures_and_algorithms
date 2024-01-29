package q1;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Driver
 */
public class Driver {

    //sorts the passed array in ascending order
    public static void sortAscending(int[] arr) { //O(nlogn) + O(n) = O(nlogn)
        Arrays.sort(arr); //O(nlogn)
        System.out.println("Sorting in Ascending Order: " + Arrays.toString(arr)); //O(n)
    }

    //sorts the passed array in descending order
    public static void sortDescending(int[] arr) {
        
        //first ensures the array is sorted in ascending order
        Arrays.sort(arr); //O(nlogn)

        int i = 0; //O(1)
        int lastIndex = arr.length-1; //O(1)

        //this loop swaps opposite indexed elements until the
        //the center of the array is reached
        //becuase the array is in ascending order, swapping the elements
        //effectively converts the array into descending order
        while (i < lastIndex-i) { //O(n)
            int temp = arr[i];
            arr[i] = arr[lastIndex-i];
            arr[lastIndex-i] = temp;
            i++;
        }

        System.out.println("Sorting in Descending Order: " + Arrays.toString(arr));

    }

    public static void main(String[] args) {

        int[] numbers = new int[]{2, 4, 1, 9, 8, 6, 0};

        System.out.println("Before Sorting: " + Arrays.toString(numbers));
        sortAscending(numbers);
        sortDescending(numbers);
        
    }

}