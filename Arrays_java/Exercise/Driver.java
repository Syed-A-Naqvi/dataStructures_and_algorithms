package Exercise;

import java.util.*;

/**
 * Driver
 */
public class Driver {


    public static boolean compareList(ArrayList<String> l1, ArrayList<String> l2 ) {

        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)){
            
                return false;
            }
        }

        return true;
    }

    


    public static void main(String[] args) {


        ArrayList<String> str1 = new ArrayList<>();
        str1.add("Toronto");
        str1.add("Oshawa");
        str1.add("Whitby");

        
        ArrayList<String> str2 = new ArrayList<>();
        str2.add("Toronto");
        str2.add("Oshawa");
        str2.add("Whitby");

        System.out.println(compareList(str1, str2));
        

    }
}