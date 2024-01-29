package q2;

/**
 * Car
 */
public class Car extends CarbonFootPrint {

    private double gallons;

    Car(double gallons){
        this.gallons = gallons;
    }

    public double getCarbonFootPrint(){
        return this.gallons * 20;
    }

    
    public void display(){
        System.out.printf("Car (%.2f gallons): %.2f\n", this.gallons, this.getCarbonFootPrint());
    }
    
}