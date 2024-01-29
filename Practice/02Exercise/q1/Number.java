/**
 * Number
 */
package q1;

public class Number{

    double number;

    Number(int num){
        this.number = num;
    }

    Number(double num){
        this.number = num;
    }

    public class Precision{
        
        double setPrecision(int acc){

            double newNum = Math.round((number * Math.pow(10,acc))) / (Math.pow(10,acc));
            return newNum;

        }
    }
}