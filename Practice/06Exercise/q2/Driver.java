package q2;

/**
 * Driver
 */
public class Driver {


    public static int sumArrayElements(int[] numbers, int n) { //O(n)
        
        if(n == 0){
            return numbers[0];
        }
        else{
            return numbers[n] + sumArrayElements(numbers, n-1);
        }

    }


    public static void main(String[] args) {

        int[] numbers = new int[]{1,2,3,4,5,6};

        System.out.println(sumArrayElements(numbers, 5));
        
    }

}