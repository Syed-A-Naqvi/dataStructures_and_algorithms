
//this class contains the main function and will be used to run the program
public class Driver {

    public static void main(String[] args) {
        
        //creating a new instance of the MyDate class
        MyDate when = new MyDate();

        //using the setDate methods of the MyDate class to initialize the MyDate fields
        when.setDate(17, 7, 2022);

        //using the System.out.println function in conjunction with the toString() method of the MyDate class to convert the date
        //fields in a string in the day-month-year format
        System.out.println(when.toString());

        //Declaring a new circle object belonging to the Circle class
        //using a custom constructor to set the radius
        Circle circle = new Circle(5.5f);

        //Declaring a new square object belonging to the Square class
        //using a custom constructor to set the side lengths
        Square square = new Square(5.5f);
        
        //Calling the static CalculateArea function to output the areas of the created circle and square
        CalculateArea(square, circle);

        
    }

    public static void CalculateArea(Square square, Circle circle) {
        
        float aSquare;
        double aCircle;

        aSquare = square.side * square.side;
        aCircle = (circle.radius * circle.radius) * Math.PI;

        System.out.println("Area of Circle: " + aCircle);
        System.out.println("Area of Square: " + aSquare);

    }
}