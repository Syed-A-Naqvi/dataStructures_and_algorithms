package q2;

import java.util.Arrays;

/**
 * Driver
 */
public class Driver {

    //returns a new independent copy of the array being passed as a reference
    public static int[] copyIntArray(int[] arr) {
        
        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }

        return arr2;

    }

    //returns a new independent array that is a reversed version of the passed by reference array
    public static int[] reverseArray(int[] arr) {

        int[] arr2 = copyIntArray(arr);
        
        for(int i = (arr2.length-1), c = 0; i > c; i--, c++){

            int temp = arr2[c];
            arr2[c] = arr2[i];
            arr2[i] = temp;

        }

        return arr2;
    }


    public static void main(String[] args) {

        int[] numbers = new int[]{1,6,2,7,9,3,5};

        
        System.out.println("Reversed Array:");
        System.out.println(Arrays.toString(reverseArray(numbers)));
        
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(numbers));

    }
}