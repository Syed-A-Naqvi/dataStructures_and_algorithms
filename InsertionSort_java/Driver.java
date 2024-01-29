package InsertionSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Driver
 */
public class Driver {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertionSort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            
            int current = numbers[i];

            int j = i-1;

            while(j > -1 && current < numbers[j]){

                numbers[j+1] = numbers[j];
                j--;

            }

            numbers[j + 1] = current;

        }

    }


    public static void main(String[] args) {
        
        int[] arr = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {

            arr[i] = rand.nextInt(1000);
            
        }

        System.out.println("Before sorting:");
        System.out.println("------------------------------------------------------------------------------------------------------"); 
        System.out.println(Arrays.toString(arr) + "\n");
        insertionSort(arr);
        System.out.println("After sorting:");
        System.out.println("------------------------------------------------------------------------------------------------------"); 
        System.out.println(Arrays.toString(arr));


    }

}