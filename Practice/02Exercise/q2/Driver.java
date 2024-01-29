package q2;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {

        CarbonFootPrint carbon = new CarbonFootPrint();
        Bicycle bicycle = new Bicycle();
        Car car = new Car(60);
        Building building = new Building(2500, 50, 60, 70, 80);

        carbon.display();
        bicycle.display();
        car.display();
        building.display();

    }
}