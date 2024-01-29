// Assignment 1: Question 4
// Syed Arham Naqvi
// 100590852

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.lang.Math;

/**
 * Heap
 */
public class Heap {

    // takes an int array, uses it to construct a max heap, then sorts the array by returning the largest elements one at a time from the max heap
    public static void heapSort(int[] arr) {

        MaxHeap heap = new MaxHeap(arr);

        for (int i = arr.length - 1; i > - 1; i--) {
                 arr[i] = heap.heapExtractMax();
        }

    }

    public static void main(String[] args) {
        
        int[] A = new int[] {7,9,8,2,1,4,3,16,10,14};
        int[] B = Arrays.copyOf(A, A.length);

        System.out.println("Array: " + Arrays.toString(A));
        System.out.println();

        MaxHeap heap = new MaxHeap(A);
        System.out.print("Max-Heapifying the Array: ");
        heap.printAsArray();
        System.out.println();
        heap.printAsTree(0, 15);
        System.out.println();

        System.out.print("Inserting elements into the heap: ");
        System.out.println();
        heap.maxHeapInsert(100);
        heap.maxHeapInsert(7);
        heap.maxHeapInsert(43);
        heap.maxHeapInsert(89);
        heap.maxHeapInsert(1);
        heap.maxHeapInsert(55);
        heap.maxHeapInsert(13);
        heap.maxHeapInsert(10);
        heap.maxHeapInsert(0);
        heap.printAsArray();
        System.out.println();
        heap.printAsTree(0, 20);
        System.out.println();


        System.out.println("Removing maximum elements: ");
        heap.heapExtractMax();
        heap.heapExtractMax();
        heap.heapExtractMax();
        heap.heapExtractMax();
        heap.heapExtractMax();
        heap.printAsArray();
        System.out.println();
        heap.printAsTree(0,15);
        System.out.println();


        System.out.println("Oridinal Array Unsorted: " + Arrays.toString(B));
        heapSort(B);
        System.out.println("Sorted Array: " + Arrays.toString(B));


    }

}


/**
 * MaxHeap will be used for the creation and manipulation of the Max-Heap data structure
 */
class MaxHeap{
        
    
    //keeps track of the number of elements part of the heap which may differ from the size of maxHeap
    private int heapSize;
    //using arraylist to simplify deletion and insertion of elements
    private ArrayList<Integer> maxHeap;


    // adds all elements of the passed array into the mazHeap arraylist
    // uses buildMaxHeap() to configure maxHeap arraylist into a max heap data structure
    // updates the heapsize with the size of the passed array to keep track of all elements in heap
    MaxHeap(int[] A){
        this.maxHeap = new ArrayList<Integer>(A.length);
        for (int i : A) {
            maxHeap.add(i);
        }
        this.heapSize = A.length;
        buildMaxHeap();
    }

    // creates an empty maxHeap that will maintain its configuration as new elements are added through the maxHeapInsert() method
    MaxHeap(){
        this.maxHeap = new ArrayList<Integer>();
        this.heapSize = 0;
    }


    //returns the indecies of the parent or the left and right children of element at index i using zero-based indexing
    private int Left(int i){
        return 2*(i+1) - 1;
    }
    private int Right(int i){
        return 2*(i+1);
    }
    private int parent(int i){
        return ((i+1)/2) -1;
    }


    // will heapify maxHeap for subtree rooted at index i
    private void maxHeapify(int i){
        
        int l = Left(i);
        int r = Right(i);

        int largest = i;
        if( (l <= (heapSize-1)) && (maxHeap.get(l) > maxHeap.get(i)) ){
            largest = l;
        }
        if( (r <= (heapSize-1)) && (maxHeap.get(r) > maxHeap.get(largest)) ){
            largest = r;
        }
        if ( !(largest == i) ){

            Collections.swap(maxHeap, i, largest);
            //recursive call to heapify next subtree rooted at current subtree's previous largest child's index (largest)
            maxHeapify(largest);

        }
    }


    // builds the array into a maxHeap configuration
    private void buildMaxHeap(){

        //calculating the index of what will be the last parent
        int lastParent = (heapSize/2) - 1;

        // beginning from the last parent, will heapify each subtree rooted at each parent along the way to the root of the entire tree
        for (int i = lastParent; i > -1; i--) {
            maxHeapify(i);
        }

    }


    // returning the largest element in the maxHeap (i.e. the root element)
    public int heapMaximum() {
        return maxHeap.get(0);
    }


    // removing and returning the largest element in the max heap.
    // will be much simplier due to the utilization of an arraylist
    public int heapExtractMax() {
        
        // ensuring that heap contains an element to be extracted
        if(heapSize == 0){
            throw new NoSuchElementException("heap underflow");
        }

        // we will swap largest element with the last child, remove and return the last child, re-heapify from the root
        Collections.swap(maxHeap, 0, heapSize-1);
        int max = maxHeap.remove(heapSize-1);


        //very important to update the heap size immediately upon node removal
        heapSize--;

        //re-heapify the tree
        maxHeapify(0);

        //return the max (i.e. the root)
        return max;
    }


    // appends a new element to the end of the heap, adding a new leaf
    // while the new child is greater than its parent, swaps parent and child
    public void maxHeapInsert(int element) {
        
        //adding the new element to the end of the heap
        maxHeap.add(element);
        heapSize++;

        // determining the index of the new element
        int newElementIndex = heapSize-1;            

        // moves the element up the tree until it is smaller than its parent or is the root
        while( (newElementIndex > 0) && (maxHeap.get(newElementIndex) > maxHeap.get(parent(newElementIndex))) ){
            
            // finding the index of the parent
            int parentIndex = parent(newElementIndex);
            
            // performing the parent child swap
            Collections.swap(maxHeap, parentIndex, newElementIndex);

            // index of the new element becomes that of its parent after the swap
            newElementIndex = parentIndex;

        }

    }


    // printing the max heap as an array
    public void printAsArray() {
        System.out.println("Heap as array: "+ maxHeap.toString());
    }


    // printing the max heap as a horizontal tree (reverse traversal)
    // pass index 0 (index of the root node) and the maximum desired depth to indent the nodes
    public void printAsTree(int i, int depth) {

        //return if the recursive calls move beyond the bounds of the heap
        if(i > heapSize - 1){
            return;
        }

        //recursive call on the right subtree
        printAsTree(Right(i), depth);        
        
        //calculating the current depth based on the current index number and the total number of elements in the heap
        int currentDepth = (int) ( Math.floor( (depth/(Math.log(heapSize)/Math.log(2))) ) * Math.floor( ( Math.log((i+1)) / Math.log(2) ) ) );
        //inserting the correct number of blank spaces for the current depth
        System.out.println(String.valueOf(' ').repeat(currentDepth) + maxHeap.get(i));

        //recursive call on the left subtree
        printAsTree(Left(i), depth);

    }


}