package q3;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {

        CarbonFootPrint[] footPrints = new CarbonFootPrint[3];

        footPrints[0] = new Bicycle();
        footPrints[1] = new Car(60);
        footPrints[2] = new Building(2500, 50, 60, 70, 80);

        for (CarbonFootPrint i : footPrints) {
            i.display();
        }

    }
}