package q3;

import java.util.*;

/**
 * Driver
 */
public class Driver {


    public static int missingElement(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if ( (arr[i+1]) != (arr[i]+1) ){
                return arr[i]+1;
            }
            
        }

        return 0;
        
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{0,1,3,4,5,6,7,8};

        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Missing Element: " + missingElement(numbers));
        
    }

}