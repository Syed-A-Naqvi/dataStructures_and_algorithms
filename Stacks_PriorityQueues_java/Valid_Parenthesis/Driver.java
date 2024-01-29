package Valid_Parenthesis;

import java.util.*;

/**
 * Driver
 */
public class Driver {
    
    public static boolean isValid(String str) {

        Stack<Character> stack = new Stack<Character>();

        for (char c : str.toCharArray()) {

            if( (c=='(') || (c=='{') || (c=='[') ) {

                stack.push(c);

            } else if (stack.isEmpty()){

                return false;

            } else if ( (c==')' && stack.pop() != '(') || (c=='}' && stack.pop() != '{') || (c==']' && stack.pop() != '[')){

                return false;

            }
            
        }

        return stack.isEmpty();
        
    }

    public static void main(String[] args) {

        System.out.println(isValid("(){}[{(})]"));
    
    }

}