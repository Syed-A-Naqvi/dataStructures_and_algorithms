package Stack_Class;

import java.util.*;

/**
 * Driver
 */
public class Driver {

    public static void pushElements(Stack<Integer> stack) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element: ");
            stack.push(scanner.nextInt());
        }

        scanner.close();
        
    }

    public static void emptyStack(Stack<Integer> stack) {

        while(!stack.isEmpty()){

            System.out.println("Element " + stack.pop() + " popped.");
        
        }
        
    }

    public static void searchElement(Stack<Integer> stack, int value) {
        
        int index = stack.search(value);

        if (index == -1) {

            System.out.println("Item not found!");
            
        } else {
            
            System.out.println("Item found at index " + index);

        }

    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        
        pushElements(stack);
        searchElement(stack, 0);
        emptyStack(stack);
        
    }

}