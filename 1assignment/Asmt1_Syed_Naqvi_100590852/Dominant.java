// Assignment 1: Question 3
// Syed Arham Naqvi
// 100590852


/**
 * Dominant
 */
public class Dominant {

    //finding the count of a value in an array from the passed start index to the passed end index
    //-----------------------------------------------O( n ) time complexity-----------------------------------------------
    public static int valueCount(int[] A, int start, int end, int value){
        
        int count = 0;

        for (int i = start; i < end + 1; i++) {
            if(A[i] == value){
                count++;
            }
        }

        return count;
    }

    
    public static DominantNumber findDominantNumber(int[] A, int start, int end){

        //-----------------------------------------------constant time-----------------------------------------------
        if(!(start < end)){
            return new DominantNumber(A[start], 1);
        }

        int mid = (start + end) / 2;
        int size = end - start + 1;
        //-----------------------------------------------constant time-----------------------------------------------



        // each of the below recursive calls implements the divide and conquer approach, dividing the current array in half
        //-----------------------------------------------O( lg(n) ) time complexity-----------------------------------------------
        DominantNumber leftDominant = findDominantNumber(A, start, mid);
        DominantNumber rightDominant = findDominantNumber(A, mid+1, end);
        //-----------------------------------------------O( lg(n) ) time complexity-----------------------------------------------



        // at each recursive level we count the number of times a potential dominant number (returned from left and/or right subarrays) appears in the current array
        //-----------------------------------------------O( n ) time complexity-----------------------------------------------
        if(leftDominant != null){
            leftDominant.setCount(valueCount(A, start, end, leftDominant.getValue()));
        }
        if(rightDominant != null){
            rightDominant.setCount(valueCount(A, start, end, rightDominant.getValue()));
        }
        //-----------------------------------------------O( n ) time complexity-----------------------------------------------



        //-----------------------------------------------constant time-----------------------------------------------
        // we return whichever dominant number from the left or right subarrays is also dominant in the current array
        // if there is no dominant number, we return null
        if(leftDominant != null){
            if(leftDominant.getCount() > size/2){
                return leftDominant;
            }
        }

        if(rightDominant != null){
            if(rightDominant.getCount() > size/2){
                return rightDominant;
            }
        }

        return null;        
        //-----------------------------------------------constant time-----------------------------------------------
    }

    public static void main(String[] args) {
        
        int[] array = new int[] {1,3,8,8,4,5,6,7,8,8,8,8,8,8};

        DominantNumber dominant = findDominantNumber(array, 0, array.length - 1);

        if(dominant == null){
            System.out.println("The array does not contain a dominant number.");
        }
        else{
            System.out.println("Dominant Numebr: " + dominant.getValue());
        }


    }
}


/**
 * DominantNumber object will be used to store a value along with its count
 */
class DominantNumber {

    int value;
    int count;
    
    //constructor
    DominantNumber(int value, int count){
        this.value = value;
        this.count = count;
    }
    
    //setters
    public void setCount(int count) {
        this.count = count;
    }
    public void setValue(int value) {
        this.value = value;
    }
    
    //getters
    public int getCount() {
        return count;
    }
    public int getValue() {
        return value;
    }
}
