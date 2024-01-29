package String_Arrays;

public class Driver {

    //This functions takes a string array as an argument and displays the contents of the array to the console
    public static void display(String[] cities)
    {

        System.err.print("[");
        for(String city: cities)
        {
            System.out.printf(" \"%s\" ", city);
        }
        System.out.println(" ]");
    
    }

    //This function displalys whether or not the passed city is in the array
    public static void search(String[] cities, String query) {
        
        for (String string : cities) {
            
            //the string.equals() function returns true if the passed
            //string equals the calling string, case sensitive
            if(string.equals(query)){
                System.out.printf("\"%s\" found in the array.\n", query);
                return;
            }

            //case insensitive version of the above code
            /*if(string.equalsIgnoreCase(query)){
                System.out.printf("\"%s\" found in the array.\n", query);
                return;
            }
            */

        }

        System.out.printf("\"%s\" not found in the array.\n", query);

    }


    public static void main(String[] args) {

        String[] cities = new String[]{"Toronto", "New York", "Tokyo", "London"};
        display(cities);
        search(cities, "london");

    }


}