package Simple_Arrays;
import java.util.*;

/**
 * Driver
 */
public class Driver {


    //This function displays the passed array in an easily readable format
    public static void printArray(int[] arr) {

        System.out.printf("[");
        for (int i = 0; i < arr.length; i++) { 
            System.out.printf(" %d ", arr[i]);
        }
        System.out.printf("] \n");

    }

    //Modifies one of the elements of the passed array
    public static void modify(int[] numbers, int value) {

        numbers[0] = value;
    
    }

    //changes the array pointed to by the passed array reference parameter and modifies one of the elements of the new array pointed
    //to by the reference
    public static void changeReference(int[] numbers)
    {
        numbers = new int[5];
        numbers[0] = 200;
    }

    //creates and returns a new user-defined array
    public static int[] userArray(){
        
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter size of array: ");
        int i = scanner.nextInt();

        int[] numbers = new int[i];

        for (int j = 0; j < i; j++) {

            System.out.printf("numbers[%d]: ", j);
            numbers[j] = scanner.nextInt();
            
        }

        scanner.close();

        return numbers;

    }



    public static void main(String[] args) {
            
        //int[] arr = new int[]{1,2,3,4,5};

        //having the user enter an array with size and entries of
        //their choice
        int [] numbers = userArray();

        printArray(numbers);
        //modify(numbers,12);
        //printArray(numbers);
        //changeReference(arr);
        //printArray(arr);

        //The Arrays class has a variety of useful methods for
        //manipulating arrays
        Arrays.sort(numbers);
        printArray(numbers);

    }
    

}