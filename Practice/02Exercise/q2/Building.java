package q2;

/**
 * Building
 */
public class Building extends CarbonFootPrint {

    private int squareFeet, wood, concrete, steel, glass;
    
    Building(int squareFeet, int wood, int concrete, int steel, int glass){
        this.squareFeet = squareFeet;
        this.wood = wood;
        this.concrete = concrete;
        this.steel = steel;
        this.glass = glass;
    }

    public double getCarbonFootPrint(){
        return this.squareFeet * (this.wood + this.concrete + this.steel + this.glass);
    }

    public void display(){
        System.out.printf("Building (%d squarefeet, %d wood, %d concrete, %d steel, %d glass): %.2f\n",
        this.squareFeet, this.wood, this.concrete, this.steel, this.glass, this.getCarbonFootPrint());
    }
}