package MultiDim_Arrays;

import java.util.*;

/**
 * Driver
 */
public class Driver {

    public static void display(int[][] numbers) {
        
        for (int i = 0; i < numbers.length; i++) {
            
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.println(numbers[i][j]);
            }

        }

        //for (int[] i : numbers) {
            //System.out.println(Arrays.toString(numbers));
        //}
    }

    public static void main(String[] args) {
        
        int[][] numbers = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}         
        };

        display(numbers);

    }
}