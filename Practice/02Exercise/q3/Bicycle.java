package q3;

/**
 * Bicycle
 */
public class Bicycle extends CarbonFootPrint {

    public double getCarbonFootPrint(){
        return 0.0;
    }

    public void display(){

        System.out.println("Bicycle: " + this.getCarbonFootPrint());
    
    }
    
}