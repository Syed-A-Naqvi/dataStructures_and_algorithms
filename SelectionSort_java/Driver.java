package SelectionSort;

import java.util.Arrays;

/**
 * Driver
 */
public class Driver {

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            
            int smallest = i;
            int temp;

            for (int j = i+1; j < arr.length; j++) {

                if ( arr[smallest] > arr[j]){
                    smallest = j;
                }
                
            }

            temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }

    }

    //finish this implementation
    public static void selectionSort(LinkedList list) {
        
        
        if (list.head == null || list.head.next == null){
            return;
        }

        
        Node i = list.head;

        while(i != null){

            Node j = i.next;
            Node smallest = i;

            while(j != null){

                if(smallest.data > j.data){
                    smallest = j;
                }

                j = j.next;

            }

            int temp = i.data;
            i.data = smallest.data;
            smallest.data = temp;

            i = i.next;

        }
        
    }


    public static void main(String[] args) {

        int[] numbers = new int[]{1,3,2,4,5,3,8,1,0};

        System.out.println("Array before sorting: " + Arrays.toString(numbers));
        selectionSort(numbers);
        System.out.println("Array after sorting: " + Arrays.toString(numbers));

        LinkedList list = new LinkedList();

        list.insertElement(3);
        list.insertElement(0);
        list.insertElement(8);
        list.insertElement(2);
        list.insertElement(11);
        list.insertElement(4);
        list.insertElement(1);

        System.out.print("List before sorting: ");
        list.printLinkedList();
        selectionSort(list);
        System.out.print("List after sorting: ");
        list.printLinkedList();

    }

}