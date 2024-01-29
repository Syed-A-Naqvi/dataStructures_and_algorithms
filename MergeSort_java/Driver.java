package MergeSort;
import java.util.Arrays;

/**
 * Driver
 */
public class Driver {


    public static void mergeSort(int[] numbers) {

        int arrLen = numbers.length;

        if (arrLen < 2){
            return;
        }

        int mid = arrLen/2;

        int[] left = new int[mid];
        int[] right = new int[arrLen - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = numbers[i];
        }

        for (int i = mid; i < arrLen; i++) {
            right[i-mid] = numbers[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(numbers, left, right);

    }
    

    private static void merge(int[] numbers, int[]left, int[] right) {

        int leftSize = left.length;
        int rightSize = right.length;

        int l = 0, r = 0, n = 0;

        while(l < leftSize && r < rightSize){

            if(left[l] <= right[r]){
                numbers[n] = left[l];
                l++;
            }
            else{
                numbers[n] = right[r];
                r++;
            }
            n++;

        }

        while(l < leftSize){
            numbers[n] = left[l];
            l++;
            n++;
        }
        while(r < rightSize){
            numbers[n] = right[r];
            r++;
            n++;
        }

    }    


    public static void main(String[] args) {

        int[] numbers = new int[]{13,1,2,3,4,5,6};
        
        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(numbers));

        mergeSort(numbers);

        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(numbers));
       
    }

}