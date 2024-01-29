package q1;

/**
 * Driver
 */
public class Driver {

    public static int fibonacci(int n) { //O(n)
        
        if(n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }

    }

    public static void showFibonacci(int n) { //O(n)
        System.out.println(fibonacci(n));
    }

    public static void main(String[] args) {


        showFibonacci(9);
        

    }
    
}