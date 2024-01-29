/**
 * Driver
 */
package q1;

public class Driver {

    public static void main(String[] args) {

        Number figure = new Number(2.1234897);

        Number.Precision precFig = figure.new Precision(); 

        System.out.println("Original Number: " + figure.number);
        System.out.println("Resultant Number: " + precFig.setPrecision(4));

    }
}