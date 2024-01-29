package q3;

import java.util.Arrays;

/**
 * Driver
 */
public class Driver {

    public static void reverseArray(int[] array, int start, int end) { //O(n/2)
        if(start < end){
            
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            reverseArray(array, start+1, end-1);

        }

    }

    public static void main(String[] args) {
        
        int[] numbers = new int[]{1,2,3,4,5,6};

        System.out.println("Before: " + Arrays.toString(numbers));
        reverseArray(numbers, 0, 5);
        System.out.println("After: " + Arrays.toString(numbers));

    }

}