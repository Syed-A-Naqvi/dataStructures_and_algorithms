package q1;

import java.util.Arrays;

/**
 * Driver
 */
public class Driver {


    //quick sort algorithm will sort any passed numerical array in ascending order
    public static void quickSort(int[] arr, int lowIndex, int highIndex){
        
        if (lowIndex >= highIndex){
            return;
        }

        int pivot = arr[highIndex];
        int lp = lowIndex;
        int rp = highIndex;

        while (lp < rp){

            while ( (arr[lp] <= pivot) && (lp < rp) ) {
                lp++;
            }

            while ( (arr[rp] >= pivot) && (lp < rp)) {
                rp--;
            }

            swap(arr, lp, rp);
        }

        swap(arr, lp, highIndex);

        quickSort(arr, lowIndex, lp-1);
        quickSort(arr, lp+1, highIndex);

    }

    //swap function used exclusively by the quicksort method to swap two values of a passed array at the passed indecies
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;        
    }

    //prints the second last element of the passed array
    public static void getSecondLargest(int[] arr){

        System.out.println("Second Largest Element: " + arr[arr.length-2]);

    }

    public static void main(String[] args) {

        int[] array = new int[] {3, 89, 90, 1, 8, 16, 12};
        
        System.out.println("Original Array: " + Arrays.toString(array));

        quickSort(array, 0, array.length-1);

        System.out.println("Sorted Array: " + Arrays.toString(array));

        getSecondLargest(array);

    }

}