/**
 * MyDate
 */

 //defining the MyDate class to be able to store the date using three different fields for the day, month and year
public class MyDate {

    //date fields
    int day, month, year;

    //this function will be called using an object of this class in order to set the date fields
    public void setDate ( int d, int m, int y) {
        
        //setting the date fields to the paremeters passed to the setDate method
        day = d;
        month = m;
        year = y;

    }

    //converts the current date fields into a single string in day-month-year format and returns the string
    public String toString () {
        
        String date = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);

        return date;
    }



    
}