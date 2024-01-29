package Array_List;
import java.util.*;

/**
 * Driver
 */
public class Driver {
    
    //Compares each element of both array lists and returns true if they are all the same, false otherwise
    public static boolean compareStringArrays(ArrayList<String> str1, ArrayList<String> str2) {

        for (int i = 0; i < str1.size(); i++) {
            if (str1.get(i) != str2.get(i)){
                return false;
            }
        }
        return true;

    }

    //Controlling the removal of select elements from an array list
    public static void removeByName(ArrayList<String> fruits, String remove) {
        
        System.out.println("\nBefore Removal: " + fruits);
        System.out.printf("Removing %s...\n", remove);
        fruits.remove(remove);
        System.out.println("After Removal: " + fruits);

    }


    public static void displayEach(ArrayList<String> fruits) {
        
        System.out.println(fruits);

        //alternative implementation
        /*for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }*/
        
        //alternative implementation
        /*for (String i : fruits) {
            System.out.println(i);
        }*/

    }

    public static void main(String[] args) {

        //Creates an arraylist that will hold objects of type String
        //This is a class of objects designed to facilitate the creation
        //of dynamic arrays which can be increased and decreased in size
        //this is unlike regular arrays which are fixed in size once initialized
        ArrayList<String> fruits = new ArrayList<String>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grapes");

        //The arraylist object can be printed directly in a formatted manner
        //System.out.println(fruits);
        
        displayEach(fruits);
        fruits.set(0,"Mango");
        displayEach(fruits);

        removeByName(fruits, "Grapes");

        //creating two string array lists that will be compared
        ArrayList<String> str1 = new ArrayList<>();
        str1.add("Toronto");
        str1.add("Ottawa");
        str1.add("Montreal");

        ArrayList<String> str2 = new ArrayList<>();
        str2.add("Toronto");
        str2.add("Ottawa");
        str2.add("Montreal");

        if (compareStringArrays(str1, str2)){
            System.out.println("\nThe string arrays are equal.");
        }
        else{
            System.out.println("\nThe string arrays are not equal.");
        }

    }

}
